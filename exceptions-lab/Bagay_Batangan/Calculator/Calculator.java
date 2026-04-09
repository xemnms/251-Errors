public abstract class Calculator {

    // DOUBLE METHODS
    public abstract double add(double a, double b);
    public abstract double subtract(double a, double b);
    public abstract double multiply(double a, double b);
    public abstract double divide(double a, double b) throws ZeroDivisionException;

    // INT METHODS (OVERLOADED)
    public abstract int add(int a, int b);
    public abstract int subtract(int a, int b);
    public abstract int multiply(int a, int b);
    public abstract int divide(int a, int b) throws ZeroDivisionException;
}
