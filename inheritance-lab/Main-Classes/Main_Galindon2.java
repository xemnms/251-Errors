//main class by galindon
public class Main_Galindon2 {
    public static void main(String[] args) {

        // Dynamic binding example
        MusicEra_Alonde era = new PopEra_Galindon("1989", 2014, 13);

        era.playEra();       // Calls overridden method
        era.displayInfo();  // Calls parent method

        // Access child-specific method
        PopEra_Galindon pop = new PopEra_Galindon("Lover", 2019, 18);
        pop.performConcert();

        System.out.println("Total Eras Created: " + MusicEra_Alonde.getTotalEras());
    }
}