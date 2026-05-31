package com.alonde.app.payment;

import org.springframework.stereotype.Component;

// grasp: polymorphism - 3rd implementation of PaymentProcessor (bonus: multiple polymorphic implementations)
@Component("gcashProcessor")
public class GCashPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("[GCash] Sending ₱" + amount + " via GCash mobile wallet...");
    }

    @Override
    public String getType() { return "GCASH"; }
}