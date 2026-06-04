package com.app.util;

// GRASP: Pure Fabrication — SalaryCalculator is a utility class built to perform salary-related computations. Instead of overloading the Employee entity with tax calculation algorithms, we delegate it here to keep the Employee class simple.
// GRASP: High Cohesion — This class's only responsibility is calculating financial values related to employee salary.
public class SalaryCalculator {

    private static final double TAX_RATE = 0.20; // 20% flat tax rate

    private SalaryCalculator() {
        // Private constructor to prevent instantiation of utility class
    }

    public static double calculateAnnualSalary(double monthlySalary) {
        return monthlySalary * 12;
    }

    public static double calculateTax(double monthlySalary) {
        if (monthlySalary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        return monthlySalary * TAX_RATE;
    }

    public static double calculateNetPay(double monthlySalary) {
        if (monthlySalary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        return monthlySalary - calculateTax(monthlySalary);
    }
}
