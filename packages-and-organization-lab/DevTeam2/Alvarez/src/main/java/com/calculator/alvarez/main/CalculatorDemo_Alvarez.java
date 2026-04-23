/* 
This class represent Calculator Demo on how the system function properly and how it handles exceptions. 
It demonstrates the use of custom exceptions, method overloading, and basic arithmetic operations.
Created by Acosta, Alvarez, Bautista 
*/

// packages and imports
package com.calculator.alvarez.main;
import com.calculator.alvarez.service.Calculator_System;
import com.calculator.alvarez.exception.DivisionByZeroException;
import com.calculator.alvarez.exception.NegativeNumberException;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculatorDemo_Alvarez {
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
* I separated my project into model, service, exception, util, and main packages.
* Each package has a clear responsibility, following OOP modular design.

2. Why did you separate your classes this way?
* Service classes handle business logic, model classes represent data,
* exceptions handle error conditions, and main contains the entry point.
* This separation makes the code easier to maintain and extend.

3. How do packages improve encapsulation?
* Packages group related classes together and hide implementation details.
* Other parts of the program only import what they need, reducing coupling.

4. Where are your exceptions located?
* All custom exceptions (DivisionByZeroException, NegativeNumberException)
* are inside the 'exception' package for clarity and reuse.

5. Why did you choose Maven or Gradle?
* I chose Maven because it standardizes project structure, manages dependencies,
* and automates builds. It integrates well with Codespaces and makes running
* the project consistent across environments.

*/
