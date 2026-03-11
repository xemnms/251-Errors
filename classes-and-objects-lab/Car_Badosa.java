/*
* This class represents a car with its brand name, model and engine status along with the action to turn the engine on or off
* Created by Bien Manuel Badosa
*/

public class Car_Badosa {
    // Attributes
    String brandName;
    String carModel;
    String carColor;
    boolean engineIsRunning = false;

    // Static Attribute
    static int totalCars = 0;

    // Default constructor
    Car_Badosa() {
        brandName = "Unbranded";
        carModel = "Model";
        carColor = "Colorless";
        totalCars++;
    }

    // Parameterized constructor
    Car_Badosa(String brandName, String carModel, String carColor) {
        this.brandName = brandName;
        this.carModel = carModel;
        this.carColor = carColor;
        totalCars++;
    }

    // Overloaded constructor
    Car_Badosa(String brandName, String carModel) {
        this.brandName = brandName;
        this.carModel = carModel;
        carColor = "Colorless";
        totalCars++;e
    }

    // Behavior without parameters
    void checkEngine() {
        System.out
                .println("Your " + carColor + " " + brandName + " " + carModel + " is "
                        + (engineIsRunning ? "running" : "not running"));
    }

    // Behavior with parameters
    void runEngine() {
        engineIsRunning = true;
    }

    void stopEngine() {
        engineIsRunning = false;
    }
}
