package com.calculator.rodenas.service;

import com.calculator.rodenas.exception.InvalidInputException;
import com.calculator.rodenas.exception.NegativeNumberException;

public class CalculatorServiceImpl extends Calculator_Rodenas {

    private double lastResult;
    private int operationCount;
    private boolean allowNegativeResults = false;

    public double getLastResult() {
        return lastResult;
    }

    public int getOperationCount() {
        return operationCount;
    }

    private void validate(double a, double b) throws InvalidInputException {
        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }
    }

    private void checkNegative(double result) {
        if (!allowNegativeResults && result < 0) {
            throw new NegativeNumberException("Negative results are not allowed");
        }
    }

    @Override
    public double add(double a, double b) throws InvalidInputException {
        validate(a, b);
        double result = a + b;
        checkNegative(result);

        lastResult = result;
        operationCount++;
        return result;
    }

    @Override
    public double subtract(double a, double b) throws InvalidInputException {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new InvalidInputException("Invalid input for subtraction");
        }

        return a - b; // ✅ no restriction
    }

    @Override
    public double multiply(double a, double b) throws InvalidInputException {
        validate(a, b);
        double result = a * b;
        checkNegative(result);

        lastResult = result;
        operationCount++;
        return result;
    }

    @Override
    public double divide(double a, double b) throws InvalidInputException {
        validate(a, b);

        if (b == 0) {
            throw new InvalidInputException("Cannot divide by zero");
        }

        double result = a / b;
        checkNegative(result);

        lastResult = result;
        operationCount++;
        return result;
    }
}