package com.nepomuceno.app.service;

import com.nepomuceno.app.entity.Order;
import org.springframework.stereotype.Component;

// GRASP: Polymorphism — second concrete implementation of the Payment interface
// GRASP: Protected Variations — adding this class required zero changes to existing code
@Component
public class CashPayment implements Payment {

    @Override
    public void process(Order order) {
        // GRASP: High Cohesion — only cash payment logic here
        System.out.println("Processing cash payment for Order ID: "
                + order.getId()
                + " | Total: " + order.calculateTotal());
        order.setStatus("PAID_CASH");
    }

    @Override
    public String getType() {
        return "CASH";
    }
}
