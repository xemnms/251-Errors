public class Main_Costiniano {

    public static void main(String[] args) {

        // create Room object
        Room_Badosa room1 = new Room_Badosa();

        // set room attributes using setters
        room1.setRoomNumber(101);
        room1.setRoomPrice(200);
        room1.setRoomType("Luxury");

        // display room details
        room1.getRoomDetails();

        // room behaviors
        room1.checkIn();
        room1.getRoomDetails();
        room1.checkOut();

        System.out.println("------------------------------------");

        // create Cat object
        Cat1_Acosta cat1 = new Cat1_Acosta("Milo", "Persian", 3);

        // use getters
        System.out.println("Cat ID: " + cat1.getId());
        System.out.println("Cat Name: " + cat1.getName());

        // cat behaviors
        cat1.introduceCat();
        cat1.meow();

        System.out.println("------------------------------------");

        // testing validation rules (invalid inputs)

        room1.setRoomNumber(-5); // invalid
        room1.setRoomType("Alien"); // invalid

        cat1.setAge(-2); // invalid
        cat1.setName(""); // invalid

        System.out.println("------------------------------------");

        // static methods
        System.out.print("Total Rooms: ");
        room1.getTotalRoom();
        System.out.println("Total Cats: " + Cat1_Acosta.getTotalCats());
    }
}
