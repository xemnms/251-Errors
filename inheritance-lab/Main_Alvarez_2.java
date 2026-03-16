// Main Class Created by Alvarez

public class Main_Alvarez2 {
    public static void main(String[] args) {

        System.out.println("==========================");
        System.out.println("     Instrument Guide     ");
        System.out.println("==========================");

        // Create a Guitar object
        Guitar_Alvarez myGuitar = new Guitar_Alvarez("Acoustic Guitar", "Wood", "String", 6);

        System.out.println("=== Guitar Info ===");
        System.out.println("Name: " + myGuitar.getInstrumentName());
        System.out.println("Material: " + myGuitar.getMaterial());
        System.out.println("Type: " + myGuitar.getInstrumentType());
        myGuitar.play();         // from parent
        myGuitar.tune();         // from parent
        myGuitar.sound();        // overridden in child
        myGuitar.strum();        // child-specific method

        System.out.println("\n=== Piano Info ===");
        // Create a Piano object
        Piano_Alvarez myPiano = new Piano_Alvarez("Grand Piano", "Wood & Metal", "Keyboard", 88);

        System.out.println("Name: " + myPiano.getInstrumentName());
        System.out.println("Material: " + myPiano.getMaterial());
        System.out.println("Type: " + myPiano.getInstrumentType());
        myPiano.play();          // from parent
        myPiano.tune();          // from parent
        myPiano.sound();         // overridden in child
        myPiano.pressKeys();     // child-specific method

        System.out.println("\n=== Polymorphism Demo ===");
        // Using parent class reference
        Instrument_Bautista instrument;

        instrument = myGuitar;   // parent reference to Guitar object
        instrument.sound();       // calls overridden Guitar sound()

        instrument = myPiano;    // parent reference to Piano object
        instrument.sound();       // calls overridden Piano sound()
    }
}
