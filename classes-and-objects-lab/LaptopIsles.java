public class LaptopIsles {
	//Dan Marvin Isles
	//this class represents laptops with its usual displayed specs
	
	//attributes of laptop
	String brand;
	int maxStorage; //storage counted in gigabytes
	boolean refurbished;
	static int defaultRam = 8; //static value
	
	//default constructor + sets the laptop's specs
	public LaptopIsles() {
		brand = "MSI";
		maxStorage = 1000;
		refurbished = true;
	}
	
	//parameterized constructor + allows user to set the laptop's specs
	public LaptopIsles(String brand, int maxStorage, boolean refurbished) {
		this.brand = brand;
		this.maxStorage = maxStorage;
		this.refurbished = refurbished;
	}
	
	//method w/o parameter and displays the laptop's specs
	void displaySpecs() {
		System.out.println("Brand: " + brand);
	    System.out.println("Max Storage: " + maxStorage + "GB");
	    System.out.println("Refurbished: " + refurbished);
	    System.out.println("Default RAM: " + defaultRam + "GB");
	}
	
	//method with parameters that updates the laptop's specs
	void newLaptop(String brand, int maxStorage, boolean refurbished) {
		this.brand = brand;
		this.maxStorage = maxStorage;
		this.refurbished = refurbished;
	}
}
