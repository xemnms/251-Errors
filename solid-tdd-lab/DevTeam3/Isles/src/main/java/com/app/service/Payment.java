package com.app.service;

// GRASP: Protected Variations - Payment hides changing payment algorithms behind one interface.
public interface Payment {

    // OCP: New payment methods add a new implementation instead of changing PaymentProcessor.
    String method();

    // GRASP: Polymorphism - each payment type decides how it processes a payment.
    PaymentReceipt process(double amount);
}
