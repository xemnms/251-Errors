package com.calculator.batangan.main;

import java.util.Scanner;

import com.calculator.batangan.service.BasicCalculator;
import com.calculator.batangan.exception.InvalidInputException;
import com.calculator.batangan.exception.NegativeNumberException;
import com.calculator.batangan.exception.ZeroDivisionException;

public class CalculatorDemo_Batangan {

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

                    // Polymorphism (int methods)
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

                    // Output
                    System.out.println("Result: " + result);

                // Demonstrates method overloading using double methods
                } else if (mode == 2) {
                    System.out.print("Enter first number: ");
                    double a = in.nextDouble();

                    System.out.print("Enter second number: ");
                    double b = in.nextDouble();

                    double result;

                    // Polymorphism (double methods)
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

                    // Output
                    System.out.println("Result: " + result);

                } else {
                    throw new InvalidInputException("Invalid mode selected.");
                }

                // Encapsulation Demo & displays last executed operation
                System.out.println("Last Operation: " + calc.getLastOperation());

            // EXCEPTION HANDLING 
            } catch (ZeroDivisionException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                in.nextLine(); // clear input

            } catch (NegativeNumberException e) {
                System.out.println("Runtime Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter correct values.");
                in.nextLine(); // clear input

            } finally {
                System.out.println("---- Operation Complete ----");
            }
        }

        in.close();
        System.out.println("Calculator closed.");
    }
}
