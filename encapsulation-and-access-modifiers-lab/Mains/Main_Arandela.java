public class Main_Arandela {
    public static void main(String[] args) {

        // Galindon_Student.java Class Created by Galindon

        // FIRST OBJECT OF THE STUDENT CLASS
        System.out.println("\nFirst Student Object:");
        Galindon_Student studentOne = new Galindon_Student();
        studentOne.setName("John Doe"); // Setters with validation
        studentOne.setStudentId("12345678901");
        studentOne.setAge(22);
        studentOne.setGwa(3.5);
        studentOne.setProgram("Computer Science");
        studentOne.improveGwa(0.5); // Behavior of the Student class
        studentOne.displayStudentInfo(); // Getter-like method to display the details of the student

        System.out.println("\n-----------------------------\n");
        // LRCBook_Rodenas.java Class Created by Rodenas
        LRCBook_Rodenas bookOne = new LRCBook_Rodenas(101, "Java Programming", 350); // Creating an object
                                                                                     // with valid values
        bookOne.getBookDetails(); // Using getter-like method to display the details of the book
        System.out.println("\nBorrowing the book...");
        bookOne.borrowBook(); // Testing the borrow method
        bookOne.getBookDetails(); // Display updated details
        System.out.println("\nReturning the book...");
        bookOne.returnBook(); // Testing the return method
        bookOne.getBookDetails(); // Display updated details


    }

}
