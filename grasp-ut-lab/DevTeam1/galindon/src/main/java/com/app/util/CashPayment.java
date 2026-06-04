package com.app.util;

public class CashPayment implements Payment {

    @Override
    public void process() {
        System.out.println("Cash payment processed");
    }
}