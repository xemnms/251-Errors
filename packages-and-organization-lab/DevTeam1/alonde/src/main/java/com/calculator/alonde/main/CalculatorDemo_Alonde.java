package com.calculator.alonde.main;

import com.calculator.alonde.exception.InvalidInputException_Alonde;
import com.calculator.alonde.exception.NegativeResultException_Alonde;
import com.calculator.alonde.service.Calculator_Alonde;

public class CalculatorDemo_Alonde {
  public static void main(String[] args) {
    Calculator_Alonde calc = new Calculator_Alonde(false);

    System.out.println("=== Calculator Demo Program ===");

      // testing addition (normal and overloaded)
      try {
        System.out.println("Addition: ");
        System.out.println("Int Addition (6 + 7): " + calc.add(6, 7));
        System.out.println("Double Addition (5.5 + 7.5): " + calc.add(5.5, 7.5));
      } 
      catch (Exception e) {
        System.out.println("Unexpected Error: " + e.getMessage());
      }

      // testing subtraction and triggering checked exception (InvalidInput)
      try {
        System.out.println("\nSubtraction: ");
        calc.subtract(0, 1300);
      } 
      catch (InvalidInputException_Alonde e) {
        System.out.println("Caught Checked Exception: " + e.getMessage());
      }

      // testing multiplication and triggering unchecked exception (NegativeResult)
      try {
        System.out.println("\nMultiplication: ");
        System.out.println("Result: " + calc.multiply(6, -6));
      } 
      catch (NegativeResultException_Alonde e) {
        System.out.println("Caught Unchecked Exception: " + e.getMessage());
      }

      // testing division and triggering arithmetic exception
      try {
        System.out.println("\nDivision: ");
        calc.divide(130, 0); 
      } 
      catch (ArithmeticException e) {
        System.err.println("Caught Arithmetic Exception: " + e.getMessage());
      } 
      finally {
        // demonstrating try-catch-finally
        System.out.println("Division Test Sequence Completed.");
      }

      System.out.println("\n=== Demo Terminated Successfully ===");
  }
}


/*

  PROJECT ANALYSIS:
  
  1. How did you organize your packages?
   - I used a reverse-domain package (com.calculator.alonde), split into service, 
     exception, and main.

  2. Why did you separate your classes this way?
   - This keeps business logic (service) away from user interaction (main), making
     it easier to test or update independently.

  3. How do packages improve encapsulation?
   - Packages allow me to use access modifiers like 'protected' or 'package-private'
     to hide helper methods from other layers.

  4. Where are your exceptions located?
   - All custom exceptions are centralized in the com.calculator.alonde.exception 
     package. Specifically, the InvalidInputException_Alonde.java and 
     NegativeResultException_Alonde.java files.

  5. Why did you choose Maven or Gradle?
   - I chose Maven for its standardized directory structure and because it's 
     commonly used for java projects.

 */