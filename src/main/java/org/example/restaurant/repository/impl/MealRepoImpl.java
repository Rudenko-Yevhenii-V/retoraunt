package org.example.restaurant.repository.impl;

import org.example.restaurant.entity.Meal;
import org.example.restaurant.entity.enums.Cuisine;
import org.example.restaurant.repository.MealRepo;
import org.example.restaurant.repository.bd.ListDB;

import java.util.List;

public class MealRepoImpl implements MealRepo {
    ListDB listDB = ListDB.getInstance();

    @Override
    public List<Meal> getAll(Cuisine cuisine) {
        return listDB.getAllMeal(cuisine);
    }
}
