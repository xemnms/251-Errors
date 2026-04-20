//main calculator class 
//this class showcases the logic of calculator

public class Isles_Rodenas_Calculator extends Isles_Rodenas_Calculator_Interface {

    //private attributes
    private double lastResult; //stores last computed result
    private int operationCount; //counts how many operations were used

    //getter for lastResult
    public double getLastResult() {
        return lastResult;
    }
    //setter for lastResult
    public void setLastResult(double lastResult) {
        this.lastResult = lastResult;
    }
    //getter for operationCount
    public int getOperationCount() {
        return operationCount;
    }
    //setter for operationCount
    public void setOperationCount(int operationCount) {
        this.operationCount = operationCount;
    }

    //int version - method overloading - add
    @Override
    public int add(int a, int b) throws InvalidInputException {

        //invalid if both are zero
        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        //invalid if may negative
        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
        }

        int result = a + b; //performs addition

        setLastResult(result); //save last result
        operationCount++; //increase usage counter

        return result;
    }

    //double version - overloading - add
    @Override
    public double add(double a, double b) throws InvalidInputException {

        //same validation
        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
        }

        double result = a + b;//performs addition

        setLastResult(result);
        operationCount++;

        return result;
    }

    //int version - method overloading - subtract
    @Override
    public int subtract(int a, int b) throws InvalidInputException {

        //input checking
        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
        }

        int result = a - b; //performs subtraction

        setLastResult(result);
        operationCount++;

        return result;
    }

    //double version - overloading - subtract
    @Override
    public double subtract(double a, double b) throws InvalidInputException {

        //same validation ulit
        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
        }

        double result = a - b; //performs subtraction

        setLastResult(result);
        operationCount++;

        return result;
    }

    //int version - method overloading - multiply
    @Override
    public int multiply(int a, int b) throws InvalidInputException {

        //check invalid inputs
        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
        }

        int result = a * b; //multiply

        setLastResult(result);
        operationCount++;

        return result;
    }

    //double version - overloading - multiply
    @Override
    public double multiply(double a, double b) throws InvalidInputException {

        //validation again
        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
        }

        double result = a * b;

        setLastResult(result);
        operationCount++;

        return result;
    }
    
    //int version - method overloading - division
    @Override
    public int divide(int a, int b) throws InvalidInputException {

        //input validation
        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
        }

        //division by zero is invalid
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        int result = a / b; //division

        setLastResult(result);
        operationCount++;

        return result;
    }

    //double version - overloading - division
    @Override
    public double divide(double a, double b) throws InvalidInputException {

        //same checks
        if (a == 0 && b == 0) {
            throw new InvalidInputException("Both inputs cannot be zero");
        }

        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
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