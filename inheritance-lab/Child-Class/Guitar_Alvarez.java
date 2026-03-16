/*
* Child Class created by Angelo Hayden Alvarez
* This class extends Instrument_Bautsita.
*/

public class Guitar_Alvarez extends Instrument_Bautista {

    private in numberOfStrings;

    // Constructor
    public Guuitar_Alvarez(String name, String material, String type, int numberOfStrings) {
        this.instrumentName = instrumentName;
        this.material = material;
        this.instrumentType = instrumentType;
        this.numberOfStrings = numberOfStrings;
    }

    // New Behavior
    public void strum() {
        System.out.println("Strumming the guitar with " + numberOfStrings + " strings.");
    }

    // override method
    @Override
    public void sound() {
        System.out.println("Guitar sound: Strum lang ng Strum");
    }

    
}