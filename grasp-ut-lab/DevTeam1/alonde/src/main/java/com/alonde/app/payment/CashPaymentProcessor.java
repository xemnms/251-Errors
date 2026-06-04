package com.alonde.app.payment;

import org.springframework.stereotype.Component;

// grasp: polymorphism - 2nd implementation of PaymentProcessor
@Component("cashProcessor")
public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("[Cash] Recording cash payment of ₱" + amount);
    }

    @Override
    public String getType() { return "CASH"; }
}
