package com.alonde.app.payment;

import org.springframework.stereotype.Component;

// grasp: polymorphism - 1st implementation of PaymentProcessor
@Component("creditCardProcessor")
public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("[Credit Card] Charging ₱" + amount + " via credit card gateway...");
    }

    @Override
    public String getType() { return "CREDIT_CARD"; }
}