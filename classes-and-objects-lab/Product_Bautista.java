/*
* This class represents a product with a name, category, and price.
* Created by Lei Bautista
*/

public class Product_Bautista {

    // Attributes
    String name;
    int price;
    String category;

    // Static attribute
    static int totalProducts = 0;

    // Default constructor
    Product_Bautista() {
        name = "Unknown";
        price = 0;
        category = "Undeclared";
        totalProducts++;
    }

    // Parameterized constructor
    Product_Bautista(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        totalProducts++;
    }

    // Overloaded constructor
    Product_Bautista(String name, String category) {
        this.name = name;
        this.category = category;
        this.price = 0; // default price
        totalProducts++;
    }

    // Behavior without parameters
    void introduce() {
        System.out.println("Product Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
    }

    // Behavior with parameters
    void updateCategory(String newCategory) {
        category = newCategory;
        System.out.println("Category updated to " + category);
    }

    // Static method
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}