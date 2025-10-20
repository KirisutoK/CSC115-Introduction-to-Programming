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
    public static void main(String[] args) {
        quotes();
    }

    public static void quotes() {

        Scanner scanner = new Scanner(System.in);

        // ========== INSERT YOUR CODE HERE ==========

        System.out.println("Enter a number 1-10:");
        int CHOICES = scanner.nextInt();

        switch (CHOICES) {
            case 1:
                System.out.println("QUOTE 1:");
                System.out.println("Get busy living, or get busy dying.");
                System.out.println("Thank you for getting cultured.");
                break;

            case 2:
                System.out.println("QOUTE 2:");
                System.out.println("What are you so hesitant about?");
                System.out.println("Its your dream isn't it?");
                break;

            case 3:
                System.out.println("QUOTE 3:");
                System.out.println("If you don't take risks.");
                System.out.println("You can't create a future.");
                break;

            case 4:
                System.out.println("QUOTE 4:");
                System.out.println("Do or do not. There is no try.");
                System.out.println("Thank you for getting cultured.");
                break;

            case 5:
                System.out.println("QUOTE 5:");
                System.out.println("Push through the pain.");
                System.out.println("Giving up hurts more.");
                break;

            case 6:
                System.out.println("QUOTE 6:");
                System.out.println("Hardwork is worthless.");
                System.out.println("For those that don't believe in themselves.");
                break;

            case 7:
                System.out.println("QUOTE 7:");
                System.out.println("The important thing is not how long you live.");
                System.out.println("It's what you accomplish with your life.");
                break;

            case 8:
                System.out.println("QUOTE 8:");
                System.out.println("If you never listen to anyone.");
                System.out.println("You can't give proper advice.");
                break;

            case 9:
                System.out.println("QUOTE 9:");
                System.out.println("Sometimes you need a little wishful thinking.");
                System.out.println("To keep on living.");
                break;

            case 10:
                System.out.println("QUOTE 10:");
                System.out.println("Clever girl.");
                System.out.println("Thank you for getting cultured.");
                break;
        }

        // ===========================================

        scanner.close();

    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 *  I had a hard time figuring out which variable to use for the switch. I also recently changed from
 *  Google Cloud Shell to GITHUB and it was kinda difficult to maneuver and utilizing its capabilities
 *  to its fullest.
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 *  I just realized that the colors in the code help use identify what type of data is the word is. 
 *  Since i am using Dark+ Defualt. the green represents an int value. Classes are colored darker green.
 *  and Variables are colored light blue which helps us write code in a comprehensible and understandable
 *  way enhancing how the programmer will create the code in a better visual pattern.
 * 
 * 
 * 
 * 
 */
