public interface InterfaceDevice_Alonde {

    // abstract method
    void connectToNetwork(String networkName);

    // default method
    default void showStatus() {
        System.out.println("System Status: Online and Functional.");
    }
}