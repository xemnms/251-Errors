import java.util.Scanner;

public class CalculatorDemo_IslesRodenas {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Isles_Rodenas_Calculator calc = new Isles_Rodenas_Calculator();

        System.out.println("===== Isles & Rodenas Calculator System =====");

        try {
            System.out.print("Enter First Number  : ");
            double firstNum = in.nextDouble();

            System.out.print("Enter Second Number : ");
            double secondNum = in.nextDouble();

            System.out.println("\n===== Results =====");

            try {
                System.out.println("Addition       : " + calc.add(firstNum, secondNum));
            } catch (InvalidInputException | Isles_Rodenas_NegativeNumberException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                System.out.println("Subtraction    : " + calc.subtract(firstNum, secondNum));
            } catch (InvalidInputException | Isles_Rodenas_NegativeNumberException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                System.out.println("Multiplication : " + calc.multiply(firstNum, secondNum));
            } catch (InvalidInputException | Isles_Rodenas_NegativeNumberException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                System.out.println("Division       : " + calc.divide(firstNum, secondNum));
            } catch (InvalidInputException | Isles_Rodenas_NegativeNumberException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\nLast Result    : " + calc.getLastResult());
            System.out.println("Operations Done: " + calc.getOperationCount());

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } finally {
            System.out.println("\nCalculation Completed.");
            in.close();
        }
    }
}
