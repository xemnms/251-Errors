 // Subclass created by Bautista
 // This class represents a Magical Sorcerer and Useless Sorcerer.
 // Inherits from Sorcerer_Alvarez and adds new abilities.

public class MagicalSorcerer extends Sorcerer_Alvarez {

    // Additional attribute
    private String signatureMove;

    // Constructor
    public MagicalSorcerer(String jujutsuGrade, String cursedTechnique, double cursedEnergyConsumption, String signatureMove) {
        super(jujutsuGrade, cursedTechnique, cursedEnergyConsumption);
        this.signatureMove = signatureMove;
    }

    // Getter
    public String getSignatureMove() {
        return signatureMove;
    }

    // New behavior
    public void ultimateMove() {
        System.out.println("Unleashing ultimate move... 🖖✌️🤌👐 " + signatureMove + "! 👊🔥");
    }

    // Overriding attack method
    @Override
    public void attack() {
        System.out.println("Sorcerer attacks with crazy cursed energy! 💥 ... ✨ 85% damage!");
    }
}

// UselessSorcerer Subclass ( 2nd Subclass )
class UselessSorcerer extends Sorcerer_Alvarez {

    private String uselessMove;

    // Constructor
    public UselessSorcerer(String jujutsuGrade, String cursedTechnique, double cursedEnergyConsumption, String uselessMove) {
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