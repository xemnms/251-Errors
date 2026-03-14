import java.util.Random;

public class Main_Bagay {
    public static void main(String[] args) {
        Random random = new Random();

        String[] characterNames = {"Rin", "Kai", "Astra", "Noel", "Vera"};
        String[] catNames = {"Mochi", "Luna", "Miso", "Tofu", "Nori"};
        String[] catBreeds = {"Persian", "Siamese", "Maine Coon", "Ragdoll", "British Shorthair"};

        // SUMMON PHASE
        GachaCharacterMaker_Nepomuceno[] characters = new GachaCharacterMaker_Nepomuceno[3];
        Cat1_Acosta[] cats = new Cat1_Acosta[3];

        boolean[] usedCharacterName = new boolean[characterNames.length];
        boolean[] usedCatName = new boolean[catNames.length];

        for (int i = 0; i < characters.length; i++) {
            int nameIndex;
            do {
                nameIndex = random.nextInt(characterNames.length);
            } while (usedCharacterName[nameIndex]);
            usedCharacterName[nameIndex] = true;

            String name = characterNames[nameIndex];

            if (random.nextBoolean()) {
                characters[i] = new GachaCharacterMaker_Nepomuceno(name);
            } else {
                int rarity = (random.nextInt(100) < 20) ? 5 : 4;
                int level = 1 + random.nextInt(20);
                int health = 100 + random.nextInt(101);
                int stamina = 50 + random.nextInt(51);
                characters[i] = new GachaCharacterMaker_Nepomuceno(name, rarity, level, health, stamina);
            }

            // [GachaCharacterMaker_Nepomuceno][Getter + Setter]
            // Sync alive status for name-only constructor objects.
            characters[i].setHealth(characters[i].getHealth());
        }

        for (int i = 0; i < cats.length; i++) {
            if (random.nextBoolean()) {
                cats[i] = new Cat1_Acosta();
            } else {
                int catNameIndex;
                do {
                    catNameIndex = random.nextInt(catNames.length);
                } while (usedCatName[catNameIndex]);
                usedCatName[catNameIndex] = true;

                String cName = catNames[catNameIndex];
                String cBreed = catBreeds[random.nextInt(catBreeds.length)];
                int cAge = random.nextInt(16);
                cats[i] = new Cat1_Acosta(cName, cBreed, cAge);
            }
        }

        // TEAM SELECT (fixed until adventure ends)
        GachaCharacterMaker_Nepomuceno hero = characters[random.nextInt(characters.length)];
        Cat1_Acosta companion = cats[random.nextInt(cats.length)];

        // [GachaCharacterMaker_Nepomuceno][Setters - valid]
        hero.setName("Champion " + hero.getName());
        hero.setRarity(5);
        hero.setLevel(hero.getLevel() + 2);
        hero.setHealth(hero.getHealth() + 30);
        hero.setStamina(hero.getStamina() + 20);

        // [Cat1_Acosta][Setters - valid]
        companion.setName(companion.getName());
        companion.setBreed(companion.getBreed());
        companion.setAge(companion.getAge());

        // ADVENTURE LOOP (class behavior prints used here)
        System.out.println("=== Adventure Begins ===");
        System.out.println("The forest path opens. Shadows gather. The party moves forward.");
        companion.meow();
        System.out.println();

        for (int chapter = 1; chapter <= 3; chapter++) {
            System.out.println("-- Chapter " + chapter + " --");

            int staminaCost = 10 + random.nextInt(21);
            int incomingDamage = 15 + random.nextInt(31);

            hero.attack(staminaCost);
            System.out.println();

            hero.takeDamage(incomingDamage);
            System.out.println();

            if (hero.isAlive() && hero.getStamina() >= 20) {
                hero.levelUp();
                System.out.println();
            }

            companion.meow();

            if (chapter < 3) {
                System.out.println();
            }
        }

        // POST-ADVENTURE: class prints + validations
        System.out.println("\n=== Adventure End: Class Output Enabled ===");

        // [GachaCharacterMaker_Nepomuceno][Behavior methods]
        hero.displayStatus();

        // [Cat1_Acosta][Behavior methods]
        companion.introduceCat();
        companion.meow();

        // [GachaCharacterMaker_Nepomuceno][Setter + Validation]
        hero.setName("   ");
        hero.setLevel(0);
        hero.setStamina(-10);
        hero.setRarity(9);

        // [Cat1_Acosta][Setter + Validation]
        companion.setName("");
        companion.setBreed("");
        companion.setAge(99);
        companion.setAge(-1);

        System.out.println("\n[All Characters]");
        for (int i = 0; i < characters.length; i++) {
            characters[i].displayStatus();
        }

        System.out.println("[All Cats]");
        for (int i = 0; i < cats.length; i++) {
            cats[i].introduceCat();
            cats[i].meow();
            // [Cat1_Acosta][Getters]
            System.out.println("Cat Info -> ID: " + cats[i].getId()
                    + ", Name: " + cats[i].getName()
                    + ", Breed: " + cats[i].getBreed()
                    + ", Age: " + cats[i].getAge());
        }

        System.out.println("\nTotals -> Characters: " + GachaCharacterMaker_Nepomuceno.getTotalCharacters()
                + ", Cats: " + Cat1_Acosta.getTotalCats());
    }
}