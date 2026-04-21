package service;
public abstract class Isles_Rodenas_Calculator_Interface {

    //abstract methods (must be implemented)
    public abstract int add(int a, int b) throws Exception;
    public abstract double add(double a, double b) throws Exception;

    public abstract int subtract(int a, int b) throws Exception;
    public abstract double subtract(double a, double b) throws Exception;

    public abstract int multiply(int a, int b) throws Exception;
    public abstract double multiply(double a, double b) throws Exception;

    public abstract int divide(int a, int b) throws Exception;
    public abstract double divide(double a, double b) throws Exception;
}
