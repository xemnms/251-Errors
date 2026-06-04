package com.app.entity;

// GRASP: Polymorphism - second concrete implementation of Payment
public class CardPayment implements Payment {
    @Override
    public void process(double amount) {
        System.out.println("Processing CARD payment of: " + amount);
    }
    @Override
    public String getPaymentType() { return "CARD"; }
}
