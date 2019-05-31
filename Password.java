
/**
 * YAPG - Yet Another Password Generator
 * A password generator that barely anyone (no one) will use
 * 
 * @author Sebastian Alejandro, Borjan Palankov
 * @version 0.0.1
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) {

        String selection = "";
        boolean running = true;

        Scanner in = new Scanner(System.in);

        System.out.printf("Hello, and Welcome to: \n\n");

        System.out.println(" #     #    #    ######   ##### "); /* Please appreciate this, it took me like 30 mins */
        System.out.println("  #   #    # #   #     # #     #"); 
        System.out.println("   # #    #   #  #     # #      ");
        System.out.println("    #    #     # ######  #  ####");
        System.out.println("    #    ####### #       #     #");
        System.out.println("    #    #     # #       #     #");
        System.out.println("    #    #     # #        ##### ");

        System.out.println("\nWould you like a complex or simple  password?");
        System.out.println("Please type \"complex\" for a complex password, or \"simple\" for a simple password, or press \"Q\" to quit.");

        while (running) { /* will constantly run until the user exits */
            if (in.hasNext()) {
                selection = in.next();
                if (selection.equalsIgnoreCase("complex")) {
                    System.out.println("Complex password selected.");
                    System.out.println("Your password is ");
                    genComplex();
                } else if (selection.equalsIgnoreCase("simple")) {
                    System.out.println("Simple password selected");
                    System.out.print("Your password is ");
                    genSimple();
                } else if (selection.equalsIgnoreCase("q")) {
                    System.out.println("Exiting YAPG.");
                    running = false;
                } else {
                    System.out.println("Unknown Input. Please put in a correct password type, either \"complex\" or \"simple\". ");
                }
            } 
        }
    }

    private static String genComplex() {
        /*
         * This will generate a complex password, such as "S3AZ$C@Y7z$&!x"
         */
        String finalpasswd = "";
        // using CHAR_LOWER, gen a random num (0 or 1), and either keep it as it is, or use .toUpperCase()
        final String[] CHARS = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q","r", "s", "t", "u", "v", "w", "x", "y", "z" };
        final String[] SPECIAL_CHARS = { "!", "@", "#", "$", "%", "^", "&", ",", "(", ")", "_", "-", ",", "." };
        final String[] NUMBERS = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

        Random rand = new Random();

        return finalpasswd;
    }

    private static String genSimple() {
        /*
         * This will generate a simple pasword, such as "emperor blaming broadband" or
         * "reusable-hurled-eggbeater"
         */

        String finalpasswd = " ";
        String separator;

        ArrayList<String> dict = readDict();

        if (dict == null) { /* when dict is null, program exits */
            System.err.print("Could not find wordlist, exiting.");
            System.exit(0);
        }

        return finalpasswd;
    }

    private static ArrayList<String> readDict () {

        ArrayList<String> dict = new ArrayList();
        /* If the file "wordlist.txt" could not be found, it will return null, or the actual array if the file can be found */
        /* Should it fail, it will let the user know, and fail. */
        try {
            Scanner reader = new Scanner(new File("wordlist.txt"));  

            while (reader.hasNext()) {
                dict.add(reader.nextLine());
            }

            return dict;
        } catch (Exception e) {
            System.out.printf("Could not find file\n");
        }
        return null;
    }
}
