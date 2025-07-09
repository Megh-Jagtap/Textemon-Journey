import java.util.*;

public class JourneyStory {
    public static void helpingHand() {
        Partition.display_partition();
        String sq1 = "\033[1mSide Quest 1: Helping Hand\033[0m";
        int width = 160; // Width of the text area
        System.out.println();
        System.out.printf("%" + ((width + sq1.length()) / 2) + "s%n", sq1);
        System.out.println();

        // Introduction
        System.out.println("As you walk along the forest outskirts, you hear a faint voice calling for help.\n");
        System.out.println("You follow the sound and discover a lost traveler named Alex.\n");
        System.out.println("\nAlex: Oh, thank goodness you're here! I've lost my way in this dense forest.\n");
        System.out.println("Alex explains that they were trying to reach a nearby village but got disoriented.\n");

        // Objective
        System.out.println("\033[1mYour objective is to assist Alex in finding the village by guiding them through the forest.\033[0m\n");

        // Action
        System.out.println("You offer to help Alex navigate through the forest and lead them to the village.\n");
        System.out.println("Along the way, you encounter various obstacles and wild Textemons.\n");

        // Player's choice of Textemon
        Textemon playerTextemon;
        boolean win;
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("You decide to bring your trusty " + playerTextemon.getName() + " along for protection.\n");

            Battle battle = new Battle(playerTextemon, Water_type.Textemon_W.TOTODILE);
            win = battle.startBattle();
            if (!win) {
                System.out.println("You lost the battle! Your " + playerTextemon.getName() + " fainted.");
            }
        } while (!win);

        // Resolution
        System.out.println("\nAfter a challenging journey, you successfully guide Alex to the village.\n");
        System.out.println("Alex: I can't thank you enough for your help! You're a true hero.\n");
        System.out.println("Alex expresses gratitude and continues their journey, leaving you with a sense of accomplishment.\n");

        System.out.println("\nClick (P) and (Enter) to view the Textedox!");
        System.out.println("Press (Space-bar) to continue the journey!");
        String ip;
        Scanner scanner = new Scanner(System.in);
        do{
            ip = scanner.nextLine().trim();
            if (ip.equalsIgnoreCase("P")) {
                System.out.println("Displaying textedox...");
                Textedox.displayAllTextemons("ForestExploration");
            } else if (ip.isEmpty()) {
                Partition.display_partition();
                System.out.println(("Continuing the journey..."));
                JourneyStory.forestExploration();
            } else {
                System.out.println("Invalid key pressed!");
            }
        } while (!ip.equalsIgnoreCase("P"));
    }



    public static void forestExploration() {
        Partition.display_partition();
        String sq2 = "\033[1mSide Quest 2: Forest Exploration\033[0m";
        int width = 160; // Width of the text area
        System.out.println();
        System.out.printf("%" + ((width + sq2.length()) / 2) + "s%n", sq2);
        System.out.println();

        // Introduction
        System.out.println("You meet a local herbalist named Maya, who requests rare herbs found deep in the forest.\n");

        // Objective
        System.out.println("Your objective is to venture into the forest to collect the rare herbs for Maya.\n");

        // Action
        System.out.println("You explore the dense forest, battling wild Textemons and collecting herbs along the way.\n");
        System.out.println("You encounter puzzles and obstacles that require problem-solving skills to overcome.\n");

        Textemon playerTextemon;
        boolean win;
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("You decide to bring your trusty " + playerTextemon.getName() + " along for protection.\n");

            Battle battle = new Battle(playerTextemon, Grass_type.Textemon_G.FORESTOX); // Replace TOTODILE with a suitable wild Textemon
            win = battle.startBattle();
            if (!win) {
                System.out.println("You lost the battle! Your " + playerTextemon.getName() + " fainted.");
            }
        } while (!win);

        // Resolution
        System.out.println("\nYou gather the rare herbs and return to Maya.\n");
        System.out.println("Maya rewards you with gratitude and promises to share her herbal knowledge with you.\n");

        System.out.println("\nClick (P) and (Enter) to view the Textedox!");
        System.out.println("Press (Space-bar) to continue the journey!");
        String ip;
        Scanner scanner = new Scanner(System.in);
        do {
            ip = scanner.nextLine().trim();
            if (ip.equalsIgnoreCase("P")) {
                System.out.println("Displaying textedox...");
                Textedox.displayAllTextemons("GuardiansChallenge");
            } else if (ip.isEmpty()) {
                Partition.display_partition();
                System.out.println(("Continuing the journey..."));
                guardiansChallenge();
            } else {
                System.out.println("Invalid key pressed!");
            }
        } while (!ip.equalsIgnoreCase("P"));
    }


    public static void guardiansChallenge() {
        Partition.display_partition();
        String sq1 = "\033[1mMain Quest 1: Guardian's Challenge\033[0m";
        int width = 160; // Width of the text area
        System.out.println();
        System.out.printf("%" + ((width + sq1.length()) / 2) + "s%n", sq1);
        System.out.println();

        // Introduction
        System.out.println("Rumors spread of a legendary guardian Textemon guarding a sacred grove.");
        System.out.println("Your objective is to seek out the guardian and prove worthy of its blessing.");

        // Action
        System.out.println("You embark on a journey to the grove, facing trials of strength and wisdom.");
        System.out.println("Along the way, you encounter various challenges and obstacles.");

        Textemon playerTextemon;
        boolean win;
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("You encounter a powerful opponent! Prepare for battle with your trusty " + playerTextemon.getName() + "!");

            Battle battle = new Battle(playerTextemon, Fire_type.Textemon_F.CHARIZARD);
            win = battle.startBattle();
            if (!win) {
                System.out.println("You were defeated by the Guardian! Your " + playerTextemon.getName() + " fainted.\nKeep training and try again!");
            }
        } while (!win);
        System.out.println("Congratulations! You impress the guardian with determination and respect.");
            System.out.println("You gain the guardian's blessing, unlocking the defeated Textemon to join your team.");

        System.out.println("\nClick (P) and (Enter) to view the Textedox!");
        System.out.println("Press (Space-bar) to continue the journey!");
        String ip;
        Scanner scanner = new Scanner(System.in);
        do{
            ip = scanner.nextLine().trim();
            if (ip.equalsIgnoreCase("P")) {
                System.out.println("Displaying textedox...");
                Textedox.displayAllTextemons("ElementalTrials");
            } else if (ip.isEmpty()) {
                Partition.display_partition();
                System.out.println(("Continuing the journey..."));
                elementalTrials();
            } else {
                System.out.println("Invalid key pressed!");
            }
        } while (!ip.equalsIgnoreCase("P"));
    }

    public static void elementalTrials() {
        Partition.display_partition();
        String sq1 = "\033[1mMain Quest 2: Elemental Trials\033[0m";
        int width = 160; // Width of the text area
        System.out.println();
        System.out.printf("%" + ((width + sq1.length()) / 2) + "s%n", sq1);
        System.out.println();

        // Introduction
        System.out.println("You learn of ancient Elemental Trials held in a hidden temple.");
        System.out.println("Your objective is to conquer the trials and harness elemental powers.");

        // Action
        System.out.println("You journey to the temple, facing challenges representing fire, water, grass, and electricity.");
        System.out.println("The trials test your strength, wisdom, and bond with your Textemons.");

        // Player's choice of Textemon
        Textemon playerTextemon;
        boolean win;

        // Water Trial
        System.out.println("\nYou enter the Water Trial chamber, filled with the sound of rushing waves.");
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("Prepare for the Water Trial with your trusty " + playerTextemon.getName() + "!");

            Battle battle = new Battle(playerTextemon, Water_type.Textemon_W.GYARADOS);
            win = battle.startBattle();
            if (!win) {
                System.out.println("You were defeated in the Water Trial! Your " + playerTextemon.getName() + " fainted.\nTry again with more determination!");
            }
        } while (!win);

        // Electric Trial
        System.out.println("\nYou proceed to the Electric Trial chamber, crackling with energy.");
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("Prepare for the Electric Trial with your trusty " + playerTextemon.getName() + "!");

            Battle battle = new Battle(playerTextemon, Electric_type.Textemon_E.ELECTIVIRE);
            win = battle.startBattle();
            if (!win) {
                System.out.println("You were defeated in the Electric Trial! Your " + playerTextemon.getName() + " fainted.\nTry again with more determination!");
            }
        } while (!win);

        // Grass Trial
        System.out.println("\nYou advance to the Grass Trial chamber, surrounded by lush foliage.");
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("Prepare for the Grass Trial with your trusty " + playerTextemon.getName() + "!");

            Battle battle = new Battle(playerTextemon, Grass_type.Textemon_G.SCEPTILE);
            win = battle.startBattle();
            if (!win) {
                System.out.println("You were defeated in the Grass Trial! Your " + playerTextemon.getName() + " fainted.\nTry again with more determination!");
            }
        } while (!win);

        // Fire Trial
        System.out.println("\nYou reach the Fire Trial chamber, where flames dance with intensity.");
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("Prepare for the Fire Trial with your trusty " + playerTextemon.getName() + "!");

            Battle battle = new Battle(playerTextemon, Fire_type.Textemon_F.INFERNAPE);
            win = battle.startBattle();
            if (!win) {
                System.out.println("You were defeated in the Fire Trial! Your " + playerTextemon.getName() + " fainted.\nTry again with more determination!");
            }
        } while (!win);

        // Resolution
        System.out.println("\nCongratulations! You have conquered the elemental trials.");
        System.out.println("You master the elemental powers and strengthen bonds with your Textemons.");

        // Option to view Textedox or continue the journey
        System.out.println("\nClick (P) and (Enter) to view the Textedox!");
        System.out.println("Press (Space-bar) to continue the journey!");
        String ip;
        Scanner scanner = new Scanner(System.in);
        do {
            ip = scanner.nextLine().trim();
            if (ip.equalsIgnoreCase("P")) {
                System.out.println("Displaying textedox...");
                Textedox.displayAllTextemons("LostRelic");
            } else if (ip.isEmpty()) {
                Partition.display_partition();
                System.out.println(("Continuing the journey..."));
                lostRelic();
            } else {
                System.out.println("Invalid key pressed!");
            }
        } while (!ip.equalsIgnoreCase("P"));
    }

    public static void lostRelic() {
        Partition.display_partition();
        String sq1 = "\033[1mSide Quest 3: Lost Relic\033[0m";
        int width = 160; // Width of the text area
        System.out.println();
        System.out.printf("%" + ((width + sq1.length()) / 2) + "s%n", sq1);
        System.out.println();

        // Introduction
        System.out.println("Legends speak of a lost relic hidden within the depths of a forgotten ruin.");
        System.out.println("Your objective is to discover the relic and unlock its secrets.");

        // Action
        System.out.println("You embark on a journey to the ruins, filled with traps, puzzles, and mysterious electric energies surrounding the relic.");
        System.out.println("As you explore deeper, you feel the crackling energy in the air and hear the distant hum of electric Textemons guarding the relic.");

        // Player's choice of Textemon
        Textemon playerTextemon;
        boolean win;

        // Initial exploration
        System.out.println("\nYou enter the ruins, shrouded in darkness and crackling with electric energy.");
        System.out.println("Suddenly, a wild electric Textemon appears!");

        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("Prepare for battle with your trusty " + playerTextemon.getName() + "!");

            Battle battle = new Battle(playerTextemon, Electric_type.Textemon_E.THUNDERLORD);
            win = battle.startBattle();
            if (!win) {
                System.out.println("You were defeated by the wild Textemon! Your " + playerTextemon.getName() + " fainted.\nKeep exploring and try again!");
            }
        } while (!win);

        // Resolution
        System.out.println("\nAfter a fierce battle, you emerge victorious!");
        System.out.println("You continue your exploration, guided by the crackling energy towards the heart of the ruins.");

        System.out.println("\nYou finally reach the heart of the ruins and discover the lost relic, surrounded by swirling electric currents.");
        System.out.println("As you claim the relic, you feel its electric power resonating with your own.");

        // Option to view Textedox or continue the journey
        System.out.println("\nClick (P) and (Enter) to view the Textedox!");
        System.out.println("Press (Space-bar) to continue the journey!");
        String ip;
        Scanner scanner = new Scanner(System.in);
        do {
            ip = scanner.nextLine().trim();
            if (ip.equalsIgnoreCase("P")) {
                System.out.println("Displaying textedox...");
                Textedox.displayAllTextemons("DarkCitadel");
            } else if (ip.isEmpty()) {
                Partition.display_partition();
                System.out.println(("Continuing the journey..."));
                JourneyStory.darkCitadel();
            } else {
                System.out.println("Invalid key pressed!");
            }
        } while (!ip.equalsIgnoreCase("P"));
    }
    public static void darkCitadel() {
        Partition.display_partition();
        String sq1 = "\033[1mMain Quest 3: Dark Citadel\033[0m";
        int width = 160; // Width of the text area
        System.out.println();
        System.out.printf("%" + ((width + sq1.length()) / 2) + "s%n", sq1);
        System.out.println();

        // Introduction
        System.out.println("Dark clouds gather over the forest as rumors of a sinister citadel emerge.");
        System.out.println("Your objective is to infiltrate the citadel, confront its master, and restore balance.");

        // Action
        System.out.println("You journey into the heart of the forest, facing treacherous halls and dark minions.");
        System.out.println("Along the way, you encounter various challenges and obstacles.");

        // Player's choice of Textemon
        Textemon playerTextemon;
        boolean win;
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("Prepare for the final showdown with your powerful " + playerTextemon.getName() + "!");

            Battle battle = new Battle(playerTextemon, Fire_type.Textemon_F.VOLCARONA);
            win = battle.startBattle();
            if (!win) {
                System.out.println("You were defeated in the final battle! Your " + playerTextemon.getName() + " fainted.\nGather more strength and try again!");
            }
        } while (!win);

        // Resolution
        System.out.println("Congratulations! You confront the citadel's master in an epic showdown.");
        System.out.println("You restore light and peace to the forest, and the defeated Textemons join your team.");

        // Option to view Textedox or continue the journey
        System.out.println("\nClick (P) and (Enter) to view the Textedox!");
        System.out.println("Press (Space-bar) to continue the journey!");
        String ip;
        Scanner scanner = new Scanner(System.in);
        do {
            ip = scanner.nextLine().trim();
            if (ip.equalsIgnoreCase("P")) {
                System.out.println("Displaying textedox...");
                Textedox.displayAllTextemons("GuardiansLegacy");
            } else if (ip.isEmpty()) {
                Partition.display_partition();
                System.out.println(("Continuing the journey..."));
                JourneyStory.guardiansLegacy();
            } else {
                System.out.println("Invalid key pressed!");
            }
        } while (!ip.equalsIgnoreCase("P"));
    }
    public static void guardiansLegacy() {
        Partition.display_partition();
        String sq1 = "\033[1mSide Quest 4: Guardian's Legacy\033[0m";
        int width = 160; // Width of the text area
        System.out.println();
        System.out.printf("%" + ((width + sq1.length()) / 2) + "s%n", sq1);
        System.out.println();

        // Introduction
        System.out.println("The player discovers remnants of the guardian's legacy scattered across the forest.");
        System.out.println("Your objective is to locate the guardian's artifacts and honor its memory.");

        // Action
        System.out.println("You embark on a journey to search hidden locations and battle guardians protecting the artifacts.");
        System.out.println("Piece together the guardian's story as you uncover the artifacts.");

        // Player's choice of Textemon
        Textemon playerTextemon;
        boolean win;

        // First Battle
        System.out.println("\nYou encounter a guardian's protector, a powerful Grass type Textemon, Venusaur!");
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("Prepare for battle with your trusty " + playerTextemon.getName() + "!");

            Battle battle1 = new Battle(playerTextemon, Grass_type.Textemon_G.VENUSAUR);
            win = battle1.startBattle();
            if (!win) {
                System.out.println("You were defeated in battle! Your " + playerTextemon.getName() + " fainted. Continue your quest with renewed determination!");
            }
        } while (!win);

        // Between Battles
        System.out.println("\nAfter defeating the guardian's protector, you sense another presence guarding the next artifact.");

        // Second Battle
        System.out.println("\nYou encounter another guardian's protector, a formidable Water type Textemon, Blastoise!");
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("Prepare for battle with your trusty " + playerTextemon.getName() + "!");

            Battle battle2 = new Battle(playerTextemon, Water_type.Textemon_W.BLASTOISE);
            win = battle2.startBattle();
            if (!win) {
                System.out.println("You were defeated in battle! Your " + playerTextemon.getName() + " fainted. Continue your quest with renewed determination!");
            }
        } while (!win);

        // Resolution
        System.out.println("\nCongratulations! You have located the guardian's artifacts:");
        System.out.println("- Guardian's Sword");
        System.out.println("- Guardian's Shield");
        System.out.println("- Guardian's Amulet");
        System.out.println("You pay tribute to the guardian, receiving blessings and rare items.");

        // Option to view Textedox or continue the journey
        System.out.println("\nClick (P) and (Enter) to view the Textedox!");
        System.out.println("Press (Space-bar) to continue the journey!");
        String ip;
        Scanner scanner = new Scanner(System.in);
        do {
            ip = scanner.nextLine().trim();
            if (ip.equalsIgnoreCase("P")) {
                System.out.println("Displaying textedox...");
                Textedox.displayAllTextemons("FinalConfrontation");
            } else if (ip.isEmpty()) {
                Partition.display_partition();
                System.out.println(("Continuing the journey..."));
                finalConfrontation();
            } else {
                System.out.println("Invalid key pressed!");
            }
        } while (!ip.equalsIgnoreCase("P"));
    }

    public static void finalConfrontation() {
        Partition.display_partition();
        String sq1 = "\033[1mMain Quest 4: Final Confrontation\033[0m";
        int width = 160; // Width of the text area
        System.out.println();
        System.out.printf("%" + ((width + sq1.length()) / 2) + "s%n", sq1);
        System.out.println();

        // Introduction
        System.out.println("A powerful adversary threatens to plunge the forest into darkness once more.");
        System.out.println("Your objective is to gather allies, confront the adversary, and save the forest.");

        // Action
        System.out.println("Unite with companions met throughout the journey. Strategize and plan battles against formidable foes.");
        System.out.println("Prepare for the final showdown against the adversary.");

        // Player's choice of Textemon
        Textemon playerTextemon;
        boolean win;
        do {
            playerTextemon = Textedox.chooseTextemon();
            System.out.println("Prepare for the final battle with your trusty " + playerTextemon.getName() + "!");

            Battle battle = new Battle(playerTextemon, Electric_type.Textemon_E.ZEKROM);
            win = battle.startBattle();
            if (!win) {
                System.out.println("You were defeated in the final battle! Your " + playerTextemon.getName() + " fainted. Gather your strength and try again!");
            }
        } while (!win);

        // Resolution
        System.out.println("Congratulations! You emerge victorious in the final confrontation.");
        System.out.println("Your newfound powers and teamwork ensure peace for the forest.");
        System.out.println("Thank you for playing! This marks the end of your journey in the forest.");

        Partition.display_partition();
        System.out.println("Game by - Deep Raval - 202303058 and Megh Jagtap - 202303040");

        // End of the game
        System.exit(0);
    }

}