
/**
 * Compliment 02 Lab
 * True or False if Statements
 *
 * @author Christ Aerjil Dampog
 * @since October 14, 2025
 */

import java.util.Scanner;

public class Compliment02 {
    public static void main (String[] args) {
        makeCompliment();
    }

    public static void makeCompliment() {

        // ========== INSERT YOUR CODE HERE ==========

        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like a compliment (\"1\" for YES, \"2\" for NO)?");
        int CHOICES = scanner.nextInt();

        scanner.close();

        if (CHOICES == 1) {
            System.out.println("You are an amazing programmer.");
        }

        System.out.println("Game Over");
        // ===========================================


    }
}


// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    Trying to put the (") inside.



2. What will you always remember (never forget) from this exercise?
the slash techniques are very useful. they are like shortcuts for coding.




*/

