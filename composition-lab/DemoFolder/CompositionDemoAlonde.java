public class CompositionDemoAlonde {
    public static void main(String[] args) {
        ValorantMapGalindon bind = new ValorantMapGalindon("Bind", 2, true);
        Weapon_Nepomuceno vandal = new Weapon_Nepomuceno("Vandal", "Rifle", 40, 25);

        ValorantMatch_Alonde currentMatch = new ValorantMatch_Alonde("VM-2026", "Competitive", bind, vandal);

        currentMatch.startRound();
        currentMatch.reloadPhase();
    }
}

/* 
TASK 8: DESIGN ANALYSIS - COMPOSITION & COUPLING

1. WHAT ARE THE HAS-A RELATIONSHIPS?
- ValorantMatch_Alonde HAS-A ValorantMapGalindon and HAS-A Weapon_Nepomuceno.

2. WHICH CLASSES WERE REUSED? 
- I reused 'ValorantMapGalindon' and 'Weapon_Nepomuceno' created by my teammates.

3. HOW DOES COMPOSITION REDUCE COUPLING? 
- My Match class does not know how the ammo validation works in the Weapon 
  class, nor does it know how the teleporter logic works in the Map class. 
  It only calls their public behaviors. If Galindon or Nepomuceno update 
  their code, my Match class does not need to be rewritten.

4. HOW IS COHESION MAINTAINED? 
- Each class has one focus: Weapon handles ballistics, Map handles 
  environment data, and Match handles the coordination of the session.

5. WHY IS INHERITANCE NOT APPROPRIATE HERE? 
- A Match "is-not-a" Weapon. If I used 'class Match extends Weapon', the 
  Match object would incorrectly have 'ammo' and 'damage' attributes. 
  Composition is the only logical way to say a match "contains" a weapon.

*/