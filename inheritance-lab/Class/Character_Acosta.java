/*
* Character Class created by Acosta
* 
*/

public class Character_Acosta {
    //Attributes
    private String name = "John Doe";
    private String characterClass = "Unchosen";
    private int level = 0;

    
    void attack() {
        System.out.println(name+ " the " + characterClass + " attacks with a basic strike!"); //Overridable method, changes based on character class
    } 

    void levelUp() {
        level++;
        System.out.println(name + " has leveled up to level " + level + "!");
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getCharacterClass() {
        return characterClass;
    }
    public int getLevel() {
        return level;
    }

    //Setters
    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    public void setCharacterClass(String characterClass) {
        if (characterClass.isEmpty()) {
            System.out.println("Character class cannot be empty.");
        } else {
            this.characterClass = characterClass;
        }
        }
    
    public void setLevel(int level) {
        if (level < 0) {
            System.out.println("Level cannot be negative.");
        } else {
            this.level = level;
        }
    }
}


