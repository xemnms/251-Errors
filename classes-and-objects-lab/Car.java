/*
* This class represents a student with a name, age, and GPA.
* Created by Bien Manuel Badosa
*/

public class Car {
    
    //Attributes
    String brandName;
    String brandModel;
    boolean engineRunning = false;

    //Static Attribute
    static int numberOfWheels = 4

    //Default Constructor
    Car(){
        brandName = "N/A";
        brandModel = "N/A";
        boolean = false;
        numberOfWheels = 4;
    }

    //Parameterized Constructor
    Car(String brandName, String brandModel) {
        this.brandName = brandName;
        this.brandModel = brandModel;
    }

    //Behaviour without Parameters
    void startCar(){
        engineRunningRunning = true;
        System.out.println(brandName + " " + brandModel + " has started.")
    }
    void stopCar(){
        engineRunningRunning = false;
        System.out.println(brandName + " " + brandModel + " has stopped.")
    }

    //Behaviour with Parameters
    void displayCarStatus(boolean engineRunning){
        System.out.println("Your engine is " + (engineRunning ? "running" : "not running"))
    }
}