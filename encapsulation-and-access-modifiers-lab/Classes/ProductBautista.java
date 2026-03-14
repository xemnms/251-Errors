/*
 * This class represents a Product with encapsulated attributes,
 * validation rules, and a static counter for created products.
 *
 * Created by: Lei Bautista
 */

public class ProductBautista {

    // Private Attributes

    private String name;
    private int id;
    private double price;
    private int stock;

    // Static attribute shared by all objects
    private static int totalProducts = 0;

    // Constructors ( Initializes a product with default values )
    
    public ProductBautista() {
        this.name = "Unknown Product";
        this.id = 0;
        this.price = 0.0;
        this.stock = 0;

        totalProducts++;
    }

    // Parameterized constructor ( Allows initialization with specific values )

    public ProductBautista(String name, int id, double price, int stock) {
        setName(name);
        this.id = id;
        setPrice(price);
        setStock(stock);

        totalProducts++;
    }

    // Getters

    // Returns the product name
    public String getName() {
        return name;
    }

    // Returns the product id
    public int getId() {
        return id;
    }

    // Returns the product price
    public double getPrice() {
        return price;
    }

    // Returns the available stock
    public int getStock() {
        return stock;
    }

    // Returns the number of products created
    public static int getTotalProducts() {
        return totalProducts;
    }

    // Setters with Validation

    // Sets the product name ( Validation: name must not be empty )
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name. Name cannot be empty.");
        }
    }

    // Sets the product price ( Validation: price must not be negative )
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price. Price cannot be negative.");
        }
    }

    // Sets the product quantity ( Validation: stock must not be negative )
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Invalid stock value.");
        }
    }

    // Behavior Methods
    // Adds new stock to the product inventory
    public void restock(int quantity) {
        if (quantity > 0) {
            stock += quantity;
            System.out.println(quantity + " units added to stock.");
        } else {
            System.out.println("Restock quantity must be positive.");
        }
    }

    /**
     * Sells a quantity of the product.
     * Validation prevents selling more than available stock.
     */
    
    public void sell(int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
        } 
        else if (quantity > stock) {
            System.out.println("Not enough stock available.");
        } 
        else {
            stock -= quantity;
            System.out.println(quantity + " units sold.");
        }
    }

    public void displayProductInfo(){
        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stock);
    }
}