/*
**Parent class made by Rodenas, Child class made by Batangan
*/

public class Smartphone_Batangan extends Device_Rodenas {

    // Additional attribute for the smartphone
    String operatingSystem;

    // Constructor
    public Smartphone_Batangan(String brand, String model, String operatingSystem) {
        super(brand, model); // calls parent constructor
        this.operatingSystem = operatingSystem;
    }

    // Additional behavior
    public void takePhoto() {
        System.out.println("Smartphone is taking a photo.");
    }

    // Overriding the parent method
    @Override
    public void crashDevice() {
        System.out.println("Device is not responding.");
    }

}
