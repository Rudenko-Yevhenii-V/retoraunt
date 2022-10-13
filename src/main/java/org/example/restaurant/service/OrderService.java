package org.example.restaurant.service;

import org.example.restaurant.entity.Order;

public interface OrderService {
    Order createOrder(Order order);

    void finalizeOrder(Order order);

    String getReport(String position);
}
