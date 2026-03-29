// Uses teammate interface `Feed_Acosta` created by Acosta.
// Demonstrates overriding and overloading.

public class TimedFeeder_Bagay implements Feed_Acosta {
    // Overriding
    @Override
    public void feedAnimal() {
        System.out.println("Dispensing food at scheduled feeding time.");
    }

    // Overloading
    public void feedAnimal(String foodType) {
        System.out.println("Dispensing " + foodType + " on schedule.");
    }
}