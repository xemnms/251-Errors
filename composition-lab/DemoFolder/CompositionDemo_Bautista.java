/* 
HAS-A relationships: WallE_Bautista has a Gadgets_Bagay and an Accessory_Batangan.
Reused classes: Gadgets_Bagay and Accessory_Batangan are reused as components in the WallE_Bautista class.
Low coupling: By allowing components to be replaced independently, keeping WallE_Bautista unaffected.
Cohesion: WallE_Bautista focuses on coordinating the behavior of its components, maintaining a single responsibility.
Inheritance not appropriate: Because the relationship is part-whole (HAS-A) rather than type specialization (IS-A).

Main class to demonstrate composition with Wall-E character
Created by Bautista for composition demo
*/

public class CompositionDemo_Bautista {
    public static void main(String[] args) {

        // Instantiate teammate component classes
        Gadgets_Bagay wallESystem = new Gadgets_Bagay(50); // 50% battery
        wallESystem.setGadgetType("Wall-E Power System");

        // Use subclassed accessory
        CustomAccessory_Bautista wallEAccessory = new CustomAccessory_Bautista("A001", "Trash Cube Holder", "Rusty", 10.0);

        // Pass them into the composite class (HAS-A relationship)
        WallE_Bautista wallE = new WallE_Bautista("Wall-E", wallESystem, wallEAccessory);

        // Call methods across objects
        System.out.println("=== Initial Status ===");
        wallE.start();
        wallE.useAccessory();
        wallE.displayStatus();

        // Demonstrate customization of accessory
        System.out.println("\n=== Customizing Accessory ===");
        wallEAccessory.customize("Bright Red", 12.5);
        wallE.useAccessory();
        wallE.displayStatus();

        // Low coupling demo
        System.out.println("\n=== Low Coupling Demo: Replace Accessory ===");
        Accessory_Batangan newAccessory = new Accessory_Batangan("A002", "Solar Panel Cap", "Shiny", 15.0);
        wallE.setAccessory(newAccessory);
        wallE.useAccessory();
        wallE.displayStatus();

        // Optional recharge behavior
        System.out.println("\n=== Recharging Wall-E ===");
        wallE.recharge();
        wallE.displayStatus();
    }
}
