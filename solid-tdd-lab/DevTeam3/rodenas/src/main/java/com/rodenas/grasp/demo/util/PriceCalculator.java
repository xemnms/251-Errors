package com.rodenas.grasp.demo.util;

import com.rodenas.grasp.demo.entity.Order;

// SRP/DIP: Price math is its own abstraction so services do not hardcode calculation rules.
public interface PriceCalculator {
    double calculateVat(double total);
    double calculateSeniorDiscount(double total);
    double calculateFinalTotal(double total, boolean isSenior);
    double calculateTotalWithVat(Order order);
}
