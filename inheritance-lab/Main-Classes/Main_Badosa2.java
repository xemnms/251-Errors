// IS-A relationship: Boeing IS-A kind of Aeroplane
// Overridden method: displayType()
// Dynamic binding: The method to be invoked is determined at runtime based on the actual object type, not the reference type. 
// Inherited methods: getModel(),getSpeed(), getColor(), fly(), land()
// New behavior: greetPassengers()

// Main Class by Badosa

public class Main_Badosa2 {
    public static void main(String[] args) {

        Boeing_Badosa boeing = new Boeing_Badosa("Boeing 747", 120, "Blue", 100, 500);
        // Listing attributes
        System.out.println("Model: " + boeing.getModel());
        System.out.println("Speed: " + boeing.getSpeed());
        System.out.println("Color: " + boeing.getColor());
        System.out.println("Capacity: " + boeing.getPassengerCapacity());
        System.out.println("Max Fuel: " + boeing.getMaxFuel());
        System.out.println("Actions\n ==================");

        // Methods
        boeing.fly();
        boeing.land();
        boeing.greetPassengers();
        boeing.displayType();

        // Dynamic binding demonstration
        System.out.println("\nDynamic Binding Demonstration:");
        Aeroplane_Bagay plane = new Boeing_Badosa("Boeing 777", 150, "White", 200, 600);
        plane.displayType(); // At runtime, calls Boeing_Badosa's displayType() method due to dynamic binding
    }
}