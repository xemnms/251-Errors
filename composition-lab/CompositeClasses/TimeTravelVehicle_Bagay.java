/*
Composed class that models HAS-A relationships.
TimeTravelVehicle_Bagay coordinates mission behavior using injected components.
*/
public class TimeTravelVehicle_Bagay {

    // Private fields enforce encapsulation of composed components.
    private String vehicleName;
    private engine_alvarez engine;
    private TimeMachine_Bautista timeMachine;

    // Constructor injection for required collaborators.
    public TimeTravelVehicle_Bagay(String vehicleName, engine_alvarez engine, TimeMachine_Bautista timeMachine) {
        this.vehicleName = vehicleName;
        this.engine = engine;
        this.timeMachine = timeMachine;
    }

    // Starts a mission by delegating to engine and time machine objects.
    public void startMission() {
        System.out.println("Preparing vehicle: " + vehicleName);
        engine.startEngine();
        timeMachine.turnOn();
    }

    // Delegates travel behavior to the time machine component.
    public void travelMission(int year, int month, String destination) {
        System.out.println("Mission launched by " + vehicleName + ".");
        timeMachine.travelToTime(year, month, destination);
    }

    // Ends mission by shutting down time machine operations.
    public void endMission() {
        System.out.println("Ending mission for " + vehicleName + ".");
        timeMachine.turnOff();
    }

    // Setter injection enables replacement with compatible engine objects.
    public void setEngine(engine_alvarez engine) {
        this.engine = engine;
    }

    // Setter injection allows swapping time machine collaborators if needed.
    public void setTimeMachine(TimeMachine_Bautista timeMachine) {
        this.timeMachine = timeMachine;
    }

    // Displays current composition setup for verification in the demo.
    public void showSetup() {
        System.out.println("Vehicle: " + vehicleName);
        System.out.println("Engine type: " + engine.getType());
        System.out.println("Horsepower: " + engine.getHorsepower());
        System.out.println("Time machine ID: " + timeMachine.getMachineID());
        System.out.println("Current destination: " + timeMachine.getDestinationPoint());
    }
}