/*
 * IS-A Relationship: 
 * - Greys_Nepomuceno IS-A Aliens_Galindon
 * - Reptilians_Nepomuceno IS-A Aliens_Galindon
 * 
 * Overridden Methods:
 * - Greys_Nepomuceno overrides powers()
 * - Reptilians_Nepomuceno overrides communicate()
 * 
 * Dynamic Binding Behavior:
 * - At compile-time, variable type is Aliens_Galindon (parent)
 * - At runtime, actual object is Greys_Nepomuceno or Reptilians_Nepomuceno (child)
 * - The child version of the overridden method executes at runtime
 * 
 * Inherited Methods:
 * - Both child classes inherit exist() and other parent methods
 * 
 * New Behavior:
 * - Greys_Nepomuceno introduces scans() method
 * - Reptilians_Nepomuceno introduces shapeshifts() method
 */

public class Main_Nepomuceno2 {
    public static void main(String[] args) {
        System.out.println("=== Demonstrating Inheritance and Dynamic Binding ===\n");
        
        // Create instances of child classes
        Greys_Nepomuceno grey1 = new Greys_Nepomuceno("Zyx", 250, "Zeta Reticuli");
        Reptilians_Nepomuceno reptilian1 = new Reptilians_Nepomuceno("Ssssara", 500, "Alpha Draconis");
        
        System.out.println("--- Greys_Nepomuceno Object ---");
        grey1.exist();  // Inherited method
        grey1.communicate();  // Inherited method
        grey1.powers();  // OVERRIDDEN method (Grey version executes)
        grey1.scans();  // New method specific to Greys
        
        System.out.println("\n--- Reptilians_Nepomuceno Object ---");
        reptilian1.exist();  // Inherited method
        reptilian1.communicate();  // OVERRIDDEN method (Reptilian version executes)
        reptilian1.powers();  // Inherited method (parent version)
        reptilian1.shapeshifts();  // New method specific to Reptilians
        
        System.out.println("\n--- Demonstrating Dynamic Binding ---");
        // Parent reference pointing to child object
        Aliens_Galindon alien1 = new Greys_Nepomuceno("Zyx-2", 200, "Zeta Reticuli");
        Aliens_Galindon alien2 = new Reptilians_Nepomuceno("Ssssara-2", 450, "Alpha Draconis");
        
        System.out.println("\nCalling methods via parent reference:");
        alien1.powers();  // Calls Greys version (runtime polymorphism)
        alien2.communicate();  // Calls Reptilians version (runtime polymorphism)
    }
}