/**
 * Uses interface Summonable_Costiniano by Costiniano
 * This class was made by Kyla Cassandra Rodenas
 */

public class SummonAction_Rodenas implements Summonable_Costiniano {

    private String mode;

    //Constructor
    public SummonAction_Rodenas(String mode) {
        this.mode = mode;
    }

    @Override //Override abstract method
    public void performAction() {
        System.out.println("Performing action in " + mode + " mode.");
    }

    @Override //Override default method
    public void chant() {
        Summonable_Costiniano.super.chant();
        System.out.println("Summoning completed.");
    }

    //Overload method
    public void performAction(String target) {
        System.out.println("Performing action on " + target + " in " + mode + " mode.");
    }
}