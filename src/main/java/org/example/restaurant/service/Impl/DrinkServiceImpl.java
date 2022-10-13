package org.example.restaurant.service.Impl;

import org.example.restaurant.entity.Drink;
import org.example.restaurant.entity.enums.Cuisine;
import org.example.restaurant.refl.ObjectFactory;
import org.example.restaurant.repository.DrinkRepo;
import org.example.restaurant.service.DrinkService;

import java.util.List;

public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepo drinkRepo = ObjectFactory.getInstance().getImplClass(DrinkRepo.class);

    @Override
    public List<Drink> getAll(Cuisine cuisine) {
        return drinkRepo.getAll(cuisine);
    }
}
