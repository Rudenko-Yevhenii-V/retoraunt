package org.example.restaurant.service.Impl;

import org.example.restaurant.entity.Drink;
import org.example.restaurant.entity.enums.Cuisine;
import org.example.restaurant.init.InitDb;
import org.example.restaurant.service.DrinkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class DrinkServiceImplTest {

    private final static DrinkService drinkService = new DrinkServiceImpl();

    @BeforeAll
    public static void setUp() {
        new InitDb().initEntity();
    }
    @Test
    void getAll() {
        List<Drink> allPolish = drinkService.getAll(Cuisine.Polish);

        allPolish.forEach(drink -> Assertions.assertEquals(Cuisine.Polish, drink.getCuisine()));
    }
}