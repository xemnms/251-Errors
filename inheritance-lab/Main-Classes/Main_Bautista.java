// Main class created by Bautista

public class Main_Bautista {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       ⚡ MAGICAL SORCERER GUIDE ⚡      ");
        System.out.println("==========================================\n");

        // Create first sorcerer
        MagicalSorcerer sorcerer1 = new MagicalSorcerer("Grade 1", "Shadow Slash", 50.0, "Meteor Strike");

        System.out.println("------------ SORCERER 1 ------------");
        System.out.println("Grade           : " + sorcerer1.getJujutsuGrade());
        System.out.println("Technique       : " + sorcerer1.getCursedTechnique());
        System.out.println("Energy Consumed : " + sorcerer1.getCursedEnergyConsumption());
        // sorcerer1.displayInfo();
        // sorcerer1.useTechnique();
        sorcerer1.attack();
        System.out.println("Signature Move  : " + sorcerer1.getSignatureMove());
        sorcerer1.ultimateMove();
        System.out.println("------------------------------------\n");

        // Create second sorcerer
        MagicalSorcerer sorcerer2 = new MagicalSorcerer("Grade 2", "Cursed Fireball", 75.0, "Dragon Burst");

        System.out.println("------------ SORCERER 2 ------------");
        System.out.println("Grade           : " + sorcerer2.getJujutsuGrade());
        System.out.println("Technique       : " + sorcerer2.getCursedTechnique());
        System.out.println("Energy Consumed : " + sorcerer2.getCursedEnergyConsumption());
        // sorcerer2.displayInfo();
        // sorcerer2.useTechnique();
        sorcerer2.attack();
        System.out.println("Signature Move  : " + sorcerer2.getSignatureMove());
        sorcerer2.ultimateMove();
        System.out.println("------------------------------------\n");

        // Create the 2nd subclass sorcerer
        UselessSorcerer useless = new UselessSorcerer("Grade 0", "Confetti Throw", 0.0, "Epic Fail");

        System.out.println("---------- USELESS SORCERER ----------");
        System.out.println("Grade           : " + useless.getJujutsuGrade());
        System.out.println("Technique       : " + useless.getCursedTechnique());
        System.out.println("Energy Consumed : " + useless.getCursedEnergyConsumption());
        // useless.displayInfo();
        // useless.useTechnique();
        useless.attack();
        useless.doNothing();
        System.out.println("Useless Move    : " + useless.getUselessMove());
        System.out.println("------------------------------------\n");
    }
}