public class Calculator_Alonde_Dizon_Nepomuceno {

    private boolean allowNegativeResults;

    public Calculator_Alonde_Dizon_Nepomuceno(boolean allowNegativeResults) {
        this.allowNegativeResults = allowNegativeResults;
    }

    private void checkNegative(double result) {
        if (!allowNegativeResults && result < 0) {
            throw new NegativeResultException_Alonde_Dizon_Nepomuceno("Error: Negative results are not allowed.");
        }
    }
// ADDITION 
    public int add(int a, int b) {
        int result = a + b;
        checkNegative(result);
        return result;
    }

    public double add(double a, double b) {
        double result = a + b;
        checkNegative(result);
        return result;
    }

    // SUBTRACTION 
    public int subtract(int a, int b) throws InvalidInputException_Alonde_Dizon_Nepomuceno {
        // Example of triggering a checked exception
        if (a == 0 && b > 1000) {
            throw new InvalidInputException_Alonde_Dizon_Nepomuceno("Large subtrahends from zero are restricted.");
        }
        int result = a - b;
        checkNegative(result);
        return result;
    }

    public double subtract(double a, double b) throws InvalidInputException_Alonde_Dizon_Nepomuceno {
        if (a == 0 && b > 1000) {
            throw new InvalidInputException_Alonde_Dizon_Nepomuceno("Large subtrahends from zero are restricted.");
        }
        double result = a - b;
        checkNegative(result);
        return result;
    }

    // MULTIPLICATION 
    public int multiply(int a, int b) {
        int result = a * b;
        checkNegative(result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        checkNegative(result);
        return result;
    }

    // DIVISION 

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Cannot divide by zero.");
        }

        int result = a / b;
        checkNegative(result);
        return result;
    }

    //Overloaded method for double division
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Cannot divide by zero.");
        }

        double result = (a / b);
        checkNegative(result);
        return result;
    }
}