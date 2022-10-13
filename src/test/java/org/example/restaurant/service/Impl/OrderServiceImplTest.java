package org.example.restaurant.service.Impl;

import org.example.restaurant.entity.Order;
import org.example.restaurant.entity.enums.Cuisine;
import org.example.restaurant.init.InitDb;
import org.example.restaurant.repository.bd.ListDB;
import org.example.restaurant.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    private final static OrderService service = new OrderServiceImpl();
    private ListDB listDB = ListDB.getInstance();

    @BeforeAll
    public static void setUp() {
        new InitDb().initEntity();
    }

    @Test
    void createOrder() {
        Order order = Order.builder()
                .drinks(listDB.getAllDrink(Cuisine.Polish))
                .build();
        Order savedOrder = service.createOrder(order);

        Assertions.assertNotNull(savedOrder);
        Assertions.assertNotNull(savedOrder.getId());
        Assertions.assertNotNull(savedOrder.getCreatedDate());
    }
}