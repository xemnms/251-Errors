//parent class by alonde, child class by galindon
//first class, popopoppop era by nayeon eme

public class PopEra_Galindon extends MusicEra_Alonde {

    // Constructor
    public PopEra_Galindon(String name, int year, int tracks) {
        super(name, year, tracks);
    }

    // Overridden method
    @Override
    public void accountType() {
        System.out.println("This is a Pop Era.");
    }

    // New behavior unique to PopEra
    public void performConcert() {
        System.out.println("Performing a pop concert for the " + getEraName() + " era!");
    }
}