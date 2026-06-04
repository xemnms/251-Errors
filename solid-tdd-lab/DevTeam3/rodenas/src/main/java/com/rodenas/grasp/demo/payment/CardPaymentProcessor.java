package com.rodenas.grasp.demo.payment;

import org.springframework.stereotype.Component;

@Component
public class CardPaymentProcessor implements PaymentProcessor {

    @Override
    public String getPaymentMethod() {
        return "CARD";
    }

    @Override
    public boolean process(double amount) {
        System.out.println("[Kaydonalds] Processing CARD payment of P" + amount);
        return true;
    }

    @Override
    public String getReceipt(double amount) {
        return "🍔 Kaydonalds Receipt | CARD | Total: P" + amount + " | Salamat, balik ka ulit!";
    }
}
