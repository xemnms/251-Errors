package main;
import exception.InvalidInputException;
import service.Isles_Calculator;

public class CalculatorDemo_Isles {
    public static void main(String[] args) {

        //create calculator object 
        Isles_Calculator calc = new Isles_Calculator();

        System.out.println("=== CALCULATOR DEMO ===\n");

        //running normal operations
        try {
            System.out.println("Addition (int): 5 + 3 = " + calc.add(5, 3));
            System.out.println("Addition (double): 2.5 + 4.5 = " + calc.add(2.5, 4.5));

            System.out.println("Subtraction: 10 - 4 = " + calc.subtract(10, 4));
            System.out.println("Multiplication: 6 * 2 = " + calc.multiply(6, 2));
            System.out.println("Division: 8 / 2 = " + calc.divide(8, 2));

        } catch (InvalidInputException e) {
            System.out.println("Invalid Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }

        System.out.println("\n=== EXCEPTION TESTING ===");

        //test both zero
        try {
            calc.add(0, 0);
        } catch (InvalidInputException e) {
            System.out.println("Caught InvalidInputException: " + e.getMessage());
        }

        //test negative number
        try {
            calc.multiply(-5, 3);
        } catch (Exception e) {
            System.out.println("Caught NegativeNumberException: " + e.getMessage());
        }

        //test divide by zero
        try {
            calc.divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other Error: " + e.getMessage());
        }

        //show result tallying (to show encapsulation demo)
        System.out.println("\n=== CALCULATOR STATE ===");
        System.out.println("Last Result: " + calc.getLastResult());
        System.out.println("Total Operations Used: " + calc.getOperationCount());
    }
}
