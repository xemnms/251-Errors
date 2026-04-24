public class AbstractionPolyDemo_Badosa {
    public static void main(String[] args) {
        // Create an instance of valid driver
        Driver_Badosa goodDriver = new Driver_Badosa(true, true, true);
        // Create an instance of invalid driver
        Driver_Badosa badDriver = new Driver_Badosa(false, false, false);
        goodDriver.drive();
        badDriver.drive();
        System.out.println("-----------------------------");

        // Create an instance of a summoner
        Summoner_Badosa fireSummoner = new Summoner_Badosa("Geo Elemental");
        fireSummoner.chant(); // using the default method from the interface
        fireSummoner.performAction(); // using the implemented method
        fireSummoner.dismissSummon(); // using the class-specific method

    }
}

/*
 * 1) Abstract class used: Isles_Drive (Isles)
 * 2) Interface used: Summonable_Costiniano (Costiniano)
 * 3) Overridden methods: drive() in Driver_Badosa, performAction() in
 * Summoner_Badosa
 * 4) Overloaded methods: checkUserAge(), checkUserLicense(), checkWhereUserIs()
 * in Isles_Drive
 * 5) Dynamic binding: at runtime, the drive() method called on Driver_Badosa
 * instances executes the overridden version in the subclass, demonstrating
 * polymorphism
 * 6) Polymorphism: abstract class reference (Isles_Drive) and interface
 * reference
 * (Summonable_Costiniano) point to concrete objects
 * 7) Low coupling: Driver_Badosa and Summoner_Badosa are independent of each
 * other, and they interact with their respective abstract class and interface
 * without relying on each other
 * 8) High cohesion: each class has focused responsibility (summoning and
 * driving actions)
 */
