// Concrete class implementing the Vehicle interface
public class InterfaceConcreteVehicle_Nepomuceno implements InterfaceVehicle_Galindon {

    private final String model;
    private double speed; // km/h

    public InterfaceConcreteVehicle_Nepomuceno(String model) {
        this.model = model;
        this.speed = 0.0;
    }

    @Override
    public void accelerate(double increment) {
        if (increment <= 0) {
            System.out.println("Increment must be greater than 0.");
            return;
        }
        speed += increment;
    }

    // Convenience method to call the interface default method with this object's state
    public void displayStatus() {
        InterfaceVehicle_Galindon.super.displayStatus(model, speed);
    }

    // Optional getters
    public String getModel() {
        return model;
    }

    public double getSpeed() {
        return speed;
    }
}