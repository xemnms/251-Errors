//main class!! where the outputs are done

//1 The IS-A relationship in the program is that Laptop_Isles is a Device_Rodenas and Phone_Isles is also a Device_Rodenas, meaning both subclasses inherit from the parent class.
//2 The method that was overridden in the program is crashDevice(), as both Laptop_Isles and Phone_Isles provide their own implementation of this method instead of using the one from the parent class.
//3 During dynamic binding, the program determines at runtime which version of the overridden method to execute, so even if the reference type is Device_Rodenas, the actual method called depends on whether the object is a Laptop_Isles or a Phone_Isles.
//4 The methods inherited from the parent class include powerOn() and any other common methods defined in Device_Rodenas that were not overridden by the subclasses.
//5 The subclasses introduced new behavior by adding unique methods, where Laptop_Isles has runProgram() and Phone_Isles has takePhoto(), which are not present in the parent class.

public class Main_Isles2 {
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
