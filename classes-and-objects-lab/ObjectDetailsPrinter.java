public class ObjectDetailsPrinter {
    public static void main(String[] args) {
        // This is the object instance created from the Student class
        // Object using default constructor
        Student s1 = new Student();

        // Object using parameterized constructor
        Student s2 = new Student("Maria", 20, "BSCS");

        // Object using overloaded constructor
        Student s3 = new Student("Carlos", "BSIT");

        // Print attributes and trigger behaviors
        s1.introduce();
        s2.introduce();

        // Method with parameter
        s2.updateCourse("BS Data Science");

        // Static method
        Student.displayTotalStudents();

        // Object created by Bagay, User class created by Alvarez 
        User user1 = new User();
        user1.introduce(); 

        System.out.println(); 

        User user2 = new User("Axel Drake", 19, "Student");
        user2.introduce();

        System.out.println();

        User user3 = new User("Grr", "Gamer");
        user3.introduce();

        System.out.println();

        user3.updateStatus("Software Developer");

        System.out.println();

        User.displayTotalUsers(); 
        
    }
}

// javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinter