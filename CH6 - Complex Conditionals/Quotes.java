
/**
 * Quotes Lab
 * Asks a user to choose 1-10 and each number will println a statement from a movie which is a quoute.
 * Must use switch.
 *
 * @author Christ Aerjil Dampog
 * @since Oct 20, 2025
 */

import java.util.Scanner;

public class Quotes {
    public static void main (String[] args) {
        quotes(); 
    }

    // this method asks the user for a number and prints a quote
    public static void quotes() {

        Scanner scanner = new Scanner(System.in);

    // ========== INSERT YOUR CODE HERE ==========
        
        System.out.println("Enter a number 1-10:");
        int CHOICES = scanner.nextInt();

        switch(CHOICES) {
            case '1': System.out.println("QUOTE 1:");
            break;
        }







    // ===========================================        

        scanner.close();

    }
}







// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?




2. What will you always remember (never forget) from this exercise?




*/
