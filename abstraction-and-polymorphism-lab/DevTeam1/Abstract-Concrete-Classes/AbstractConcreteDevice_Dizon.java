
public class AbstractConcreteDevice_Dizon extends AbstractDevice_Alonde {

    private String deviceType;

    // Construct using  AbstractDevice_Alonde
    public AbstractConcreteDevice_Dizon(String modelName, int batteryLevel, String deviceType) {
        super(modelName, batteryLevel);
        this.deviceType = deviceType;
    }

    // Override
    @Override
    public void powerOn() {
        System.out.println("[System] " + getModelName() + " (" + deviceType + ") is now ONLINE.");
        System.out.println("Initializing Dizon's custom firmware modules...");
    }

    // Overloading
    public void syncData() {
        System.out.println("Syncing all local files to Dizon-Cloud...");
    }

    // Overloading
    public void syncData(String targetFolder) {
        System.out.println("Prioritizing sync for folder: " + targetFolder);
    }
}