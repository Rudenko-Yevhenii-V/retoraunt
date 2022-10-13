package org.example.restaurant.repository.bd;

import lombok.experimental.FieldDefaults;
import org.example.restaurant.entity.BaseEntity;
import org.example.restaurant.entity.Drink;
import org.example.restaurant.entity.Meal;
import org.example.restaurant.entity.Order;
import org.example.restaurant.entity.enums.Cuisine;

import java.time.Instant;
import java.util.*;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class ListDB {
    static ListDB listDBInstance;
    List<Drink> drinks = new ArrayList<>();
    List<Meal> meals = new ArrayList<>();
    List<Order> orders = new ArrayList<>();

    private ListDB() {}

    public static ListDB getInstance(){
        if (listDBInstance == null){
            listDBInstance = new ListDB();
        }

        return listDBInstance;
    }

    public BaseEntity create(BaseEntity entity) {
        entity.setId(generateId());
        entity.setCreatedDate(getTime());
        String clazzName = entity.getClass().getSimpleName();

        if (clazzName.equals("Meal")) {
            meals.add((Meal) entity);
        }
        if (clazzName.equals("Drink")) {
            drinks.add((Drink) entity);
        }
        if (clazzName.equals("Order")) {
            orders.add((Order) entity);
        }
        return entity;
    }

    public List<Meal> getAllMeal(Cuisine cuisine) {
        List<Meal> mealList = meals.stream()
                .filter(meal -> Objects.equals(meal.getCuisine(), cuisine))
                .toList();

        return mealList;
    }

    public List<Drink> getAllDrink(Cuisine cuisine) {
        List<Drink> drinkList = drinks.stream()
                .filter(drink -> Objects.equals(drink.getCuisine(), cuisine))
                .toList();

        return drinkList;
    }

    public String getOrdersReport(String password) {
        if (password.equals("password")) {
            StringBuilder result = new StringBuilder();
            orders.forEach(order -> result.append(String.format("Id %s = %s ", order.getId(), order.getPrice())));

            return result.toString();
        }

        return "Forbidden";
    }

    private UUID generateId() {
        return UUID.randomUUID();
    }

    private Instant getTime() {
        return Instant.now();
    }

}
