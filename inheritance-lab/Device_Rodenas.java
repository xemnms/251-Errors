/*
* Parent Class created by Rodenas
* This class represents a general device which has a power on and power off behavior.
* Other classes can extend this to inherit its attributes and behaviors.
*/
 
public class Device_Rodenas {
 
    //Attributes
    String brand;
    String model;
    boolean powerStatus;
 
    //Constructor
    public Device_Rodenas(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.powerStatus = false;
    }
 
    //Behavior 1
    public void powerOn() {
        powerStatus = true;
        System.out.println("Device is now ON.");
    }
 
    //Behavior 2
    public void powerOff() {
        powerStatus = false;
        System.out.println("Device is now OFF.");
    }
 
    //Method that will be overridden by child classes
    public void useDevice() {
        System.out.println("Using the device.");
    }
}