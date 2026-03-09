public class Seller {

    //Attributes
    String name;
    int age;
    String course;

    //Static Attribute
    static int totalSellers = 0;

    //Default Constructors
    Student() {
        name = "unknown";
        age = "0";
        course = "undeclared"
        totalSellers++;
    }

    //Parametized Constructor
    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
        totalSellers++;
    }

    //Overloadeed Constructor
    Student(String name, String course) {
        this.name = name;
        this.course = course;
        this.age = 18; //default average age
        totalSellers++;
    }

    //Behavior without parameters
    void introduce() {
        System.out.println("Hi, I am " + name + ".")
        System.out.println("I am " + age + "years old.")
        System.out.println("My course is " + course + ".")
    }

    //Behavior with parameters
    void updateCourse(String newCourse) {
        course = newCourse;
        System.out.println(name + " has updated their course to " + course + ".");
    }

    //Static method
    static void displayTotalSellers() {
        System.out.println("Total Sellers Created: " + totalSellers);
    }
}
