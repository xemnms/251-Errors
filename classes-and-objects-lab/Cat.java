/*
* This class represents a Cat with a name, age, fur pattern, and eye color.
* Created by Jan Lorcey Acosta
*/

public class Cat {
    // Attributes
    String name;
    int age;
    String furPattern;
    String eyeColor;
    boolean isEating;

    // Static attribute
    static int totalCats = 0;

    // Default constructor
    Cat(){
        name = "Unknown";
        age = 0;
        furPattern = "Undeclared";
        totalCats++;
    }

    //Parameterized Constructor
    Cat(String name, int age, String furPattern, String eyeColor){
        this.name = name;
        this.age = age;
        this.furPattern = furPattern;
        this.eyeColor = eyeColor;
        totalCats++;
    }

    //Overloaded Constructor
    Cat (String name, int age) {
        this.name = name;
        this.age = age;
        this.furPattern = "Tabby";
        this.eyeColor = "Green";
        totalCats++;
    }

    //Behaviours with no Parameters
    void meow(){
        System.out.println("" + name + " says: Meow!");
    }
    void introduce(){
        System.out.println("Hi, I am " + name + ".");
        System.out.println("I am " + age + " years old.");
        System.out.println("My fur pattern is " + furPattern + " and my eye color is " + eyeColor + ".");
    }

    //Behaviour with Parameters
    void feedCat(boolean isFed){
        if (isFed) {
            isEating = true;
            System.out.println("" + name + " is now eating.");
        } else {
            isEating = false;
            System.out.println("" + name + " is not eating.");
        }
    }

    //Static Method
    static void displayTotalCats(){
        System.out.println("Total Cats Created: "+totalCats);
    }


}
