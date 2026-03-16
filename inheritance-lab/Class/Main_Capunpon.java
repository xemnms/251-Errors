public class Main_Capunpon {
    public static void main(String[] args) {
        // Create an instance of Car
        Vehicle_Badosa car1 = new Car(4, 5, "Sedan", "Toyota", "Camry");

        // System.out.println("\nCar Brand: " + car1.getBrand());
        // System.out.println("Car Model: " + car1.getModel());
        System.out.println("Car Wheels: " + car1.getWheels());  
        System.out.println("Car Seats: " + car1.getSeats());
        System.out.println("Car Type: " + car1.getVehicleType());
        car1.startEngine();
        car1.displayMaxSpeed();
        car1.stopEngine();

        Car car2 = new Car(4, 2, "Coupe", "Honda", "Civic");
        System.out.println("\nCar Brand: " + car2.getBrand()); 
        System.out.println("Car Model: " + car2.getModel());
        System.out.println("Car Wheels: " + car2.getWheels());
        System.out.println("Car Seats: " + car2.getSeats());
        System.out.println("Car Type: " + car2.getVehicleType());
        car2.startEngine();
        car2.displayMaxSpeed();
        car2.stopEngine();
        
    }
}