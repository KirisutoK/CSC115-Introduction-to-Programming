
/**
 * CoinStar Assignment
 *
 * @author Christ Aerjil Dampog
 * @since October 14, 2025
 */

import java.util.Scanner;

public class CoinStar {

    public static void main(String[] args) {
        coins();
    }

    public static void coins() {

        Scanner scanner = new Scanner(System.in);

        // ========== INSERT YOUR CODE HERE ==========

        System.out.println("How many pennies did you insert?");
        int PENNIES = scanner.nextInt();

        scanner.close();

        double DOLLARS = PENNIES / 100.0;
        double PERCENT = DOLLARS * 0.20;
        double FINAL = DOLLARS - PERCENT;

        System.out.println("You have deposited $" + DOLLARS);
        System.out.println("The processing fee is: $" + PERCENT);
        System.out.println("You earned $" + FINAL);

        // ===========================================

    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 *  Trying to figure out the formula and how to get the final answer to match the output of the assignment.
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 *  I will never forget that calculation to get the final output needs to have a certain formula and process in order to function and operate properly. naming your variable
 *  to be comprehensible is also the best way to not get confused.
 * 
 * 
 * 
 */
