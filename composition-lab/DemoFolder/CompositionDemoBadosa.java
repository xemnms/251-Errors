package DemoFolder;
//Demonstration class by Badosa, Executes the planning to attack

// What are the **HAS-A relationships**: MageAttackPlanning HAS-A Mage and SchedulePlanner
//Which classes were reused?: Mage_Isles and SchedulePlanner_Rodenas were reused as components in MageAttackPlanning_Badosa
//How does composition reduce coupling?: Composition allows MageAttackPlanning_Badosa to use Mage_Isles and SchedulePlanner_Rodenas without being tightly coupled to their implementations. Changes to the Mage or Schedule classes won't directly affect the Attack Planning class, as long as the interfaces remain consistent. 
//How is cohesion maintained?: The Final plan is cohesive because all involved classes makes sense(For me atleast)
//Why is inheritance **NOT appropriate** here?: Because the MageAttackPlanning_Badosa uses both mage and schedule as components. using inheritance would imply an IS-A relationship which is not how it should be in this case.  

//Importing needed class
import CompositeClasses.MageAttackPlanning_Badosa;
import ComponentClasses.Mage_Isles;
import ComponentClasses.SchedulePlanner_Rodenas;

public class CompositionDemoBadosa {
    public static void main(String[] args) {
        // Creating Components (Sabay sila duo sa Tore Next week)
        Mage_Isles mage = new Mage_Isles();
        Mage_Isles mage2 = new Mage_Isles();
        SchedulePlanner_Rodenas schedule = new SchedulePlanner_Rodenas("Monday", "10:00 AM", "Attack Turret");

        // Creating Attack Plan
        MageAttackPlanning_Badosa attackPlan = new MageAttackPlanning_Badosa(mage, schedule);
        MageAttackPlanning_Badosa attackPlan2 = new MageAttackPlanning_Badosa(mage2, schedule);

        // Setting mage1 attributes
        mage.setElementName("Earth");
        mage.setPowerLevel(90);
        mage.setType("Damage");

        // Setting mage2 attributes
        mage2.setElementName("Water");
        mage2.setPowerLevel(80);
        mage2.setType("Support");

        // Display the plans
        attackPlan.displayPlan();
        attackPlan2.displayPlan();
    }
}
