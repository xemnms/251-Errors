/*
=== DESIGN ANALYSIS ===

HAS-A Relationships:
- Player_Arandela HAS-A Weapon_Nepomuceno
- Player_Arandela HAS-A Skin_Dizon

Reused Classes:
- Weapon_Nepomuceno
- Skin_Dizon

Low Coupling:
- The weapon was replaced from Vandal to Phantom without changing Player_Arandela.
- The system still works, proving low coupling.

Cohesion:
- Each class has a clear role:
  Weapon → combat
  Skin → visuals/sound
  Player → interaction

Why NOT inheritance:
- Player is NOT a Weapon or Skin.
- Using extends would break real-world relationships.

BONUS (Inheritance):
- TeleportMap_Arandela extends ValorantMapGalindon
- Shows IS-A relationship
- Adds new behavior (useTeleporter)
*/

public class CompositionDemoArandela {
    public static void main(String[] args) {

        // Teammate objects
        Weapon_Nepomuceno vandal = new Weapon_Nepomuceno("Vandal", "Rifle", 40, 25);
        Skin_Dizon primeSkin = new Skin_Dizon("Prime", "Premium", 4);

        // Child class (inheritance)
        TeleportMap_Arandela bind = new TeleportMap_Arandela("Bind", 2, true, 2);

        // Composition
        Player_Arandela player = new Player_Arandela("Mikasa", vandal, primeSkin);

        // Collaboration
        player.inspectLoadout();
        player.attack();

        // Map interaction
        System.out.println("\n=== MAP INFO ===");
        bind.displayMapInfo();
        bind.startMatch();
        bind.useTeleporter();

        // LOW COUPLING DEMO
        System.out.println("\n--- Switching Weapon ---");

        Weapon_Nepomuceno phantom = new Weapon_Nepomuceno("Phantom", "Rifle", 35, 30);
        player.setWeapon(phantom);

        player.attack(); // still works
    }
}