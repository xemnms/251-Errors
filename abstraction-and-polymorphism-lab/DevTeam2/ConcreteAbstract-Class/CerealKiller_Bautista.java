// Concrete abstract class created by Bautista
// Uses teammate abstract class "Cereal_Alvarez" created by Alvarez.
// Demonstrates overriding and overloading.

public class CerealKiller_Bautista extends Cereal_Alvarez {

    // Overriding
    @Override
    void prepare () {
        System.out.println("Cereal Killer is preparing a bowl of cereal with chocolate milk.");
    }

    // Overloading
    void prepare (String cerealType) {
        System.out.println("Cereal Killer is preparing a bowl of " + cerealType + " with chocolate milk.");
    }
}