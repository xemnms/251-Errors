
public class StrawHat_Dizon {
    String name;
    String affiliation; // "Straw Hat Pirates"
    int bounty;

    public StrawHat_Dizon(String name, String affiliation, int bounty) {
        this.name = name;
        this.affiliation = affiliation;
        this.bounty = bounty;
    }

    // A behavior that can be inherited as-is
    void displayStats() {
        System.out.println("Name: " + name + " | Group: " + affiliation + " | Bounty: ฿" + bounty);
    }

    // A behavior intended to be overridden by specific roles
    void performAction() {
        System.out.println(name + " is performing a general action.");
    }

    // Another overridable method for combat
    void battleCry() {
        System.out.println(name + " shouts a generic battle cry!");
    }
}