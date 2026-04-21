// Uses abstract class Cereal_Alvarez by Alvarez


public class KokoCrunch_Acosta extends Cereal_Alvarez {

    @Override //Override abstract method
    public void prepare() {
        System.out.println("Added Koko Crunch then milk to the bowl. Wait or is it milk first..?");
    }

    //Overload method
    public void prepare(int bowlAmount) {
        System.out.println("You prepared "+bowlAmount+" cereal bowls!");
    }
    
}
