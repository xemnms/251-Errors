/* 
Parent class: Vehicle_Badosa
Child classes: LuxaryCar_Bagay and Yatch_Bagay
1) IS-A relationship:
    LuxaryCar_Bagay IS-A Vehicle_Badosa.
    Yatch_Bagay IS-A Vehicle_Badosa.

2) Overridden method:
    displayMaxSpeed() is overridden in both child classes.

3) Dynamic binding:
    When a Vehicle_Badosa reference points to a child object,
    calling displayMaxSpeed() runs the child class version at runtime. 
    (Asked AI to forfeedback to explain dynamic binding, but I wrote the answer.)

4) Inherited methods from parent:
    startEngine() and stopEngine() are inherited from Vehicle_Badosa.

5) New behavior introduced by subclasses:
    LuxaryCar_Bagay adds openSunroof().
    Yatch_Bagay adds deployAnchor(). 
*/

public class InheritanceMain_Bagay {
    public static void main(String[] args) {
        LuxaryCar_Bagay myLuxuryCar = new LuxaryCar_Bagay(4, 5, "Luxury Car", "Mercedes", "S-Class");
        Yatch_Bagay myYatch = new Yatch_Bagay(0, 12, "Yatch", "Azimut", "Grande 32M");

        System.out.println("=== Direct subclass object calls ===");
        myLuxuryCar.startEngine();
        myLuxuryCar.displayMaxSpeed();
        myLuxuryCar.openSunroof();
        myLuxuryCar.stopEngine();

        System.out.println();
        myYatch.startEngine();
        myYatch.displayMaxSpeed();
        myYatch.deployAnchor();
        myYatch.stopEngine();

        System.out.println("\n=== Dynamic binding demo ===");
        Vehicle_Badosa vehicleRef1 = new LuxaryCar_Bagay(4, 5, "Luxury Car", "BMW", "7 Series");
        Vehicle_Badosa vehicleRef2 = new Yatch_Bagay(0, 10, "Yatch", "Sunseeker", "Predator 65");

        // Parent reference, child object: child override executes at runtime.
        vehicleRef1.displayMaxSpeed();
        vehicleRef2.displayMaxSpeed();

        // Inherited parent methods are still accessible through parent references.
        vehicleRef1.startEngine();
        vehicleRef2.stopEngine();
    }
}