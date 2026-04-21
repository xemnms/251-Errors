package com.calculator.galindon.main;

import com.calculator.galindon.service.Calculator_Galindon;
import com.calculator.galindon.exception.InvalidInputException_Galindon;
import com.calculator.galindon.exception.NegativeResultException_Galindon;


public class CalculatorDemo_Galindon {

    public static void main(String[] args) {

        Calculator_Galindon service = new Calculator_Galindon();

        try {
            System.out.println("Add: " + service.add(10, 5));
            System.out.println("Multiply: " + service.multiply(4, 3));

            // VALID subtract
            System.out.println("Subtract: " + service.subtract(10, 5));

            // TRIGGER negative result exception
            System.out.println("Subtract: " + service.subtract(5, 10));

        } catch (NegativeResultException_Galindon e) {
            System.out.println("Negative Result Error: " + e.getMessage());
        } catch (InvalidInputException_Galindon e) {
            System.out.println("Input Error: " + e.getMessage());
        }

        try {
            // TRIGGER invalid input (division by zero)
            System.out.println("Divide: " + service.divide(10, 0));

        } catch (InvalidInputException_Galindon e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }
}

/*

How did you organize your packages?
    - I organized them into 3 packages: main, service, and exception. Each package groups classes that serve the same purpose.
Why did you separate your classes this way?
    - So each class has one clear responsibility. This makes the code easier to read and maintain.
How do packages improve encapsulation?
    - Packages keep related classes together and hide implementation details from other parts of the program. This prevents unintended access and reduces dependencies between unrelated classes.
Where are your exceptions located?  
    - Both InvalidInputException_Galindon and NegativeResultException_Galindon are in com.calculator.galindon.exception. Keeping them in one place makes them easy to find and reuse.
Why did you choose Maven or Gradle?
    - Maven automates building and compiling the project with simple commands. It also manages project structure and plugins like the exec plugin to run the program easily.

*/
