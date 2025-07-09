import java.util.Scanner;

public class Instruction_screen {
    public static void Instruction_screen() {
        String Chosen_textemon = "default";

        if (Electric_type.Textemon_E.PIKACHU.isFound()){
            Chosen_textemon = "Pikachu";
        }
        else if(Water_type.Textemon_W.SQUIRTLE.isFound()){
            Chosen_textemon = "Squirtle";
        }
        else if(Grass_type.Textemon_G.BULBOSAUR.isFound()){
            Chosen_textemon = "Bulbosaur";
        }
        System.out.println("Hello texter! I am your personal trainer.");
        System.out.println("I will be helping you get used to the controls of this game, it ain't that hard, but its best if you follow through.");
        System.out.println("Ahh, I see you have chosen " + Chosen_textemon + ", are you aware of its special skills!??");

        System.out.println("\nHere are a few basic things that you should know!");
        System.out.println("There are mainly \033[1m four types\33[0m textemons out there in the wild...\n");
        System.out.println("1) Electric type\n2) Water type\n3) Grass type\n4) Fire type\n");
        System.out.println("Each type has unique abilities that are common to each textemon of that type\n");
        System.out.println("Each type of textemon has a slight advantage over the other...");
        System.out.println("Fire has an advantage over Grass (Fire burns Grass).\n" +
                "Grass has an advantage over Electric (Grass grounds Electricity).\n" +
                "Water has an advantage over Fire (Water extinguishes Fire).\n" +
                "Electric has an advantage over Water (Electricity conducts through Water).");

        System.out.println("\n Now keeping that in mind, I will show you what you will encounter in the world out there... \033[1mBe Prepared!!!\033[0m");
        System.out.println("Just a reminder, after defeating each pokemon, you can catch it and add it to your textedex!");

        Scanner scanner = new Scanner(System.in);
        boolean playerwins = false;
        while(true){
            if(Chosen_textemon.equals("Pikachu")){
                Battle trial = new Battle(Electric_type.Textemon_E.PIKACHU, Water_type.Textemon_W.SQUIRTLE);
                playerwins = trial.startBattle();
            }
            else if(Chosen_textemon.equals("Squirtle")){
                Battle trial = new Battle(Water_type.Textemon_W.SQUIRTLE, Fire_type.Textemon_F.CHARMENDAR);
                playerwins = trial.startBattle();
            }
            else if(Chosen_textemon.equals("Bulbosaur")){
                Battle trial = new Battle(Grass_type.Textemon_G.BULBOSAUR, Electric_type.Textemon_E.PIKACHU);
                playerwins = trial.startBattle();
            }
            if(!playerwins){
                System.out.println("You failed the trial run, no need to be ashamed of that... Do you want to try again?\n");
                System.out.println("Type \033[1myes\033[0m to retry or \33[1mno\033[0m to continue...");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("yes")) {
                    System.out.println("Game Over!");
                    Partition.display_partition();
                    System.out.println("Continuing the journey...");
                    Partition.display_partition();
                    JourneyStory.helpingHand();
                    break;
                }
            } else {
                Partition.display_partition();
//                System.out.println("trial won, showcasing the option to open textedox and proceeding to next level");
                System.out.println("Congratulations texter, you have won your first battle, Well Done!\nWith that battle hopefully you would've gotten more familiarised with the way of textemon battles...");
                System.out.println("Its time to check your Textedox to view the textemons you have collected so far!");
                System.out.println("Each textemon you defeat, is added to your Textedox, and further from now on, you can choose which textemon you want to enter the fight with!");
                System.out.println("Press \033[1m(P)\033[0m to view your Textedox!");
                System.out.println("Press (Space-bar) to continue with your journey...");
//                Scanner input = new Scanner(System.in);
                String ip;
                do {
                    ip = scanner.nextLine().trim();
                    if (ip.equalsIgnoreCase("P")) {
                        System.out.println("Displaying textedox...");
                        Textedox.displayAllTextemons("HelpingHand");
                    } else if (ip.isEmpty()) {
                        System.out.println(("Continuing the journey..."));
                        JourneyStory.helpingHand();
                    } else {
                        System.out.println("Invalid key pressed!");
                    }
                } while (!ip.equalsIgnoreCase("P"));
                break; // Exit the loop if the player wins
            }
        }
    }
}
