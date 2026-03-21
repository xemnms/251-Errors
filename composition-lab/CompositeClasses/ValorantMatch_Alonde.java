//demonstrates HAS-A relationships using ValorantMapGalindon and Weapon_Nepomuceno

public class ValorantMatch_Alonde {
    private String matchId;
    private String gameMode;
    private ValorantMapGalindon map;      
    private Weapon_Nepomuceno activeWeapon; 

    public ValorantMatch_Alonde(String matchId, String gameMode, ValorantMapGalindon map, Weapon_Nepomuceno weapon) {
        this.matchId = matchId;
        this.gameMode = gameMode;
        this.map = map;
        this.activeWeapon = weapon;
    }

    public void startRound() {
        System.out.println("--- Match ID: " + matchId + " [" + gameMode + "] ---");
        map.startMatch(); 
        map.displayMapInfo();
        
        System.out.println("\n[Round Start] Player spawned with: " + activeWeapon.getWeaponName());
        activeWeapon.fire();
    }

    public void reloadPhase() {
        System.out.println("\n[System] Safe zone reached.");
        activeWeapon.reload();
    }
}