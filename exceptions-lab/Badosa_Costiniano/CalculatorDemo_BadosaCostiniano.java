public class CalculatorDemo_BadosaCostiniano {
    public static void main(String[] args) {

        CalculatorInterface_BadosaCostiniano calculator = new Calculator_BadosaCostiniano(); // Dynamic Binding

        try {
            System.out.println("Add: " + calculator.add(5, 3));
            System.out.println("Multiply: " + calculator.multiply(4, 2));

            // trigger error
            System.out.println("Divide: " + calculator.divide(10, 0));

        } catch (ZeroDivisionException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (NegativeNumberException e) {
            System.out.println("Checked Error: " + e.getMessage());
        } finally {
            System.out.println("Operation finished.");
        }

        // propagation example
        try {
            testNegative(calculator);
        } catch (NegativeNumberException e) {
            System.out.println("Handled in main: " + e.getMessage());
        }
    }

    public static void testNegative(CalculatorInterface_BadosaCostiniano calculator) throws NegativeNumberException {
        calculator.divide(-5, 2); // propagates
    }
}

/*
 * - What exceptions did you create? We created ZeroDivisionException
 * (unchecked) and NegativeNumberException (checked).
 * - Which are checked vs unchecked? ZeroDivisionException is unchecked, while
 * NegativeNumberException is checked.
 * - Where are exceptions thrown? Exceptions are thrown in the divide method of
 * the Calculator_BadosaCostiniano class.
 * - Where are they handled? They are handled in the main method using try-catch
 * blocks.
 * - Where does propagation occur? Propagation occurs in the testNegative method
 * when it calls the divide method and doesn't handle the exception.
 * - How did you apply OOP concepts? OOP concepts like encapsulation,
 * inheritance, and polymorphism were applied through the use of interfaces and
 * abstract classes to define a common contract for calculator operations.
 */