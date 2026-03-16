

public class Sorcerer_Alvarez {
    private static final String Class_ID = "Sorcerer Class Created by Alvarez";

    // Attributes
    private String jujustuGrade;
    private String cursedTechnique;
    private double cursedEnergyConsumption;

    // Constructor
    public Sorcerer(String jujustuGrade, String cursedTechnique, double cursedEnergyConsumption) {
        this.jujustuGrade = jujustuGrade;
        this.cursedTechnique = cursedTechnique;
        this.cursedEnergyConsumption = cursedEnergyConsumption;
    }

    // Behavior 1
    public void useTechnique() {
        System.out.println("Using Cursed Technique: " + cursedTechnique);
        System.out.println("Energy consumed: " + cursedEnergyConsumption);
    }

    // Behavior 2
    public void displayInfo() {
        System.out.println(Class_ID);
        System.out.println("Grade: " + jujustuGrade);
        System.out.println("Technique: " + cursedTechnique);
    }

    // method that can be overidden later
    public void attack() {
        System.out.printl("The Sorcerer attacks using Cursed Energy!");
    }

    // Getters
    public String getJujustuGrade() {
        return jujutsuGrade;
    }

    public String getCursedTechnique() {
        return cursedTechnique;
    }

    public double getCursedEnergyConsumption() {
        return cursedEnergyConsumption;
    }
}