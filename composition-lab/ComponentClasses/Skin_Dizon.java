public class Skin_Dizon {
    private String skinName;
    private String rarity; // Select, Deluxe, Premium, Exclusive, Ultra
    private int upgradeLevel; // 1 to 4 (VFX, Animation, Finisher)
    private boolean isEquipped;

    // Constructor
    public Skin_Dizon(String skinName, String rarity, int upgradeLevel) {
        this.skinName = skinName;
        this.rarity = rarity;
        setUpgradeLevel(upgradeLevel);
        this.isEquipped = false;
    }

    // Encapsulation 
    public String getSkinName() { return skinName; }

    public String getRarity() { return rarity; }

    public int getUpgradeLevel() { return upgradeLevel; }

    // Validation logic in setter
    public void setUpgradeLevel(int level) {
        if (level >= 1 && level <= 4) {
            this.upgradeLevel = level;
        } else {
            System.out.println("[System Error] Upgrade level must be between 1 and 4.");
            this.upgradeLevel = 1; 
        }
    }

    // Examine Skin
    public void examine() {
        System.out.println("Inspecting " + skinName + " [" + rarity + "] - Level: " + upgradeLevel);
        if (upgradeLevel == 4) {
            System.out.println("✨ Finisher Animation is UNLOCKED!");
        }
    }

    // Play Sound Effect
    public void playSFX() {
        if (skinName.equalsIgnoreCase("Prime")) {
            System.out.println("🎵 Pew-Pew! Laser sounds active.");
        } else if (skinName.equalsIgnoreCase("Reaver")) {
            System.out.println("🎸 Dark bell tolls active.");
        } else {
            System.out.println("💥 Standard ballistic sounds.");
        }
    }
}