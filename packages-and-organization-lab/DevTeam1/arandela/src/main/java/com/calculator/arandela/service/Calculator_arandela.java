package com.calculator.arandela.service;

import com.calculator.arandela.exception.InvalidInputException_arandela;
import com.calculator.arandela.exception.NegativeResultException_arandela;

public class Calculator_arandela {

    private boolean allowNegativeResults;

    // CONSTRUCTOR 
    public Calculator_arandela(boolean allowNegativeResults) {
        this.allowNegativeResults = allowNegativeResults;
    }

    // NEGATIVE CHECK 
    private void checkNegative(double result) {
        if (!allowNegativeResults && result < 0) {
            throw new NegativeResultException_arandela("Error: Negative results are not allowed.");
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
    public int subtract(int a, int b) {
        int result = a - b;
        checkNegative(result);
        return result;
    }

    public double subtract(double a, double b) {
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
    public int divide(int a, int b) throws InvalidInputException_arandela {
        if (b == 0) {
            throw new InvalidInputException_arandela("Error: Cannot divide by zero.");
        }

        int result = a / b;
        checkNegative(result);
        return result;
    }

    public double divide(double a, double b) throws InvalidInputException_arandela {
        if (b == 0) {
            throw new InvalidInputException_arandela("Error: Cannot divide by zero.");
        }

        double result = a / b;
        checkNegative(result);
        return result;
    }
}