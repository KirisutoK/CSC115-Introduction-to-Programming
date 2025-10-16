
/**
 * Salt Password Lab Ch4
 *
 * @author Christ Aerjil Dampog
 * @since October 14, 2025
 */

import java.util.Scanner;
import java.util.Random;

public class SaltPassword {
    public static void main(String[] args) {
        saltIt();
    }

    public static void saltIt() {

        // ========== INSERT YOUR CODE HERE ==========//
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter seed:");
        int SEED = scanner.nextInt();

        System.out.println("Enter a password:");
        String PASSWORD = scanner.next();

        scanner.close();

        // --------------------------------------------//

        Random random = new Random(SEED);

        String SALT = "";

        SALT += (char)(random.nextInt(57 + 1) + 65);
        SALT += (char)(random.nextInt(57 + 1) + 65);
        SALT += (char)(random.nextInt(57 + 1) + 65);
        SALT += (char)(random.nextInt(57 + 1) + 65);
        SALT += (char)(random.nextInt(57 + 1) + 65);

        // ASCII from A to z (65-122)
        // (Options + 1) + StartingNumber
        // The +1 is needed

        System.out.println("Salt: " + SALT);
        System.out.println("Salted password: " + PASSWORD + SALT);


        // =========================================== //

    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 * i had a hard time generating 5 random characters and converting them into chars on a single line.
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 * I will never forget that String is a data type consisting for multiple characters(char)
 * which allows each representative of char inside a string can be manipulated.
 * 
 * 
 * 
 * 
 */
