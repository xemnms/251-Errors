/**
 Subclassing a teammate's class using option 1
 * This is a specialized version of the Weapon class.
 */
public class ElderflameVandal_Dizon extends Weapon_Nepomuceno {
    private String finisherAnimation;

    public ElderflameVandal_Dizon(String finisher) {
        // Calling the teammate's constructor
        super("Elderflame Vandal", "Rifle", 40, 25);
        this.finisherAnimation = finisher;
    }

    // Overriding behavior to show a "multiplier" effect
    @Override
    public void fire() {
        System.out.print("[Dragon Effect] 🔥 ");
        super.fire(); // Reuse the teammate's logic
    }

    public void triggerFinisher() {
        System.out.println("FINISHER: " + finisherAnimation);

        
    }
}