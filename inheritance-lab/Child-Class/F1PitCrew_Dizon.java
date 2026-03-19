public class F1PitCF1PitCrew_Dizon extends Formula1_Arandela {
    private int pitStopDuration; // in milliseconds

    public F1PitCrew_Dizon(String team, int speed, String driver, int pitStopDuration) {
        super(team, speed, driver);
        this.pitStopDuration = pitStopDuration;
    }

    // New behavior unique to this child class
    public void performPitStop() {
        System.out.println("BOX BOX! The crew is changing tires for " + driver);
        System.out.println("Pit stop completed in: " + (pitStopDuration / 1000.0) + " seconds.");
    }

    // Override the parent race method
    @Override
    public void race() {
        System.out.println(team + " is currently in the pits. Current speed: 0 km/h.");
    }
}