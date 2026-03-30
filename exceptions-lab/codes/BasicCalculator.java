class BasicCalculator extends Calculator {

    // Method Overloading (int version)
    public int add(int a, int b) {
        return a + b;
    }

    // Method Overriding (double version)
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws DivZeroException {
        if (b == 0) {
            throw new DivZeroException("Cannot divide by zero!");
        }
        return a / b;
    }

    // Example method with unchecked exception
    public double squareRoot(double num) {
        if (num < 0) {
            throw new negativeNumException("Negative numbers not allowed!");
        }
        return Math.sqrt(num);
    }
}
