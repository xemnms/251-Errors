

public class Buyer_Batangan {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
//Attributes
    String buyerName;

    String userProduct;

    int prodQuantity;

    double prodPrice;

//Static Attribute
    Static int totalQuantity = 0;

//Default Constructor
    Buyer(){
        buyerName = "Clisha Batangan";
        userProduct = "Phone Case";
        prodQuantity = "14";
        prodPrice = "$67";
        totalQuantity++;

// Parameterized Constructor
    Buyer(String buyerName, String userProduct, int prodQuantity, double prodPrice) {
        this.buyerName = name;
        this.userProduct = userProduct;
        this.prodQuantity = prodQuantity;
        this.prodPrice = prodPrice;
        totalStudents++;
    }

    // Overloaded constructor
    Buyer(String buyerName, String userProduct, int prodQuantity, double prodPrice) {
        this.buyerName = name;
        this.userProduct = userProduct;
        this.prodQuantity = 1;
        this.prodPrice = prodPrice;
        totalStudents++;   

    }

    }