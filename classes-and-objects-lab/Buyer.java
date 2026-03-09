/*
* This class represents a buyer with a buyer name, name of product, quantity of product, and order status.
* Created by Kyla Cassandra Rodenas
*/

public class Buyer {

    // Static field
    static int quantityCount = 1;

    // Attributes
    String buyerName;
    String productName;
    String orderStatus;

    // Default constructor
    public Buyer() {
        buyerName = "Kyla Cassandra Rodenas";
        productName = "Gojo Statue";
        orderStatus = "Pending";
        quantityCount++;
    }

    // Parameterized constructor
    public Buyer(String buyerName, String productName, String orderStatus) {
        this.buyerName = buyerName;
        this.productName = productName;
        this.orderStatus = orderStatus;
        quantityCount++;
    }

    // Overloaded constructor
    public Buyer(String sellerName, String productName) {
        this.buyerName = sellerName;
        this.productName = productName;
        this.orderStatus = "Pending";
        quantityCount++;
    }

    // Method without parameters
    public void showOptions() {
        System.out.println("Buyer Options:");
        System.out.println("\n[1] Buy Product");
        System.out.println("[2] Cancel Order");
        System.out.println("[3] View Order Status");
    }

    // Method with parameter
    public void updateOrderStatus(String status) {
        orderStatus = status;
        System.out.println("Order status updated to: " + orderStatus);
    }

    // Static method
    public static void displayQuantityCount() {
        System.out.println("Total products ordered: " + quantityCount);
    }
}