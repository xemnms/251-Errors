public class Machine {

    private static final String CLASS_ID = "Machine Class Created by RMCAPUNPON";
    private String objectId;
    private String model;
    private double minimumEnergyConsumption;
    private boolean isDisposable;

    private boolean isOn;

    public Machine() {
        model = "Parent Machine";
        objectId = "parent_01";
        minimumEnergyConsumption = 200;
        isDisposable = true;
        isOn = false;
    }

    public Machine(String objectId, String model, double energyConsumption, boolean isDisposable) {
        this.model = model;
        this.objectId = "parent_" + objectId;
        minimumEnergyConsumption = energyConsumption;
        this.isDisposable = isDisposable;
        this.isOn = false;
    }

    private void showClassId() {
        System.out.println(CLASS_ID);
    }

    public String getObjectId() {
        return objectId;
    }

    public boolean isDisposable() {
        return isDisposable;
    }

    public double getMinimumEnergyConsumption() {
        return this.minimumEnergyConsumption;
    }

    public String getObjectModel() {
        return model;
    }

    public void turnOn() {
        System.out.println("Machine turned on.");
    }

    public void turnOff() {
        System.out.println("Machine turned off.");
    }

}