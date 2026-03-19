public class F1Prodigy_Dizon extends Formula1_Arandela {
    private boolean drsEnabled;

    public F1Prodigy_Dizon(String team, int speed, String driver, boolean drsEnabled) {
        // parent constructor
        super(team, speed, driver);
        this.drsEnabled = drsEnabled;
    }

    // Add new behavior unique to the child class
    public void toggleDRS() {
        drsEnabled = !drsEnabled;
        String status = drsEnabled ? "Enabled" : "Disabled";
        System.out.println("DRS is now " + status + " for " + driver);
    }

    //  Override a parent method
    @Override
    public void race() {
        if (drsEnabled) {
            System.out.println(driver + " is pushing " + team + " to the limit with DRS open!");
        } else {
            System.out.println(team + " is maintaining tactical pace on the track.");
        }
    }
}