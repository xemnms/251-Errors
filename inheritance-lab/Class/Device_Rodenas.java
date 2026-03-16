/*
* Parent Class created by Rodenas
* This class represents a general device which has a power on and power off behavior.
* Other classes can extend this to inherit its attributes and behaviors.
*/

public class Device_Rodenas {

    // Attributes
    String brand;
    String model;
    boolean powerStatus;
    int batteryLevel;
    int storageCapacity;

    // Constructor
    public Device_Rodenas(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.powerStatus = false;
        this.batteryLevel = 100;
        this.storageCapacity = 128;
    }

    // Behavior 1
    public void powerOn() {
        powerStatus = true;
        System.out.println("Device is now ON.");
    }

    // Behavior 2
    public void powerOff() {
        powerStatus = false;
        System.out.println("Device is now OFF.");
    }

    // Behavior 3
    public void chargeDevice() {
        batteryLevel = 100;
        System.out.println("Device is charging. Battery is now full.");
    }

    // Behavior 4
    public void showDeviceInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }

    // Method that child classes can override
    public void crashDevice() {
        System.out.println("Device is not responding.");
    }
}