/* 
* This is a component class demonstrating composition in Java.
* IS-A: Weapon is a type of object that can be used in a game. with specific attributes and behaviors related to firearms.
* HAS-A: Weapon has attributes like name, type, rarity, damage, and ammo count.
* Author: Julliana Nepomuceno
*/
public class Weapon_Nepomuceno {
    // Attributes
    private String weaponName;
    private String weaponType; // Pistol, Rifle, Sniper, Shotgun
    private int ammo; // Current ammo count
    private int maxAmmo; // Maximum ammo capacity
    private int damage;

    // Constructor
    public Weapon_Nepomuceno(String weaponName, String weaponType, int damage, int maxAmmo) {
        this.weaponName = weaponName;
        this.weaponType = weaponType;
        this.damage = damage;
        this.maxAmmo = maxAmmo;
        this.ammo = maxAmmo;
    }

    // Encapsulation (Getters & Setters)
    public String getWeaponName() { return weaponName; }

    public String getWeaponType() { return weaponType; }

    public int getAmmo() { return ammo; }

    public int getDamage() { return damage; }


    // Setter with validation
    public void setAmmo(int amount) {
        if (amount >= 0 && amount <= maxAmmo) {
            this.ammo = amount;
        } else if (amount > maxAmmo) {
            this.ammo = maxAmmo;
            System.out.println("[System] Magazine full! Ammo capped at " + maxAmmo);
        } else {
            System.out.println("[System Error] Ammo cannot be negative.");
            this.ammo = 0;
        }
    }

    // Behavior 1: Fire weapon
    public void fire() {
        if (ammo > 0) {
            ammo--;
            System.out.println("🔫 " + weaponName + " fires! [" + ammo + "/" + maxAmmo + " ammo remaining]");
        } else {
            System.out.println("⚠️ Out of ammo! Reload " + weaponName);
        }
    }

    // Behavior 2: Reload
    public void reload() {
        System.out.println("🔄 Reloading " + weaponName + "...");
        this.ammo = maxAmmo;
        System.out.println("✅ " + weaponName + " reloaded! [" + ammo + "/" + maxAmmo + "]");
    }
}