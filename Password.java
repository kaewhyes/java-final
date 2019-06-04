
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

        System.out.println(" #     #    #    ######   ##### "); // Please appreciate this, it took me like 30 mins
        System.out.println("  #   #    # #   #     # #     #"); 
        System.out.println("   # #    #   #  #     # #      ");
        System.out.println("    #    #     # ######  #  ####");
        System.out.println("    #    ####### #       #     #");
        System.out.println("    #    #     # #       #     #");
        System.out.println("    #    #     # #        ##### ");

        System.out.println("\nWould you like a complex or simple  password?");
        System.out.println("Please type \"complex\" for a complex password, or \"simple\" for a simple password, or press \"Q\" to quit.");

        while (running) { // will constantly run until the user exits

            if (in.hasNext()) {
                selection = in.next();
                if (selection.equalsIgnoreCase("complex")) { 
                    System.out.println("Complex password selected.");
                    System.out.print("Your password is \n");
                    genComplex();
                    System.out.println();
                } else if (selection.equalsIgnoreCase("simple")) {
                    System.out.println("Simple password selected");
                    System.out.print("Your password is \n");
                    genSimple();
                    System.out.println();
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
    private static void genComplex() {
        /*
         * This will generate a complex password, such as "S3AZ$C@Y7z$&!x"
         */

        Random rand = new Random();

        /*
         * What is StringBuilder?
         * 
         * Basic Strings are always immutable, meaning they cannot change. 
         * A StringBuilder is fully mutable, allowing a programmer to append things to a String.
         * 
         */
        StringBuilder finalComplexPassword = new StringBuilder();
        
        int charSelector; // where are we pulling from
        int numSelector; // array num for NUMBERS
        int specialSelector; // array num for SPECIAL_CHARS
        int upperOrLower; // Uppercase, or Lowercase? 
        int alphabetSelector; // array num for CHARS_UPPER/LOWER

        final String[] CHARS_UPPER = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X","Y" ,"Z"}; // 0 -> 25
        final String[] CHARS_LOWER = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q","r", "s", "t", "u", "v", "w", "x", "y", "z"}; // 0 -> 25 
        final String[] NUMBERS = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "0" }; // 0 -> 19
        final String[] SPECIAL_CHARS = {"!", "@" ,"#" ,"$" ,"%" ,"^" ,"&" ,"*" ,"(" ,")" ,"_" ,"-" ,"+", "!", "@" ,"#" ,"$" ,"%" ,"^" ,"&" ,"*" ,"(" ,")" ,"_" ,"-" ,"+"}; // 0 -> 25

        // NUMBERS and SPECIAL_CHARS are repeated in order to give a greater chance 

        for (int i = 0; i < 12; i++) {
            charSelector = 1 + rand.nextInt(3);
            numSelector  = rand.nextInt(20);
            specialSelector = rand.nextInt(26);
            upperOrLower = rand.nextInt(2); // Lower = 0, Upper = 1 
            alphabetSelector = rand.nextInt(26); // A -> Z
            if (charSelector == 1) { // CHAR
                if (upperOrLower == 0) {
                    finalComplexPassword.append(CHARS_LOWER[alphabetSelector]);
                } else {
                    finalComplexPassword.append(CHARS_UPPER[alphabetSelector]);
                }
            } else if (charSelector == 2) {
                finalComplexPassword.append(NUMBERS[numSelector]);
            } else if (charSelector == 3) {
                finalComplexPassword.append(SPECIAL_CHARS[specialSelector]);
            }
            
        }
        
        System.out.print(finalComplexPassword);
    }

    /**
     * Method genSimple
     *
     * @return Final simple password
     */
    private static void genSimple() {
        /*
         * This will generate a simple pasword, such as "emperor blaming broadband" or
         * "reusable-hurled-eggbeater"
         */

        StringBuilder finalSimplePassword = new StringBuilder();
        String separator = " ";
        int dictSize;

        ArrayList<String> dict = readDict();

        if (dict == null) { // when dict is null, program exits
            System.err.print("Could not find wordlist, exiting.");
            System.exit(0);
        } 

        dictSize = dict.size(); // find size of 

        for (int i = 0; i < 4; i++) {
            if (dict == ) {

            }
        }
        System.out.println(finalSimplePassword);
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
         * An ArrayList is a mutable array, found in the java.util package. The user can read and write to the array.
         * 
         * A local array is a immutable array, where the user can only read the array.
         */

        ArrayList<String> dict = new ArrayList();
        /* 
         * If the file "wordlist.txt" could not be found, it will return null, or the actual array if the file can be found. Should it fail, it will let the user know, and fail. 
         */
        
        /* 
         * What is try and catch?
         * 
         * try: The try statement allows you to define a block of code to be tested for errors while it is being executed.
         * catch: The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
         * 
         */

        try {
            Scanner reader = new Scanner(new File("wordlist.txt"));  // Did you know: Scanner is able to scan files using File I/O!

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
