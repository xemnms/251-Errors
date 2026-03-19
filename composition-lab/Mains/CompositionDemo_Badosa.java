package Mains;
//SAMPLE CODE
import CompositeClasses.Airplane;
import ComponentClasses.Engine;

public class CompositionDemo_Badosa {
    public static void main(String[] args) {
        // Create Engine object
        Engine engine1 = new Engine("Jet", 5000);

        // Pass Engine into Airplane (composition)
        Airplane plane1 = new Airplane("Boeing 737", engine1);

        // Use the Airplane
        plane1.showDetails();
        System.out.println();
        plane1.fly();
    }
}