public class VitamilkRefreshment_Isles {
	//BTW you can name the child class something like VitamilkStrawberry if wala ka maisip
	
	private String mainContent = "Soy"; //main content of the drink
	private String bottleMaterial = "Glass"; //what the vitasoy bottle is made of
	private double msrp = 25; //cost of the default flavor vitamilk without any mark ups
	
	//this the overridable method
	void userDrinks() {
		System.out.println("Mmm tastes like soy milk");  //you can override this by changing the flavor
	}
	//this method represents that the bottle is empty
	void emptyBottle() {
		System.out.println("I finished my drink already :("); //called when the drink is finished
	}
	
	//getters!! (gets the default attributes)
	public String getMainContent() {
		return mainContent; //returns what the main ingredient of the drink is
	}
	public String getBottleMaterial() {
		return bottleMaterial; //returns what the bottle is made of
	}
	public double getMsrp() {
		return msrp; //returns the base price of the drink
	}
	
	//setters!! (sets new attributes)
	public void setMainContent(String mainContent) {
		this.mainContent = mainContent; //changes the main ingredient if needed like yung goated flavor na strawberry
	}
	public void setBottleMaterial(String bottleMaterial) {
		this.bottleMaterial = bottleMaterial; //changes the bottle material
	}
	public void setMsrp(double msrp) {
		this.msrp = msrp; //changes the price of the drink
	}
}
