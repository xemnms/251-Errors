public class Vehicle_Nepomuceno {
    private Engine engine;
    private Transmission transmission;
    private String modelName;
    private int yearManufactured;

    // Constructor with dependency injection
    public Vehicle_Nepomuceno(String modelName, int yearManufactured, Engine engine, Transmission transmission) {
        this.modelName = modelName;
        this.yearManufactured = yearManufactured;
        this.engine = engine;
        this.transmission = transmission;
    }

    // Alternative constructor with setters
    public Vehicle_Nepomuceno(String modelName, int yearManufactured) {
        this.modelName = modelName;
        this.yearManufactured = yearManufactured;
    }

    // Getter and setter for Engine
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        if (engine != null) {
            this.engine = engine;
        }
    }

    // Getter and setter for Transmission
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        if (transmission != null) {
            this.transmission = transmission;
        }
    }

    // Vehicle behavior - start the vehicle
    public void startVehicle() {
        if (engine != null && transmission != null) {
            System.out.println("Starting " + modelName + "...");
            engine.start();
            transmission.setGear("P");
            System.out.println("Vehicle ready to drive!");
        } else {
            System.out.println("Cannot start vehicle - missing components!");
        }
    }

    // Vehicle behavior - accelerate
    public void accelerate() {
        if (engine != null) {
            System.out.println("Accelerating " + modelName + "...");
            engine.increaseRPM(1500);
            if (transmission != null) {
                transmission.shiftGear();
            }
        }
    }

    // Vehicle behavior - brake
    public void brake() {
        if (engine != null && transmission != null) {
            System.out.println("Braking " + modelName + "...");
            engine.decreaseRPM(500);
            transmission.setGear("N");
        }
    }

    // Get vehicle info
    public String getVehicleInfo() {
        return "Model: " + modelName + ", Year: " + yearManufactured;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "modelName='" + modelName + '\'' +
                ", yearManufactured=" + yearManufactured +
                ", engine=" + engine +
                ", transmission=" + transmission +
                '}';
    }
}