public class AbstractPolyDemo_Dizon {

    public static void main(String[] args) {

        System.out.println("=== DIZON LAB DEMONSTRATION: ABSTRACTION & POLYMORPHISM ===\n");

        // DYNAMIC BINDING 
        //  Alonde's Abstract Class 
        AbstractDevice_Alonde myGadget = new AbstractConcreteDevice_Dizon("Spectre X1", 85, "Laptop");
        
        System.out.println(">> [Abstract Class Polymorphism]");
        // Runtime Polymorphism: The JVM decides to call Dizon's powerOn() at runtime
        myGadget.powerOn(); 
        myGadget.displayStatus(); // Calling concrete method from Alonde's class
        System.out.println();

        //  DYNAMIC BINDING (Interface) ---
        // Using Teammate Alonde's Interface as the reference type
        InterfaceDevice_Alonde myNetworkDevice = new InterfaceConcreteDevice_Dizon("Dizon-Link Router", "AF:12:34:56:78");

        System.out.println(">> [Interface Polymorphism]");
        // Runtime Polymorphism: connectToNetwork() behavior is bound at runtime
        myNetworkDevice.connectToNetwork("Student_Lab_Net");
        myNetworkDevice.showStatus(); // Executing overridden default method
        System.out.println();

        // METHOD OVERLOADING 
        System.out.println(">> [Method Overloading Demonstration]");
        AbstractConcreteDevice_Dizon specificDevice = (AbstractConcreteDevice_Dizon) myGadget;
        specificDevice.syncData();              // Version 1 (No params)
        specificDevice.syncData("Academic_Files"); // Version 2 (String param)

        InterfaceConcreteDevice_Dizon specificInterface = (InterfaceConcreteDevice_Dizon) myNetworkDevice;
        specificInterface.sendData();           // Version 1 (No params)
        specificInterface.sendData("Final_Project_v2.zip"); // Version 2 (String param)

        /* ANALYSIS
         * 1. What abstract class did you create? 
         * - AbstractHotel_Dizon 
         * 2. What interface did you create? 
         * - InterfaceConnectivity_Dizon.
         * 3. What methods did you override? 
         * - powerOn() from AbstractDevice_Alonde.
         * - connectToNetwork() and showStatus() from InterfaceDevice_Alonde.
         * 4. What methods did you overload? 
         * - syncData() and syncData(String targetFolder) in AbstractConcreteDevice_Dizon.
         * - sendData() and sendData(String dataPackage) in InterfaceConcreteDevice_Dizon.
         * 5. Where does dynamic binding occur in your code? 
         * - It occurs at 'myGadget.powerOn()' and 'myNetworkDevice.connectToNetwork()'. 
         * The code uses Alonde's abstract references, but executes Dizon's implementations.
         * 6. Which part shows polymorphism? 
         * - The assignment of Dizon concrete objects to Alonde abstract/interface references.
         * 7. How does your design achieve low coupling? 
         * - The demo interacts with the "Contract" (the abstract types) rather than the 
         * specific "Implementation," allowing classes to change without breaking the demo.
         * 8. How does your design achieve high cohesion? 
         * - Each class has a single focus: Alonde's code manages the "What it is" (Device/Interface), 
         * while Dizon's code manages the "How it works" (Concrete logic).
         * REVIEW AND RETROSPECT 
         * 1. I could have improved the constructor in AbstractConcreteDevice_Dizon to include 
         * data validation for the batteryLevel percentage.
         * 2. I could have utilized more diverse default methods in my custom interface 
         * to provide better logging utilities for teammates using my code.
         */
    }
}