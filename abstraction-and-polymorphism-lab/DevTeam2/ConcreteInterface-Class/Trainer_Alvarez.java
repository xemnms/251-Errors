/* Concrete Interface class created by Alvarez
* for Training_Bautista class created by bautista */

public class Trainer_Alvarez implements Training_Bautista {

    // interface method
    @Override
    public void train() {
        System.out.println("The Trainer pushes athlete to maximize his/her limits during training.");
    }

    // overloaded method
    public void train(int athletes) {
        System.out.println("Training " + athletes + " athletes ay sabay-sabay nag-dudusa.");
    }
}