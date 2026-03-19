public class Captain_Arandela extends StrawHat_Dizon {

    private String devilFruit; // e.g. "Gum-Gum Fruit"

    // Constructor
    public Captain_Arandela(String name, String affiliation, int bounty, String devilFruit) {
        super(name, affiliation, bounty);
        this.devilFruit = devilFruit;
    }

    // New behavior 
    public void gumGumAttack() {
        System.out.println(name + " uses " + devilFruit + " to launch a Gum-Gum attack!");
    }

    // Overridden method 
    @Override
    void performAction() {
        System.out.println(name + " stretches his body and attacks with Gum-Gum techniques!");
    }

    @Override
    void battleCry() {
        System.out.println(name + " shouts: 'I'm gonna be King of the Pirates!'");
    }
}