package com.rodenas.grasp.demo.payment;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism - Cash implementation
@Component
public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public String getPaymentMethod() { return "CASH"; }

    @Override
    public boolean process(double amount) {
        System.out.println("[Kaydonalds] Processing CASH payment of P" + amount);
        return true;
    }

    @Override
    public String getReceipt(double amount) {
        return "🍔 Kaydonalds Receipt | CASH | Total: P" + amount + " | Salamat, balik ka ulit!";
    }
}