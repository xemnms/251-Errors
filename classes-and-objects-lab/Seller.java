public class Seller {
    // Attributes
    private String sellerName;
    private int sellerAge;
    private String storeName;
    private static int totalSellers = 0; // Static attribute to count total sellers

    // Default constructor
    public Seller() {
        this.sellerName = "Unknown";
        this.sellerAge = 0;
        this.storeName = "Unnamed Store";
        totalSellers++; // Increment total sellers count
    }

    // Parameterized constructor
    public Seller(String sellerName, int sellerAge, String storeName) {
        this.sellerName = sellerName;
        this.sellerAge = sellerAge;
        this.storeName = storeName;
        totalSellers++; // Increment total sellers count
    }

    // Overloaded constructor
    public Seller(String sellerName, String storeName) {
        this.sellerName = sellerName;
        this.sellerAge = 0; // Default age
        this.storeName = storeName;
        totalSellers++; // Increment total sellers count
    }

    // Getter and setter methods
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getSellerAge() {
        return sellerAge;
    }

    public void setSellerAge(int sellerAge) {
        this.sellerAge = sellerAge;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    // Behavior: Method with no parameters
    public void displaySellerInfo() {
        System.out.println("Seller Name: " + sellerName);
        System.out.println("Age: " + sellerAge);
        System.out.println("Store Name: " + storeName);
    }

    // Behavior: Method with one parameter
    public void updateStoreName(String newStoreName) {
        this.storeName = newStoreName;
        System.out.println("Store name updated to: " + newStoreName);
    }

    // Static method
    public static int getTotalSellers() {
        return totalSellers;
    }
}