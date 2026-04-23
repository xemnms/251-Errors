package com.calculator.rodenas.service;

import com.calculator.rodenas.exception.InvalidInputException;
import com.calculator.rodenas.exception.NegativeNumberException;

/*
Abstract class (Abstraction)
Defines calculator operations contract
*/

public abstract class Calculator_Rodenas {

    public abstract double add(double a, double b) throws InvalidInputException;
    public abstract double subtract(double a, double b) throws InvalidInputException;
    public abstract double multiply(double a, double b) throws InvalidInputException;
    public abstract double divide(double a, double b) throws InvalidInputException;
}