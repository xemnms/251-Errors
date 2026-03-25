
public class InterfaceConcreteDevice_Dizon implements InterfaceDevice_Alonde {

    private String deviceName;
    private String macAddress;

    public InterfaceConcreteDevice_Dizon(String deviceName, String macAddress) {
        this.deviceName = deviceName;
        this.macAddress = macAddress;
    }

    // Overriding the abstract method from InterfaceDevice_Alonde
    @Override
    public void connectToNetwork(String networkName) {
        System.out.println(deviceName + " [MAC: " + macAddress + "] is authenticating...");
        System.out.println("Successfully connected to: " + networkName);
    }

    // Overriding the default method from the interface
    @Override
    public void showStatus() {
        // Calling the original interface default method logic
        InterfaceDevice_Alonde.super.showStatus(); 
        System.out.println("Dizon Module Update: Connection strength is Excellent.");
    }

    // Overloading Method (Version 1: No parameters)
    public void sendData() {
        System.out.println("Sending default heartbeat packet to server...");
    }

    // Overloading Method (Version 2: With String parameter)
    public void sendData(String dataPackage) {
        System.out.println("Sending encrypted package: " + dataPackage);
    }
}