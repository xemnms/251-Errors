/* Composition Demo by Acosta
*  Composite Class with Gadget (Bagay) & Accessory (Batangan) by Acosta
*  
*/

public class CompositionDemo_Acosta {
    public static void main(String[] args) {
    
        //Create Object from component class
        Accessory_Batangan watch = new Accessory_Batangan("001", "Watch", "Black", 300.0);
        Gadgets_Bagay screen = new Gadgets_Bagay(50);

        //Create Composed Object
        SmartWatch_Acosta smartWatch = new SmartWatch_Acosta("Apple", screen, watch);

        //Demo (using methods from component and composite classes)
        
        smartWatch.useWatch();          //Turn on and wear watch
        smartWatch.checkBattery();      //Display battery level
        smartWatch.displayAppearance(); //Display attributes brand and color
        screen.fullCharge();            //Charges the battery back to 100%
        smartWatch.checkBattery();      //Displays battery level once again
    
        //Demonstrating low coupling by making new objects with different values
        Accessory_Batangan newWatch = new Accessory_Batangan("002", "New Watch", "White", 500.0);
        Gadgets_Bagay newScreen = new Gadgets_Bagay(15);
        SmartWatch_Acosta newSmartWatch = new SmartWatch_Acosta("Samsung", newScreen, newWatch);

        System.out.println("\n============= LOW COUPLING DEMONSTRATION =============");
        newSmartWatch.useWatch();
        newSmartWatch.checkBattery();
        newSmartWatch.displayAppearance();
        newScreen.fullCharge();
        newSmartWatch.checkBattery(); //System still works and uses the new given values in the new created objects.

    }
}

/*
 * Analyze the Design, Answer the following:
 * 1.) What are the HAS-A relationships?
 * - The Composite class SmartWatch_Acosta HAS-A Gadgets_Bagay and HAS-A Accessory_Batangan
 * 2.) Which classes were reused?
 * - The reused classes were Gadgets_Bagay and Accessory_Batangan, to also demonstrate low coupling.
 * 3.) How does composition reduce coupling?
 * - The classes (components) can be swapped and modified freely without affecting the composite classes.
 * 4.) How is cohesion maintained?
 * - By having each class have one single function and responsibility
 * 5.) Why is inheritance NOT appropriate here? 
 * - Inheritance is for IS-A relationship, which is not compatible for making an Object Collaboration project.
 */
