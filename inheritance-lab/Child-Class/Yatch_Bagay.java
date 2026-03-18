// Additional child class by Bagay to demonstrate hierarchical inheritance with Vehicle_Badosa as the parent class.

public class Yatch_Bagay extends Vehicle_Badosa {
    private String brand;
    private String model;

    public Yatch_Bagay(int wheels, int seats, String vehicleType, String brand, String model) {
        super(wheels, seats, vehicleType);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void deployAnchor() {
        System.out.println("Anchor deployed for " + brand + " " + model + ".");
    }

    @Override
    public void displayMaxSpeed() {
        System.out.println("The maximum speed of the " + brand + " " + model + " is 45 knots.");
    }
}
