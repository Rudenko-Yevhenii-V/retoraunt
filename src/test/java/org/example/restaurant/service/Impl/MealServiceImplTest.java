package org.example.restaurant.service.Impl;

import org.example.restaurant.entity.Meal;
import org.example.restaurant.entity.enums.Cuisine;
import org.example.restaurant.init.InitDb;
import org.example.restaurant.service.MealService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class MealServiceImplTest {

    private final static MealService mealService = new MealServiceImpl();

    @BeforeAll
    public static void setUp() {
        new InitDb().initEntity();
    }

    @Test
    void getAll() {
        List<Meal> allPolish = mealService.getAll(Cuisine.Polish);

        allPolish.forEach(meal -> Assertions.assertEquals(Cuisine.Polish, meal.getCuisine()));

    }
}