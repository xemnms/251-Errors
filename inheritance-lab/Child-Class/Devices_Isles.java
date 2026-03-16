//parent class by rodenas, child class by isles

//first child class!! represents a laptop
class Laptop_Isles extends Device_Rodenas {
    //constructor for Laptop, sets brand and model
    public Laptop_Isles(String brand, String model) {
        super(brand, model); //calls parent constructor to set these attributes
    }
    //new behavior!! laptops can run programs
    public void runProgram() {
        System.out.println("Laptop is running a program."); //what happens when you run a program
    }
    //overrides the parent crash method
    @Override
    public void crashDevice() {
        System.out.println("Laptop froze."); //what happens when laptop crashes
    }
}

//second child class!! represents a phone
class Phone_Isles extends Device_Rodenas {
    //constructor for Phone, sets brand and model
    public Phone_Isles(String brand, String model) {
        super(brand, model); //calls parent constructor to set brand and model
    }
    //new behavior!! phone can take photos
    public void takePhoto() {
        System.out.println("Phone took a photo."); //what happens when you take a photo
    }
    //overrides the parent crash method
    @Override
    public void crashDevice() {
        System.out.println("Phone app crashed."); //what happens when phone crashes
    }
}
