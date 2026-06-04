package com.app.controller;

import com.app.entity.Order;
import com.app.service.OrderService;

// SOLID: SRP - only handles HTTP requests
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order create(Order order) {
        return orderService.createOrder(order);
    }

    public void pay(Long id, double amount) {
        orderService.payForOrder(id, amount);
    }
}