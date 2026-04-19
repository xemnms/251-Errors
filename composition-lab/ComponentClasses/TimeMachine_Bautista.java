// Represents a time machine that can travel to different points in time and places
// Component class for Time Machine created by Bautista

public class TimeMachine_Bautista {

    // Private attributes (encapsulation)
    private String machineID;
    private String destinationPoint;
    private int yearOfTravel;
    private int monthOfTravel;

    // Static constant array (created only once, shared by all objects)
    private static final String[] MONTH_NAMES = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    // Constructor (uses setters for validation consistency)
    public TimeMachine_Bautista(String machineID, int yearOfTravel, int monthOfTravel, String destinationPoint) {
        setMachineID(machineID);
        setYearOfTravel(yearOfTravel);
        setMonthOfTravel(monthOfTravel);
        setDestinationPoint(destinationPoint);
    }

    // Behavior methods
    public void turnOn() {
        System.out.println("Time Machine " + machineID + " powered on. Ready to travel!");
    }

    public void turnOff() {
        System.out.println("Time Machine " + machineID + " powered off. Goodbye!");
    }

    public void travelToTime(int yearOfTravel, int monthOfTravel, String destinationPoint) {
        setYearOfTravel(yearOfTravel);
        setMonthOfTravel(monthOfTravel);
        setDestinationPoint(destinationPoint);

        System.out.println("Traveling to " + this.destinationPoint + " in " +
                MONTH_NAMES[this.monthOfTravel - 1] + " " + this.yearOfTravel + "...");
    }

    // Getters
    public String getMachineID() {
        return machineID;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public int getYearOfTravel() {
        return yearOfTravel;
    }

    public int getMonthOfTravel() {
        return monthOfTravel;
    }

    // Setters 
    public void setMachineID(String machineID) {
        if (machineID != null && !machineID.trim().isEmpty()) {
            this.machineID = machineID;
        } else {
            System.out.println("Invalid machine ID. Defaulting to TM-DEFAULT.");
            this.machineID = "TM-DEFAULT";
        }
    }

    public void setDestinationPoint(String destinationPoint) {
        if (destinationPoint != null && !destinationPoint.trim().isEmpty()) {
            this.destinationPoint = destinationPoint;
        } else {
            System.out.println("Invalid destination. Defaulting to Home Location.");
            this.destinationPoint = "Home Location";
        }
    }

    public void setYearOfTravel(int yearOfTravel) {
        if (yearOfTravel != 0) {
            this.yearOfTravel = yearOfTravel;
        } else {
            System.out.println("Invalid year. Defaulting to Present Time.");
            this.yearOfTravel = 2025; // Assuming current year as default
        }
    }

    public void setMonthOfTravel(int monthOfTravel) {
        if (monthOfTravel >= 1 && monthOfTravel <= 12) {
            this.monthOfTravel = monthOfTravel;
        } else {
            System.out.println("Invalid month. Defaulting to January.");
            this.monthOfTravel = 1; // Default to January
        }
    }
}