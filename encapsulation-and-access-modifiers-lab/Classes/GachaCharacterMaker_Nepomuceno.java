/*
 * Class created by Julliana Nepomuceno
 * Class represents a gacha character creator in a gacha game, with attributes such as name, rarity, level, health, stamina and checks if player is alive. 
 * It includes constructors for creating characters with default or specified values, getters and setters with validation
 * Has behaviors to display status, take damage, attack, level up and rarity.
 * Additionally, it keeps track of the total number of characters created using a static attribute.
*/
public class GachaCharacterMaker_Nepomuceno {
    // Private attributes
    private String name;
    private int level;
    private int health;
    private int stamina;
    private boolean isAlive;
    private int rarity;
    

    // Static attribute
    private static int totalCharacters = 0;

    // Constructors
    // Default constructor with name only, other attributes set to default values
    public GachaCharacterMaker_Nepomuceno(String name) {
        setName(name); // w/ validation
        this.rarity = 4; // Default rarity
        this.level = 1;
        this.health = 100;
        this.stamina = 50;
        totalCharacters++;
    }

    // Parameterized constructor to set all attributes
    public GachaCharacterMaker_Nepomuceno(String name, int rarity, int level, int health, int stamina) {
        setName(name);
        setRarity(rarity);
        setLevel(level);
        setHealth(health);
        setStamina(stamina);
        totalCharacters++;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }
    
    public int getRarity() {
        return rarity;
    }

    // Setters with validation
    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setLevel(int level) {
        if(level > 0) {
            this.level = level;
        }
    }

    public void setHealth(int health) {
    this.health = Math.max(0, health); // Health cannot be negative
        updateAliveStatus();
    }

    public void setStamina(int stamina) {
        if(stamina >= 0) {
            this.stamina = stamina;
        }
    }

    public void setRarity(int rarity) {
        if(rarity >= 4 && rarity <= 5) {
            this.rarity = rarity;
        } else {
            this.rarity = 4; // Default to 4 if invalid rarity is provided
        }
    }

    // Helper method to enforce invariant
    private void updateAliveStatus() {
        this.isAlive = (health > 0);
    }

    // Behaviors
    public void displayStatus() {
        System.out.println("--- " + name + "'s Status ---");
        System.out.println("Name: " + name);
        System.out.println("Rarity: " + rarity);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
        System.out.println("Stamina: " + stamina);
        System.out.println("Alive: " + isAlive + "\n");
    }

    public void takeDamage(int damage) {
        if(damage > 0 && isAlive) {
            health -= damage;
            System.out.println(name + " takes " + damage + " damage.\n");
            if(health < 0) {
                health = 0;
                System.out.println(name + " has died.\n");
            }
        } else {
            System.out.println(name + " cannot take damage. They are not alive.\n");
        }
        updateAliveStatus();
    }

    public void attack(int staminaCost) {
        if(staminaCost > 0 && staminaCost <= stamina && isAlive) {
            stamina -= staminaCost;
            System.out.println(name + " attacks, costing " + staminaCost + " stamina.\n");
        } else {
            System.out.println(name + " cannot attack. They are not alive or don't have enough stamina.\n");
        }
    }

    public void levelUp() {
        if(isAlive) {
            level++;
            health += 20; // increase health on level up
            stamina += 10;   // increase stamina on level up
            System.out.println(name + " levels up to level " + level + ".\n");
        } else {
            System.out.println(name + " cannot level up because they are not alive.\n");
        }
    }

    // Static behavior
    public static int getTotalCharacters() {
        return totalCharacters;
    }
}