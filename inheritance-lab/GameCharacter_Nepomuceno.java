public class GameCharacter_Nepomuceno {
    private static final String CLASS_ID = "Machine Class Created by Nepomuceno";
    // Attributes
    private String name;
    private int health;
    private boolean isAlive;
    private int level;
    
    // Constructor with default values
    public GameCharacter_Nepomuceno() {
        name = "Default Character";
        health = 100;
        level = 1;
        isAlive = true;
    }

    // Constructor with parameters
    public GameCharacter(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.isAlive = true;
    }
    
    // Methods or Behaviors
    public void takeDamage() {
        System.out.println(name + " takes damage! Health: " + health);
        health -= 10;
        if (health <= 0) {
            isAlive = false;
            System.out.println(name + " has been defeated!");
        }
    }
    
    public void attack() {
        if (isAlive) {
            System.out.println(name + " attacks the enemy!");
        } else {
            System.out.println(name + " cannot attack because they are NOT alive.");
        }
    }
    
    public void levelUp() {
        if (isAlive) {
            level++;
            System.out.println(name + " leveled up! Current level: " + level);
        } else {
            System.out.println(name + " cannot level up because they are NOT alive.");
        }
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getLevel() {
        return level;
    }
}