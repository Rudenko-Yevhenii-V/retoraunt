package org.example.restaurant.service;

import org.example.restaurant.entity.Drink;
import org.example.restaurant.entity.enums.Cuisine;

import java.util.List;

public interface DrinkService {

    List<Drink> getAll(Cuisine cuisine);

}
