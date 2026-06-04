package com.app.payment;

// SOLID: OCP - new behavior added without modifying existing code
public class CashPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using CASH: " + amount);
    }
}