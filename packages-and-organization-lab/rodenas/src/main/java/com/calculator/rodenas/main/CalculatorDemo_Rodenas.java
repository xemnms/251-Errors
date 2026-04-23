package com.calculator.rodenas.main;

import java.util.Scanner;

import com.calculator.rodenas.service.CalculatorServiceImpl;
import com.calculator.rodenas.exception.InvalidInputException;
import com.calculator.rodenas.exception.NegativeNumberException;

/*
Main Demo Class
Demonstrates:
- Package usage
- Exception handling
- OOP concepts
Created by Rodenas
*/

public class CalculatorDemo_Rodenas {
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CalculatorServiceImpl calc = new CalculatorServiceImpl();

        System.out.println("===== Rodenas Calculator System =====");
        try {
            // USER INPUT
            System.out.print("Enter First Number  : ");
            double a = in.nextDouble();

            System.out.print("Enter Second Number : ");
            double b = in.nextDouble();

            System.out.println("\n===== Results =====");

            // ADD
            try {
                System.out.println("Addition       : " + calc.add(a, b));
            } catch (InvalidInputException | NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // SUBTRACT
            try {
                System.out.println("Subtraction    : " + calc.subtract(a, b));
            } catch (InvalidInputException | NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // MULTIPLY
            try {
                System.out.println("Multiplication : " + calc.multiply(a, b));
            } catch (InvalidInputException | NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // DIVIDE
            try {
                System.out.println("Division       : " + calc.divide(a, b));
            } catch (InvalidInputException | NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // SHOW STATS
            System.out.println("\nLast Result    : " + calc.getLastResult());
            System.out.println("Operations Done: " + calc.getOperationCount());

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Numbers only.");
        } finally {
            System.out.println("\nCalculation Completed.");
            in.close();
        }
    }
}

/* ====== CODE-BASED ANALYSIS ======

1. How did you organize your packages?
I organized my project into three main packages:
- exception → contains custom exception classes like InvalidInputException and NegativeNumberException
- service → contains the calculator logic, including the abstract class and its implementation
- main → contains the main class (CalculatorDemo_Rodenas) where the program is executed

2. Why did you separate your classes this way?
- To follow layered architecture and improve readability and maintainability

3. How do packages improve encapsulation?
- Packages improve encapsulation by grouping related classes together and limiting direct access between components.
- For example, the exception classes are only used when needed, and the main class interacts with the service layer instead of handling logic directly.

4. Where are your exceptions located?
- The custom exceptions are located in the com.calculator.rodenas.exception package.
- This includes InvalidInputException and NegativeNumberException.

5. Why did you choose Maven?
- I chose Maven because it helps manage the project structure and automates compiling and running the program.

*/