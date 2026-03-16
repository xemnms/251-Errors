/*
 * Main created by Clisha Rae Batangan
 */
public class Main_Batangan2 {
    public static void main(String[] args) {
 
        // Runtime Polymorphism
        Device_Rodenas device = new Smartphone_Batangan("Samsung", "Galaxy S23", "Android");
 
        device.powerOn();
        device.showDeviceInfo();
        device.crashDevice();  // This will call the overridden method
        device.powerOff();
 
    }
}
