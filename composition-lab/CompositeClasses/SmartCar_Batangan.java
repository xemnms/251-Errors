/* Represents a smart car that uses an engine and speakers
**Composite class created by Batangan, using Alvarez & Acosta components
 */

public class SmartCar_Batangan {

    // Private Fields (Composition)
    // The car HAS-A engine and HAS-A speakers
    private String carName;
    private engine_alvarez carEngine; // HAS-A Engine
    private Speakers_Acosta carSpeakers; // HAS-A Speakers

    // Constructor Injection
    // Components are passed into the class
    public SmartCar_Batangan(String carName, engine_alvarez carEngine, Speakers_Acosta carSpeakers) {
        this.carName = carName;
        this.carEngine = carEngine;
        this.carSpeakers = carSpeakers;
    }

    // Behavior Methods (Object Collaboration)
    // These methods use BOTH components
    // Start the car (engine + speakers interaction)
    public void startCar() {
        System.out.println("Starting car: " + carName);
        carEngine.startEngine(); // Call engine behavior
        carSpeakers.turnOn(); // Call speaker behavior
    }

    // Stop the car
    public void stopCar() {
        System.out.println("Stopping car: " + carName);
        carSpeakers.turnOff();
    }

    // Play music while driving
    public void driveWithMusic() {
        System.out.println("Driving with music on 🎶");
        carSpeakers.increaseVolume();
        System.out.println("Current volume: " + carSpeakers.getVolume());
        System.out.println("₊˚ ✧ ━━━━━━━━⊱⋆⊰━━━━━━━━ ✧ ₊˚");
    }

    // Setters (for Low Coupling)
    // Allows replacing components
    public void setEngine(engine_alvarez engine) {
        this.carEngine = engine;
    }

    public void setSpeakers(Speakers_Acosta speakers) {
        this.carSpeakers = speakers;
    }

    // Display Info
    public void displayCar() {
        System.out.println("₊˚ ✧ ━━━━━━━━━━━━━ CAR GARAGE ━━━━━━━━━━━━━ ✧ ₊˚");
        System.out.println("Car Name: " + carName);
        System.out.println("Engine Type: " + carEngine.getType());
        System.out.println("Horsepower: " + carEngine.getHorsepower());
        System.out.println("Speakers: " + carSpeakers.getBrand() + " " + carSpeakers.getModel());
    }
}
