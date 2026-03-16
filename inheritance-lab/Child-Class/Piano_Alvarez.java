/*
* Child Class Part 2 created by Angelo Hayden Alvarez
* This class extends Instrument_Bautsita.
*/

public class Piano_Alvarez extends Instrument_Bautista {

    private int numberOfKeys; // new attribute specific to Piano
    private String instrumentName;
    private String material;
    private String instrumentType;

    // Constructor
   public Piano_Alvarez(String instrumentName, String material, String instrumentType, int numberOfKeys) { 
    super(instrumentName, material, instrumentType); 
    this.instrumentName = instrumentName; 
    this.material = material; 
    this.instrumentType = instrumentType; 
    this.numberOfKeys = numberOfKeys; 
    }

    // new behaior
    public void pressKeys() {
        System.out.println("Ipindot mo baby ang piano keys (" + numberOfKeys + " keys),");
    }

    // override method
    @Override
    public void sound() {
        System.out.println("Piano sound: Pyang pyak poonk");
    }
}