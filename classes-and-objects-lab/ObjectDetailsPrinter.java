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

        // Object created by Nepomuceno, Galindon_Seller class created by Galindon
        System.out.println("\n===== SELLER CLASS OBJECTS =====\n");
        //Seller object using default constructor 
        Galindon_Seller account1 = new Galindon_Seller();
        account1.showSeller();
        account1.sell(0);
        System.out.println("______________________\n");

        //Seller object using parameterized constructor
        Galindon_Seller account2 = new Galindon_Seller("Liam", "Tech Accessories", 67.69);
        account2.showSeller();
        account2.sell(5);
        System.out.println("______________________\n");

        //Seller object using overloaded constructor (name + store only)
        Galindon_Seller account3 = new Galindon_Seller("Emma", "Books");
        account3.showSeller();
        account3.sell(3);
        System.out.println("______________________\n");

        Galindon_Seller.showTotal();
         System.out.println("______________________\n");

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
        System.out.println("\nTotal sellers created: " + SellerBagay.getTotalSellers() + "\n");

        // Object created by Galindon, Cellphone class created by Nepomuceno
        Cellphone_Nepomuceno phone1 = new Cellphone_Nepomuceno();
        phone1.display();

        Cellphone_Nepomuceno phone2 = new Cellphone_Nepomuceno("iPhone", 18000, 256);
        phone2.display();

        Cellphone_Nepomuceno phone3 = new Cellphone_Nepomuceno("Samsung", 7000);
        phone3.display();

        Cellphone_Nepomuceno.displayTotalPhonesSold();

        // Object created by Batangan, Class by Costiniano
        // Object using default constructor
        Seller_Costiniano sellerOne = new Seller_Costiniano();

        // Object using parameterized constructor
        Seller_Costiniano sellerTwo = new Seller_Costiniano("Clisha", 20, "BSCS");

        // Object using overloaded constructor
        Seller_Costiniano sellerThree = new Seller_Costiniano("Maverick", "BSIT");

        // Print attributes and trigger behaviors
        sellerOne.introduce();
        sellerTwo.introduce();
        sellerThree.introduce();

        // Method with parameter
        sellerTwo.updateCourse("BS Data Science");

        // Static method
        Seller_Costiniano.displayTotalSellers();

        // Object created by Costiniano, Class by Batangan
        Buyer_Batangan buyerOne = new Buyer_Batangan();
        Buyer_Batangan buyerTwo = new Buyer_Batangan("Maverick", "Laptop", 2, 1200.50);

        // Display attributes
        System.out.println("Buyer One Name: " + buyerOne.buyerName);
        System.out.println("Buyer One Product: " + buyerOne.userProduct);
        System.out.println("Buyer One Quantity: " + buyerOne.prodQuantity);
        System.out.println("Buyer One Price: " + buyerOne.prodPrice);

        System.out.println();

        System.out.println("Buyer Two Name: " + buyerTwo.buyerName);
        System.out.println("Buyer Two Product: " + buyerTwo.userProduct);
        System.out.println("Buyer Two Quantity: " + buyerTwo.prodQuantity);
        System.out.println("Buyer Two Price: " + buyerTwo.prodPrice);

        // Trigger behavior without parameter
        buyerOne.introduceBuyer();

        // Trigger behavior with parameter
        buyerTwo.updateQuantity(5);

        // Demonstrate static usage
        Buyer_Batangan.displayTotalBuyers();

        // Object created by Rodenas, LaptopIsles class created by Isles
        // Object created for LaptopIsles
        System.out.println("===== LAPTOP OBJECTS =====\n");

        // Object 1 using default constructor
        LaptopIsles laptop1 = new LaptopIsles();
        // Object 2 using parameterized constructor
        LaptopIsles laptop2 = new LaptopIsles("Dell", 512, false);

        // Display attributes
        System.out.println("Laptop 1 Brand: " + laptop1.brand);
        System.out.println("Laptop 1 Max Storage: " + laptop1.maxStorage + " GB");
        System.out.println("Laptop 1 Refurbished: " + laptop1.refurbished);

        System.out.println("\nLaptop 2 Brand: " + laptop2.brand);
        System.out.println("Laptop 2 Max Storage: " + laptop2.maxStorage + " GB");
        System.out.println("Laptop 2 Refurbished: " + laptop2.refurbished);

        // Trigger behaviors
        System.out.println("\n--- Laptop1 displaySpecs() ---");
        laptop1.displaySpecs();

        System.out.println("\n--- Laptop2 displaySpecs() ---");
        laptop2.displaySpecs();

        // Trigger behavior with parameter: updating specs
        System.out.println("\n--- Updating Laptop2 specs ---");
        laptop2.newLaptop("Lenovo", 1024, true);
        laptop2.displaySpecs();

        // Static
        System.out.println("\nDefault RAM for all laptops: " + LaptopIsles.defaultRam + " GB");

        // objects created by Dan Isles, sf class created by Kyla Rodenas

        SellerInfoRodenas sf = new SellerInfoRodenas();

        sf.introduceSeller();
        System.out.println();

        SellerInfoRodenas sf2 = new SellerInfoRodenas("Dan Isles", "BSIT", 1);

        sf2.introduceSeller();
        System.out.println();

        SellerInfoRodenas sf3 = new SellerInfoRodenas("Miguel Anthon", "BSIS");

        sf3.introduceSeller();
        System.out.println();

        sf3.updateYearLevel(2);
        sf3.introduceSeller();
        System.out.println();

        sf3.displayTotalSellers();
        System.out.println();

        // Object created by Acosta, Class created by Badosa

        // Default constructor
        Car_Badosa car1 = new Car_Badosa();

        // Parameterized constructor
        Car_Badosa car2 = new Car_Badosa("BMW", "M3 GTR", "White");

        // Behaviour without parameters
        car1.checkEngine();

        // Behaviour with parameters
        car2.runEngine();
        car2.checkEngine();
        car2.stopEngine();
        car2.checkEngine();

        // Static method
        Car_Badosa.displayTotalCars();
        System.out.println();

        // Object created by Badosa, Class created by Acosta
        // Object using default constructor
        Cat_Acosta cat1 = new Cat_Acosta();

        // Object using parameterized constructor
        Cat_Acosta cat2 = new Cat_Acosta("Floof", 12, "Spotted", "Blue");

        // Object using overloaded constructor
        Cat_Acosta cat3 = new Cat_Acosta("Cloud", 3);

        // Print attributes and trigger behaviours
        cat1.introduce();
        cat2.introduce();
        cat3.introduce();

        // Method with parameter
        cat1.feedCat(false);
        cat2.feedCat(true);
        cat3.feedCat(true);

        // Static method
        Cat_Acosta.displayTotalCats();
        System.out.println();

        //object created by Dizon, class created by Bautista
        //Product object using default constructor
    Product_Bautista pb1 = new Product_Bautista();
        
        //Product using parameterized Object constructor
    Product_Bautista pb2 = new Product_Bautista("Predator", 70000, "Gaming Laptop");

        //Product object using overloaded constructor
    Product_Bautista pb3 = new Product_Bautista("Bag", "School Supply");

    //behavior without parameters
    pb1.introduce();
    pb2.introduce();
    pb3.introduce();

    //behavior with parameter
    pb2.updateCategory("Main Stream");

    //static method
    Product_Bautista.displayTotalProducts();
    System.out.println();

    // Object Created by Arandela, class created by alonde
    // Default
    Clothing_Alonde c1 = new Clothing_Alonde();
    c1.display();
    System.out.println();

    // Parameter
    Clothing_Alonde c2 = new Clothing_Alonde("T-shirt", 250.0, true);
    c2.display();
    System.out.println();

    //Overloaded
    Clothing_Alonde c3 = new Clothing_Alonde("Jacket", 1999.9);
    c3.display();
    System.out.println();

    c3.updateType("Hoodie");

    System.out.println();

    // Object created by Alonde, Class created by Arandela
    // Object without parameter
    Arandela_Order order1 = new Arandela_Order();
    order1.showOrder();
    order1.addOrder(0);

    // Object with parameter
    Arandela_Order order2 = new Arandela_Order();
    order2.showOrder("001", "Empanada", 5, 24.5);
    order2.addOrder(3);

    // Object overloaded constructor
    Arandela_Order order3 = new Arandela_Order("002", "Dubai Chewy Cookie");
    order3.showOrder();
    order3.addOrder(5);

    Arandela_Order.showTotalOrders();
    }

}
// javac classes-and-objects-lab/Student.java
// classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinter
