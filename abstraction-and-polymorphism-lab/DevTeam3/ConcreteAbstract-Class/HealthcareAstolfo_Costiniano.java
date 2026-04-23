/*
 uses abstract class Baymax_Rodenas by Rodenas
 this class was made by Sean Costiniano
 */

public class HealthcareAstolfo_Costiniano extends Baymax_Rodenas {

    public HealthcareAstolfo_Costiniano(String modeName) {
        super(modeName);
    }

    @Override
    public void provideCare() {
        System.out.println("Astolfo provides healthcare with precision and kindness!");
    }

    public void provideCare(String patientName) {
        System.out.println("Astolfo provides care for " + patientName + " with extra attention!");
    }

    @Override
    public void offerHug() {
        System.out.println("Astolfo offers a warm and comforting hug! >//<");
    }

    public void comfortPatient() {
        System.out.println("Astolfo comforts the patient gently.");
    }
}