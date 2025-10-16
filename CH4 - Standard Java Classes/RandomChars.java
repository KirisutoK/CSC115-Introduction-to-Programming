
/**
 * RandomChars Lab Work
 * 
 * Write a program that asks the user for an int and uses it as a seed for the random number generator (Random class). The program should then randomly generate: 
 * > an uppercase letter 
 * > a lowercase letter
 * > a digit between 0 and 9
 *
 * @author Christ Aerjil Dampog
 * @since Oct 2, 2025
 */

import java.util.Scanner;
import java.util.Random;

public class RandomChars {
    public static void main(String[] args) {
       makeRandoms();
    }

    public static void makeRandoms() {

    // ========== INSERT YOUR CODE HERE ==========

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a seed for the random number generator:");
    int USERNUMBER = scanner.nextInt(); 

    scanner.close();
    
    Random random = new Random(USERNUMBER);

    char uppercase = (char)(random.nextInt(26) + 65);
    char lowercase = (char)(random.nextInt(26) + 97);
    char digit = (char)(random.nextInt(10)+48);

    System.out.println("RANDOM:");
    System.out.println("Uppercase = " + uppercase);
    System.out.println("Lowercase = " + lowercase);
    System.out.println("Digit = " + digit);









    // ===========================================        



    }

    public static void practiceString() {
        String username = "Christ Aerjil Dampog";
        String password = "FLCC123456789";
        System.out.println(password.length());
        System.out.println(username.charAt(0));
        System.out.println(username.charAt(9));
        System.out.println(username.indexOf("C"));
        System.out.println(username.indexOf("A"));
        System.out.println(username.indexOf("D"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your Password");
        String response = scanner.nextLine();
        System.out.println(response.equals(password));

        String drink = "Apple Cider";
        System.out.println(drink.substring(0,5));
        System.out.println(drink.substring(6, 11));
        System.out.println(drink.substring(0));

        scanner.close();
      }


}

// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
  Trying to figure out what is ASCII and figuring out ways on how the numerical range value change.

2. What will you always remember (never forget) from this exercise?
  The way to scope a specific range is by adding a starting number by putting +Number at the ending of the statement.

*/

