/*
* Child Class created by Acosta
* This class extends VitamilkRefresment_Isles
* It represents a chocolate flavored vitamilk drink, with the main content set to chocolate and the bottle material set to plastic
* Also represents a broken bottle of vitamilk, with the main content set to empty and the bottle material set to broken glass
*/


//Chocolate Vitamilk class, extends the parent class VitamilkRefreshment_Isles
public class ChocolateVitamilk_Acosta extends VitamilkRefreshment_Isles {
    
    //Overridden method to change flavor to chocolate
    @Override
    void userDrinks() {
        System.out.println("Mmm tastes like " +getMainContent()+ " soy milk! So good!"); //overridden to change the flavor of the drink
    }

    //New Behavior
    void refillDrink() {
        System.out.println("The "+getBottleMaterial()+" bottle is refilled with " +getMainContent()+ " soy milk!"); 
    } //Bottle is changed to plastic, main content is changed to chocolate
}

//Broken bottle class, extends the parent class VitamilkRefreshment_Isles
class BrokenBottle_Acosta extends VitamilkRefreshment_Isles {

    // Overridden method to change flavor to empty
    @Override
    void userDrinks() {
        System.out.println("Aw man! I can't drink from this broken bottle!"); // overridden to change the flavor of the drink
    }

    // New Behavior
    void checkDrink() {
        System.out.println("The " + getBottleMaterial() + " bottle is broken and contains " + getMainContent());
    } //Bottle is changed to broken glass, main content is changed to empty
}
