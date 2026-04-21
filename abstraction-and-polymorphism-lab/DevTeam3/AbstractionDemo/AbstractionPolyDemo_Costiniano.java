public class AbstractionPolyDemo_Costiniano {

    public static void main(String[] args) {

        //dynamic binding abstract class Astolfo
        Astolfo_Costiniano servant = new RiderAstolfo_Costiniano();
        servant.summon();
        servant.equipWeapon();
        servant.checkStatus();
        servant.noblePhantasm(); //runtime binding

        //interface polymorphism
        Summonable_Costiniano s = new RiderAstolfo_Costiniano();
        s.performAction();
        s.chant(); // default method

        //overloading
        RiderAstolfo_Costiniano ra = new RiderAstolfo_Costiniano();
        ra.noblePhantasm("Enemy");

        //teammate abstraction Baymax_Rodenas
        Baymax_Rodenas helper = new HealthcareAstolfo_Costiniano("Medical Mode");
        helper.BaymaxIntroduction();
        helper.showMode();
        helper.provideCare(); //overridden
        ((HealthcareAstolfo_Costiniano) helper).provideCare("Patient"); //overloaded

        helper.assessPain();
        helper.showCapabilities();
        helper.deactivationReminder();
        helper.fistBump();
        helper.comfortPatient();
        helper.giveLollipop();
        helper.offerHug();
        
        /*
         1. Abstract classes: Astolfo_Costiniano, Baymax_Rodenas
         2. Interfaces: Summonable_Costiniano, BaymaxChip_Rodenas
         3. Overriding: methods in RiderAstolfo_Costiniano and HealthcareAstolfo_Costiniano
         4. Overloading: noblePhantasm(String), provideCare(String)
         5. Dynamic binding: methods resolved at runtime via abstract class references
         6. Polymorphism: shown via abstract class and interface references to subclasses
         7. Low coupling & high cohesion: behavior separated using interfaces and focused classes
         */
        
    }
}