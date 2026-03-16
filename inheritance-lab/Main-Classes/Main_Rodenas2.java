/*
 * Main class by Kyla Cassandra Rodenas
 * Parent class created by Batangan
 * Demonstrates inheritance, method overriding, and dynamic binding
 */

public class Main_Rodenas2 {
public static void main(String[] args) {
    System.out.println("======================================");
    System.out.println("        🐱 ADOPTABLE KITTEN 🐱        ");
    System.out.println("             Meet Mingming!           ");
    System.out.println("======================================\n");
        
    //Dynamic binding
    Animal_Batangan pet = new Kitten_Rodenas();
    pet.name = "Mingming";
    pet.color = "Calico 🟤⚪";
    pet.age = 1;

    System.out.println("💌 Mingming's Adoption Profile");
    System.out.println("---------------------------");
    System.out.println("Name  : " + pet.name);
    System.out.println("Color : " + pet.color);
    System.out.println("Age   : " + pet.age + " year old");
    System.out.println();

    //Overridden method
    System.out.println("🔊 What does Mingming say?");
    pet.makeSound();
    System.out.println();

    //Calling methods from parent class
    pet.petEat();
    System.out.println();

    //Calling methods from child class
    Kitten_Rodenas playfulKitten = (Kitten_Rodenas) pet;
    System.out.println("🎀 Mingming's Special Talents:");
    playfulKitten.chaseTail();
    playfulKitten.napAnywhere();
    playfulKitten.knockOverObjects();
    System.out.println();
    System.out.println("--------------------------------------");
    System.out.println("💖 Mingming is looking for a loving home!");
    System.out.println("🏠 Will you adopt this chaotic little angel?");
    System.out.println("--------------------------------------");
    }
}