public class Summoner_Badosa implements Summonable_Costiniano {
    private String summonName;

    // constructor
    public Summoner_Badosa(String summonName) {
        this.summonName = summonName;
    }

    // implementation of abstract method
    @Override
    public void performAction() {
        System.out.println("You summoned " + summonName + "!");
        System.out.println(summonName + " performs a powerful attack!");
    }

    public void dismissSummon() {
        System.out.println(summonName + " has been dismissed.");
    }
}
