
/**
 * YAPG - Yet Another Password Generator
 * A password generator that barely anyone (no one) will use
 * 
 * @author Sebastian Alejandro, Borjan Palankov
 * @version 0.0.1
 * @since 2019-05-29
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Password {
    /**
     * Main method for generating password
     * 
     * @return simple or complex password
     */
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

    /**
     * Method genComplex
     *
     * @return Final complex password
     */
    private static String genComplex() {
        /*
         * This will generate a complex password, such as "S3AZ$C@Y7z$&!x"
         */

        Random rand = new Random();

        int a = 0;
        int b = 0;
        int c = 0;
        int charSelector;
        int upperOrLower;

        String finalComplexPassword = "";
        charSelector = rand.nextInt(4);
        upporOrLower = rand.nextInt(2);
        /* using CHAR, gen a random num (0 or 1), and either keep it as it is, or use .toUpperCase() */
        final String[] CHARS = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q","r", "s", "t", "u", "v", "w", "x", "y", "z" }; /* 0 -> 25 */
        final String[] NUMBERS = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" }; /* 0 -> 9 */
        final String[] SPECIAL_CHARS = {"!","@","#","$","%","^","&","*","(",")","_","-","+"}; /* 0 -> 12 */


        if (charSelector == 1)  { /* CHARS */
            if (upperOrLower == 0) {
                
            }
        } else if (charSelector == 2) { /* NUMBERS */
        
        } else if (charSelector == 3) { /* SPECIAL_CHARS */
            
        }


        /*         for (int i = 0; i < 3; i++) {
            a = (0+(int)(Math.random()* CHARS.length));
            b = (0+(int)(Math.random()* NUMBERS.length));
            c = (0+(int)(Math.random()* SPECIAL_CHARS.length));
    
        } */
        
        finalComplexPasword = (CHARS [a] + NUMBERS [b] + SPECIAL_CHARS [c]);
        
        return finalComplexPassword;
    }

    /**
     * Method genSimple
     *
     * @return Final simple password
     */
    private static String genSimple() {
        /*
         * This will generate a simple pasword, such as "emperor blaming broadband" or
         * "reusable-hurled-eggbeater"
         */

        String finalSimplePassword = " ";
        String separator;

        ArrayList<String> dict = readDict();

        if (dict == null) { /* when dict is null, program exits */
            System.err.print("Could not find wordlist, exiting.");
            System.exit(0);
        }

        return finalSimplePassword;
    }

    /**
     * Method readDict
     *
     * @return null if "wordlist.txt" cannot be found
     * @return dict array if wordlist can be found
     */
    private static ArrayList<String> readDict () { 
        /*
         * What is an ArrayList and how is it different than a normal array?
         * 
         * An ArrayList is a mutable array, found in the java.util 
         */
        ArrayList<String> dict = new ArrayList();
        /* If the file "wordlist.txt" could not be found, it will return null, or the actual array if the file can be found */
        /* Should it fail, it will let the user know, and fail. */
        
        /* 
         * What is try and catch?
         * 
         * try: The try statement allows you to define a block of code to be tested for errors while it is being executed.
         * catch: The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
         * 
         */
        try {
            Scanner reader = new Scanner(new File("wordlist.txt"));  /* Did you know: Scanner is able to scan files using File I/O! */

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
