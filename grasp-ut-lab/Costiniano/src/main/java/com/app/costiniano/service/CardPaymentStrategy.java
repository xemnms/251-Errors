package com.app.costiniano.service;

import com.app.costiniano.entity.Order;
import org.springframework.stereotype.Component;

// GRASP: Polymorphism - Alternative execution behaviors handled through polymorphic classes
@Component
public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(Order order) {
        order.setStatus("PAID_VIA_CARD");
    }

    @Override
    public String getMethodName() { 
        return "CARD"; 
    }
}