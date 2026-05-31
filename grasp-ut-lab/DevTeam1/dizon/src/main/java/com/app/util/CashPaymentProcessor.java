package com.app.util;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism - concrete implementation of PaymentProcessor
// GRASP: High Cohesion - only responsible for cash payment logic
@Component("cash")
public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("Processing cash payment of $" + amount);
    }

    @Override
    public String getPaymentType() {
        return "CASH";
    }
}
