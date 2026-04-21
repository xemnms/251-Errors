/**
 * Uses interface Summonable_Costiniano by Costiniano
 * This class was made by Isles
 */

public class Summoner_Isles implements Summonable_Costiniano {
    private String summonName;

    //constructor
    public Summoner_Isles(String summonName) {
        this.summonName = summonName;
    }

    //override abstract method
    @Override
    public void performAction() {
        System.out.println("You summoned " + summonName + "!");
        System.out.println(summonName + " attacks the enemy!");
    }

    //override default method
    @Override
    public void chant() {
        Summonable_Costiniano.super.chant();
        System.out.println("Summoning of " + summonName + " is complete.");
    }

    //overloaded method
    public void performAction(String target) {
        System.out.println(summonName + " attacks " + target + "!");
    }
}
