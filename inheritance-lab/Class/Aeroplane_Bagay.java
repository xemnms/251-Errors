// Class create by Bagay
public class Aeroplane_Bagay {
    // Attribuites of the Aeroplane class
    private String model;
    private int speed;
    private String color;


    public Aeroplane_Bagay(String model, int speed, String color) {
        this.model = model;
        this.speed = speed;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
        return color;
    }

    // Behavior of the Aeroplane class
    public void fly() {
        System.out.println("The " + color + " " + model + " is flying at a speed of " + speed + " km/h.");
    }

    public void land() {
        System.out.println("The " + color + " " + model + " is landing safely.");
    }

    // This method is intended to be overridden by subclasses.
    public void displayType() {
        System.out.println("This is a standard aeroplane.");
    } 
}