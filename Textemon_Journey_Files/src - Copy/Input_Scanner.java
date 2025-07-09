import java.sql.SQLOutput;
import java.util.Scanner;

public class Input_Scanner {

    public static void Intro_scan(){
        System.out.println();
        Scanner input = new Scanner(System.in);

        String intro_key = input.nextLine();
        if(intro_key.equals(" ")){
            System.out.println("Proceeding to Main Menu...");
            System.out.println();
        }
        else{
            System.out.println("Please press (Space-Bar) and (Enter)");
            Intro_scan();
        }
    }

    /*public static void LS_scan(){
        System.out.println();
        Scanner input = new Scanner((System.in));

        String LS_key = input.nextLine();

        if(LS_key.equals("L")){
            Login_screen.login();
        }
        else if(LS_key.equals("S")){
            Login_screen.signup();
        }
        else{
            System.out.println("Invalid key pressed!");
            LS_scan();
        }
    }*/

    public static void MM_scan(){
        System.out.println();
        Scanner input = new Scanner(System.in);

        String MM_key = input.nextLine();

        if(MM_key.equals("1")){
            System.out.println("And a new journey begins!");
            Journey_screen.display_journey();
        } else if (MM_key.equals("2")) {
            System.out.println("Loading preivous saves...");
        } else if (MM_key.equals("3")) {
            System.out.println("Loading Textedox...");
            Partition.display_partition();
            System.out.println();
            Textedox.displayAllTextemons("MainMenu");
//            Textedox.displayAllTextemons(new Player());
        } else if (MM_key.equalsIgnoreCase("E")){
            System.out.println("Exiting the game...");
        } else {
            System.out.println("Invalid key pressed!");
            MM_scan();
        }
    }

    public static void Journey_scan(){
        System.out.println();
        Scanner input = new Scanner(System.in);

        String Journey_key = input.nextLine();

        String chosenTextemon;
        switch (Journey_key) {
            case "P":
                chosenTextemon = "Pikachu";
                Electric_type.Textemon_E.PIKACHU.setFound(true);
                Textedox.addFoundTextemon(Electric_type.Textemon_E.PIKACHU);
                break;
            case "S":
                chosenTextemon = "Squirtle";
                Water_type.Textemon_W.SQUIRTLE.setFound(true);
                Textedox.addFoundTextemon(Water_type.Textemon_W.SQUIRTLE);
                break;
            case "B":
                chosenTextemon = "Bulbosaur";
                Grass_type.Textemon_G.BULBOSAUR.setFound(true);
                Textedox.addFoundTextemon(Grass_type.Textemon_G.BULBOSAUR);
                break;
            default:
                System.out.println("Invalid choice! You didn't choose a Textemon.");
                Journey_scan();
                return;
        }

        System.out.println("\nYou have chosen " + chosenTextemon + " as your starting Textemon!");
        System.out.println("Your journey begins now. Good luck, Trainer!");
        System.out.println("\nClick (Space-bar) and (Enter) to proceed to Tutorial screen.");
        System.out.println("Or click (S) and (Enter) to \033[1mskip the tutorial\033[0m");

        while(!Journey_key.equals(" ")){
            Journey_key = input.nextLine();
            if(Journey_key.equals(" ")){
                Partition.display_partition();
                System.out.println("\nLoading Tutorial...\n");
                Partition.display_partition();
                Instruction_screen.Instruction_screen();
                break;
            } else if (Journey_key.equals(("S"))) {
                Partition.display_partition();
                System.out.println("\nSkipping tutorial...\n");
                System.out.println("Proceeding to journey...\n");
                Partition.display_partition();
                JourneyStory.helpingHand();
                break;
            } else{
                System.out.println("Invalid key pressed");
            }
        }
    }
}