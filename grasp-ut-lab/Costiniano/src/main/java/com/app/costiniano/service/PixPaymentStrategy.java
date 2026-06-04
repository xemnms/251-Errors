package com.app.costiniano.service;

import com.app.costiniano.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class PixPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(Order order) {
        order.setStatus("PAID_VIA_PIX");
    }

    @Override
    public String getMethodName() { 
        return "PIX"; 
    }
}