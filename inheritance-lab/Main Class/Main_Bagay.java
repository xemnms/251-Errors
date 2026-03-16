// Parent Class Vehicle_Badosa created by Badosa
// Child Class LuxaryCar_Bagay created by Bagay
// Main class Main_Bagay created by Bagay

// IS-A relationship: LuxaryCar_Bagay IS-A Vehicle_Badosa.
// Overridden method: displayMaxSpeed() in LuxaryCar_Bagay overrides Vehicle_Badosa.displayMaxSpeed().
// Dynamic binding: when a Vehicle_Badosa reference points to a LuxaryCar_Bagay object, calling displayMaxSpeed() executes the child version at runtime.
// Inherited methods from parent class: startEngine(), stopEngine(), getWheels(), getSeats(), getVehicleType().
// New subclass behavior: openSunroof(), plus additional child attributes brand and model.

public class Main_Bagay {
    public static void main(String[] args) {
        // Create a subclass object.
        LuxaryCar_Bagay myCar = new LuxaryCar_Bagay(4, 5, "Car", "Mercedes-Benz", "S-Class");

        // Call inherited methods and inherited getters.
        myCar.startEngine();
        System.out.println("Vehicle Type: " + myCar.getVehicleType());
        System.out.println("Number of Wheels: " + myCar.getWheels());
        System.out.println("Number of Seats: " + myCar.getSeats());
        System.out.println("Brand: " + myCar.getBrand());
        System.out.println("Model: " + myCar.getModel());

        // Call behavior introduced by the subclass.
        myCar.openSunroof();

        // Call the overridden method using the subclass reference.
        myCar.displayMaxSpeed();

        // Show dynamic binding using a parent reference.
        Vehicle_Badosa vehicleRef = myCar;
        vehicleRef.displayMaxSpeed();

        // Another inherited method call.
        myCar.stopEngine();
    }
}