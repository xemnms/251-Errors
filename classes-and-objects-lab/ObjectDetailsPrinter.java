public class ObjectDetailsPrinter {
    public static void main(String[] args) {
        // Ramon's Object
        // This is the object instance created from the Student class
        Student s = new Student("Alice", 20, 3.85);
        System.out.println("Student details:");
        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());
        System.out.println("GPA: " + s.getGpa());

        // activate behavior
        s.raiseHand(2);
    }
}

// javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinter

/*
* Tasks:
* 1. Create your own class. e.g. Dog, Professor, SecurityGuard
  2. Your class should have at least 3 attributes
  3. Your class should have at least 2 behaviors.
      - at least one behavior must have a parameter
      - at least one behavior must have no parameters
  4. Create an object using a Class created by one of your teammates. (A Class cannot be reused.)
  5. Print out the attributes, and trigger the behaviors of the object you created.
*/
