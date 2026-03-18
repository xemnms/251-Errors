//Child class by Badosa, Parent Class by Bagay
public class Boeing_Badosa extends Aeroplane_Bagay {
    // Attributes
    private int passengerCapacity;
    private int maxFuel;

    // Constructor
    public Boeing_Badosa(String model, int speed, String color, int passengerCapacity, int maxFuel) {
        super(model, speed, color);
        this.passengerCapacity = passengerCapacity;
        this.maxFuel = maxFuel;
    }

    // getters
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    // New Method for child class
    public void greetPassengers() {
        System.out.println("You are now boarding a Boeing Plane, Welcome aboard!");
    }

    // Overridden method
    public void displayType() {
        System.out.println("This is a Boeing Aeroplane.");
    }
}