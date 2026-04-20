/* Demo class for Abstraction & Polymorphism
 * Uses abstract class Astolfo_Costiniano and interface Summonable_Costiniano
 * Concrete classes: AstolfoSummon_Rodenas, SummonAction_Rodenas
 * Demonstrates overriding, overloading, dynamic binding, and using concrete methods from abstract class
 * This class was made by Kyla Cassandra Rodenas
 */

public class AbstractionPolyDemo_Rodenas {
    public static void main(String[] args) {

        //AstolfoSummon_Rodenas uses abstract class Astolfo_Costiniano by Costiniano
        Astolfo_Costiniano astolfo = new AstolfoSummon_Rodenas(); //dynamic binding
        astolfo.noblePhantasm(); //Overridden method
        astolfo.summon(); //Concrete method from abstract class
        astolfo.equipWeapon();   
        astolfo.checkStatus();

        //Overloading
        AstolfoSummon_Rodenas concreteAstolfo = new AstolfoSummon_Rodenas();
        concreteAstolfo.noblePhantasm("Enemy");

        //SummonAction_Rodenas uses interface Summonable_Costiniano by Costiniano
        SummonAction_Rodenas summon = new SummonAction_Rodenas("Healthcare");
        summon.performAction(); //Overridden abstract method
        summon.chant(); //Overridden default method
        summon.performAction("Target Dummy"); //Overloaded method
    }
}

/*Code-based analysis:
1) Abstract class used: Astolfo_Costiniano (Costiniano)
2) Interface used: Summonable_Costiniano (Costiniano)
3) Overridden methods: noblePhantasm() in AstolfoSummon_Rodenas, 
    performAction() and chant() in SummonAction_Rodenas
4) Overloaded methods: noblePhantasm(String) in AstolfoSummon_Rodenas, 
   performAction(String) in SummonAction_Rodenas
5) Dynamic binding: Astolfo_Costiniano astolfo = new AstolfoSummon_Rodenas();
   calls noblePhantasm() at runtime
6) Polymorphism: abstract class reference (Astolfo_Costiniano) and interface reference
   (SummonAction_Rodenas implements Summonable_Costiniano) point to concrete objects
7) Low coupling: demo only depends on abstract class and interface, not on specific 
   implementation details
8) High cohesion: each class has focused responsibility (summoning and performing actions)
*/