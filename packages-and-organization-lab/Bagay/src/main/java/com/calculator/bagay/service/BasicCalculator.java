package com.calculator.bagay.service;

import com.calculator.bagay.exception.InvalidInputException;
import com.calculator.bagay.exception.NegativeNumberException;
import com.calculator.bagay.exception.ZeroDivisionException;

/**
 * BasicCalculator is a concrete implementation of the Calculator abstract class.
 * This class demonstrates the service layer implementation of the layered architecture.
 *
 * PACKAGE ORGANIZATION:
 * - Located in: com.calculator.bagay.service
 * - Purpose: Implements calculator operations with validation
 * - Design: Concrete class extending Calculator abstract class
 *
 * LAYERED ARCHITECTURE:
 * - Service Layer: This class handles all core calculations
 * - Exception Layer: Uses exceptions from com.calculator.bagay.exception
 * - Encapsulation: Uses private methods for internal validation
 *
 * ACCESS MODIFIERS EXPLANATION:
 * - Private fields: lastOperation stores internal state
 * - Private methods: validateDoubleInput, validateIntInput are internal helpers
 * - Public methods: Override abstract methods for external use
 * - This prevents unauthorized access to validation logic
 */
public class BasicCalculator extends Calculator {
    private String lastOperation = "none";

    /**
     * Validates double input values for NaN, infinity, and negative numbers.
     * This is a private helper method demonstrating proper encapsulation.
     */
    private void validateDoubleInput(double a, double b) throws InvalidInputException {
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new InvalidInputException("Input must be a valid finite number.");
        }
        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed.");
        }
    }

    private void validateIntInput(int a, int b) {
        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed.");
        }
    }

    public String getLastOperation() {
        return lastOperation;
    }

    @Override
    public double add(double a, double b) throws InvalidInputException {
        validateDoubleInput(a, b);
        lastOperation = "add(double, double)";
        return a + b;
    }

    @Override
    public double subtract(double a, double b) throws InvalidInputException {
        validateDoubleInput(a, b);
        lastOperation = "subtract(double, double)";
        return a - b;
    }

    @Override
    public double multiply(double a, double b) throws InvalidInputException {
        validateDoubleInput(a, b);
        lastOperation = "multiply(double, double)";
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws InvalidInputException, ZeroDivisionException {
        validateDoubleInput(a, b);
        if (b == 0.0d) {
            throw new ZeroDivisionException("Cannot divide by zero.");
        }
        lastOperation = "divide(double, double)";
        return a / b;
    }

    @Override
    public int add(int a, int b) {
        validateIntInput(a, b);
        lastOperation = "add(int, int)";
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        validateIntInput(a, b);
        lastOperation = "subtract(int, int)";
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        validateIntInput(a, b);
        lastOperation = "multiply(int, int)";
        return a * b;
    }

    @Override
    public int divide(int a, int b) throws ZeroDivisionException {
        validateIntInput(a, b);
        if (b == 0) {
            throw new ZeroDivisionException("Cannot divide by zero.");
        }
        lastOperation = "divide(int, int)";
        return a / b;
    }
}
