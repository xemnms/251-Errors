package CompositeClasses;
//SAMPLE CODE
import ComponentClasses.Engine;

public class Airplane {
    private String model;
    private Engine engine; 

    public Airplane(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void fly() {
        System.out.println(model + " is preparing to fly...");
        engine.start(); 
        System.out.println(model + " is now flying!");
    }

    public void showDetails() {
        System.out.println("Airplane Model: " + model);
        engine.displayInfo(); 
    }
}