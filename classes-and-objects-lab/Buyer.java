/*
* This class represents a buyer with a buyer name, name of product, quantity of product, and order status.
* Created by Kyla Cassandra Rodenas
*/

public class Buyer {

    // Static attribute
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
    public Buyer(String buyerName, String productName) {
        this.buyerName = buyerName;
        this.productName = productName;
        this.orderStatus = "Pending"; //default status
        quantityCount++;
    }

    // Method without parameters
    public void showOptions() {
                System.out.println("Account Name: " + buyerName);
        System.out.println("Product Name: " + productName);
        System.out.println("Order Status: " + orderStatus);
    }

    // Method with parameter
    public void updateOrderStatus(String updateStatus) {
                orderStatus = updateStatus;
        System.out.println("Order status updated to: " + orderStatus);
    }

    // Static method
    public static void displayQuantityCount() {
        System.out.println("Total products ordered: " + quantityCount);
    }
}
