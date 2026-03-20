public class ValorantMapGalindon {
    private String mapName;
    private int numberOfSites;
    private boolean hasTeleporters;

    // Constructor
    public ValorantMapGalindon(String mapName, int numberOfSites, boolean hasTeleporters) {
        this.mapName = mapName;
        setNumberOfSites(numberOfSites); // validation
        this.hasTeleporters = hasTeleporters;
    }

    // Getters
    public String getMapName() {
        return mapName;
    }

    public int getNumberOfSites() {
        return numberOfSites;
    }

    public boolean hasTeleporters() {
        return hasTeleporters;
    }

    // Setters
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void setNumberOfSites(int numberOfSites) {
        if (numberOfSites >= 1 && numberOfSites <= 3) {
            this.numberOfSites = numberOfSites;
        } else {
            System.out.println("Maps should have 1 to 3 sites only.");
        }
    }

    public void setHasTeleporters(boolean hasTeleporters) {
        this.hasTeleporters = hasTeleporters;
    }

    // Behaviors
    public void displayMapInfo() {
        System.out.println("Map: " + mapName);
        System.out.println("Sites: " + numberOfSites);
        System.out.println("Has Teleporters: " + hasTeleporters);
    }

    public void startMatch() {
        System.out.println("Match starting on " + mapName + "...");
    }
}