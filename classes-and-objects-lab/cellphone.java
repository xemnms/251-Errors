/*
* This class represents a student with a name, age, and GPA.
* Created by Julliana Nepomuceno
*/
public class cellphone {
    // Attributes
    String brand;
    double price;
    int storage;

    // Static attribute
    static int totalPhonesSold = 0;

    // Deafault constructor
    cellphone() {
        brand = "Unknown";
        price = 0;
        storage = "Undeclared";
        totalPhonesSold++;
    }

    // Parameterized constructor
    cellphone(String brand, double price, int storage) {
        this.brand = brand;
        this.price = price;
        this.storage = storage;
        totalPhonesSold++;
    }

    // Overloaded constructor
    cellphone(String brand, double price){
        this.brand = brand;
        this.price = price;
        this.storage = 128; // phone base model storage
    }

    // Behavior without parameters
    void display() {
        System.out.println("Brand: " + brand + "| Price: " + price + "| Storage: " + storage);
    }

    // Behavior with parameters
    void updateBrand(String newBrand){
        brand = newBrand;
        System.out.println("The phone brand was updated to: " + brand);
    }
    // Static method
    static void displayTotalPhonesSold() {
        System.out.println("Total Phones Sold: " + totalPhonesSold);
    }
}
