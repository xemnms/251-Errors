// main calculator class 
// this class showcases the logic of calculator

public class Isles_Rodenas_Calculator extends Isles_Calculator_Interface {

    // private attributes
    private double lastResult; // stores last computed result
    private int operationCount; // counts how many operations were used

    // getter for lastResult
    public double getLastResult() {
        return lastResult;
    }

    // setter for lastResult
    public void setLastResult(double lastResult) {
        this.lastResult = lastResult;
    }

    // getter for operationCount
    public int getOperationCount() {
        return operationCount;
    }

    // setter for operationCount
    public void setOperationCount(int operationCount) {
        this.operationCount = operationCount;
    }

    // int version - add
    @Override
    public int add(int a, int b) throws InvalidInputException {

        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new Isles_Rodenas_NegativeNumberException("Negative numbers are not allowed");
        }

        int result = a + b;

        setLastResult(result);
        operationCount++;

        return result;
    }

    // double version - add
    @Override
    public double add(double a, double b) throws InvalidInputException {

        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new Isles_Rodenas_NegativeNumberException("Negative numbers are not allowed");
        }

        double result = a + b;

        setLastResult(result);
        operationCount++;

        return result;
    }

    // int version - subtract
    @Override
    public int subtract(int a, int b) throws InvalidInputException {

        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new Isles_Rodenas_NegativeNumberException("Negative numbers are not allowed");
        }

        int result = a - b;

        setLastResult(result);
        operationCount++;

        return result;
    }

    // double version - subtract
    @Override
    public double subtract(double a, double b) throws InvalidInputException {

        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new Isles_Rodenas_NegativeNumberException("Negative numbers are not allowed");
        }

        double result = a - b;

        setLastResult(result);
        operationCount++;

        return result;
    }

    // int version - multiply
    @Override
    public int multiply(int a, int b) throws InvalidInputException {

        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new Isles_Rodenas_NegativeNumberException("Negative numbers are not allowed");
        }

        int result = a * b;

        setLastResult(result);
        operationCount++;

        return result;
    }

    // double version - multiply
    @Override
    public double multiply(double a, double b) throws InvalidInputException {

        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new Isles_Rodenas_NegativeNumberException("Negative numbers are not allowed");
        }

        double result = a * b;

        setLastResult(result);
        operationCount++;

        return result;
    }

    // int version - divide
    @Override
    public int divide(int a, int b) throws InvalidInputException {

        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new Isles_Rodenas_NegativeNumberException("Negative numbers are not allowed");
        }

        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        int result = a / b;

        setLastResult(result);
        operationCount++;

        return result;
    }

    // double version - divide
    @Override
    public double divide(double a, double b) throws InvalidInputException {

        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new Isles_Rodenas_NegativeNumberException("Negative numbers are not allowed");
        }

        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        double result = a / b;

        setLastResult(result);
        operationCount++;

        return result;
    }
}
