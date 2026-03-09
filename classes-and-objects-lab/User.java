/** 
 * This class represent a user with a name, age, and status
 * Created by Angelo Hayden Alvarez
 */

public class User {

    //Attributes
    String name;
    int age;
    String status;

    // Static attribute
    static int totalUsers = 0;

    // Default constructor
    User() {
        name = "Unknown";
        age = 0;
        status = "Undeclared";
        totalUsers++;
    }

    // Parameterized constructor
    User(String name, int age, String status) {
        this.name = name;
        this.age = age;
        this.status = status;
        totalUsers++;
    }

    // Overloaded constructor
    User(String name, String status) {
        this.name = name;
        this.status = status;
        this.age = 18; // default age
        totalUsers++;
    }

    // Behaviour without parameters
    void introduce() {
        System.out.println("Hello, I am " + name + ".");
        System.out.println("I am " + age + "years old.");
        System.out.println(name + " is a " + status + " as of the moment.");
    }


    // Behaviour with parameters;
    void updateStatus(String newStatus) {
        status = newStatus;
        System.out.println(name + " has updated their status to " + status + ".");
    }

    // Static method
    static void displayTotalUsers() {
        System.out.println("Total Users Created: " + totalUsers);
    }
}