public class Intro_screen {
    public static void display_intro(){


        String game_name = "\033[1mTextemon Journey\033[0m";
        String catch_phrase = "Gotta code em' all!!";
//        System.out.println(game_name);
        /*\033: This is an escape sequence in octal notation. It represents the ASCII control character ESC (Escape), which has the octal value 033 (27 in decimal).

[1m: This is an ANSI escape code for turning on bold text. In ANSI escape code sequences, [ indicates the beginning of an escape sequence, 1 indicates the attribute for bold, and m marks the end of the escape sequence.

Bold Text: This is the actual text that you want to display in bold.

\033[0m: This is another ANSI escape code that resets the text attributes to their default values. Similar to before, \033 represents the ESC character, [0 resets all text attributes, and m marks the end of the escape sequence.*/

//        String centerAlignedText = "Textemon Journey";
        int width = 160; // Width of the text area
        System.out.printf("%" + ((width + game_name.length()) / 2) + "s%n", game_name);
        System.out.printf("%" + ((width - 5 + catch_phrase.length())/2) + "s%n", catch_phrase);
//        System.out.printf("%" + width + "s%n", game_name); right align
//        System.out.printf("%-" + width + "s%n", game_name); left align
        String entry = "Press (Space-bar) and (Enter) to proceed to Main-Menu!";
        System.out.println();
        System.out.println();
        System.out.printf("%" + ((width - 4 + entry.length()) / 2) + "s%n", entry);

    }
}
