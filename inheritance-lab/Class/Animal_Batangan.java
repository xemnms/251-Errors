/*
* Parent Class created by Batangan
* This class represents an animal that can make a sound and can move
* Other classes can extend this to inherit its attributes and behaviors.
*/

public class Animal_Batangan {

    // Attributes
        String name;
        String color;
        int age;
    
    // Behaviors
    public void makeSound() {
            System.out.println("The pet makes a cute sound.");
        }
    
    public void eat() {
            System.out.println(name + " is eating.");
        }
    
    }
