public class Arandela_Order {

    String orderNumber;
    String foodItem;
    int quantity;
    double price;

    static int totalOrders = 0;

    // Default Constructor
    Arandela_Order() {
        this.orderNumber = "ORD000";
        this.foodItem = "McChicken";
        this.quantity = 1;
        this.price = 120.0;
        totalOrders++;
    }

    // Parameterized Constructor
    Arandela_Order(String orderNumber, String foodItem, int quantity, double price) {
        this.orderNumber = orderNumber;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
        totalOrders++;
    }

    // Overloaded Constructor
    Arandela_Order(String orderNumber, String foodItem) {
        this.orderNumber = orderNumber;
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = 120.0;
        totalOrders++;
    }

    // Method without parameter
    void showOrder() {
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Food Item: " + foodItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: ₱" + price);
        System.out.println();
    }

    // Method with parameter
    void addOrder(int extra) {
        quantity += extra;
        System.out.println("Added more items to order " + orderNumber);
        System.out.println("New Quantity: " + quantity);
        System.out.println();
    }

    // Static method
    static void showTotalOrders() {
        System.out.println("Total Orders Made: " + totalOrders);
    }
}