/*
 * Parent class for Formula 1 cars.
 * Created to support the FerrariCar/BugattiCar child classes.
 */
public class Formula1_Arandela {
    String team;
    int speed;
    String driver;

    public Formula1_Arandela(String team, int speed, String driver) {
        this.team = team;
        this.speed = speed;
        this.driver = driver;
    }

    public void race() {
        System.out.println(team + " Formula 1 car races on the track.");
    }

    public void pitStop() {
        System.out.println(team + " car performs a pit stop.");
    }

    public void accelerate() {
        System.out.println(team + " car accelerates to " + speed + " km/h.");
    }
}