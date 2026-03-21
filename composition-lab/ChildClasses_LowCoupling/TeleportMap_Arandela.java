public class TeleportMap_Arandela extends ValorantMapGalindon {

    private int teleporterCount;

    // Constructor
    public TeleportMap_Arandela(String mapName, int numberOfSites, boolean hasTeleporters, int teleporterCount) {
        super(mapName, numberOfSites, hasTeleporters);
        this.teleporterCount = teleporterCount;
    }

    // Getter
    public int getTeleporterCount() {
        return teleporterCount;
    }

    // Override method
    @Override
    public void displayMapInfo() {
        super.displayMapInfo();
        System.out.println("Teleporter Count: " + teleporterCount);
    }

    // New behavior
    public void useTeleporter() {
        System.out.println("🌀 Player used a teleporter!");
    }
}