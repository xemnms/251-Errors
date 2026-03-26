// Vehicle interface
public interface InterfaceVehicle_Galindon {
    // Abstract method
    void accelerate(double increment);

    // Default method
    default void displayStatus(String model, double speed) {
        System.out.println("Vehicle Model: " + model + ", Current Speed: " + speed + " km/h kachow!");
    }
}