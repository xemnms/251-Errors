 public class Car extends Vehicle_Badosa {

    //Attributes of a Car
    private String brand;
    private String model;

    //Constructor
    public Car(int wheels, int seats, String vehicleType, String brand, String model) {
        super(wheels, seats, vehicleType);
        this.brand = brand;
        this.model = model;
    }

    //Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    //Overriding the displayMaxSpeed method to provide specific behavior for Car
    @Override
    public void displayMaxSpeed() {
        System.out.println("The maximum speed of this car is 200 km/h.");
    }
}
