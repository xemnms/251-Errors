import java.util.Scanner;

public class Main_Batangan {
    public static void main(String[] args) {

    	Scanner in = new Scanner(System.in);
        BasicCalculator calcu = new BasicCalculator();

        try {
            System.out.print("Enter first number: ");
            double num1 = in.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = in.nextDouble();

            System.out.println("\n--------------------------");
            System.out.println("Choose operation:");
            System.out.println("1 - Add");
            System.out.println("2 - Subtract");
            System.out.println("3 - Multiply");
            System.out.println("4 - Divide");
            System.out.print("Enter choice: ");
            int choice = in.nextInt();

            double result = 0;

            switch (choice) {
                case 1:
                    result = calcu.add(num1, num2);
                    break;

                case 2:
                    result = calcu.subtract(num1, num2);
                    break;

                case 3:
                    result = calcu.multiply(num1, num2);
                    break;

                case 4:
                    result = calcu.divide(num1, num2); // may throw exception
                    break;

                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            System.out.println("Result: " + result);

        } catch (DivZeroException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (negativeNumException e) {
            System.out.println("Runtime Error: " + e.getMessage());

        } catch (Exception e) {
            // handles invalid input like letters instead of numbers
            System.out.println("Invalid input! Please enter numbers only.");

        } finally {
            System.out.println("Successful.");
            in.close();
        }
    }
}
