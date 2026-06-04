package com.app.alvarez.service;

import com.app.alvarez.entity.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class CardPaymentProcessor implements PaymentProcessor {

    // GRASP: Polymorphism - card payments provide their own behavior behind the PaymentProcessor interface.
    @Override
    public PaymentMethod supports() {
        return PaymentMethod.CARD;
    }

    @Override
    public void process(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Card payment amount must be positive");
        }
    }
}