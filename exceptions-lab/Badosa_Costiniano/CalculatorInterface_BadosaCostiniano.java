public interface CalculatorInterface_BadosaCostiniano {

    // method overloading
    int add(int a, int b);

    double add(double a, double b);

    int subtract(int a, int b);

    double subtract(double a, double b);

    int multiply(int a, int b);

    double multiply(double a, double b);

    double divide(double a, double b) throws NegativeNumberException;
}