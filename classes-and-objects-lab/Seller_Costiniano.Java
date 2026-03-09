/**
 * 
 *  This class is made by Sean Costiniano
 * 
 */

public class Seller {

    // Attributes (fields)
    String name;
    int age;
    String shopName;

    // Static attribute
    static int totalSellers = 0;

    // Default constructor
    public Seller() {
        name = "Unknown";
        age = 0;
        shopName = "No Shop";
        totalSellers++;
    }

    // Parameterized constructor
    public Seller(String name, int age, String shopName) {
        this.name = name;
        this.age = age;
        this.shopName = shopName;
        totalSellers++;
    }

    // Method with no parameters
    public void displaySellerInfo() {
        System.out.println("Seller Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Shop Name: " + shopName);
    }

    // Method with parameter
    public void updateShopName(String newShopName) {
        shopName = newShopName;
        System.out.println("Shop name updated to: " + shopName);
    }

    // Static method
    public static void showTotalSellers() {
        System.out.println("Total Sellers Created: " + totalSellers);
    }
}