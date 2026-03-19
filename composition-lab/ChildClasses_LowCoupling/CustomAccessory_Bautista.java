// Represents a customized accessory for Wall-E
// Extends Accessory_Batangan to add customization
// Created by Bautista for Option 1 inheritance demo

public class CustomAccessory_Batangan extends Accessory_Batangan {

    // Constructor calls parent constructor
    public CustomAccessory_Batangan(String accessoryID, String accessoryName, String color, double price) {
        super(accessoryID, accessoryName, color, price);
    }

    // New behavior: customize accessory color and price
    public void customize(String newColor, double newPrice) {
        setColor(newColor);      // update color
        setPrice(newPrice);      // update price
        System.out.println("Accessory customized to color: " + newColor + " and price: " + newPrice);
    }

    // Optional override: add Wall-E flavor to wear method
    @Override
    public void wear() {
        System.out.println("Wall-E is now using a customized accessory!");
        super.wear();  // call parent wear method
    }
}