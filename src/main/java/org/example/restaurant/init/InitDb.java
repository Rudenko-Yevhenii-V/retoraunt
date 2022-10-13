package org.example.restaurant.init;

import lombok.experimental.FieldDefaults;
import org.example.restaurant.entity.Drink;
import org.example.restaurant.entity.Meal;
import org.example.restaurant.entity.enums.Cuisine;
import org.example.restaurant.entity.enums.MealType;
import org.example.restaurant.repository.bd.ListDB;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class InitDb {
    ListDB listDB;

    public InitDb() {
        this.listDB = ListDB.getInstance();
    }

    public void initEntity() {
        listDB.create(Meal.builder()
                .cuisine(Cuisine.Polish)
                .name("Pierogi")
                .mealType(MealType.Course)
                .price(200L)
                .build());

        listDB.create(Meal.builder()
                .cuisine(Cuisine.Polish)
                .name("Golabki")
                .mealType(MealType.Dessert)
                .price(400L)
                .build());

        listDB.create(Drink.builder()
                .cuisine(Cuisine.Polish)
                .name("Goldwasser")
                .price(40L)
                .build());

        listDB.create(Meal.builder()
                .cuisine(Cuisine.Mexican)
                .name("Mexican1")
                .mealType(MealType.Course)
                .price(100L)
                .build());

        listDB.create(Meal.builder()
                .cuisine(Cuisine.Mexican)
                .name("Mexican2")
                .mealType(MealType.Dessert)
                .price(200L)
                .build());

        listDB.create(Drink.builder()
                .cuisine(Cuisine.Mexican)
                .name("Mexican drink")
                .price(48L)
                .build());

        listDB.create(Meal.builder()
                .cuisine(Cuisine.Italian)
                .name("ItalianMeal")
                .mealType(MealType.Course)
                .price(500L)
                .build());

        listDB.create(Drink.builder()
                .cuisine(Cuisine.Italian)
                .name("ItalianDrink")
                .price(150L)
                .build());

    }
}
