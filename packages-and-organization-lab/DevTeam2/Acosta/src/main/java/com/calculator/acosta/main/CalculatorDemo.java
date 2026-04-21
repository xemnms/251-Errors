package com.calculator.acosta.main;
import com.calculator.acosta.service.Calculator_System;
import com.calculator.acosta.exception.NegativeNumberException;
import com.calculator.acosta.exception.DivisionByZeroException;
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

/*
 * ====== CODE-BASED ANALYSIS ======
 * How did you organize your packages?
 * - Following the readme file, I created the folder tree accordingly.
 * - Exception (Errir handlers), Main (Excecution), Service (Logic)
 * 
 * Why did you separate your classes this way?
 * - This improves readability and makes the system easier to maintain.
 * 
 * Where are your exceptions located?
 * - Exceptions are placed in a separate package (exception) to isolate error handling logic.
 * 
 * Why did you choose Maven?
 * - I chose Maven to manage the project structure and automate the build prcess
 */
