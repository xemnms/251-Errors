public abstract class AbstractDevice_Alonde {
    private String modelName;
    private int batteryLevel;

    // constructor
    public AbstractDevice_Alonde(String modelName, int batteryLevel) {
        this.modelName = modelName;
        this.batteryLevel = batteryLevel;
    }

    // overloaded constructor
    public AbstractDevice_Alonde(String modelName) {
        this(modelName, 100); 
    }

    // abstract method
    public abstract void powerOn();

    // concrete method
    public void displayStatus() {
        System.out.println("Device: " + modelName + " | Battery: " + batteryLevel + "%");
    }

    // getters
    public String getModelName() {
        return modelName;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}