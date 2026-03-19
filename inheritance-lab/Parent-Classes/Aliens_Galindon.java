//Parent class created by Galindon
//This class represents an alien that has a name, age, and planet of origin
//Other classes can extend this to inherit its attributes and behaviors

class Aliens_Galindon {
    // Attributes 
    String name;
    int age;
    String planetOrigin;

    // Constructor
    Aliens_Galindon(String name, int age, String planetOrigin) {
        this.name = name;
        this.age = age;
        this.planetOrigin = planetOrigin;
    }

    // Behavior 1
    void exist() {
        System.out.println(name + " exists somewhere in the universe.");
    }

    // Behavior 2
    void communicate() {
        System.out.println(name + " is sending signals from " + planetOrigin + ".");
    }

    // Method that can be overridden
    void powers() {
        System.out.println(name + " has a mysterious unknown ability.");
    }
}