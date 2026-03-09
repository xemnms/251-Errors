public class cellphone {

    // Attributes
    String brand;
    double price;
    int storage;

    // Static attribute
    static int totalPhonesSold = 0;

    // Deafault constructor
    cellphone() {
        brand = "Unknown";
        price = 0;
        storage = "Undeclared";
        totalPhonesSold++;
    }

    // Parameterized constructor
    cellphone(String brand, double price, int storage) {
        this.brand = brand;
        this.price = price;
        this.storage = storage;
        totalPhonesSold++;
    }
}