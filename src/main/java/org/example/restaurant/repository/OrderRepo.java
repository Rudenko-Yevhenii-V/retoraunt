package org.example.restaurant.repository;

import org.example.restaurant.entity.Order;

public interface OrderRepo {

    Order create(Order order);

    String getReport(String position);
}
