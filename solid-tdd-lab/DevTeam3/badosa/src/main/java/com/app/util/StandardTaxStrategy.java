package com.app.util;

// SOLID: LSP — StandardTaxStrategy implements the TaxStrategy interface, behaves consistently, and can serve as a pluggable replacement for the abstraction anywhere in the system.
public class StandardTaxStrategy implements TaxStrategy {

    private static final double STANDARD_RATE = 0.20; // 20% standard rate

    @Override
    public double calculateTax(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        return salary * STANDARD_RATE;
    }
}
