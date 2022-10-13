package org.example.restaurant.repository.impl;

import org.example.restaurant.entity.Order;
import org.example.restaurant.repository.OrderRepo;
import org.example.restaurant.repository.bd.ListDB;

public class OrderRepoImpl implements OrderRepo {
    ListDB listDB = ListDB.getInstance();

    @Override
    public Order create(Order order) {
        return (Order) listDB.create(order);
    }

    @Override
    public String getReport(String position) {
        return listDB.getOrdersReport(position);
    }
}
