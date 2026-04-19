package com.calculator.bagay.service;

import com.calculator.bagay.exception.InvalidInputException;
import com.calculator.bagay.exception.ZeroDivisionException;

/**
 * Calculator is an abstract base class that defines the contract for all
 * calculator implementations. This class demonstrates the service layer of
 * the layered architecture.
 *
 * PACKAGE ORGANIZATION:
 * - Located in: com.calculator.bagay.service
 * - Purpose: Defines calculator operation interface
 * - Design: Abstract class with method overloading
 *
 * WHY THIS STRUCTURE:
 * - Separates interface (Calculator) from implementation (BasicCalculator)
 * - Allows multiple calculator implementations
 * - Encapsulates core calculations in the service layer
 *
 * EXCEPTION HANDLING:
 * - Exceptions are declared in separate com.calculator.bagay.exception package
 * - This keeps cross-cutting concerns organized
 * - Makes it easy to add new exception types
 */
public abstract class Calculator {

    public abstract double add(double a, double b) throws InvalidInputException;
    public abstract double subtract(double a, double b) throws InvalidInputException;
    public abstract double multiply(double a, double b) throws InvalidInputException;
    public abstract double divide(double a, double b) throws InvalidInputException, ZeroDivisionException;

    public abstract int add(int a, int b);
    public abstract int subtract(int a, int b);
    public abstract int multiply(int a, int b);
    public abstract int divide(int a, int b) throws ZeroDivisionException;
}
