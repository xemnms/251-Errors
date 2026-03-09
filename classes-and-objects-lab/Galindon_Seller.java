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
 
    // Main method
    public static void main(String[] args) {
 
        // Using default constructor
        Galindon_Seller s0 = new Galindon_Seller();
        s0.showSeller();
 
        // Using parameterized constructor
        Galindon_Seller s1 = new Galindon_Seller("Max",  "Dubai Chewy Cookie", 135);
        Galindon_Seller s2 = new Galindon_Seller("Ralph",  "Chocolate Xiao Long Bao", 129);
 
        s1.showSeller();
        s2.showSeller();
 
        s1.sell(12);
        s2.sell(24);
 
        Galindon_Seller.showTotal();
    }
}