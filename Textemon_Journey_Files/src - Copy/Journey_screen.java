public class Journey_screen {
    public static void display_journey(){
        Partition.display_partition();
        System.out.println("Welcome, Textemon Trainer!");
        System.out.println("Your training is now over and your journey is about to begin.");
        System.out.println("Now it is time for you to decide which textemon you would like to choose to embrace your journey with!");
        System.out.println("You have three options, so choose wisely.");
        System.out.println();

        String pika = "Press \033[1m(P)\033[0m and (Enter) to choose \033[1mPikachu\033[0m";
        String squirtle = "Press \033[1m(S)\033[0m and (Enter) to choose \033[1mSquirtle\033[0m";
        String bulbosaur = "Press \033[1m(B)\033[0m and (Enter) to choose \033[1mBulbosaur\033[0m";

        int width = 160;

        System.out.printf("%-" + width + "s%n", pika);
        System.out.printf("%-" + width + "s%n", squirtle);
        System.out.printf("%-" + width + "s%n", bulbosaur);

        Input_Scanner.Journey_scan();
    }
}