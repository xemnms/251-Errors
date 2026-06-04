package com.rodenas.grasp.demo.util;

import com.rodenas.grasp.demo.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class PriceCalculatorImpl implements PriceCalculator {

    private static final double VAT_RATE = 0.12;
    private static final double SENIOR_DISCOUNT = 0.20;

    @Override
    public double calculateVat(double total) {
        return total * VAT_RATE;
    }

    @Override
    public double calculateSeniorDiscount(double total) {
        return total * SENIOR_DISCOUNT;
    }

    @Override
    public double calculateFinalTotal(double total, boolean isSenior) {
        if (isSenior) {
            return total - calculateSeniorDiscount(total);
        }
        return total;
    }

    @Override
    public double calculateTotalWithVat(Order order) {
        double total = order.calculateTotal();
        return total + calculateVat(total);
    }
}
