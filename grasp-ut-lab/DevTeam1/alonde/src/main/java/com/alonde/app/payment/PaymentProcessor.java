package com.alonde.app.payment;

// grasp: protected variations - stable interface, swappable implementations
// grasp: low coupling - service depends on this interface, not concrete classes
public interface PaymentProcessor {
    void process(double amount);
    String getType();
}
