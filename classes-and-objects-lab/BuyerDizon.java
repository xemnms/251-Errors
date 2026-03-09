public class Buyer {
    // Attributes (Instance variables)
    String name;
    int age;
    double budget;

    // Static attribute (Shared across all Buyer objects)
    static int totalBuyers = 0;

    // Default constructor
    Buyer() {
        this.name = "Guest";
        this.age = 0;
        this.budget = 0.0;
        totalBuyers++;
    }

    // Parameterized constructor
    Buyer(String name, int age, double budget) {
        this.name = name;
        this.age = age;
        this.budget = budget;
        totalBuyers++;
    }

    // Overloaded constructor (Assumes a default budget for new shoppers)
    Buyer(String name, int age) {
        this.name = name;
        this.age = age;
        this.budget = 100.0; // Default starting budget
        totalBuyers++;
    }

    // Behavior: Display buyer information
    void displayProfile() {
        System.out.println("Buyer Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Current Budget: $" + budget);
    }

    // Behavior: Update budget after a purchase
    void makePurchase(double amount) {
        if (amount <= budget) {
            budget -= amount;
            System.out.println(name + " bought an item for $" + amount + ".");
            System.out.println("Remaining budget: $" + budget);
        } else {
            System.out.println(name + " has insufficient funds for a $" + amount + " purchase.");
        }
    }

    // Static method
    static void displayTotalBuyers() {
        System.out.println("Total Buyers in System: " + totalBuyers);
    }
}