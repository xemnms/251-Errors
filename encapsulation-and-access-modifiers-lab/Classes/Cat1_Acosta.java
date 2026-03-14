/* 
* Cat class with encapsulation and validation for attributes (name, breed, age) and a static attribute to track total cats created.
* Class Created by Jan Lorcey Acosta
*/

public class Cat1_Acosta {
    // Attributes
    private int id;
    private String name;
    private String breed;
    private int age;

    // Static attribute
    private static int totalCats = 0;

    // Default constructor
    public Cat1_Acosta() {
        this.id = ++totalCats;
        this.name = "Unknown";
        this.breed = "Unknown";
        this.age = 0;
    }

    // Parameterized constructor
    public Cat1_Acosta(String name, String breed, int age) {
        this.id = ++totalCats;
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    public void setBreed(String breed) {
        if (breed.isEmpty()) {
            System.out.println("Breed cannot be empty.");
        } else {
            this.breed = breed;
        }
    }

    public void setAge(int age) {
        if (age < 0 || age > 35) {
            System.out.println("Age cannot be negative or older than 35.");
        } else {
            this.age = age;
        }
    }

    // Behaviours (methods)
    public void introduceCat() {
        System.out.println("Hi! My name is " + name + " the " + breed + " cat, and I am " + age + " years old.");
    }

    public void meow() {
        System.out.println(name + " says: Meow!");
    }

    // Static behaviour(method)
    public static int getTotalCats() {
        return totalCats;
    }

}