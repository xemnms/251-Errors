package com.calculator.alonde.service;

import com.calculator.exception.InvalidInputException_Alonde;
import com.calculator.exception.NegativeResultException_Alonde;

public class Calculator_Alonde {

    private final boolean allowNegativeResults;

    public Calculator_Alonde(boolean allowNegativeResults) {
        this.allowNegativeResults = allowNegativeResults;
    }

    private void checkNegative(double result) {
        if (!allowNegativeResults && result < 0) {
            throw new NegativeResultException_Alonde("Error: Negative results are not allowed.");
        }
    }

    // ADDITION
    public int add(int a, int b) {
        int result = a + b;
        checkNegative(result);
        return result;
    }

    public double add(double a, double b) {
        double result = a + b;
        checkNegative(result);
        return result;
    }

    // SUBTRACTION
    public int subtract(int a, int b) throws InvalidInputException_Alonde {
        if (a == 0 && b > 1000) {
            throw new InvalidInputException_Alonde("Large subtrahends from zero are restricted.");
        }
        int result = a - b;
        checkNegative(result);
        return result;
    }

    public double subtract(double a, double b) throws InvalidInputException_Alonde {
        if (a == 0.0 && b > 1000.0) {
            throw new InvalidInputException_Alonde("Large subtrahends from zero are restricted.");
        }
        double result = a - b;
        checkNegative(result);
        return result;
    }

    // MULTIPLICATION
    public int multiply(int a, int b) {
        int result = a * b;
        checkNegative(result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        checkNegative(result);
        return result;
    }

    // DIVISION
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Cannot divide by zero.");
        }
        int result = a / b;
        checkNegative(result);
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0.0) {
            throw new ArithmeticException("Error: Cannot divide by zero.");
        }
        double result = a / b;
        checkNegative(result);
        return result;
    }
}