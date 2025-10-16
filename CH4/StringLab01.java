
/**
 * StringLab01 Labs
 *
 * @author Christ Aerjil Dampog
 * @since Oct 14, 2025
 */

import java.util.Scanner;

public class StringLab01 {
    public static void main(String[] args) {
        stringLab();
    }

    public static void stringLab() {

        // ========== INSERT YOUR CODE HERE ==========
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a phrase:\n");
        String PHRASE = scanner.nextLine();

        System.out.println("Please enter a character to search for:\n");
        char CHARACTER = scanner.next().charAt(0);

        scanner.close();

        System.out.println("The length of your String is " + PHRASE.length() + ".");
        System.out.println("The character in the first position is '" + (PHRASE.substring(0, 1)) + "'." );
        System.out.println("The character in the last position is '" + (PHRASE.charAt(PHRASE.length() - 1)) + "'.");
        System.out.println("The first occurrence of '" + CHARACTER + "' is in position " + (PHRASE.indexOf(CHARACTER)+1) + ".");

        // ===========================================

    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 * trying to do the 2 middle part which is finding the specific word of the phrase
 * 
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 * ALWAYS THE PARENTHESIS. i will never forget that parentheis means "to include".
 * 
 * 
 * 
 * 
 */
