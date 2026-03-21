public class Player_Arandela {
    // HAS-A relationships (composition)
    private String playerName;
    private Weapon_Nepomuceno weapon;
    private Skin_Dizon skin;

    // Constructor Injection
    public Player_Arandela(String playerName, Weapon_Nepomuceno weapon, Skin_Dizon skin) {
        this.playerName = playerName;
        this.weapon = weapon;
        this.skin = skin;
    }

    // Behavior: Attack using weapon + skin effects
    public void attack() {
        System.out.println("👤 " + playerName + " attacks!");
        weapon.fire();
        skin.playSFX();
    }

    // Behavior: Inspect loadout
    public void inspectLoadout() {
        System.out.println("\n=== LOADOUT ===");
        System.out.println("Player: " + playerName);
        System.out.println("Weapon: " + weapon.getWeaponName());
        skin.examine();
    }

    // Setter (for low coupling demonstration)
    public void setWeapon(Weapon_Nepomuceno weapon) {
        this.weapon = weapon;
    }
}