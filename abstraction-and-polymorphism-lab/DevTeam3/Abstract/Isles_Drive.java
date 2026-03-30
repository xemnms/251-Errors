//abstract class by Dan Isles
//this class represents driving

public abstract class Isles_Drive {
	
	//encapsulated attributes that serves as default situations for user
	private boolean hasLicense = false;
	private boolean inVehicle = false;
	private boolean isLegalAge = false;
	
	//constructor 
    public Isles_Drive(boolean hasLicense, boolean inVehicle, boolean isLegalAge) {
        this.hasLicense = hasLicense;
        this.inVehicle = inVehicle;
        this.isLegalAge = isLegalAge; 
    }
    // getters
    public boolean hasLicense() {
        return hasLicense;
    }

    public boolean isInVehicle() {
        return inVehicle;
    }

    public boolean isLegalAge() {
        return isLegalAge;
    }
    
    //subclasses must implement this to work
    public abstract void drive();
    
    //checks user age if eligible to drive
    public void checkUserAge() {
    	if (isLegalAge) {
    		System.out.println("You are eligible to get a license.");
    	} else {
    		System.out.println("Please wait until you are legally able to drive");
    	}
    	}
    	
    //checks if user has a license
    public void checkUserLicense() {
        if(hasLicense) {
        		System.out.println("You are eligible to start driving");
        } else {
        	System.out.println("Please get a license first before you start driving");
        }
    	}
    
    //checks if user is inside a vehicle
    public void checkWhereUserIs() {
        if(inVehicle) {
        	System.out.println("Enjoy driving! broom broom");
        } else {
        	System.out.println("Please go inside the vehicle to start driving");
        }
    	}

    public void checkAllRequirements() { //makes a summarized decision if you are able to drive or not
    	checkUserAge();
    	checkUserLicense();
    	checkWhereUserIs();
    	
        if (hasLicense && inVehicle && isLegalAge) {
            System.out.println("You are fully allowed to drive.");
        } else {
        	System.out.println("You cannot drive yet. Please complete all requirements.");
        }
}
}
