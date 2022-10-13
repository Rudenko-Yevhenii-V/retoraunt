package org.example.restaurant.service.Impl;

import lombok.SneakyThrows;
import org.example.restaurant.controller.OrderController;
import org.example.restaurant.entity.Drink;
import org.example.restaurant.entity.Meal;
import org.example.restaurant.entity.Order;
import org.example.restaurant.refl.ObjectFactory;
import org.example.restaurant.repository.OrderRepo;
import org.example.restaurant.service.OrderService;
import org.example.restaurant.util.Print;

public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo = ObjectFactory.getInstance().getImplClass(OrderRepo.class);

    @Override
    public Order createOrder(Order order) {
        return orderRepo.create(order);
    }

    @Override
    @SneakyThrows
    public void finalizeOrder(Order order) {
        long priceOrder = 0;
        long priceMeals = order.getMeals().stream().map(Meal::getPrice).reduce(0L, Long::sum);;
        long priceDrinks = order.getDrinks().stream().map(Drink::getPrice).reduce(0L, Long::sum);;
        priceOrder += priceDrinks + priceMeals;

        if (priceOrder < 1) {
            Print.printGoAway();
            Thread.sleep(5000);

            new OrderController().start();
            return;
        }
        Print.printText(String.format("your restaurant bill was $%s", priceOrder));
        order.setPrice(priceOrder);
        createOrder(order);

        Print.printThans();

        Thread.sleep(5000);
        new OrderController().start();
    }

    @Override
    public String getReport(String position) {
        return orderRepo.getReport(position);
    }
}
