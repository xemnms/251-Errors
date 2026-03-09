public class ObjectDetailsPrinter {
    public static void main(String[] args) {
        // Object created by Isles: LaptopIsles class
        // Object using default constructor
        LaptopIsles laptop1 = new LaptopIsles();

        // Object using parameterized constructor
        LaptopIsles laptop2 = new LaptopIsles("Dell", 2000, false);

        // Print attributes and trigger behaviors
        System.out.println("\nlaptop1 (default) \n");
        laptop1.displaySpecs();

        System.out.println("\nlaptop2 (parameterized)");
        laptop2.displaySpecs();

        // Method with parameters: update laptop2's specs
        System.out.println("\nUpdating laptop2's specs...");
        laptop2.newLaptop("Asus", 1500, true);

        // Show updated info
        System.out.println("\nlaptop2 (after update)\n");
        laptop2.displaySpecs();
    }
}
