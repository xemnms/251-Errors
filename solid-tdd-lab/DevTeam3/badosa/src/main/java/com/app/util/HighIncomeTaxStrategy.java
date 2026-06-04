package com.app.util;

// SOLID: LSP — HighIncomeTaxStrategy correctly implements the TaxStrategy contract and behaves interchangeably with any other tax strategy, ensuring stable base assumptions (like throwing exceptions for negative inputs).
public class HighIncomeTaxStrategy implements TaxStrategy {

    private static final double HIGH_INCOME_RATE = 0.30; // 30% rate for high earners

    @Override
    public double calculateTax(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        return salary * HIGH_INCOME_RATE;
    }
}
