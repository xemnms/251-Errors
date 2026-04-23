/*
  uses interface BaymaxChip_Rodenas by Rodenas
  this class was made by Costiniano
  */

public class BaymaxAssist_Costiniano implements BaymaxChip_Rodenas {

    private String mode;

    //constructor
    public BaymaxAssist_Costiniano(String mode) {
        this.mode = mode;
    }

    @Override //override abstract method
    public void assistPatient() {
        System.out.println("Assisting patient in " + mode + " mode.");
    }

    @Override //override default method 
    public void scanVitals() {
        BaymaxChip_Rodenas.super.scanVitals();
        System.out.println("Vitals scanned successfully in " + mode + " mode.");
    }

    @Override
    public void comfortPatient() {
        System.out.println("Comforting patient in " + mode + " mode.");
    }

    @Override
    public void encouragePatient() {
        System.out.println("Stay strong! (" + mode + " mode encouragement)");
    }

    @Override
    public void giveTreat() {
        System.out.println("Have a lollipop! (Mode: " + mode + ")");
    }

    @Override
    public void offerHug() {
        System.out.println("Offering a warm hug in " + mode + " mode >//<");
    }

    //overloaded method 
    public void assistPatient(String patientName) {
        System.out.println("Assisting " + patientName + " in " + mode + " mode.");
    }
}