public class AbstractConcreteVehicle_Arandela extends AbstractVehicle_Galindon {

    public AbstractConcreteVehicle_Arandela(String model, double speed, double maxSpeed) {
        super(model, speed, maxSpeed);
    }

    // OVERRIDING (abstract class)
    @Override
    public void stop() {
        setSpeed(0);
        System.out.println(getModel() + " has stopped.");
    }

    // METHOD (extra behavior)
    public void accelerate(double increment) {
        setSpeed(getSpeed() + increment);
        System.out.println(getModel() + " accelerated.");
    }

    // OVERLOADING
    public void accelerate(double increment, String mode) {
        if (mode.equalsIgnoreCase("sport")) {
            setSpeed(getSpeed() + increment * 2);
        } else {
            setSpeed(getSpeed() + increment);
        }
        System.out.println(getModel() + " accelerated in " + mode + " mode.");
    }
}