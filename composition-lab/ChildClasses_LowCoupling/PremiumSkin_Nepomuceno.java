/**
 * PremiumSkin_Nepomuceno - A subclass of Skin_Dizon
 * 
 * IS-A Relationship: PremiumSkin IS-A Skin_Dizon
 * 
 * This demonstrates inheritance where PremiumSkin extends the functionality
 * of the base Skin_Dizon class with premium-exclusive features.
 */
public class PremiumSkin_Nepomuceno extends Skin_Dizon {
    
    // Additional attributes for premium skins
    private boolean hasGlowEffect;
    private boolean hasParticleEffect;
    private double premiumPrice;
    
    // Constructor
    public PremiumSkin_Nepomuceno(String skinName, String rarity, int upgradeLevel, double premiumPrice) {
        super(skinName, rarity, upgradeLevel);  // Call parent constructor
        this.premiumPrice = premiumPrice;
        this.hasGlowEffect = true;
        this.hasParticleEffect = upgradeLevel >= 3;
    }
    
    // Additional getter
    public double getPremiumPrice() {
        return premiumPrice;
    }
    
    // Override parent method: examine()
    @Override
    public void examine() {
        super.examine();
        System.out.println("[PREMIUM] Price: $" + premiumPrice);
        System.out.println("[PREMIUM] Glow Effect: " + (hasGlowEffect ? "ON" : "OFF"));
        System.out.println("[PREMIUM] Particle Effect: " + (hasParticleEffect ? "ON" : "OFF"));
    }
    
    // Override parent method: playSFX()
    @Override
    public void playSFX() {
        super.playSFX();
        System.out.println("[PREMIUM] Exclusive premium sound effect playing!");
    }
    
    // New behavior specific to premium skins
    public void activatePremiumMode() {
        System.out.println("PREMIUM MODE ACTIVATED!");
        System.out.println("Glow effect: ON");
        System.out.println("Particle effect: ON");
        System.out.println("Premium sounds: ON");
        playSFX();
    }
    
    // New behavior specific to premium skins
    public void displayPremiumFeatures() {
        System.out.println("\nPREMIUM FEATURES:");
        System.out.println("   Glow Effect: " + (hasGlowEffect ? "YES" : "NO"));
        System.out.println("   Particle Effect: " + (hasParticleEffect ? "YES" : "NO"));
        System.out.println("   Price: $" + premiumPrice);
        System.out.println("   Exclusive Audio: YES");
    }
}