package service;

import exception.InvalidInputException;

public abstract class Isles_Calculator_Interface {

    public abstract int add(int a, int b) throws InvalidInputException;
    public abstract double add(double a, double b) throws InvalidInputException;

    public abstract int subtract(int a, int b) throws InvalidInputException;
    public abstract double subtract(double a, double b) throws InvalidInputException;

    public abstract int multiply(int a, int b) throws InvalidInputException;
    public abstract double multiply(double a, double b) throws InvalidInputException;

    public abstract int divide(int a, int b) throws InvalidInputException;
    public abstract double divide(double a, double b) throws InvalidInputException;
}
