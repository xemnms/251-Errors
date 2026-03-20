/**
 * Composed Class: ValorantLoadout_Dizon
 * Represents a player's current equipment.
 * HAS-A Weapon (Nepomuceno) and HAS-A Payment/Credits (Arandela)
 */
public class ValorantLoadout_Dizon {
    private String playerName;
    private Weapon_Nepomuceno primaryWeapon;
    private Payment_Arandela economy;

    public ValorantLoadout_Dizon(String playerName, Weapon_Nepomuceno weapon, Payment_Arandela economy) {
        this.playerName = playerName;
        this.primaryWeapon = weapon;
        this.economy = economy;
    }

    // GETTERS 
    public String getPlayerName() { return playerName; }
    public Weapon_Nepomuceno getPrimaryWeapon() { return primaryWeapon; }
    public Payment_Arandela getEconomy() { return economy; }

    // SETTERS 
    public void setPlayerName(String playerName) {
        if (playerName != null && !playerName.trim().isEmpty()) {
            this.playerName = playerName;
        }
    }

    // Low Coupling
    public void setPrimaryWeapon(Weapon_Nepomuceno newWeapon) {
        if (newWeapon != null) {
            System.out.println("[SYSTEM] " + playerName + " picked up a " + newWeapon.getWeaponName());
            this.primaryWeapon = newWeapon;
        }
    }

    public void setEconomy(Payment_Arandela economy) {
        this.economy = economy;
    }

    
    public void buyPhase() {
        System.out.println("--- BUY PHASE: " + playerName + " ---");
        if (economy.getAmount() >= 2900) { // Price of a Phantom/Vandal
            economy.processPayment();
            System.out.println("Purchased " + primaryWeapon.getWeaponName() + " successfully.");
        } else {
            System.out.println("Insufficient Credits! Save this round.");
        }
    }

    public void combat() {
        System.out.println("Engaging enemy...");
        primaryWeapon.fire();
    }
}