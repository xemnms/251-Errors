public class TournamentMap_Alonde extends ValorantMapGalindon {
    private String tournamentName;
    private boolean isBanned;

    public TournamentMap_Alonde(String mapName, int numberOfSites, boolean hasTeleporters, String tournamentName) {
        super(mapName, numberOfSites, hasTeleporters);
        this.tournamentName = tournamentName;
        this.isBanned = false;
    }

    public void setMapBanStatus(boolean status) {
        this.isBanned = status;
        String statusText = status ? "BANNED" : "AVAILABLE";
        System.out.println("[Tournament Update] Map " + getMapName() + " is now " + statusText);
    }

    @Override
    public void startMatch() {
        if (!isBanned) {
            System.out.println("--- WELCOME TO " + tournamentName.toUpperCase() + " ---");
            super.startMatch(); // Calls the original startMatch logic
        } else {
            System.out.println("Error: Cannot start match. " + getMapName() + " is currently banned.");
        }
    }

    public String getTournamentName() { return tournamentName; }
    public void setTournamentName(String tournamentName) { this.tournamentName = tournamentName; }
}