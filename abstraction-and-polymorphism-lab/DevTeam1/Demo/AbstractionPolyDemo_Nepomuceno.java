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

        // "Test drive" - accelerate vehicles
        car1.accelerate(20);
        car2.accelerate(35);
        car3.accelerate(50);

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
    }
}