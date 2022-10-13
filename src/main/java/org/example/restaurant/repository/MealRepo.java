package org.example.restaurant.repository;

import org.example.restaurant.entity.Meal;
import org.example.restaurant.entity.enums.Cuisine;

import java.util.List;

public interface MealRepo {

    List<Meal> getAll(Cuisine cuisine);
}
