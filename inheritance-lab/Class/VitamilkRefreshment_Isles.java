public class VitamilkRefreshment_Isles {
	//BTW you can name the child class something like VitamilkStrawberry if wala ka maisip
	
	String mainContent = "Soy"; //main content of the drink
	String bottleMaterial = "Glass"; //what the vitasoy bottle is made of
	int msrp = 25; //cost of the default flavor vitamilk without any mark ups
	
	//this the overridable method
	void userDrinks() {
		System.out.println("Mmm tastes like soy milk");  //you can override this by changing the flavor of vitamilk (strawberry, ube, etc.)
	}
	//this method represents that the bottle is empty
	void emptyBottle() {
		System.out.println("I finished my drink already :("); 
	}
}

