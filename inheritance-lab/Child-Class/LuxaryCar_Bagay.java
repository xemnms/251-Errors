// Child class created by Bagay, Parent class is Vehicle_Badosa created by Badosa

public class LuxaryCar_Bagay extends Vehicle_Badosa {
    // Luxary car specific attributes
    private String brand;
    private String model;

    public LuxaryCar_Bagay(int wheels, int seats, String vehicleType, String brand, String model) {
        super(wheels, seats, vehicleType); // Call the constructor of the parent class
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    // Override the displayMaxSpeed method to provide specific behavior for cars
    @Override
    public void displayMaxSpeed() {
        System.out.println("The maximum speed of the " + brand + " " + model + " is 240 km/h.");
    }
}