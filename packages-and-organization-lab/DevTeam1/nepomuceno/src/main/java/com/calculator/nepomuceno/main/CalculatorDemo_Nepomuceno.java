package com.calculator.nepomuceno.main;

import com.calculator.nepomuceno.exception.InvalidInputException_Nepomuceno;
import com.calculator.nepomuceno.exception.NegativeResultException_Nepomuceno;
import com.calculator.nepomuceno.service.Calculator_Nepomuceno;

public class CalculatorDemo_Nepomuceno {
    public static void main(String[] args) {
        Calculator_Nepomuceno calc = new Calculator_Nepomuceno(false);

        System.out.println("=== Calculator Demo Program ===");

        try {
            System.out.println("Addition: ");
            System.out.println("Int Addition (6 + 7): " + calc.add(6, 7));
            System.out.println("Double Addition (5.5 + 7.5): " + calc.add(5.5, 7.5));
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        try {
            System.out.println("\nSubtraction: ");
            calc.subtract(0, 1300);
        } catch (InvalidInputException_Nepomuceno e) {
            System.out.println("Caught Checked Exception: " + e.getMessage());
        }

        try {
            System.out.println("\nMultiplication: ");
            System.out.println("Result: " + calc.multiply(6, -6));
        } catch (NegativeResultException_Nepomuceno e) {
            System.out.println("Caught Unchecked Exception: " + e.getMessage());
        }

        try {
            System.out.println("\nDivision: ");
            calc.divide(130, 0);
        } catch (ArithmeticException e) {
            System.err.println("Caught Arithmetic Exception: " + e.getMessage());
        } finally {
            System.out.println("Division Test Sequence Completed.");
        }

        System.out.println("\n=== Demo Terminated Successfully ===");
    }
}

/*
How did you organize your packages?
- I organized my packages by responsibility under a common base package (com.calculator.nepomuceno):
  1) com.calculator.nepomuceno.service
     - Contains the core calculator logic (Calculator_Nepomuceno).
  2) com.calculator.nepomuceno.exception
     - Contains custom exception classes (InvalidInputException_Nepomuceno, NegativeResultException_Nepomuceno).
  3) com.calculator.nepomuceno.main
     - Contains the demo/main runner class (CalculatorDemo_Nepomuceno).

Why did you separate your classes this way?
- To keep the code clean and maintainable:
  - The service package holds business logic (operations + validation rules).
  - The exception package holds reusable error types that the service throws and callers catch.
  - The demo class is only for running/testing the program and should not be mixed with the logic layer.

How do packages improve encapsulation?
- Packages improve encapsulation by grouping related classes and helping limit what other parts of the program can access.
- In Java, access can be controlled using visibility levels:
  - private: accessible only inside the class
  - package-private (no modifier): accessible only within the same package
  - public: accessible anywhere
- In this project, encapsulation is supported by:
  - private fields/methods like allowNegativeResults and checkNegative(...), so users can’t bypass validation.
  - keeping exceptions in a separate package so the calculator API is clearer and organized.

Where are your exceptions located?
- They are located in the package:
  com.calculator.nepomuceno.exception
- Files:
  - InvalidInputException_Nepomuceno.java
  - NegativeResultException_Nepomuceno.java

Why did you choose Maven or Gradle?
- I chose Maven because:
  - It is commonly used for Java projects and is simple for small applications.
  - It enforces a standard folder structure (src/main/java), which helps avoid build/compile issues.
  - It uses a pom.xml that clearly defines compilation settings and plugins (like running the main class).
*/