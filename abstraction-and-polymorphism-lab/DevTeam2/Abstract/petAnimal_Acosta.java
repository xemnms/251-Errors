//Abstract class by Acosta
//1 abstract method and 1 concrete method

public abstract class petAnimal_Acosta {
    abstract void move (); //abstract method

    void makeNoise(String petNoise) { //concrete method
        System.out.println("Your pet says "+ petNoise);
    }
}