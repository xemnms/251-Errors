package com.app.payment;

public class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using CREDIT CARD: " + amount);
    }
}