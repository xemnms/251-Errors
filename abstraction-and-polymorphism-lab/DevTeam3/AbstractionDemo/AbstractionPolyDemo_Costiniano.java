public class AbstractionPolyDemo_Costiniano {

    public static void main(String[] args) {

        //dynamic binding (abstract class)
        Astolfo_Costiniano servant = new AstolfoSummon_Rodenas();
        servant.summon();
        servant.equipWeapon();
        servant.checkStatus();
        servant.noblePhantasm(); // runtime binding (overridden method)

        //overloading demo
        AstolfoSummon_Rodenas ra = new AstolfoSummon_Rodenas();
        ra.noblePhantasm("Enemy");

        //teammate abstract class (Baymax system)
        Baymax_Rodenas helper = new HealthcareAstolfo_Costiniano("Medical Mode");
        helper.BaymaxIntroduction();
        helper.showMode();
        helper.provideCare(); // overridden method

        ((HealthcareAstolfo_Costiniano) helper).provideCare("Patient"); // overloaded

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