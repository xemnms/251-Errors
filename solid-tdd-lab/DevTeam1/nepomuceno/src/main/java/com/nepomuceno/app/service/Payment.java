package com.nepomuceno.app.service;

import com.nepomuceno.app.entity.Order;

// GRASP: Polymorphism — defines a common interface for all payment types
// GRASP: Protected Variations — new payment methods can be added without changing existing code
public interface Payment {

    // Process the payment for a given order
    void process(Order order);

    // Returns the identifier for this payment type (e.g. "CREDIT_CARD", "CASH")
    String getType();
}
