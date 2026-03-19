package ComponentClasses;
//SAMPLE CODE
public class Engine {
    private String type;
    private int horsepower;

    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }

    public void start() {
        System.out.println(type + " engine is starting...");
    }

    public void displayInfo() {
        System.out.println("Engine Type: " + type);
        System.out.println("Horsepower: " + horsepower);
    }
}