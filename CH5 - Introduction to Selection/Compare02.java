
/**
 * @author Christ Aerjil Dampog
 * @since October 14, 2025
 * 
 * Compare02 - Compare inputted integers from the user and compare another integer  from the user to define if its greater or less.
 */

import java.util.Scanner;

public class Compare02 {
    public static void main(String[] args) {
        compare02();
    }

    public static void compare02() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int INTEGER1 = scanner.nextInt();

        System.out.println("Enter another integer:");
        int INTEGER2 = scanner.nextInt();


        scanner.close();

        if (INTEGER1 > INTEGER2) {
            System.out.println("The number " + INTEGER1 + " is GREATER than " + INTEGER2); 
        } else if (INTEGER1 == INTEGER2) {
            System.out.println("The two numbers are equal");
        } else {
            System.out.println("The number " + INTEGER1 + " is LESS than " + INTEGER2);
        }
        
        System.out.println("Program finished!");

    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 * Figuring out where to put the Print Statement for ifs
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 * If Statements are conditional so it likes a switch, if true then print if not then no. 
 * 
 * 
 * 
 * 
 */