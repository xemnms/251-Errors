package com.app.util;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism - concrete implementation of PaymentProcessor
// GRASP: High Cohesion - only responsible for credit card payment logic
@Component("creditCard")
public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }

    @Override
    public String getPaymentType() {
        return "CREDIT_CARD";
    }
}
