package com.app.util;

public class CreditCardPayment implements Payment {

    @Override
    public void process() {
        System.out.println("Credit card payment processed");
    }
}