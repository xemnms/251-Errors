/* Composite class created by Alvarez
* for TimeMachine_Bautista component class created by bautista
*/

public class TimeController_Alvarez {

    // Private field (composition)
    private TimeMachine_Bautista timeMachine;

    // Constructor injection
    public TimeController_Alvarez(TimeMachine_Bautista timeMachine) {
        this.timeMachine = timeMachine;
    }

    // Method to operate the machine
    public void startJourney() {
        System.out.println("Starting time travel sequence...");
        timeMachine.turnOn();

        timeMachine.travelToTime(
                timeMachine.getYearOfTravel(),
                timeMachine.getMonthOfTravel(),
                timeMachine.getDestinationPoint());

        timeMachine.turnOff();
        System.out.println("Time travel sequence completed.");
    }

    // Setter (
    public void setTimeMachine(TimeMachine_Bautista timeMachine) {
        this.timeMachine = timeMachine;
    }

    // Getter
    public TimeMachine_Bautista getTimeMachine() {
        return timeMachine;
    }
}