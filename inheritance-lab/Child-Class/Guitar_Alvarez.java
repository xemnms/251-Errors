/*
* Child Class Part 1 created by Angelo Hayden Alvarez
* This class extends Instrument_Bautsita.
*/

public class Guitar_Alvarez extends Instrument_Bautista {

    private int numberOfStrings; // new attribute specific to guitar
    private String instrumentName;
    private String material;
    private String instrumentType;

    // Constructor
    public Guitar_Alvarez(String name, String material, String instrumentType, int numberOfStrings) { 
        super(name, material, instrumentType); 
        this.instrumentName = name; 
        this.material = material; 
        this.instrumentType = instrumentType; 
        this.numberOfStrings = numberOfStrings; }
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