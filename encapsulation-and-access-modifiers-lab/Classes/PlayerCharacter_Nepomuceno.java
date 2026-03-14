/*
 * Class created by Julliana Nepomuceno
 * Class represents a player character in a game, with attributes such as name, level, health, mana and checks if player is alive. 
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
    private boolean isAlive;

    // Static attribute
    private static int totalPlayers = 0;

    // Constructors
    // Default constructor with name only, other attributes set to default values
    public PlayerCharacter_Nepomuceno(String name) {
        setName(name); // w/ validation
        this.level = 1;
        this.health = 100;
        this.mana = 50;
        totalPlayers++;
    }

    // Parameterized constructor to set all attributes
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

    public boolean isAlive() {
        return isAlive;
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
    this.health = Math.max(0, health); // Health cannot be negative
        updateAliveStatus();
    }

    public void setMana(int mana) {
        if(mana >= 0) {
            this.mana = mana;
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
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana);
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

    public void castSpell(int manaCost) {
        if(manaCost > 0 && manaCost <= mana && isAlive) {
            mana -= manaCost;
            System.out.println(name + " casts a spell, costing " + manaCost + " mana.\n");
        } else {
            System.out.println(name + " cannot cast the spell. They are not alive or don't have enough mana.\n");
        }
    }

    public void levelUp() {
        if(isAlive) {
            level++;
            health += 20; // increase health on level up
            mana += 10;   // increase mana on level up
            System.out.println(name + " levels up to level " + level + ".\n");
        } else {
            System.out.println(name + " cannot level up because they are not alive.\n");
        }
    }

    // Static behavior
    public static int getTotalPlayers() {
        return totalPlayers;
    }
}
