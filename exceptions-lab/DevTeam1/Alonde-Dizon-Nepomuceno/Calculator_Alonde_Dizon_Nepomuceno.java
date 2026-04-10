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

    // SUBTRACTION 



    // MULTIPLICATION 
  
    public int multiply(int a, int b) {
        int result = a * b;
        checkNegative(result);
        return result;
    }

    //Overloaded method for double multiplication
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