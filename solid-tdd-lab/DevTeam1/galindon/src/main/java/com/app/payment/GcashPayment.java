package com.app.payment;

// SOLID: OCP - extension without modifying existing code
public class GCashPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using GCASH: " + amount);
    }
}