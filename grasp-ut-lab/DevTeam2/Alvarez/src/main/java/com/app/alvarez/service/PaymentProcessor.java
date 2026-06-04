package com.app.alvarez.service;

import com.app.alvarez.entity.PaymentMethod;

// GRASP: Protected Variations - callers depend on this stable payment interface, not concrete processors.
public interface PaymentProcessor {

    PaymentMethod supports();

    void process(double amount);
}