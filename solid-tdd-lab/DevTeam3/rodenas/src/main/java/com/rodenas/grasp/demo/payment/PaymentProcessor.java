package com.rodenas.grasp.demo.payment;

public interface PaymentProcessor {
    String getPaymentMethod();
    boolean process(double amount);
    String getReceipt(double amount);
}
