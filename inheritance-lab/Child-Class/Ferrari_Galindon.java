//parent class by arandela, child class by galindon
//first child class!! represents a sports car

class FerrariCar extends Formula1_Arandela {

    // Constructor
    public FerrariCar(String team, int speed, String driver) {
        super(team, speed, driver);
    }

    //  New behavior
    public void activateTurbo() {
        System.out.println(team + " activates turbo boost!");
    }

    // Override parent method
    @Override
    public void race() {
        System.out.println(team + " Ferrari car speeds aggressively on the track!");
    }
}
