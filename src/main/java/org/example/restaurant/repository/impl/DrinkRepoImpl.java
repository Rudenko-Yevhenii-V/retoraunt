package org.example.restaurant.repository.impl;

import org.example.restaurant.entity.Drink;
import org.example.restaurant.entity.enums.Cuisine;
import org.example.restaurant.repository.DrinkRepo;
import org.example.restaurant.repository.bd.ListDB;

import java.util.List;

public class DrinkRepoImpl implements DrinkRepo {
    ListDB listDB = ListDB.getInstance();

    @Override
    public List<Drink> getAll(Cuisine cuisine) {
        return listDB.getAllDrink(cuisine);
    }
}
