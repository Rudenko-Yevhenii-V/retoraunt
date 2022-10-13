package org.example.restaurant.service.Impl;

import org.example.restaurant.entity.Meal;
import org.example.restaurant.entity.enums.Cuisine;
import org.example.restaurant.refl.ObjectFactory;
import org.example.restaurant.repository.MealRepo;
import org.example.restaurant.service.MealService;

import java.util.List;

public class MealServiceImpl implements MealService {
    private final MealRepo mealRepo = ObjectFactory.getInstance().getImplClass(MealRepo.class);

    @Override
    public List<Meal> getAll(Cuisine cuisine) {
        return mealRepo.getAll(cuisine);
    }
}
