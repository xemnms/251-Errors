/* Smart Watch class by Acosta
*  Component classes by Bagay (Gadgets) and Batangan (Accessory)
*/

public class SmartWatch_Acosta {
    
    //Attributes, use of other component class demonstrates HAS-A relationship
    private String brand;
    private Gadgets_Bagay gadget;
    private Accessory_Batangan accessory;

    //Constructor Injection
    public SmartWatch_Acosta(String brand, Gadgets_Bagay gadget, Accessory_Batangan accessory) {
        this.brand = brand;
        this.gadget = gadget;
        this.accessory = accessory;
    }

    //Behaviours
    public void useWatch() {
        System.out.println("\nYou have worn and turned the " + getBrand() + " smart watch on.");
        gadget.setGadgetType("Screen");
        gadget.turnOn();
        accessory.wear();
    }

    public void checkBattery() {
        if (gadget.isLowBattery()){
            System.out.println("Battery: " + gadget.getBatteryLevel() + "%. Low Battery.");
        } else {
        System.out.println("Battery: "+gadget.getBatteryLevel()+"%");
        }
    }

    public void displayAppearance() {
        System.out.println("\nYour smartwatch is...");
        System.out.println("Brand: "+getBrand());
        System.out.println("Color: "+accessory.getColor());
    }

    //Getters
    public String getBrand(){
        return brand;
    }

    //Setter with validatiom
    public void setBrand(String brand){
        if (brand == null || brand.isEmpty()) {
            System.out.println("Brand name is empty");
        } else {
        this.brand = brand;
        }
    }

}
