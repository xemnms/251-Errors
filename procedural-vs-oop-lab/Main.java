import java.util.Scanner;

public class Main {

    // Basic Operations
    public static double add(double a, double b) { return a + b; }

    public static double subtract(double a, double b) { return a - b; }

    public static double multiply(double a, double b) { return a * b; }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return a / b;
    }

    public static double modulo(double a, double b) {
        return a % b;
    }

    // Advanced Operations
    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double squareRoot(double a) {
        return Math.sqrt(a);
    }

    public static double absolute(double a) {
        return Math.abs(a);
    }

    public static double max(double a, double b) {
        return Math.max(a, b);
    }

    public static double min(double a, double b) {
        return Math.min(a, b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== CALCULATOR ===");
        System.out.println("1. +  (Addition)");
        System.out.println("2. -  (Subtraction)");
        System.out.println("3. *  (Multiplication)");
        System.out.println("4. /  (Division)");
        System.out.println("5. %  (Modulo)");
        System.out.println("6. ^  (Power)");
        System.out.println("7. √  (Square Root)");
        System.out.println("8. abs (Absolute)");
        System.out.println("9. max (Maximum)");
        System.out.println("10. min (Minimum)");

        System.out.print("Choose operation: ");
        int choice = sc.nextInt();

        double num1, num2, result = 0;

        switch (choice) {

            case 1:
                System.out.print("Enter two numbers: ");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                result = add(num1, num2);
                break;

            case 2:
                System.out.print("Enter two numbers: ");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                result = subtract(num1, num2);
                break;

            case 3:
                System.out.print("Enter two numbers: ");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                result = multiply(num1, num2);
                break;

            case 4:
                System.out.print("Enter two numbers: ");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                result = divide(num1, num2);
                break;

            case 5:
                System.out.print("Enter two numbers: ");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                result = modulo(num1, num2);
                break;

            case 6:
                System.out.print("Enter base and exponent: ");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                result = power(num1, num2);
                break;

            case 7:
                System.out.print("Enter number: ");
                num1 = sc.nextDouble();
                result = squareRoot(num1);
                break;

            case 8:
                System.out.print("Enter number: ");
                num1 = sc.nextDouble();
                result = absolute(num1);
                break;

            case 9:
                System.out.print("Enter two numbers: ");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                result = max(num1, num2);
                break;

            case 10:
                System.out.print("Enter two numbers: ");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                result = min(num1, num2);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Result: " + result);
    }
}
