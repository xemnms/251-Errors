public class Galindon_Seller {

    String name;
    String product;
    double price;
    double totalSales;

    static int totalSellers = 0;

    // Default Constructor
    Galindon_Seller() {
        this.name = "Unknown";
        this.product = "Unknown";
        this.price = 0.0;
        this.totalSales = 0;
        totalSellers++;
    }

    // Parameterized Constructor
    Galindon_Seller(String name, String product, double price) {
        this.name = name;
        this.product = product;
        this.price = price;
        this.totalSales = 0;
        totalSellers++;
    }

    // Overloaded Constructor 
    Galindon_Seller(String name, String product) {
        this.name = name;
        this.product = product;
        this.price = 0.0;
        this.totalSales = 0;
        totalSellers++;
    }

    // Show seller info
    void showSeller() {
        System.out.println("Seller: " + name);
        System.out.println("Product: " + product);
        System.out.println("Price: ₱" + price);
        System.out.println();
    }

    // Sell product
    void sell(int quantity) {
        double sale = quantity * price;
        totalSales += sale;

        System.out.println(name + " sold " + quantity + " " + product);
        System.out.println("Sale: ₱" + sale);
        System.out.println("Total Sales: ₱" + totalSales);
        System.out.println();
    }

    // Static method
    static void showTotal() {
        System.out.println("Total Sellers Created: " + totalSellers);
    }
}
