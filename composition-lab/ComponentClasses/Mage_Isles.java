//component class created by Dan Isles
//this class represents a mage element system (parang powers ng character mo)

public class Mage_Isles {
    // private attributes
    private String elementName; // name of the element (Fire, Water, etc.)
    private int powerLevel; // kung gaano kalakas yung element
    private String type; // role ng mage (Offense, Defense, Support)

    // default constructor (default values muna if wala pa sinet)
    public Mage_Isles() {
        this.elementName = "Unknown";
        this.powerLevel = 0;
        this.type = "None";
    }

    // setters!! (pwede mo baguhin values later)
    // allows user to set their mage's element type (refer to the options sa taas)
    public void setElementName(String elementName) {
        // bawal null or empty
        if (elementName == null || elementName.isEmpty()) {
            this.elementName = "Unknown"; // fallback value
        } else {
            this.elementName = elementName; // sets new element name
        }
    }

    // allows user to set their mage's power level (refer to the options sa taas)
    public void setPowerLevel(int powerLevel) {
        // validation: bawal negative kasi walang weak na ganon 😭
        if (powerLevel < 0) {
            this.powerLevel = 0; // fallback if invalid
        } else {
            this.powerLevel = powerLevel; // sets new power level
        }
    }

    // allows user to set their mage role (refer to the options sa taas)
    public void setType(String type) {
        // validation ulit para safe
        if (type == null || type.isEmpty()) {
            this.type = "Unknown"; // default role
        } else {
            this.type = type; // sets mage role
        }
    }

    // getters!! (kuha ng values)
    public String getElementName() {
        return elementName; // returns element name
    }

    public int getPowerLevel() {
        return powerLevel; // returns strength ng element
    }

    public String getType() {
        return type; // returns mage role
    }

    // behavior method 1 (display info ng mage)
    public void displayElement() {
        System.out.println("Element: " + elementName);
        System.out.println("Power Level: " + powerLevel);
        System.out.println("Type: " + type);
    }

    // behavior method 2 (parang attack or paggamit ng power)
    public void useElement() {
        System.out.println("Using " + elementName + " element!");
    }
}
