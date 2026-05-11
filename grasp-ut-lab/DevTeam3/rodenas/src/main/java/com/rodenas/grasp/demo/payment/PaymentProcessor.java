package com.rodenas.grasp.demo.payment;

// GRASP: Polymorphism - interface allows multiple payment implementations
// GRASP: Protected Variations - new payment methods won't break existing code
public interface PaymentProcessor {
    String getPaymentMethod();
    boolean process(double amount);
    String getReceipt(double amount);
}