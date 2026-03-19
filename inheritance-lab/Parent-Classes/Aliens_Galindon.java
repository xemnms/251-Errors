public class Aliens_Galindon {
    // Attributes
    String name;
    String homePlanet;
    String species;
    int numberOfAntennae;

    // Constructor
    public Aliens_Galindon(String name, String homePlanet, String species, int numberOfAntennae) {
        this.name = name;
        this.homePlanet = homePlanet;
        this.species = species;
        this.numberOfAntennae = numberOfAntennae;
    }

    // Behavior 1
    public void communicate() {
        System.out.println(name + " emits a series of alien clicks and lights.");
    }

    // Behavior 2
    public void travel() {
        System.out.println(name + " is traveling through hyperspace from " + homePlanet + ".");
    }

    // Behavior 3 (can be overridden)
    public void scanEnvironment() {
        System.out.println(name + " scans the environment and reports: all systems normal.");
    }

    // Additional method
    public void displayInfo() {
        System.out.println("Alien Info: " + name + " (" + species + ") from " + homePlanet + " with " + numberOfAntennae + " antennae.");
    }
}
