/* 
This class represent Calculator Demo on how the system function properly and how it handles exceptions. 
It demonstrates the use of custom exceptions, method overloading, and basic arithmetic operations.
Created by Acosta, Alvarez, Bautista 
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculatorDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calculator_System calc = new Calculator_System();

        System.out.println("===== Simple Calculator System =====");

        try {
            // Ask user for two numbers
            System.out.print("Enter First Number  : ");
            double num1 = in.nextDouble();

            System.out.print("Enter Second Number : ");
            double num2 = in.nextDouble();

            // Check for negative numbers
            calc.checkNegative(num1);
            calc.checkNegative(num2);

            // Perform operations
            System.out.println("\n===== Results =====");
            System.out.println("Addition       : "  + calc.add(num1, num2));
            System.out.println("Subtraction    : " + calc.subtract(num1, num2));
            System.out.println("Multiplication : " + calc.multiply(num1, num2));

            // Division ( May throw exception if num2 is zero )
            System.out.println("Division       : " + calc.divide(num1, num2));

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numeric values only.");

        } catch (DivisionByZeroException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (NegativeNumberException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("\nCalculation Completed.");
            in.close();
        }
    }
}

/* ====== CODE-BASED ANALYSIS ======
1. What exceptions did you create?
* DivisionByZeroException
* NegativeNumberException

2. Which are checked vs unchecked?
* Checked Exception: DivisionByZeroException extends Exception
* Unchecked Exception: NegativeNumberException extends RuntimeException

3. Where are exceptions thrown?
* divide(int a, int b) and divide(double a, double b)
  - throws DivisionByZeroException when dividing by zero
* checkNegative(double num)
  - throws NegativeNumberException when number is negative
* InputMismatchException is thrown automatically by Scanner when input is not numeric

4. Where Exceptions are Handled?
* Inside the main method using:
    * catch (InputMismatchException e)
    * catch (DivisionByZeroException e)
    * catch (NegativeNumberException e)

5. Where does propagation occur?
* DivisionByZeroException is propagated from divide() methods to main using "throws" 
* NegativeNumberException propagates automatically (unchecked exception)
* InputMismatchException propagates from Scanner.nextDouble() to the try block

6. How did you apply OOP concepts?
* Encapsulation
    - Methods grouped inside Calculator_System class

* Method Overloading (Polymorphism)
    - Same method names (add, subtract, multiply, divide) implemented for both int and double parameters
    
* Inheritance
    - DivisionByZeroException extends Exception (checked exception)
    - NegativeNumberException extends RuntimeException (unchecked exception)

* Abstraction
    * Users interact with methods without knowing internal logic 

*/
