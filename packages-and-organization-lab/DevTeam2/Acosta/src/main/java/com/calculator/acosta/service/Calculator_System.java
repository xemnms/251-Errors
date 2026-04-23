package com.calculator.acosta.service;
import com.calculator.acosta.exception.DivisionByZeroException;
import com.calculator.acosta.exception.NegativeNumberException;

public class Calculator_System {

    // Methods for integer operations
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide by zero.");
        }
        return a / b;
    }

    // Overloaded methods for double inputs
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide by zero.");
        }
        return a / b;
    }

    // Method to check for negative numbers
    public void checkNegative(double num) {
        if (num < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed.");
        }
    }
}