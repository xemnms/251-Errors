/*
* Child Class created by Kyla Cassandra Rodenas
* This class extends Animal_Batangan.
* A playful, mischievous kitten with personality.
*/

public class Kitten_Rodenas extends Animal_Batangan {

    //New behavior
    public void chaseTail() {
        System.out.println(name + " is chasing its own tail! Spins around wildly! 🌀");
    }

    public void knockOverObjects() {
        System.out.println(name + " just knocked over your favorite mug! 😼");
    }

    public void napAnywhere() {
        System.out.println(name + " has claimed your keyboard as a nap spot. Zzz... 💤");
    }

    //Overridden method with playful twist
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow meow! (and maybe a tiny hiss if ignored!)");
    }
}
