public class CalculatorDemo_Arandela_Galindon {

    public static void main(String[] args) {

        // ABSTRACTION + ENCAPSULATION
        Calculator_Arandela_Galindon calc = new Calculator_Arandela_Galindon(false);

        System.out.println("=== Calculator Demo Program ===");

        // NORMAL OPERATIONS
        try {
            System.out.println("Addition: " + calc.add(10, 5));
            System.out.println("Multiplication: " + calc.multiply(3, 4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // EXCEPTION 1: NEGATIVE RESULT
        try {
            System.out.println("Subtraction: " + calc.subtract(5, 10));
        } catch (NegativeResultException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        // EXCEPTION 2: DIVIDE BY ZERO
        try {
            System.out.println("Division: " + calc.divide(10, 0));
        } catch (InvalidInputException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        // POLYMORPHISM (method overloading)
        try {
            System.out.println("Double Addition: " + calc.add(2.5, 3.7));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=== End of Program ===");
    }
}



/*
1. What exceptions did you create?
NegativeResultException and InvalidInputException. These handle negative results and invalid operations like division by zero.
2. Which are checked vs unchecked?
InvalidInputException is a checked exception because it extends Exception. NegativeResultException is unchecked because it extends RuntimeException.
3. Where are exceptions thrown?
NegativeResultException is thrown inside checkNegative() when results are negative. InvalidInputException is thrown in divide() when the divisor is zero.

*/