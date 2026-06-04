package com.app.util;

// GRASP: Polymorphism - defines the contract that all payment methods must follow
// GRASP: Protected Variations - adding new payment methods won't break existing code
public interface PaymentProcessor {
    void process(double amount);
    String getPaymentType();
}
