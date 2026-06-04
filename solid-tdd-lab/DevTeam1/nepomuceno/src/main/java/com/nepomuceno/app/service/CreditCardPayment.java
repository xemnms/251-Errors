package com.nepomuceno.app.service;

import com.nepomuceno.app.entity.Order;
import org.springframework.stereotype.Component;

// GRASP: Polymorphism — one concrete implementation of the Payment interface
@Component
public class CreditCardPayment implements Payment {

    @Override
    public void process(Order order) {
        // GRASP: High Cohesion — only credit card payment logic here
        System.out.println("Processing credit card payment for Order ID: "
                + order.getId()
                + " | Total: " + order.calculateTotal());
        order.setStatus("PAID_CREDIT");
    }

    @Override
    public String getType() {
        return "CREDIT_CARD";
    }
}
