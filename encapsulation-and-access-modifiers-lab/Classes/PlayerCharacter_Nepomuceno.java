/*
 * Class created by Julliana Nepomuceno
 * Class represents a player character in a game, with attributes such as name, level, health, and mana. 
 * It includes constructors for creating characters with default or specified values, getters and setters with validation
 * Has behaviors to display status, take damage, cast spells, and level up.
 * Additionally, it keeps track of the total number of player characters created using a static attribute.
*/

public class PlayerCharacter_Nepomuceno {
    // Private attributes
    private String name;
    private int level;
    private int health;
    private int mana;

    // Static attribute
    private static int totalPlayers = 0;

    // Constructors
    public PlayerCharacter_Nepomuceno(String name) {
        setName(name); // validation
        this.level = 1;
        this.health = 100;
        this.mana = 50;
        totalPlayers++;
    }

    public PlayerCharacter_Nepomuceno(String name, int level, int health, int mana) {
        setName(name);
        setLevel(level);
        setHealth(health);
        setMana(mana);
        totalPlayers++;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
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
        if(health >= 0) { // invariant: health cannot be negative
            this.health = health;
        }
    }

    public void setMana(int mana) {
        if(mana >= 0) { // invariant: mana cannot be negative
            this.mana = mana;
        }
    }

    // Behaviors
    public void displayStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana);
    }

    public void takeDamage(int damage) {
        if(damage > 0) {
            health -= damage;
            if(health < 0) {
                health = 0; // enforce invariant
            }
        }
    }

    public void castSpell(int manaCost) {
        if(manaCost > 0 && manaCost <= mana) {
            mana -= manaCost;
        }
    }

    public void levelUp() {
        level++;
        health = 100; // restore health on level up
        mana = 50;    // restore mana on level up
    }

    // Static behavior
    public static int getTotalPlayers() {
        return totalPlayers;
    }
}
