package com.rodenas.grasp.demo.payment;

import org.springframework.stereotype.Component;

@Component
public class GCashPaymentProcessor implements PaymentProcessor {

    @Override
    public String getPaymentMethod() {
        return "GCASH";
    }

    @Override
    public boolean process(double amount) {
        System.out.println("[Kaydonalds] Processing GCASH payment of P" + amount);
        return true;
    }

    @Override
    public String getReceipt(double amount) {
        return "🍔 Kaydonalds Receipt | GCASH | Total: P" + amount + " | Salamat, balik ka ulit!";
    }
}
