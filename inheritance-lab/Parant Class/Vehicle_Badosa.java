//Class created by Badosa
public class Vehicle_Badosa{
    //Attributes of a Vehicle
    private int wheels;
    private int seats;
    private String vehicleType;

    //Constructor
    public Vehicle_Badosa(int wheels, int seats, String vehicleType){
        this.wheels = wheels;
        this.seats = seats;
        this.vehicleType = vehicleType;
    }
    //Getters
    public int getWheels(){
        return wheels;
    }
    public int getSeats(){
        return seats;
    }
    public String getVehicleType(){
        return vehicleType;
    }

    //Behaviors
    public void startEngine(){
        System.out.println("You have started your engine");
    }
    public void stopEngine(){
        System.out.println("You have stopped your engine");
    }
    public void displayMaxSpeed(){
        System.out.println("Unknown");
    }
}