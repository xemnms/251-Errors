/*
 * Main class by Rodenas
 * Parent class created by Batangan
 * Demonstrates inheritance, method overriding, and dynamic binding
 */

public class Main_Rodenas2 {
public static void main(String[] args) {
    System.out.println("======================================");
    System.out.println("        🐱 ADOPTABLE KITTEN 🐱        ");
    System.out.println("            Meet Mingming!                ");
    System.out.println("======================================\n");

    //Dynamic binding
    Animal_Batangan pet = new Kitten_Rodenas();

    //Animal Information
    pet.name = "Mingming";
    pet.color = "Calico 🟤⚪";
    pet.age = 1;
    pet.weight = 2.5;
    pet.breed = "Persian 🐾";

    System.out.println("💌 Mingming's Adoption Profile");
    System.out.println("---------------------------");
    System.out.println("Name   : " + pet.name);
    System.out.println("Color  : " + pet.color);
    System.out.println("Age    : " + pet.age + " year old");
    System.out.println("Weight : " + pet.weight + " kg");
    System.out.println("Breed  : " + pet.breed);
    System.out.println();

    //Overridden method
    System.out.println("🔊 What does Mingming say?");
    pet.makeSound();
    System.out.println();

    //Inherited behaviors
    System.out.println("🐾 Mingming's Daily Routine:");
    pet.petEat();
    pet.petJump();
    pet.sleep();
    pet.play();
    System.out.println();

    //Child class behaviors
    Kitten_Rodenas playfulKitten = (Kitten_Rodenas) pet;

    System.out.println("🎀 Mingming's Special Talents:");
    playfulKitten.chaseTail();
    playfulKitten.napAnywhere();
    playfulKitten.knockOverObjects();
    playfulKitten.playWithYarn();

    System.out.println("\n--------------------------------------");
    System.out.println("💖 Mingming is looking for a loving home!");
    System.out.println("🏠 Will you adopt this chaotic angel?");
    System.out.println("--------------------------------------");
    }
}