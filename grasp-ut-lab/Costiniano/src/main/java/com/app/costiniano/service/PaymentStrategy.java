package com.app.costiniano.service;

import com.app.costiniano.entity.Order;

public interface PaymentStrategy {
    void processPayment(Order order);
    String getMethodName();
}