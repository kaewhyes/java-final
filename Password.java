
/**
 * @author Sebastian Alejandro, Borjan Palankov
 * @version 2019-05-29
 */

import java.util.Scanner;
import java.util.Random;

public class Password {
    public static void main(String[] args) {

        int selection = 0;

        Scanner in = new Scanner(System.in);
        
        System.out.printf("Hello, and Welcome to: \n\n");
        
        System.out.println(" #     #    #    ######   ##### ");
        System.out.println("  #   #    # #   #     # #     #");
        System.out.println("   # #    #   #  #     # #      ");
        System.out.println("    #    #     # ######  #  ####");
        System.out.println("    #    ####### #       #     #");
        System.out.println("    #    #     # #       #     #");
        System.out.println("    #    #     # #        ##### ");

        System.out.println("\nWould you like a complex or simple  password?");
        System.out.println("Please press \"1\" for  a complex, or \"2\" for a simple password");



        if (in.hasNextInt()){
            selection = in.nextInt();
            
            if (selection == 1) {
                System.out.println("Complex password selected.");
                in.close();
            }

            if (selection == 2) {
                System.out.println("Simple password selected");
                in.close();
            }

            if (selection != 1 || selection != 2) {
                System.out.println("Unknown");
            }
        }  
    }

    public String genComplex ( ) {
        /* 
         * This will generate a complex password, such as "S3AZ$C@Y7z$&!x" 
         */
        String finalpasswd = "";
        final String CHARS_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String CHARS_LOWER = "abcdefghijklmnopqrstuvwxyz";
        final String SPECIAL_CHARS = "!@#$%^&*()_-.";
        final String NUMBERS = "1234567890";

        return finalpasswd;
    }

    public String genSimple() {
        /*
         * This will generate a simple pasword, such as "emperor blaming broadband" or
         * "reusable-hurled-eggbeater"
         */
        String finalpasswd = "";
        String separator;

        return finalpasswd;
    }
}