package com.app.alvarez.service;

import com.app.alvarez.entity.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class CashPaymentProcessor implements PaymentProcessor {

    // GRASP: Polymorphism - cash payments provide their own behavior behind the PaymentProcessor interface.
    @Override
    public PaymentMethod supports() {
        return PaymentMethod.CASH;
    }

    @Override
    public void process(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Cash payment amount must be positive");
        }
    }
}