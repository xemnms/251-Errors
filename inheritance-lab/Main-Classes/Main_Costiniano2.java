/*main created by Costiniano
*the IS-A relationship in my program is the Mage. It is a type of Character_Acosta.
*the overridden method is the attack() method, which allows me to change how the Mage attacks compared to the default character.
*during dynamic binding, the Mage is created from the parent class reference type Character_Acosta, but the actual object type is Mage_Costiniano. It uses the overridden attack() method from the Mage class.
*the subclass Mage_Costiniano adds new behavior with the castSpell() method, which allows the character to use mana to perform a special attack.
*/

public class Main_Costiniano2 {
    public static void main(String[] args) {

        //create Mage object
        Character_Acosta mageCharacter = new Mage_Costiniano("Eudora", 5, 100); //Dynamic Binding: reference type is Character_Acosta, but actual object type is Mage_Costiniano
        Mage_Costiniano mage = new Mage_Costiniano("Lunox", 3, 80); //Used for new behavior call

        //overridden method call
        mageCharacter.attack(); //calls overridden method in Mage
        mageCharacter.levelUp(); //inherited method

        //new behavior call
        mage.castSpell();
    }
}