public class AbstractionPolyDemo_Nepomuceno {
    public static void main(String[] args) {
        System.out.println("=== Welcome to Nepomuceno Vehicle Shop ===");

        // Create vehicles (inventory) using real car models
        InterfaceConcreteVehicle_Nepomuceno car1 = new InterfaceConcreteVehicle_Nepomuceno("Toyota Corolla 2024");
        InterfaceConcreteVehicle_Nepomuceno car2 = new InterfaceConcreteVehicle_Nepomuceno("Honda Civic 2023");
        InterfaceConcreteVehicle_Nepomuceno car3 = new InterfaceConcreteVehicle_Nepomuceno("Ford Mustang GT 2022");

        // Display initial status
        System.out.println("\n=== Initial Vehicle Status ===");
        car1.displayStatus();
        car2.displayStatus();
        car3.displayStatus();

        // REGULAR call (uses the overridden interface method: accelerate(double))
        car1.accelerate(20.0);

        // OVERLOADING example (calls accelerate(double, int))
        car2.accelerate(5.0, 3);

        // (Optional extra regular call)
        car3.accelerate(50.0);

        // Display updated status
        System.out.println("\n=== Updated Vehicle Status ===");
        car1.displayStatus();
        car2.displayStatus();
        car3.displayStatus();

        // Simulate buying a car using the abstract payment concrete class
        System.out.println("\n=== Checkout / Payment ===");
        System.out.println("Customer chose: " + car3.getModel() + "\n");

        AbstractConcretePayment_Nepomuceno payment =
                new AbstractConcretePayment_Nepomuceno("Cash Payment", "2026-03-25", 35000.00);

        payment.processPayment();

        /*
         * - What abstract class did you create?
         *   AbstractPayment_Arandela is the abstract class (it defines abstract processPayment()).
         *
         * - What interface did you create?
         *   InterfaceVehicle_Galindon is the interface (it defines accelerate(double) and default displayStatus()).
         *
         * - What methods did you override?
         *   1) In AbstractConcretePayment_Nepomuceno: processPayment() overrides AbstractPayment_Arandela.processPayment().
         *   2) In InterfaceConcreteVehicle_Nepomuceno: accelerate(double) overrides InterfaceVehicle_Galindon.accelerate(double).
         *
         * - What methods did you overload?
         *   In InterfaceConcreteVehicle_Nepomuceno:
         *     accelerate(int increment)
         *     accelerate(double increment, int times)
         *   These overload accelerate(...) because they have the same name but different parameters.
         *
         * - Where does dynamic binding occur in your code?
         *   Dynamic binding happens when an overridden method is called through a parent type reference at runtime.
         *   Example: calling processPayment() on an AbstractPayment_Arandela reference, like:
         *       AbstractPayment_Arandela p = new AbstractConcretePayment_Nepomuceno(...);
         *       p.processPayment();  // runtime chooses the subclass method
         *   (In this demo, payment is declared as AbstractConcretePayment_Nepomuceno, but the same concept applies.)
         *
         * - Which part shows polymorphism?
         *   Polymorphism is shown when a parent type can refer to a child object and call overridden methods.
         *   Example pattern (polymorphism):
         *       AbstractPayment_Arandela p = new AbstractConcretePayment_Nepomuceno(...);
         *       p.processPayment();
         *   Also (interface polymorphism idea):
         *       InterfaceVehicle_Galindon v = new InterfaceConcreteVehicle_Nepomuceno(...);
         *       v.accelerate(10.0);
         *
         * - How does your design achieve low coupling?
         *   By coding to abstractions (InterfaceVehicle_Galindon and AbstractPayment_Arandela),
         *   other parts of the program can depend on the interface/abstract class instead of concrete classes.
         *   That means you can replace the concrete vehicle/payment implementations with minimal changes.
         *
         * - How does your design achieve high cohesion?
         *   Each class has one clear responsibility:
         *     - InterfaceConcreteVehicle_Nepomuceno handles vehicle state/behavior (model, speed, accelerate, display).
         *     - AbstractPayment_Arandela / AbstractConcretePayment_Nepomuceno handle payment behavior/status.
         *   The demo class only coordinates the flow (shop simulation) and doesn't mix in the internal logic.
         */
    }
}