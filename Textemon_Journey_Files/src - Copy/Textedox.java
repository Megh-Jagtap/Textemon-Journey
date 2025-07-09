/*
import java.util.*;

public class Textedox {
    private static final List<Textemon> allTextemons = new ArrayList<>();
    private static final List<Textemon> foundTextemons = new ArrayList<>();

    // Add Electric type Pokémon
    private static final List<Electric_type> electricTextemons = new ArrayList<>();
    static {
        electricTextemons.add(Electric_type.Textemon_E.PIKACHU);
        electricTextemons.add(Electric_type.Textemon_E.RAICHU);
        electricTextemons.add(Electric_type.Textemon_E.ZOLTEON);
        // Add more Electric type textemons as needed
        allTextemons.addAll(electricTextemons);
    }

    // Add Fire type Pokémon
    private static final List<Fire_type> fireTextemons = new ArrayList<>();
    static {
        fireTextemons.add(Fire_type.Textemon_F.CHARMENDAR);
        fireTextemons.add(Fire_type.Textemon_F.NINETALES);
        fireTextemons.add(Fire_type.Textemon_F.ARCANINE);
        // Add more Fire type textemons as needed
        allTextemons.addAll(fireTextemons);
    }

    // Add Grass type Pokémon
    private static final List<Grass_type> grassTextemons = new ArrayList<>();
    static {
        grassTextemons.add(Grass_type.Textemon_G.BULBOSAUR);
        grassTextemons.add(Grass_type.Textemon_G.EXEGGUTOR);
        grassTextemons.add(Grass_type.Textemon_G.VICTREEBEL);
        // Add more Grass type textemons as needed
        allTextemons.addAll(grassTextemons);
    }

    // Add Water type Pokémon
    private static final List<Water_type> waterTextemons = new ArrayList<>();
    static {
        waterTextemons.add(Water_type.Textemon_W.BLASTOISE);
        waterTextemons.add(Water_type.Textemon_W.SQUIRTLE);
        waterTextemons.add(Water_type.Textemon_W.VAPOREON);
        // Add more Water type textemons as needed
        allTextemons.addAll(waterTextemons);
    }

    public static void displayAllTextemons() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which type of Pokémon do you want to see?");
        System.out.println("1. Electric type");
        System.out.println("2. Fire type");
        System.out.println("3. Grass type");
        System.out.println("4. Water type");
        System.out.println("5. All available textemons");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                displayTextemons(electricTextemons);
                break;
            case 2:
                displayTextemons(fireTextemons);
                break;
            case 3:
                displayTextemons(grassTextemons);
                break;
            case 4:
                displayTextemons(waterTextemons);
                break;
            case 5:
                displayTextemons(allTextemons);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void displayTextemons(List<? extends Textemon> textemons) {
        System.out.println();
        for (Textemon textemon : textemons) {
            if (textemon.isFound()) {
                textemon.display();
                System.out.println();
            } else {
                System.out.println("The Textemon: " + textemon.getName() + " has not been found yet.");
            }
        }
//        System.out.println("testing, here i have to keep the optionto go back to main menu.");
        System.out.println("\nPress (M) to go back to Main-Menu!");
        Scanner input = new Scanner(System.in);
        String ip;
        do{
            ip = input.nextLine();
            if(ip.equals("M")){
                System.out.println();
                Partition.display_partition();
                Main_menu.display_MainMenu();
                break;
            }
            else {
                System.out.println("Invalid key pressed!");
            }
        }while(ip != "M");
    }

    public static Textemon chooseTextemon() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Select a Textemon to use:");
            for (int i = 0; i < foundTextemons.size(); i++) {
                System.out.println((i + 1) + ". " + foundTextemons.get(i).getName());
            }
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            if (choice < 1 || choice > foundTextemons.size()) {
                System.out.println("Invalid choice. Please choose a Textemon from the list.");
            }
        } while (choice < 1 || choice > foundTextemons.size());
        return foundTextemons.get(choice - 1);
    }

    public static void addFoundTextemon(Textemon textemon) {
        foundTextemons.add(textemon);
    }
}
*/
import java.util.*;

public class Textedox {
    private static final List<Textemon> allTextemons = new ArrayList<>();
    private static final List<Textemon> foundTextemons = new ArrayList<>();

    // Add Electric type Pokémon
    private static final List<Electric_type> electricTextemons = new ArrayList<>();
    static {
        electricTextemons.add(Electric_type.Textemon_E.PIKACHU);
        electricTextemons.add(Electric_type.Textemon_E.ELECTIVIRE);
        electricTextemons.add(Electric_type.Textemon_E.THUNDERLORD);
        electricTextemons.add(Electric_type.Textemon_E.ZEKROM);
        // Add more Electric type textemons as needed
        allTextemons.addAll(electricTextemons);
    }

    // Add Fire type Pokémon
    private static final List<Fire_type> fireTextemons = new ArrayList<>();
    static {
        fireTextemons.add(Fire_type.Textemon_F.CHARMENDAR);
        fireTextemons.add(Fire_type.Textemon_F.CHARIZARD);
        fireTextemons.add(Fire_type.Textemon_F.INFERNAPE);
        fireTextemons.add(Fire_type.Textemon_F.VOLCARONA);
        allTextemons.addAll(fireTextemons);
    }

    // Add Grass type Pokémon
    private static final List<Grass_type> grassTextemons = new ArrayList<>();
    static {
        grassTextemons.add(Grass_type.Textemon_G.BULBOSAUR);
        grassTextemons.add(Grass_type.Textemon_G.FORESTOX);
        grassTextemons.add(Grass_type.Textemon_G.SCEPTILE);
        grassTextemons.add(Grass_type.Textemon_G.VENUSAUR);
        // Add more Grass type textemons as needed
        allTextemons.addAll(grassTextemons);
    }

    // Add Water type Pokémon
    private static final List<Water_type> waterTextemons = new ArrayList<>();
    static {
        waterTextemons.add(Water_type.Textemon_W.SQUIRTLE);
        waterTextemons.add(Water_type.Textemon_W.TOTODILE);
        waterTextemons.add(Water_type.Textemon_W.GYARADOS);
        waterTextemons.add(Water_type.Textemon_W.BLASTOISE);
        // Add more Water type textemons as needed
        allTextemons.addAll(waterTextemons);
    }

    public static void displayAllTextemons(String source) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which type of Pokémon do you want to see?");
        System.out.println("1. Electric type");
        System.out.println("2. Fire type");
        System.out.println("3. Grass type");
        System.out.println("4. Water type");
        System.out.println("5. All available textemons");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                displayTextemons(electricTextemons, source);
                break;
            case 2:
                displayTextemons(fireTextemons, source);
                break;
            case 3:
                displayTextemons(grassTextemons, source);
                break;
            case 4:
                displayTextemons(waterTextemons, source);
                break;
            case 5:
                displayTextemons(allTextemons, source);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void displayTextemons(List<? extends Textemon> textemons, String source) {
        System.out.println();
        for (Textemon textemon : textemons) {
            if (textemon.isFound()) {
                textemon.display();
                System.out.println();
            } else {
                System.out.println("The Textemon: " + textemon.getName() + " has not been found yet.");
            }
        }
        if (source.equals("MainMenu")) {
            System.out.println("\nPress (M) to go back to Main-Menu!");
        } else {
            System.out.println("\nPress (B) to go back to the previous part of the story.");
        }
        Scanner input = new Scanner(System.in);
        String ip;
        do {
            ip = input.nextLine();
            if (source.equals("MainMenu") && ip.equals("M")) {
                System.out.println();
                Partition.display_partition();
                Main_menu.display_MainMenu();
                break;
            } else if (!source.equals("MainMenu") && ip.equals("B")) {
                System.out.println();
                Partition.display_partition();
                // Navigate back to the previous part of the story
                navigateBackToStory(source);
                break;
            } else {
                System.out.println("Invalid key pressed!");
            }
        } while (true);
    }

    private static void navigateBackToStory(String source) {
        // Add logic to navigate back to the specific part of the story based on the source
        // For simplicity, let's assume it prints a message indicating the navigation
        switch (source) {
            case "HelpingHand":
                System.out.println("Navigating back to the Helping Hand quest...");
                JourneyStory.helpingHand();
                break;
            case "ForestExploration":
                System.out.println("Navigating back to the Forest Exploration quest...");
                JourneyStory.forestExploration();
                break;
            case "GuardiansChallenge":
                System.out.println("Navigating back to the Guardians Challenge quest...");
                JourneyStory.guardiansChallenge();
                break;
            case "ElementalTrials":
                System.out.println("Navigating back to the Elemental Trials quest...");
                JourneyStory.elementalTrials();
            case "LostRelic":
                System.out.println("Navigating back to the Lost Relic quest...");
                JourneyStory.lostRelic();
            case "DarkCitadel":
                System.out.println("Navigating back to the Dark Citadel quest...");
                JourneyStory.darkCitadel();
            case "GuardiansLegacy":
                System.out.println("Navigating back to the Guardians Legacy quest...");
                JourneyStory.guardiansLegacy();
            case "FinalConfrontation":
                System.out.println("Navigating back to the Final Confrontation quest...");
            default:
                System.out.println("Invalid source. Unable to navigate back.");
        }
    }

    public static Textemon chooseTextemon() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Select a Textemon to use:");
            for (int i = 0; i < foundTextemons.size(); i++) {
                System.out.println((i + 1) + ". " + foundTextemons.get(i).getName());
            }
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            if (choice < 1 || choice > foundTextemons.size()) {
                System.out.println("Invalid choice. Please choose a Textemon from the list.");
            }
        } while (choice < 1 || choice > foundTextemons.size());
        return foundTextemons.get(choice - 1);
    }

    public static void addFoundTextemon(Textemon textemon) {
        foundTextemons.add(textemon);
    }
}
