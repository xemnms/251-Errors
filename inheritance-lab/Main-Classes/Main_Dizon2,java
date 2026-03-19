/*
 ==============================================================================
 ANALYSIS OF INHERITANCE BEHAVIOR (Task 11)
 ==============================================================================
 1. What is the IS-A relationship in your program?
  F1Prodigy_Dizon IS-A Formula1 (Subclass of Formula1)
  F1PitCrew_Dizon IS-A Formula1 (Subclass of Formula1)
 2. Which method was overridden?
 The race() method was overridden in both child classes to provide 
 unique logic.
 3. What happens during dynamic binding?
  When the parent-type variable 'polymorphicRacer' calls race(), Java 
  waits until runtime to see what the actual object is (F1Prodigy_Dizon). 
  It then executes the child's version of race() instead of the parent's.
 4. What methods were inherited from the parent class?
  displayInfo() was inherited and used directly.
 The attributes 'team', 'speed', and 'driver' were also inherited.
 5. What new behavior did the subclass introduce?
 F1Prodigy_Dizon introduced toggleDRS().
 F1PitCrew_Dizon introduced performPitStop().
 ==============================================================================
 */

public class Main_Dizon {
    public static void main(String[] args) {
        
        System.out.println("=================================================");
        System.out.println("   FORMULA 1 INHERITANCE MANAGEMENT SYSTEM       ");
        System.out.println("        Developed by: DIZON, From 251B           ");
        System.out.println("=================================================");

        // Instantiating Objects
        F1Prodigy_Dizon racerA = new F1Prodigy_Dizon("Red Bull", 345, "Max Verstappen", false);
        F1PitCrew_Dizon racerB = new F1PitCrew_Dizon("Mercedes", 330, "Lewis Hamilton", 2100);

        // First Child Class (Prodigy)
        System.out.println("\n[SCENARIO 1: ON-TRACK PERFORMANCE]");
        racerA.displayInfo(); // Inherited
        racerA.toggleDRS();   // Unique Behavior
        racerA.race();        // Overridden

        //Second Child Class (Pit Crew)
        System.out.println("\n[SCENARIO 2: PIT LANE STRATEGY]");
        racerB.displayInfo();    // Inherited
        racerB.performPitStop(); // Unique Behavior
        racerB.race();           // Overridden

        //Dynamic Binding 
        System.out.println("\n[SCENARIO 3: DYNAMIC BINDING DEMO]");
        System.out.println("Note: Using Formula1 variable to hold an F1Prodigy object...");
        
        // Variable type is Parent, Object type is Child
        Formula1 polymorphicRacer = new F1Prodigy_Dizon("Ferrari", 338, "Charles Leclerc", true);
        
        // Calling the overridden method
        System.out.print("Executing .race() -> ");
        polymorphicRacer.race(); 

        // FOOTER DESIGN
        System.out.println("\n=================================================");
        System.out.println("         LAB EXERCISE COMPLETED SUCCESSFULLY      ");
        System.out.println("===================================================");
    }
}