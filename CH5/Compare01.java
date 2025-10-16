
/**
 * @author Christ Aerjil Dampog
 * @since October 14, 2025
 * 
 * Compare01 - Compare inputted integers from the user and compare the integer to be greater or less than 10.
 */

import java.util.Scanner;

public class Compare01 {
    public static void main(String[] args) {
        compare01();
    }

    public static void compare01() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int INTEGER = scanner.nextInt();

        scanner.close();

        String RESULT = "";

        if (INTEGER > 10) {
            RESULT = "GREATER";
        } else {
            RESULT = "NOT GREATER";
        }

        System.out.println("The number " + INTEGER + " is " + RESULT + " than 10.");
        System.out.println("Program finished!");

    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 * mistakin the greater than and less than signs
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 * when its an int, it can be == or >= or <= or > or < or !=. But if its a string, you have to do the Variable.equals("");
 * 
 * 
 * 
 * 
 */