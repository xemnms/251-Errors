package ad;

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

//main class!! where the outputs are done
public class Devices_Isles {
    public static void main(String[] args) {
        //creating laptop object
        Laptop_Isles laptop = new Laptop_Isles("MSI", "2000s Series"); //brand and model set here
        //creating phone object
        Phone_Isles phone = new Phone_Isles("Samsung", "Galaxy"); //brand and model set here

        //normal usage for laptop
        laptop.powerOn(); //turns laptop on
        laptop.runProgram(); //runs a program

        System.out.println(); //used to space the outputs out      
        
        //normal usage for phone
        phone.powerOn(); //turns phone on
        phone.takePhoto(); //takes a photo
        
        System.out.println(); //used to space the outputs out        
        
        //dynamic binding demonstration
        Device_Rodenas dev1 = laptop; //calls Laptop_Isles version, not Device_Rodenas version
        Device_Rodenas dev2 = phone; //calls Phone_Isles version, not Device_Rodenas version

        dev1.crashDevice(); //calls laptop version of crash
        dev2.crashDevice(); //calls phone version of crash
    }
}
