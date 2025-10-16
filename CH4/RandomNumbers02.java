/**
 * RandomNumbers02 Lab Work
 * Enter a Seed
 *
 * @author Christ Aerjil Dampog
 * @since Oct 2, 2025
 */

import java.util.Scanner;
import java.util.Random;

public class RandomNumbers02 {

    // --- Global Variables --- //

    public static int Seed;

    // --- --- --- --- --- --- //

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter a seed for the RNG:");
        Seed = scanner.nextInt(); //--Global Variable

        //--Classes
        RNG();
    }

    public static void RNG() {

        Random R = new Random(Seed);

        System.out.println("Random number = " + R.nextInt());
        System.out.println("Random, bounded number = " + (R.nextInt(100)+1));
    }
}

// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    Using the variable in the wrong way and where to put the right things to exactly get the output you want. Including Parenthesis (to determine the scope of the calculation)
    , Range (Maximun and Minimum numbers), and lastly printing it. 
2. What will you always remember (never forget) from this exercise?
    I will never forget that parenthesis are able to make (R.nextInt(100)+1)); into 20. If you take out the outer parenthesis, it will equal to 19 which is the random number for 
    33 in a maximum range of a 100. making the final value of the R.nextInt(100) to be 19 + 1 which results in having no parenthesis meaning it be like 191 like a string. if you
    add a parenthesis like (19+1), it will act like a numerical value which turns into 20.
*/