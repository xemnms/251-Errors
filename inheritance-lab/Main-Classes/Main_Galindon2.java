// IS-A relationship: FerrariCar IS-A Formula1_Arandela (FerrariCar is a type of Formula1_Arandela)
// Overridden method: race() in FerrariCar (and BugattiCar) overrides Formula1_Arandela.race()
// Dynamic binding: a Formula1_Arandela reference pointing to FerrariCar calls FerrariCar.race() at runtime
// Methods inherited from parent class: pitStop(), accelerate(), plus the original race() implementation (before override)
// New behavior in subclass: activateTurbo() in FerrariCar, activatePremiumSoundSystem() in BugattiCar

public class Main_Galindon2 {
    public static void main(String[] args) {
        System.out.println("--- Create subclass objects and call behaviors ---");

        FerrariCar ferrari = new FerrariCar("Scuderia Ferrari", 320, "Charles Leclerc");
        BugattiCar bugatti = new BugattiCar("Bugatti Racing", 310, "Max Verstappen");

        // Call overridden methods
        ferrari.race();
        bugatti.race();

        // Call inherited methods
        ferrari.accelerate();
        ferrari.pitStop();

        // Call new subclass behavior
        ferrari.activateTurbo();
        bugatti.activatePremiumSoundSystem();

        System.out.println("\n--- Dynamic binding behavior ---");
        Formula1_Arandela dynamicCar = new FerrariCar("Ferrari Dynamic", 330, "Carlos Sainz");
        // Although reference type is parent, overridden method in FerrariCar executes
        dynamicCar.race();
        dynamicCar.pitStop();

        System.out.println("\n--- Summary output example style ---");
        System.out.println("Ferrari barks (simulating base behavior in your request style)");
        System.out.println("Formula1_Arandela moves");
    }
}
