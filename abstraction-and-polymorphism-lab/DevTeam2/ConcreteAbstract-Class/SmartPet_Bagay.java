// Uses teammate abstract class `petAnimal_Acosta` created by Acosta.
// Demonstrates overriding and overloading.

public class SmartPet_Bagay extends petAnimal_Acosta {
    // Overriding
    @Override
    void move() {
        System.out.println("Smart pet follows voice commands while moving.");
    }

    // Overloading
    void move(String direction) {
        System.out.println("Smart pet moves toward: " + direction);
    }
}