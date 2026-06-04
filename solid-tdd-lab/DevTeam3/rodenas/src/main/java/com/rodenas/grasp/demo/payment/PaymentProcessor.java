package com.rodenas.grasp.demo.payment;

// ISP/OCP: Small payment interface lets new payment types be added without changing order logic.
public interface PaymentProcessor {
    String getPaymentMethod();
    boolean process(double amount);
    String getReceipt(double amount);
}
