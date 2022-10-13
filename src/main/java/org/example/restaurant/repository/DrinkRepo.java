package org.example.restaurant.repository;

import org.example.restaurant.entity.Drink;
import org.example.restaurant.entity.enums.Cuisine;

import java.util.List;

public interface DrinkRepo {

    List<Drink> getAll(Cuisine cuisine);
}
