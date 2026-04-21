/* 
This class represents the main class of the Calculator System. It handles user input and displays the resullt of different operations.
It demonstrates the use of custom exceptions for handling specific error cases (division by zero and negative numbers) as well as input mismatch exceptions.
*/

package com.calculator.bautista.main;

import com.calculator.bautista.service.Calculator_System;
import com.calculator.bautista.exception.DivisionByZeroException;
import com.calculator.bautista.exception.NegativeNumberException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculatorDemo_Bautista {
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
1. How did you organize your packages?
    * I organized my project into three main packages based on their roles:
        - main: Contains the main class "CalculatorDemo_Bautista" which handles user interaction and displays results.
        - service: Contains the "Calculator_System" class which implements the core logic of the calculator operations.
        - exception: Contains custom exception classes ("DivisionByZeroException" and "NegativeNumberException") to handle specific error cases.

2. Why did you separate your classes this way?
    * I separated the classes to follow the single responsibility principle and to improve code maintainability. 
    * Each class has its own specific role, making it easier to manage and understand the code.
    * The main class focuses on user interaction, the service class focuses on the logic of calculations, and the exception classes focus on error handling. 

3. How do packages improve encapsulation?
    * Packages help group related classes together and control access between them.
    * This prevents unnecesarry access to internal logic and keeps the system organized.

4. Where are your exceptions located?
    * All custom exceptions are placed inside the exception package.
    * This keeps error handling centralized and separate from the main logic of the application, making it easier to manage and understand.

5. Why did you choose Maven or Gradle?
    * I chose Maven because it helps manage dependencies and project structure easily.
    * It also provides a standardized way to build and run the project, making the process more efficient and less error-prone.
*/