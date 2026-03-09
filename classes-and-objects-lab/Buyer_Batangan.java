/**
 * This class represents a Buyer with name, product, quantity, and price
 * This class was made by Clisha Batangan
 */

public class Buyer_Batangan {

    // Attributes
    String buyerName;
    String userProduct;
    int prodQuantity;
    double prodPrice;

    // Static attribute
    static int totalBuyers = 0;

    // Default constructor
    public Buyer_Batangan() {
        buyerName = "Clisha Batangan";
        userProduct = "Phone Case";
        prodQuantity = 1;
        prodPrice = 67;
        totalBuyers++;
    }

    // Parameterized constructor
    public Buyer_Batangan(String buyerName, String userProduct, int prodQuantity, double prodPrice) {
        this.buyerName = buyerName;
        this.userProduct = userProduct;
        this.prodQuantity = prodQuantity;
        this.prodPrice = prodPrice;
        totalBuyers++;
    }

    // Overloaded constructor (bonus)
    public Buyer_Batangan(String buyerName, String userProduct, double prodPrice) {
        this.buyerName = buyerName;
        this.userProduct = userProduct;
        this.prodQuantity = 1;
        this.prodPrice = prodPrice;
        totalBuyers++;
    }

    // Behavior without parameters
    void introduceBuyer() {
        System.out.println("Hi, I am " + buyerName);
        System.out.println("I bought " + userProduct);
        System.out.println("Quantity: " + prodQuantity);
        System.out.println("Price: " + prodPrice);
    }

    // Behavior with parameters
    void updateQuantity(int newQuantity) {
        prodQuantity = newQuantity;
        System.out.println(buyerName + " updated quantity to " + prodQuantity);
    }

    // Static method
    static void displayTotalBuyers() {
        System.out.println("Total Buyers Created: " + totalBuyers);
    }
}
