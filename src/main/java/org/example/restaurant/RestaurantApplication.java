package org.example.restaurant;

import org.example.restaurant.controller.OrderController;
import org.example.restaurant.init.InitDb;

public class RestaurantApplication {

    public static void main(String[] args) {
        new InitDb().initEntity();
        new OrderController().start();
    }
}
