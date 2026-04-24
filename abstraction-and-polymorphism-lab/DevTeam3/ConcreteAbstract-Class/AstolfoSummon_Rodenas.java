/**
 * Uses abstract class Astolfo_Costiniano by Costiniano
 * This class was made by Kyla Cassandra Rodenas
 */

public class AstolfoSummon_Rodenas extends Astolfo_Costiniano {

    @Override // Override abstract method
    public void noblePhantasm() {
        System.out.println("Astolfo is using his Noble Phantasm!");
    }

    // Overload method
    public void noblePhantasm(String target) {
        System.out.println("Astolfo targets " + target + " with Noble Phantasm!");
    }
}