/*
* This class represents a cellphone with a brand, price, and storage.
* Created by Julliana Nepomuceno
*/
public class Cellphone_Nepomuceno {
    // Attributes
    String brand;
    double price;
    int storage;

    // Static attribute
    static int totalPhonesSold = 0;

    // Deafault constructor
    Cellphone_Nepomuceno() {
        brand = "Unknown";
        price = 0;
        storage = 0;
        totalPhonesSold++;
    }

    // Parameterized constructor
    Cellphone_Nepomuceno(String brand, double price, int storage) {
        this.brand = brand;
        this.price = price;
        this.storage = storage;
        totalPhonesSold++;
    }

    // Overloaded constructor
    Cellphone_Nepomuceno(String brand, double price){
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
