/*
Compatible child component used to demonstrate low coupling.
This class overrides startup behavior while keeping the same engine contract.
*/
public class EcoEngine_Bagay extends engine_alvarez {

    // Constructor forwards required engine data to the parent component.
    public EcoEngine_Bagay(int horsepower, String type) {
        super(horsepower, type);
    }

    @Override
    // Customized startup behavior while preserving compatibility.
    public void startEngine() {
        if (!isRunning()) {
            setRunning(true);
            System.out.println("silent ignition... eco engine online.");
        } else {
            System.out.println("eco engine already running.");
        }
    }
}
