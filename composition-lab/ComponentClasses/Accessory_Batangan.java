// Represents a cute accessory that can be worn and styled
// Component class for Accessory created by Batangan

public class Accessory_Batangan {

    // Private attributes (encapsulation)
	// These variables cannot be accessed directly from outside the class
    private String accessoryID;
    private String accessoryName;
    private String color;
    private double price;

    // Constructor to initialize the accessory
    public Accessory_Batangan(String accessoryID, String accessoryName, String color, double price) {
        this.accessoryID = accessoryID;
        this.accessoryName = accessoryName;
        this.color = color;
        setPrice(price); // validated price
    }

    // Method to "wear" the accessory
    public void wear() {
        System.out.println("Accessory " + accessoryName + " is now being worn 💅");
    }

    // Method to style or change accessory details
    public void styleAccessory(String accessoryName, String color, double price) {
        if (price < 0) {
            System.out.println("Invalid price. Please enter a non-negative value.");
            return;
        }
        
     // Update attributes if valid
        this.accessoryName = accessoryName;
        this.color = color;
        this.price = price;
        
     // Output confirmation
        System.out.println("Styling accessory: " + accessoryName + " in " + color + " ✨");
    }

    // Method to display accessory details
    public void displayAccessory() {
        System.out.println("Accessory ID: " + accessoryID);
        System.out.println("Name: " + accessoryName);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
    }

    // Getters
    public String getAccessoryID() {
        return accessoryID;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setAccessoryID(String accessoryID) {
        this.accessoryID = accessoryID;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    // Ensure price is not negative
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price. Please enter a non-negative value.");
        }
    }
}
