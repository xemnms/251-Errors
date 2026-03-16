 // Subclass created by Bautista
 // This class represents a Magical Sorcerer and Useless Sorcerer.
 // Inherits from Sorcerer_Alvarez and adds new abilities.

public class MagicalSorcerer_Bautista extends Sorcerer_Alvarez {

    // Additional attribute
    private String signatureMove;

    // Constructor
    public MagicalSorcerer_Bautista(String jujutsuGrade, String cursedTechnique, double cursedEnergyConsumption, String signatureMove) {
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
