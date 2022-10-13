package org.example.restaurant.controller;

import lombok.experimental.FieldDefaults;
import org.example.restaurant.entity.Drink;
import org.example.restaurant.entity.Meal;
import org.example.restaurant.entity.Order;
import org.example.restaurant.entity.enums.Cuisine;
import org.example.restaurant.entity.enums.MealType;
import org.example.restaurant.exception.CustomException;
import org.example.restaurant.refl.ObjectFactory;
import org.example.restaurant.repository.bd.ListDB;
import org.example.restaurant.service.DrinkService;
import org.example.restaurant.service.MealService;
import org.example.restaurant.service.OrderService;
import org.example.restaurant.util.Print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.example.restaurant.util.Constants.*;

@FieldDefaults(level = PRIVATE)
public class OrderController {
    private final DrinkService drinkService = ObjectFactory.getInstance().getImplClass(DrinkService.class);
    private final MealService mealService = ObjectFactory.getInstance().getImplClass(MealService.class);
    private final OrderService orderService = ObjectFactory.getInstance().getImplClass(OrderService.class);
    private Order order = new Order();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Print.printHello();
        String position;

        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                mainProposition(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                mainProposition(position, reader);
            }
        } catch (IOException e) {
            Print.printText("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        Print.printText(MAIN_MENU);
    }

    private void mainProposition(String position, BufferedReader reader) {
       try {
           switch (position) {
               case "1" -> getMeal(reader);
               case "2" -> getDrink(reader);
               case "3" -> orderService.finalizeOrder(order);
               case "password" -> Print.printText(orderService.getReport(position));
               case "0" -> System.exit(0);
           }
           runNavigation();
       }catch (Exception e) {
           //do nothing
           runNavigation();
       }

    }

    private void getDrink(BufferedReader reader) throws IOException {
        Drink drink;

        Cuisine cuisine = getCuisine(reader);
        List<Drink> drinkList = drinkService.getAll(cuisine);

        for (int i = 0; i < drinkList.size(); i++) {
            Drink drinkInfo = drinkList.get(i);
            System.out.printf("if you want %s price = %s , enter %s\n", drinkInfo.getName(), drinkInfo.getPrice(), i);
        }

        Print.printText("return to main menu, press any key");

        try {
            Integer choice = Integer.parseInt(reader.readLine());
            drink = drinkList.get(choice);
        }catch (Exception e) {
            return;
        }

        Print.printText("do you wanna cubes: yes(1) no(any)");
        boolean cubes = reader.readLine().equals("1");
        drink.setCubes(cubes);

        Print.printText("do you wanna lemon: yes(1) no(any)");
        boolean lemon = reader.readLine().equals("1");;
        drink.setLemon(lemon);

        order.getDrinks().add(drink);
    }

    private void getMeal(BufferedReader reader) throws IOException {
        Meal meal;

        Cuisine cuisine = getCuisine(reader);
        MealType typeMeal = getTypeMeal(reader);

        List<Meal> mealList = mealService.getAll(cuisine).stream()
                .filter(mealT -> mealT.getMealType().equals(typeMeal))
                .toList();

        for (int i = 0; i < mealList.size(); i++) {
            Meal mealInfo = mealList.get(i);
            System.out.printf("if you want %s price = %s , enter %s\n", mealInfo.getName(), mealInfo.getPrice(), i);
        }

        Print.printText("return to main menu, press any key");

        try {
            int choice = Integer.parseInt(reader.readLine());
            meal = mealList.get(choice);
        }catch (Exception e) {
            return;
        }

        order.getMeals().add(meal);
    }

    private Cuisine getCuisine(BufferedReader reader) throws IOException {
        Print.printText(CUISINE_CHO);
        String point = reader.readLine();

        Cuisine result;
        switch (point) {

            case "1" -> result = Cuisine.Polish;
            case "2" -> result = Cuisine.Mexican;
            case "3" -> result = Cuisine.Italian;
            default -> throw new CustomException("wrong choice..");
        }
        return result;
    }

    private MealType getTypeMeal(BufferedReader reader) throws IOException {
        Print.printText(TYPE_MEAL);
        String point = reader.readLine();

        MealType result;
        switch (point) {

            case "1" -> result = MealType.Course;
            case "2" -> result = MealType.Dessert;
            default -> throw new CustomException("wrong choice..");
        }
        return result;
    }

}
