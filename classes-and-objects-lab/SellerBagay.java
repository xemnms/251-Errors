public class SellerBagay {
    // Attributes
    String sellerName;
    int sellerAge;
    String storeName;
    static int totalSellers = 0; // Static attribute to count total sellers

    // Default constructor
    SellerBagay() {
        this.sellerName = "Unknown";
        this.sellerAge = 0;
        this.storeName = "Unnamed Store";
        totalSellers++; // Increment total sellers count
    }

    // Parameterized constructor
    SellerBagay(String sellerName, int sellerAge, String storeName) {
        this.sellerName = sellerName;
        this.sellerAge = sellerAge;
        this.storeName = storeName;
        totalSellers++; // Increment total sellers count
    }

    // Overloaded constructor
    SellerBagay(String sellerName, String storeName) {
        this.sellerName = sellerName;
        this.sellerAge = 0; // Default age
        this.storeName = storeName;
        totalSellers++; // Increment total sellers count
    }

    // Getter and setter methods
    String getSellerName() {
        return sellerName;
    }

    void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    int getSellerAge() {
        return sellerAge;
    }

    void setSellerAge(int sellerAge) {
        this.sellerAge = sellerAge;
    }

    String getStoreName() {
        return storeName;
    }

    void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    // Behavior: Method with no parameters
    void displaySellerInfo() {
        System.out.println("Seller Name: " + sellerName);
        System.out.println("Age: " + sellerAge);
        System.out.println("Store Name: " + storeName);
    }

    // Behavior: Method with one parameter
    void updateStoreName(String newStoreName) {
        this.storeName = newStoreName;
        System.out.println("Store name updated to: " + newStoreName);
    }

    // Static method
    static int getTotalSellers() {
        return totalSellers;
    }
}