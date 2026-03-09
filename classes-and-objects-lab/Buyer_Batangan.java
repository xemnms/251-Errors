/**
 * This class represents a Buyer with name, product, quantity, price
 * This class was made by Clisha Batangan
 */

public class Buyer_Batangan {
    public static void main(String[] args) {

//Attributes
    String buyerName;
    String userProduct;
    int prodQuantity;
    double prodPrice;

//Static Attribute
    Static int totalQuantity = 0;

//Default Constructor
    Buyer(){
        buyerName = "Clisha Batangan";
        userProduct = "Phone Case";
        prodQuantity = "14";
        prodPrice = "$67";
        totalQuantity++;

//Parameterized Constructor
    Buyer(String buyerName, String userProduct, int prodQuantity, double prodPrice) {
        this.buyerName = name;
        this.userProduct = userProduct;
        this.prodQuantity = prodQuantity;
        this.prodPrice = prodPrice;
        totalQuantity++;
    }

//Overloaded constructor
    Buyer(String buyerName, String userProduct, int prodQuantity, double prodPrice) {
        this.buyerName = name;
        this.userProduct = userProduct;
        this.prodQuantity = 1;
        this.prodPrice = prodPrice;
        totalQuantity++;   
    }
//Behavior without parameters
    void introduceBuyer() {
        System.out.println("Hi, I am " + name + ".");
        System.out.println("I bought " + userProduct + ".");
        System.out.println("The quantity is " + prodQuantity + ".");
        System.out.println("The Price is " + prodPrice + ".");
    }

//Behavior with parameters
    void updateQuantity(String newQuantity) {
        Quantity = newQuantity;
        System.out.println(name + " has updated their quantity to " + Quantity + ".");
    }

//Static method
    static void displayTotalQuantity() {
        System.out.println("Total Quantity Created: " + totalQuantity);
    }
 }
