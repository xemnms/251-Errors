// Concrete class implementing the Vehicle interface
public class InterfaceConcreteVehicle_Nepomuceno implements InterfaceVehicle_Galindon {

    private final String model;
    private double speed; // km/h

    public InterfaceConcreteVehicle_Nepomuceno(String model) {
        this.model = model;
        this.speed = 0.0;
    }

    // OVERRIDING (from the interface)
    @Override
    public void accelerate(double increment) {
        if (increment <= 0) {
            System.out.println("Increment must be greater than 0.");
            return;
        }
        speed += increment;
    }

    // OVERLOADING example #1: accelerate using an int
    public void accelerate(int increment) {
        accelerate((double) increment); // reuse the double version
    }

    // OVERLOADING example #2: accelerate using "times" and "increment"
    public void accelerate(double increment, int times) {
        if (times <= 0) {
            System.out.println("Times must be greater than 0.");
            return;
        }
        for (int i = 0; i < times; i++) {
            accelerate(increment);
        }
    }

    public void displayStatus() {
        InterfaceVehicle_Galindon.super.displayStatus(model, speed);
    }

    public String getModel() {
        return model;
    }

    public double getSpeed() {
        return speed;
    }
}