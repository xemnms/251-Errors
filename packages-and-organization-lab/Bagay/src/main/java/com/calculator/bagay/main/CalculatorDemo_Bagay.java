package com.calculator.bagay.main;

import java.util.Scanner;

import com.calculator.bagay.service.BasicCalculator;
import com.calculator.bagay.exception.InvalidInputException;
import com.calculator.bagay.exception.NegativeNumberException;
import com.calculator.bagay.exception.ZeroDivisionException;

/**
 * CalculatorDemo_Bagay demonstrates the complete calculator system with
 * proper package organization and exception handling.
 *
 * Q1: How did you organize your packages?
 * Organized into layered architecture: service (core calculations), exception (error handling), main (UI).
 *
 * Q2: Why separate classes this way?
 * Separation of Concerns - each package has one responsibility.
 * Service layer can be reused, exceptions are centralized, UI is independent.
 *
 * Q3: How do packages improve encapsulation?
 * Packages hide implementation details. Private methods can't be accessed externally.
 * Only public interfaces are exposed, preventing unauthorized access to internal logic.
 *
 * Q4: Where are exceptions located?
 * All in com.calculator.bagay.exception package.
 * InvalidInputException (checked), NegativeNumberException (unchecked), ZeroDivisionException (checked).
 *
 * Q5: Why choose Maven?
 * Standardizes build process, manages dependencies, enforces project structure,
 * makes scaling and testing easier.
 */
public class CalculatorDemo_Bagay {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        BasicCalculator calc = new BasicCalculator();

        // Allows the program to run continuously until user exits
        boolean running = true;

        // Mode Selection for int or double
        while (running) {
            try {
                System.out.println("\n─────୨୧ CALCULATOR ୨୧─────");
                System.out.println("Choose mode:");
                System.out.println("1 - Integer");
                System.out.println("2 - Double");
                System.out.println("3 - Exit");
                System.out.print("Enter choice: ");

                int mode = in.nextInt();

                if (mode == 3) {
                    System.out.println("Exiting calculator...");
                    break;
                }

                // Operation Menu
                System.out.println("\nChoose operation:");
                System.out.println("1 - Add");
                System.out.println("2 - Subtract");
                System.out.println("3 - Multiply");
                System.out.println("4 - Divide");
                System.out.print("Enter choice: ");

                int choice = in.nextInt();

                // Demonstrates method overloading using int methods
                if (mode == 1) {
                    System.out.print("Enter first integer: ");
                    int a = in.nextInt();

                    System.out.print("Enter second integer: ");
                    int b = in.nextInt();

                    int result;

                    // Polymorphism through abstract method implementation
                    switch (choice) {
                        case 1:
                            result = calc.add(a, b);
                            break;
                        case 2:
                            result = calc.subtract(a, b);
                            break;
                        case 3:
                            result = calc.multiply(a, b);
                            break;
                        case 4:
                            result = calc.divide(a, b);
                            break;
                        default:
                            throw new InvalidInputException("Invalid operation choice.");
                    }

                    System.out.println("Result: " + result);

                } else if (mode == 2) {
                    System.out.print("Enter first number: ");
                    double a = in.nextDouble();

                    System.out.print("Enter second number: ");
                    double b = in.nextDouble();

                    double result;

                    // Polymorphism through abstract method implementation
                    switch (choice) {
                        case 1:
                            result = calc.add(a, b);
                            break;
                        case 2:
                            result = calc.subtract(a, b);
                            break;
                        case 3:
                            result = calc.multiply(a, b);
                            break;
                        case 4:
                            result = calc.divide(a, b);
                            break;
                        default:
                            throw new InvalidInputException("Invalid operation choice.");
                    }

                    System.out.println("Result: " + result);

                } else {
                    throw new InvalidInputException("Invalid mode selected.");
                }

                // Encapsulation Demo - access lastOperation through public getter only
                System.out.println("Last Operation: " + calc.getLastOperation());

            } catch (ZeroDivisionException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                in.nextLine(); // clear input buffer

            } catch (NegativeNumberException e) {
                System.out.println("Runtime Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter correct values.");
                in.nextLine(); // clear input buffer

            } finally {
                System.out.println("---- Operation Complete ----");
            }
        }

        in.close();
        System.out.println("Calculator closed.");
    }
}
