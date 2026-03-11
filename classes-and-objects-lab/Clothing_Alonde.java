public class Clothing_Alonde {
 
    // attributes
    String type;
    double price;
    boolean inStock;
 
    // static attributes
    static int totalClothingItems;
 
    // default constructor
    Clothing_Alonde() {
        type = "Unknown";
        price = 0;
        inStock = true;
        totalClothingItems++;
    }
 
    // parameterized constructor
    Clothing_Alonde(String type, double price, boolean inStock) {
        this.type = type;
        this.price = price;
        this.inStock = inStock;
        totalClothingItems++;
    }
 
    // overloaded constructor
    Clothing_Alonde(String type, double price) {
        this.type = type;
        this.price = price;
        this.inStock = true;
        totalClothingItems++;
    }
 
    // Behavior without parameters
    void display() {
        System.out.println("Type: " + type + "| Price: " + price + "| Stock: " + inStock);
    }
 
         // Behavior with parameters
    void updateType(String newType){
        type = newType;
        System.out.println("The clothing type was updated to: " + type);
    }
 
 
}