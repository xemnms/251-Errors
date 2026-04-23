public class CalculatorDemo_Alonde_Dizon_Nepomuceno {
  public static void main(String[] args) {
    Calculator_Alonde_Dizon_Nepomuceno calc = new Calculator_Alonde_Dizon_Nepomuceno(false);

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
      catch (InvalidInputException_Alonde_Dizon_Nepomuceno e) {
        System.out.println("Caught Checked Exception: " + e.getMessage());
      }

      // testing multiplication and triggering unchecked exception (NegativeResult)
      try {
        System.out.println("\nMultiplication: ");
        System.out.println("Result: " + calc.multiply(6, -6));
      } 
      catch (NegativeResultException_Alonde_Dizon_Nepomuceno e) {
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
1. What exceptions did you create?
- We created two custom exception classes to handle specific business logic for the calculator.
  First is NegativeResultException. It was used when the user performs a calculation that
  results in a negative number while allowNegativeResults is set to false. Second is 
  InvalidOperandExceptio. It was used to catch specific mathematical scenarios that are
  logically restricted (for example, subtracting a very large number from zero).

2. Which are checked vs unchecked?
- InvalidInputException: checked (extends Exception).
- NegativeResultException: unchecked (extends RuntimeException)

3. Where are exceptions thrown?
- Exceptions are thrown in the following locations within the Calculator_Alonde_Dizon_Nepomuceno class 
  such as, negativeResultException, thrown within the private checkNegative(double result) 
  method. Since every operation (add, subtract, multiply, divide) calls this helper method, 
  the exception can originate from any of them. Thus, invalidOperandException it was thrown 
  inside the subtract(int a, int b) and subtract(double a, double b) methods if the input 
  parameters meet specific restricted criteria (e.g., a == 0 && b > 1000). Last but not the least,
  arithmeticException it also thrown inside both versions of the divide() method if the 
  divisor (b) is equal to zero.

4. Where are they handled?
- They are handled in this Demo class within the try-catch blocks in the main method.

5. Where does propagation occur?
- Exceptions propagate from the Calculator class methods to the main() method
  in the demo class when they are not handled inside the methods.

6. How did you apply OOP concepts?

Encapsulation:
- The field allowNegativeResults is private and controlled via the constructor.

Abstraction:
- Users interact with the calculator through methods like add(), subtract(),
  multiply(), and divide(), without needing to know the internal logic.

Inheritance:
- Custom exceptions extend Exception and RuntimeException.

Polymorphism:
- Method overloading is used for add, subtract, multiply, and divide methods
  (int and double versions).
*/