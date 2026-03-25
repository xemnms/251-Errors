// Abstract class implementing Vehicle interface
public abstract class AbstractVehicle_Galindon{
    private final String model;
    protected double speed; // km/h
    private final double maxSpeed;

    // Constructor
    public AbstractVehicle_Galindon(String model, double speed, double maxSpeed) {
        this.model = model;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
    }

    // Concrete method
    public void showInfo() {
        System.out.println("Model: " + model + " | Current Speed: " + speed + " km/h | Max Speed: " + maxSpeed + " km/h");
    }

    // Abstract method (to override)
    public abstract void stop();

   
    protected void setSpeed(double speed) {
        if (speed < 0) {
            this.speed = 0;
        } else if (speed > maxSpeed) {
            this.speed = maxSpeed;
        } else {
            this.speed = speed;
        }
    }

    protected double getSpeed() {
        return speed;
    }

    protected String getModel() {
        return model;
    }

    protected double getMaxSpeed() {
        return maxSpeed;
    }
}