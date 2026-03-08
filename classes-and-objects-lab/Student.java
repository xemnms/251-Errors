/*
* This class represents a student with a name, age, and GPA.
* Created by Ramon Capunpon
*/

public class Student {

    // Attributes
    String name;
    int age;
    String course;

    // Static attribute
    static int totalStudents = 0;

    // Default constructor
    Student() {
        name = "Unknown";
        age = 0;
        course = "Undeclared";
        totalStudents++;
    }

    // Parameterized constructor
    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
        totalStudents++;
    }

    // Overloaded constructor
    Student(String name, String course) {
        this.name = name;
        this.course = course;
        this.age = 18; // default age
        totalStudents++;
    }

    // Behavior without parameters
    void introduce() {
        System.out.println("Hi, I am " + name + ".");
        System.out.println("I am " + age + " years old.");
        System.out.println("My course is " + course + ".");
    }

    // Behavior with parameters
    void updateCourse(String newCourse) {
        course = newCourse;
        System.out.println(name + " has updated their course to " + course + ".");
    }

    // Static method
    static void displayTotalStudents() {
        System.out.println("Total Students Created: " + totalStudents);
    }
}