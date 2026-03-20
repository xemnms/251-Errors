// Represents a time machine that can travel to different points in time and places
// Component class for Time Machine created by Bautista

public class TimeMachine_Bautista {

    // Private attributes (encapsulation)
    private String machineID;
    private String destinationPoint;
    private int yearOfTravel;
    private int monthOfTravel;

    // Constructor to initialize the time machine
    public TimeMachine_Bautista(String machineID, int yearOfTravel, int monthOfTravel, String destinationPoint) {
        this.machineID = machineID;
        this.yearOfTravel = yearOfTravel;
        setMonthOfTravel(monthOfTravel); // validated month
        this.destinationPoint = destinationPoint;
    }

    // Method to turn on the time machine
    public void turnOn() {
        System.out.println("Time Machine " + machineID + " powered on. Ready to travel!");
    }

    // Method to turn off the time machine
    public void turnOff() {
        System.out.println("Time Machine " + machineID + " powered off. Goodbye!");
    }

    // Method to travel to a specific time and place
    public void travelToTime(int yearOfTravel, int monthOfTravel, String destinationPoint) {
        // Validate the month of travel
        if (monthOfTravel < 1 || monthOfTravel > 12) {
            System.out.println("Invalid month of travel. Please enter a value between 1 and 12.");
            return;
        }

        this.yearOfTravel = yearOfTravel;
        this.monthOfTravel = monthOfTravel;
        this.destinationPoint = destinationPoint;

        // Array of month names
        String[] monthNames = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };

        System.out.println("Traveling to " + destinationPoint + " in " +
                monthNames[monthOfTravel - 1] + " " + yearOfTravel + "...");
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
        this.machineID = machineID;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public void setYearOfTravel(int yearOfTravel) {
        this.yearOfTravel = yearOfTravel;
    }

    public void setMonthOfTravel(int monthOfTravel) {
        if (monthOfTravel >= 1 && monthOfTravel <= 12) {
            this.monthOfTravel = monthOfTravel;
        } else {
            System.out.println("Invalid month. Please enter a value between 1 and 12.");
        }
    }
}