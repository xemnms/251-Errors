//Child class created by Badosa, Parent class is Aeroplane_Bagay

public class Boeing_Badosa extends Aeroplane_Bagay{
    private int maxFuel;
    private int passengerCapacity;

    public Boeing_Badosa(String model, int speed, String color, int maxFuel, int passengerCapacity){
        super(model, speed, color);
        this.maxFuel = maxFuel;
        this.passengerCapacity = passengerCapacity;
    }

    //getter
    public int getMaxFuel(){
        return maxFuel;
    }
    public int getpassengerCapacity(){
        return passengerCapacity;
    }

    //additional method
    public void emergencyLand(){
        System.out.println("Your plane has landed successfully due to an emergency");
    }

    //Override
    public void displayType(){
        System.out.println("This is a Boeing plane");
    }
}
