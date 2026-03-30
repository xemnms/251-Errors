
import java.util.*;

public class Main {
    public static void main(String[] args) {

            int number = 10;
            Student student = new Student("Alice", 20);
            System.out.println("Student Friends: " + student.getFriends());

            try { 
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student Age: " + student.getAge());
                 // This will throw NullPointerException

                int result = divide(10, 0);
                System.out.println("Result: " + result);
            }  
            catch (Exception e) {
                
            } finally {
                System.out.println("This block will always execute.");
            }
        
    }

    public static int divide(int a, int b) {
        return a / b; // This will throw ArithmeticException if b is 0
    }
}