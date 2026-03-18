//Child class created by Costiniano extending Parent class Character_Acosta

public class Mage_Costiniano extends Character_Acosta {

    private int mana;

    //constructor
    public Mage_Costiniano(String name, int level, int mana) {
        setName(name);
        setCharacterClass("Mage");
        setLevel(level);
        this.mana = mana;
    }

    //new behavior
    public void castSpell() {
        System.out.println(getName() + " casts a powerful spell using " + mana + " mana!");
    }

    //override parent method
    @Override
    void attack() {
        System.out.println(getName() + " the Mage attacks with a fireball!");
    }
}


