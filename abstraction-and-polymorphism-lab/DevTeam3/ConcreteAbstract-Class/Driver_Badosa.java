public class Driver_Badosa extends Isles_Drive {
    // Constructor that passes values to the parent abstract class
    public Driver_Badosa(boolean hasLicense, boolean inVehicle, boolean isLegalAge) {
        super(hasLicense, inVehicle, isLegalAge);
    }

    // Implementation of the abstract method
    @Override
    public void drive() {
        if (hasLicense() && isInVehicle() && isLegalAge()) {
            System.out.println("You are now driving the car safely.");
        } else {
            System.out.println("You cannot start driving yet.");
            checkAllRequirements(); // reuse the parent method
        }
    }
}