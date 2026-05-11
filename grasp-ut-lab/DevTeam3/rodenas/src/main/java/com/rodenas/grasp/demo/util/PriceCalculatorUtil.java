package com.rodenas.grasp.demo.util;

import com.rodenas.grasp.demo.entity.Order;
import org.springframework.stereotype.Component;

// GRASP: Pure Fabrication - doesn't represent a real-world concept
// GRASP: High Cohesion - only handles price calculations
@Component
public class PriceCalculatorUtil {

    private static final double VAT_RATE = 0.12;
    private static final double SENIOR_DISCOUNT = 0.20;

    public double calculateVat(double total) {
        return total * VAT_RATE;
    }

    public double calculateSeniorDiscount(double total) {
        return total * SENIOR_DISCOUNT;
    }

    public double calculateFinalTotal(double total, boolean isSenior) {
        if (isSenior) return total - calculateSeniorDiscount(total);
        return total;
    }

    public double calculateTotalWithVat(Order order) {
        double total = order.calculateTotal();
        return total + calculateVat(total);
    }
}