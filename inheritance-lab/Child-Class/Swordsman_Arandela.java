public class Swordsman_Arandela extends StrawHat_Dizon {

    private int swordCount;

    public Swordsman_Arandela(String name, String affiliation, int bounty, int swordCount) {
        super(name, affiliation, bounty);
        this.swordCount = swordCount;
    }

    // New behavior
    public void swordAttack() {
        System.out.println(name + " attacks using " + swordCount + " swords!");
    }

    // Override methods
    @Override
    void performAction() {
        System.out.println(name + " performs a powerful sword technique!");
    }

    @Override
    void battleCry() {
        System.out.println(name + " shouts: 'Santoryu!!!'");
    }
}