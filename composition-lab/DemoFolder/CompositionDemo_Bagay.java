public class CompositionDemo_Bagay {

	public static void main(String[] args) {
		// Instantiate two teammate component classes.
		engine_alvarez standardEngine = new engine_alvarez(220, "V6");
		TimeMachine_Bautista primaryMachine = new TimeMachine_Bautista("TM-01", 2120, 9, "Neo Manila");

		// Inject components into the composed class (HAS-A composition).
		TimeTravelVehicle_Bagay missionVehicle = new TimeTravelVehicle_Bagay(
			"Chrono Runner",
			standardEngine,
			primaryMachine
		);

		// Initial collaboration across composed objects.
		System.out.println("=== Initial Collaboration ===");
		missionVehicle.showSetup();
		missionVehicle.startMission();
		missionVehicle.travelMission(2120, 9, "Neo Manila");
		missionVehicle.endMission();

		// Low coupling test: swap one component with a compatible subclass object. 
		System.out.println("\n=== Low Coupling Test: Replace Engine with Compatible Subclass ===");
		engine_alvarez replacementEngine = new EcoEngine_Bagay(180, "Hybrid-Flux");
		missionVehicle.setEngine(replacementEngine);

		missionVehicle.showSetup();
		missionVehicle.startMission();
		missionVehicle.travelMission(1986, 10, "Old City District");
		missionVehicle.endMission();

		/*
		Design Analysis Answers:
		1. HAS-A relationships:
		   TimeTravelVehicle_Bagay HAS-A engine_alvarez and HAS-A TimeMachine_Bautista.
		2. Reused classes:
		   engine_alvarez (Alvarez) and TimeMachine_Bautista (Bautista) are teammate classes.
		   EcoEngine_Bagay is a compatible child class used for replacement testing.
		3. How composition reduces coupling:
		   The vehicle receives components through constructor/setter injection, so components can
		   be replaced without changing mission logic.
		4. How cohesion is maintained:
		   TimeTravelVehicle_Bagay is focused on one responsibility: coordinating mission flow
		   using its engine and time machine collaborators.
		5. Why inheritance is NOT appropriate:
		   The design is part-whole (HAS-A), not type specialization (IS-A), so composition is the
		   correct relationship for flexibility and clarity.
		*/
	}
}
