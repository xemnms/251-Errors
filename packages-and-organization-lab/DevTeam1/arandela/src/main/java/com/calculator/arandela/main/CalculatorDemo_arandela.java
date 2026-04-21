package com.calculator.arandela.main;

import com.calculator.arandela.service.Calculator_arandela;
import com.calculator.arandela.exception.InvalidInputException_arandela;
import com.calculator.arandela.exception.NegativeResultException_arandela;

public class CalculatorDemo_arandela {

    public static void main(String[] args) {

        // ABSTRACTION + ENCAPSULATION
        Calculator_arandela calc = new Calculator_arandela(false);

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
        } catch (NegativeResultException_arandela e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        // EXCEPTION 2: DIVIDE BY ZERO
        try {
            System.out.println("Division: " + calc.divide(10, 0));
        } catch (InvalidInputException_arandela e) {
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
How did you organize your packages?
- I organized my project into packages based on their purpose: exception for custom errors, service for the calculator logic, and the main package for running the program.

Why did you separate your classes this way?
- I separated them to keep the code clean and easy to manage, so each part of the program has its own responsibility.

How do packages improve encapsulation?
- Packages group related classes together and limit access, which helps protect the code and makes it easier to control what can be used outside.

Where are your exceptions located?
- My custom exceptions are placed in the com.calculator.arandela.exception package.

Why did you choose Maven or Gradle?
- I chose Maven because it is simple to use, automatically manages dependencies, and helps organize the project structure properly.
*/