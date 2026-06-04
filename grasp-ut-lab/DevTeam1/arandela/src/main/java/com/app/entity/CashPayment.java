package com.app.entity;

// GRASP: Polymorphism - concrete implementation of Payment
public class CashPayment implements Payment {
    @Override
    public void process(double amount) {
        System.out.println("Processing CASH payment of: " + amount);
    }
    @Override
    public String getPaymentType() { return "CASH"; }
}
