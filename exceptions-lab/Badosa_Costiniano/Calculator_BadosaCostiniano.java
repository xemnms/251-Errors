public class Calculator_BadosaCostiniano implements CalculatorInterface_BadosaCostiniano {

    // ENCAPSULATION
    private boolean restrictNegative = true;

    // ADD
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    // SUBTRACT
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    // MULTIPLY
    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    // DIVIDE with exceptions
    @Override
    public double divide(double a, double b) throws NumberNegativeException {

        if (b == 0) {
            throw new ZeroDivisionException("Cannot divide by zero!");
        }

        if (restrictNegative && (a < 0 || b < 0)) {
            throw new NumberNegativeException("Negative numbers are not allowed.");
        }

        return a / b;
    }
}