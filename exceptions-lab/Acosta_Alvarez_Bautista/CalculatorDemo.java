/* this represent Calculator Demo in which show how the system
functions properly alongside error messages.
Created by Acosta, Alvarez, Bautista */

import java.util.Scanner;

public class CalculatorDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calculator_System calc = new Calculator_System();

        try {
            // ask user for two numbers
            System.out.print("Enter First Number: ");
            double num1 = in.nextDouble();

            System.out.print("Enter Second Number: ");
            double num2 = in.nextDouble();

            // check for negative numbers
            calc.checkNegative(num1);
            calc.checkNegative(num2);

            // perform operations
            System.out.println("\nResults: ");
            System.out.println("Addition: "  + calc.add(num1, num2));
            System.out.println("Subtraction: " + calc.subtract(num1, num2));
            System.out.println("Multiplication: " + calc.multiply(num1, num2));

            // division (throw exception)
            System.out.println("Division: " + calc.divide(num1, num2));

        } catch (InvalidInputException e) {
            // handles division by zero
            System.out.println("Error: " + e.getMessage());
        
        } catch (NegativeNumberException e) {
            // handles negative number input
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            // handles other unexpected errors
            System.out.println("Invalid input. Please Enter Numeric values only.");

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
* divide(int a, int b) and divide(double a, double b) throws InvalidInputException when dividing by zero
* checkNegative(double num) throws NegativeNumberException when number is negative

4. Where Exceptions are Handled?
* Inside the main method using:
    * catch (InvalidInputException e)
    * catch (NegativeNumberException e)
    * catch (Exception e)

5. Where does propagation occur?
* From divide() methods propagated to main using throws InvalidInputException
* checkNegative() propagates automatically (unchecked exception)

6. How did you apply OOP concepts?
* Encapsulation
    * Methods grouped inside Calculator_System class

* Method Overloading (Polymorphism)
    * Same methods (add, subtract, etc.) with int and double
    
* Inheritance
    * Custom exceptions extend Exception and RuntimeException

* Abstraction
    * Users interact with methods without knowing internal logic */
