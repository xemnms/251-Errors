
//second child class!! represents a luxury sports car
class BugattiCar extends Formula1_Arandela {

    // Constructor
    public BugattiCar(String team, int speed, String driver) {
        super(team, speed, driver);
    }

    // New behavior
    public void activatePremiumSoundSystem() {
        System.out.println(team + " activates premium sound system!");
    }

    // Override parent method
    @Override
    public void race() {
        System.out.println(team + " luxury car cruises smoothly on the track!");
    }
}