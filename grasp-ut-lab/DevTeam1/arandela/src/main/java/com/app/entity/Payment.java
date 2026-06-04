package com.app.entity;

// GRASP: Polymorphism - shared contract for all payment types
// GRASP: Protected Variations - new types added without changing existing code
public interface Payment {
    void process(double amount);
    String getPaymentType();
}
