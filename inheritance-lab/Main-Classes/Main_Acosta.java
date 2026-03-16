/* Main created by Acosta
*  The IS-A relationship in my program is the chocolate vitamilk and the broken bottle. They are both types of vitamilk refreshments
*  The overridden method is the userDrinks() method, which allows me to change the flavor of the selected drink and the response when the user tries to drink from the broken bottle.
*  During dynamic binding, the chocolate vitamilk is created from the parent class reference type, but the actual object type is the chocolate vitamilk class. It inherits the overridden methods.
*  The subclass chocolate vitamilk adds new behavior with the refillDrink() method, which allows the user to refill the drink. The broken bottle subclass adds new behavior with the checkDrink() method, which allows the user to check the status of the broken bottle.
*/

public class Main_Acosta {
    public static void main(String[] args) {

        //Create chocolate vitamilk object
        VitamilkRefreshment_Isles chocolateVitamilk = new ChocolateVitamilk_Acosta(); //Dynamic Binding: reference type is VitamilkRefreshment_Isles, but actual object type is ChocolateVitamilk_Acosta
        ChocolateVitamilk_Acosta refillChocolate = new ChocolateVitamilk_Acosta(); //Used for the new behaviour call
        chocolateVitamilk.setMainContent("chocolate"); //setting main content to chocolate
        chocolateVitamilk.setBottleMaterial("plastic"); //setting bottle material to plastic

        refillChocolate.setMainContent(chocolateVitamilk.getMainContent()); //Copy attributes from chocolateVitamilk to refillChocolate
        refillChocolate.setBottleMaterial(chocolateVitamilk.getBottleMaterial()); 

        //Overridden method calls
        chocolateVitamilk.userDrinks(); //calls the overridden method in ChocolateVitamilk
        //New behavior call
        refillChocolate.refillDrink();


        //Create broken bottle object
        BrokenBottle_Acosta brokenBottle = new BrokenBottle_Acosta(); //Dynamic Binding: reference type is VitamilkRefreshment_Isles, but actual object type is BrokenBottle_Acosta
        brokenBottle.setMainContent("Empty");
        brokenBottle.setBottleMaterial("broken glass");

        System.out.println();
        brokenBottle.userDrinks(); //calls the overridden method in BrokenBottle
        brokenBottle.checkDrink(); //calls the new behavior method in BrokenBottle
    }
}
