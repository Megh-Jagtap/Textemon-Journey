public class Main_menu {
    public static void display_MainMenu(){
        String game_name = "\033[1mTextemon Journey\033[0m";
        int width = 160;

        System.out.printf("%" + ((width + game_name.length()) / 2) + "s%n", game_name);


        String start = "Press (1) and (Enter) to start the journey!";
        String load_game = "Press (2) and (Enter) to load saved game!";
        String view_pokedex = "Press (3) and (Enter) to view Textedox!";
        String Exit_game = "Press (E) and (Enter) to exit the game!";

        System.out.println();
        System.out.printf("%-" + width + "s%n", start);
        System.out.printf("%-" + width + "s%n", load_game);
        System.out.printf("%-" + width + "s%n", view_pokedex);
        System.out.printf("%-" + width + "s%n", Exit_game);

        Input_Scanner.MM_scan();
    }
}
