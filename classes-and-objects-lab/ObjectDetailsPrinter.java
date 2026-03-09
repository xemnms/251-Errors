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
        

        // Object created by Nepomuceno, SellerBagay class created by Bagay
        // Object created for Seller class
        SellerBagay account1 = new SellerBagay();
        account1.displaySellerInfo();

        System.out.println();

        SellerBagay account2 = new SellerBagay("Juan Dela Cruz", 35, "JDC Electronics");
        account2.displaySellerInfo();

        System.out.println();

        SellerBagay account3 = new SellerBagay("Maria Santos", "Santos Store");
        account3.displaySellerInfo();

        System.out.println();

        account2.updateStoreName("JDC Tech Hub");

        System.out.println();

        System.out.println("Total Sellers: " + SellerBagay.getTotalSellers());


        // Object created by Bautista, BuyerDizon class created by Dizon
        BuyerDizon buyer1 = new BuyerDizon();
        buyer1.displayProfile();

        System.out.println();

        BuyerDizon buyer2 = new BuyerDizon("Acbde", 20, 500.0);
        buyer2.displayProfile();

        System.out.println();

        BuyerDizon buyer3 = new BuyerDizon("Eyefgi", 30);
        buyer3.displayProfile();

        System.out.println();

        buyer3.makePurchase(150.0);
        buyer2.makePurchase(200.0);
        buyer1.makePurchase(50.0);

        System.out.println();

        BuyerDizon.displayTotalBuyers();

        // Object created by Alvarez, Classes by Bagay

// Object using default constructor
        SellerBagay sll1 = new SellerBagay();

        // Object using parameterized constructor
        SellerBagay sll2 = new SellerBagay("Angelo", 28, "Hayden's Mart");

        // Object using overloaded constructor (name + store only)
        SellerBagay sll3 = new SellerBagay("Alvarez", "Tech Corner");

        // Print attributes and trigger behaviors
        System.out.println("--- sll1 (default) ---");
        sll1.displaySellerInfo();

        System.out.println("\n--- sll2 (parameterized) ---");
        sll2.displaySellerInfo();

        System.out.println("\n--- sll3 (overloaded) ---");
        sll3.displaySellerInfo();

        // Method with parameter: update store name
        System.out.println("\nUpdating sll2's store name...");
        sll2.updateStoreName("Maria's Supermart");

        // Show updated info
        System.out.println("\n--- sr2 (after update) ---");
        sll2.displaySellerInfo();

        // Static method: total sellers created
        System.out.println("\nTotal sellers created: " + SellerBagay.getTotalSellers());
    }

}
// javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinter
