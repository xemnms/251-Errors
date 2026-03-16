// 2nd Subclass created by Bautista
// This class represents a Magical Sorcerer and Useless Sorcerer.
// Inherits from Sorcerer_Alvarez and adds new abilities.

// UselessSorcerer Subclass ( 2nd Subclass )
class UselessSorcerer_Bautista extends Sorcerer_Alvarez {

    private String uselessMove;

    // Constructor
    public UselessSorcerer_Bautista(String jujutsuGrade, String cursedTechnique, double cursedEnergyConsumption, String uselessMove) {
        super(jujutsuGrade, cursedTechnique, cursedEnergyConsumption);
        this.uselessMove = uselessMove;
    }

    public String getUselessMove() {
        return uselessMove;
    }

    // New behavior
    public void doNothing() {
        System.out.println("Sorcerer tries to do something... only tickles the enemy. 😅");
    }

    // Overriding attack
    @Override
    public void attack() {
        System.out.println("Confetti Attack!! 🎉💥✨ ... 💨 0% damage! ");
    }
}