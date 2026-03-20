// Represents the Wall-E character from the movie "Wall-E"
// Uses two component classes: Accessory_Batangan and Gadgets_Bagay
// Composite class for Wall-E created by Bautista

public class WallE_Bautista {

    // HAS-A relationship (composition)
    private String name; // robot name
    private Gadgets_Bagay system; // battery + power system
    private Accessory_Batangan accessory; // collected item

    // Constructor Injection
    public WallE_Bautista(String name, Gadgets_Bagay system, Accessory_Batangan accessory) {
        this.name = name;
        this.system = system;
        this.accessory = accessory;
    }

    // Behavior: Start robot
    public void start() {
        System.out.println(name + " is starting up...");
        system.turnOn();
    }

    // Behavior: Recharge battery
    public void recharge() {
        System.out.println(name + " is recharging...");
        system.fullCharge();
    }

    // Behavior: Use accessory
    public void useAccessory() {
        System.out.println(name + " is using its accessory...");
        accessory.wear();
    }

    // Behavior: Display status
    public void displayStatus() {
        System.out.println(name + "'s current status:");
        system.displayDetails(); // Gadget details
        accessory.displayAccessory(); // Accessory details
    }

    // Low coupling demo support (setter replacement)
    public void setAccessory(Accessory_Batangan accessory) {
        this.accessory = accessory;
    }
}