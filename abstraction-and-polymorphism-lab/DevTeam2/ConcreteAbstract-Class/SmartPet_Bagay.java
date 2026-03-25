// Uses teammate abstract class `petAnimal_Acosta` created by Acosta.
// Demonstrates overriding and overloading.

public class SmartPet_Bagay extends petAnimal_Acosta {
    @Override
    void move() {
        System.out.println("Smart pet follows voice commands while moving.");
    }

    void move(String direction) {
        System.out.println("Smart pet moves toward: " + direction);
    }
}