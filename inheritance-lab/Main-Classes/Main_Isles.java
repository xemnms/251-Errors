//main class!! where the outputs are done
public class Main_Isles {
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
