package com.calculator.dizon.main;

import com.calculator.dizon.service.Calculator_Dizon;
import com.calculator.dizon.exception.InvalidInputException_Dizon;
import com.calculator.dizon.exception.NegativeResultException_Dizon;

public class CalculatorDemo_Dizon {
    public static void main(String[] args) {
        // Instantiate the service with negative results disabled
        Calculator_Dizon calc = new Calculator_Dizon(false);

        System.out.println("=== Calculator Demo Program (Dizon) ===");

        // Normal Addition
        try {
            System.out.println("Addition: ");
            System.out.println("Int Addition (6 + 7): " + calc.add(6, 7));
            System.out.println("Double Addition (5.5 + 7.5): " + calc.add(5.5, 7.5));
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        // Triggering Checked Exception (InvalidInput)
        try {
            System.out.println("\nSubtraction Test:");
            calc.subtract(0, 1300);
        } catch (InvalidInputException_Dizon e) {
            System.out.println("Caught Checked Exception: " + e.getMessage());
        }

        // Triggering Unchecked Exception (NegativeResult)
        try {
            System.out.println("\nMultiplication Test:");
            System.out.println("Result: " + calc.multiply(6, -6));
        } catch (NegativeResultException_Dizon e) {
            System.out.println("Caught Unchecked Exception: " + e.getMessage());
        }

        // Triggering Arithmetic Exception
        try {
            System.out.println("\nDivision Test:");
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
- I organized my project using a layered architecture to keep components distinct by their role:
  com.calculator.dizon.service
     - This contains the main logic and math operations.
  com.calculator.dizon.exception
     - This contains my custom error classes for both checked and unchecked exceptions.
  com.calculator.dizon.main
     - This holds the demo class that acts as the entry point for the program.

Why did you separate your classes this way?
- I separated them to implement "Separation of Concerns." By isolating the logic, the exceptions, 
  and the execution class, the code is much easier to maintain and troubleshoot. 
- It also ensures that the business logic (the math) isn't cluttered by the code used 
  just to print outputs in the demo.

How do packages improve encapsulation?
- Packages allow me to group related classes together and control access levels. 
- In this project, I used private modifiers for fields like allowNegativeResults and 
  kept internal validation methods hidden from the main class. 
- This ensures that only the intended "public" methods are visible to other packages, 
  preventing external classes from messing with the internal logic rules.

Where are your exceptions located?
- My exceptions are located in the dedicated package:
  com.calculator.dizon.exception
- Specifically:
  - InvalidInputException_Dizon.java (Checked)
  - NegativeResultException_Dizon.java (Unchecked)

Why did you choose Maven or Gradle?
- I chose Maven because it creates a standard structure (src/main/java) that is widely 
  used in professional Java development. 
- The pom.xml makes it easy to set the compiler version and manage the build process, 
  making the project portable and easy for my teammates to run.
*/