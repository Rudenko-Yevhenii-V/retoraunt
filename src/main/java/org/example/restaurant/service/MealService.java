package org.example.restaurant.service;

import org.example.restaurant.entity.Meal;
import org.example.restaurant.entity.enums.Cuisine;

import java.util.List;

public interface MealService {

    List<Meal> getAll(Cuisine cuisine);

}
