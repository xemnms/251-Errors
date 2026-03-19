public class Formula1_Arandela {

    // Attributes
    protected String team;
    protected int speed;
    protected String driver;

    // Constructor
    public Formula1_Arandela(String team, int speed, String driver) {
        this.team = team;
        this.speed = speed;
        this.driver = driver;
    }

    // Method (can be overridden)
    public void race() {
        System.out.println(team + " car is racing on the track!");
    }

    // Another method
    public void displayInfo() {
        System.out.println("Team: " + team);
        System.out.println("Driver: " + driver);
        System.out.println("Speed: " + speed + " km/h");
    }
}