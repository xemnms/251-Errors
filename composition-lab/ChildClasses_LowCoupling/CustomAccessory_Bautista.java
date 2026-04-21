// Represents a customized accessory for Wall-E
// Extends Accessory_Batangan to add customization
// Created by Bautista for Option 1 inheritance demo

public class CustomAccessory_Bautista extends Accessory_Batangan {

    // Constructor calls parent constructor
    public CustomAccessory_Bautista(String accessoryID, String accessoryName, String color, double price) {
        super(accessoryID, accessoryName, color, price);
    }

    // New behavior: customize accessory color and price
    public void customize(String newColor, double newPrice) {

        // Validate color
        if (newColor == null || newColor.trim().isEmpty()) {
            System.out.println("Invalid color. Customization failed.");
            return;
        }

        // Validate price
        if (newPrice < 0) {
            System.out.println("Invalid price. Customization failed.");
            return;
        }

        setColor(newColor);
        setPrice(newPrice);

        System.out.println("Accessory customized to color: " + newColor +
                " and price: " + newPrice);
    }

    // Override wear method
    @Override
    public void wear() {
        System.out.println("Wall-E is now using a customized accessory!");
        super.wear(); // call parent wear method
    }
}
