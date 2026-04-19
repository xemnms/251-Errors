package com.calculator.nepomuceno;

import com.calculator.nepomuceno.exception.InvalidInputException_Nepomuceno;
import com.calculator.nepomuceno.exception.NegativeResultException_Nepomuceno;
import com.calculator.nepomuceno.service.Calculator_Nepomuceno;

public class CalculatorDemo_Nepomuceno {
    public static void main(String[] args) {
        Calculator_Nepomuceno calc = new Calculator_Nepomuceno(false);

        System.out.println("=== Calculator Demo Program ===");

        // testing addition (normal and overloaded)
        try {
            System.out.println("Addition: ");
            System.out.println("Int Addition (6 + 7): " + calc.add(6, 7));
            System.out.println("Double Addition (5.5 + 7.5): " + calc.add(5.5, 7.5));
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        // testing subtraction and triggering checked exception (InvalidInput)
        try {
            System.out.println("\nSubtraction: ");
            calc.subtract(0, 1300);
        } catch (InvalidInputException_Nepomuceno e) {
            System.out.println("Caught Checked Exception: " + e.getMessage());
        }

        // testing multiplication and triggering unchecked exception (NegativeResult)
        try {
            System.out.println("\nMultiplication: ");
            System.out.println("Result: " + calc.multiply(6, -6));
        } catch (NegativeResultException_Nepomuceno e) {
            System.out.println("Caught Unchecked Exception: " + e.getMessage());
        }

        // testing division and triggering arithmetic exception
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