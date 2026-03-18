// Parent Class created by Bautista
// Represents musical instrument that can be played and tuned

public class Instrument_Bautista {

    // Attributes
    private String instrumentName;
    private String material;
    private String instrumentType;

    // Constructor
    public Instrument_Bautista(String instrumentName, String material, String instrumentType) {
        this.instrumentName = instrumentName;
        this.material = material;
        this.instrumentType = instrumentType;
    }

    // Getters
    public String getInstrumentName() {
        return instrumentName;
    }

    public String getMaterial() {
        return material;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    // Behaviors
    public void play() {
        System.out.println("Playing " + instrumentName + "...");
    }

    public void tune() {
        System.out.println("Tuning... hindi na sintunado—hopefully.");
    }

    // Method that can be overridden
    public void sound() {
        System.out.println("Random music noises.");
    }
}