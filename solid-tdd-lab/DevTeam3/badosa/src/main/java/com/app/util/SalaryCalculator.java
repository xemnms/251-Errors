package com.app.util;

// SOLID: OCP — SalaryCalculator is closed for modification but open for expansion by accepting any pluggable TaxStrategy implementation.
// SOLID: DIP — SalaryCalculator depends strictly on the TaxStrategy abstraction interface rather than concrete math logic.
public class SalaryCalculator {

    private SalaryCalculator() {
        // Private constructor to prevent instantiation of utility class
    }

    public static double calculateAnnualSalary(double monthlySalary) {
        return monthlySalary * 12;
    }

    // SOLID: DIP — Accepts the TaxStrategy interface, delegating the calculation algorithm.
    public static double calculateTax(double monthlySalary, TaxStrategy strategy) {
        if (monthlySalary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        if (strategy == null) {
            throw new IllegalArgumentException("Tax strategy cannot be null");
        }
        return strategy.calculateTax(monthlySalary);
    }

    // SOLID: DIP — Computes net pay polymorphically using the provided strategy.
    public static double calculateNetPay(double monthlySalary, TaxStrategy strategy) {
        if (monthlySalary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        return monthlySalary - calculateTax(monthlySalary, strategy);
    }

    // SOLID: OCP / KISS — Factory helper that automatically determines the correct tax strategy based on salary brackets.
    public static TaxStrategy getStrategyForSalary(double monthlySalary) {
        if (monthlySalary > 5000.0) {
            return new HighIncomeTaxStrategy();
        } else {
            return new StandardTaxStrategy();
        }
    }
}
