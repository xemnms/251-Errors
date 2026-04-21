import java.util.Scanner;

public class CalculatorDemo_IslesRodenas {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Isles_Calculator calc = new Isles_Calculator();

        System.out.println("===== Isles & Rodenas Calculator System =====");

        try {
            System.out.print("Enter First Number  : ");
            double firstNum = in.nextDouble();

            System.out.print("Enter Second Number : ");
            double secondNum = in.nextDouble();

            System.out.println("\n===== Results =====");

            try {
                System.out.println("Addition       : " + calc.add(firstNum, secondNum));
            } catch (InvalidInputException | Isles_Rodenas_NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                System.out.println("Subtraction    : " + calc.subtract(firstNum, secondNum));
            } catch (InvalidInputException | Isles_Rodenas_NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                System.out.println("Multiplication : " + calc.multiply(firstNum, secondNum));
            } catch (InvalidInputException | Isles_Rodenas_NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                System.out.println("Division       : " + calc.divide(firstNum, secondNum));
            } catch (InvalidInputException | Isles_Rodenas_NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\nLast Result    : " + calc.getLastResult());
            System.out.println("Operations Done: " + calc.getOperationCount());

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } finally {
            System.out.println("\nCalculation Completed.");
            in.close();
        }
    }
}

/* ====== CODE-BASED ANALYSIS ======

1. What exceptions did you create?
* InvalidInputException
* NegativeNumberException

2. Which are checked vs unchecked?
* Checked Exception: InvalidInputException extends Exception
* Unchecked Exception: NegativeNumberException extends RuntimeException

3. Where are exceptions thrown?
* add(int a, int b), add(double a, double b)
* subtract(int a, int b), subtract(double a, double b)
* multiply(int a, int b), multiply(double a, double b)
    - throws InvalidInputException when both inputs are zero
    - throws NegativeNumberException when any number is negative

* divide(int a, int b), divide(double a, double b)
    - throws InvalidInputException when both inputs are zero
    - throws NegativeNumberException when any number is negative
    - throws InvalidInputException when dividing by zero

4. Where Exceptions are Handled?
* Inside the main method using:
    * catch (InvalidInputException e)
    * catch (NegativeNumberException e)

5. Where does propagation occur?
* InvalidInputException is propagated from calculator methods to main using "throws"
* NegativeNumberException propagates automatically (unchecked exception)

6. How did you apply OOP concepts?

* Encapsulation
    - Methods grouped inside Isles_Rodenas_Calculator class

* Method Overloading (Polymorphism)
    - Same method names (add, subtract, multiply, divide) implemented for both int and double parameters

* Inheritance
    - Isles_Rodenas_Calculator extends Isles_Rodenas_Calculator_Interface
    - InvalidInputException extends Exception (checked exception)
    - NegativeNumberException extends RuntimeException (unchecked exception)

* Abstraction
    - Isles_Rodenas_Calculator_Interface defines abstract methods
    - Users interact with methods without knowing internal logic

*/
