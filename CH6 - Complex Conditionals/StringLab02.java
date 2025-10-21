/**
 * StringLab02 Lab
 * 1. Obtain a phrase from the user.
 * 2. Output a menu and capture a choice from the user.
 * 3. Output the result of the operation the user selected
 *
 * @author Christ Aerjil Dampog
 * @since Oct 20, 2025
 */

import java.util.Scanner;

public class StringLab02 {

    public static void main (String[] args) {
        stringMethod();
    }

    public static void stringMethod() {
        Scanner scanner = new Scanner(System.in);

    // ========== INSERT YOUR CODE HERE ==========

    System.out.println("Please enter a phrase:");
    String PHRASE = scanner.nextLine();

    System.out.println("\n1. Find the length of the string");
    System.out.println("2. Perform charAt");
    System.out.println("3. Perform equals");
    System.out.println("4. Perform compareTo");
    System.out.println("5. Perform indexOf");
    System.out.println("6. Perform substring");
    System.out.println("7. Perform toLowerCase");
    System.out.println("8. Perform toUpperCase\n");

    System.out.println("Please make a selection:");
    int SELECTION = scanner.nextInt();

    switch(SELECTION) {
        case 1:
            System.out.println("The length of the phrase is " + PHRASE.length());
        break;

        case 2:
            System.out.println("\nEnter a number between 0 and " + (PHRASE.length()-1)  + ":");
            int NUMBER2 = scanner.nextInt();

            System.out.println("\nThe character at index " + NUMBER2 + " is '" + PHRASE.charAt(NUMBER2) + "'");
        break;

        case 3:
            System.out.println("Enter a phrase that will be compared with \"" + PHRASE + "\":");
            scanner.nextLine();
            String PHRASECOMPARE3 = scanner.nextLine();

            if (PHRASE.equals(PHRASECOMPARE3)) {
                System.out.println("\nThe two phrases DO have the same sequence of characters.");
            } else {
                System.out.println("\nThe two phrases DO NOT have the same sequence of characters.");
            }
        break;

        case 4:
            System.out.println("\nEnter a phrase that will be compared with \"" + PHRASE + "\":");
            scanner.nextLine();
            String PHRASECOMPARE4 = scanner.nextLine();

            int COMPARE4RESULT = PHRASE.compareTo(PHRASECOMPARE4);

            if (COMPARE4RESULT == 0) {
                System.out.println("\nThe two phrases are equivalent.");
            } else if (COMPARE4RESULT > 0) {
                System.out.println("\nAlphabetically, \"" + PHRASE + "\" comes after \"" + PHRASECOMPARE4 + "\"");
            } else {
                System.out.println("\nAlphabetically, \"" + PHRASE + "\" comes before \"" + PHRASECOMPARE4 + "\"");               
            }
        break;

        case 5:
            System.out.println("\nEnter a String to search \"" + PHRASE +"\" for:");
            scanner.nextLine();
            String INDEXOF = scanner.nextLine();

            int INDEXOFRESULT = PHRASE.indexOf(INDEXOF);

            if (INDEXOFRESULT > 0) {
                System.out.println("\nThe first occurence of \"" + INDEXOF + "\" is at index " + INDEXOFRESULT);
            } else {
                System.out.println("\n\"" + INDEXOF + "\" is not in the phrase \"" + PHRASE + "\"");
            }
        break;

        case 6:
            System.out.println("\nChoose one of the methods:");
            System.out.println("1. Create a substring from a selected index until the end");
            System.out.println("2. Create a substring from a selected index until another selected index");

            System.out.println("\nEnter selection:");
            int CHOICE6 = scanner.nextInt();

            switch(CHOICE6) {
                case 1:
                    System.out.println("\nWhich index (between 0 and " + (PHRASE.length()-1) +") would you like to start with?");
                    int PHRASESUBSTRING6 = scanner.nextInt();

                    if (PHRASESUBSTRING6 < 0) {
                        System.out.println("Invalid");
                    }

                    System.out.println("\nThe new phrase is: \"" + PHRASE.substring(PHRASESUBSTRING6) + "\"");
                break;

                case 2:
                    System.out.println("\nWhich index (between 0 and " + (PHRASE.length()-1) + ") would you like to start with?");
                    int PHRASESUBSTRING6START = scanner.nextInt();

                    if (PHRASESUBSTRING6START < 0) {
                        System.out.println("\nInvalid");
                    }

                    System.out.println("\nWhich index (between " + PHRASESUBSTRING6START + " and " + (PHRASE.length()-1) + ") would you like to end with?");
                    int PHRASESUBSTRING6END = scanner.nextInt();

                    if (PHRASESUBSTRING6END > PHRASE.length()) {
                        System.out.println("\nThe total length of the Phrase exceeded the ending number for the substring");
                    }

                    System.out.println("\nThe new phrase is: \"" + PHRASE.substring(PHRASESUBSTRING6START, PHRASESUBSTRING6END) + "\"");
                break;

                default: System.out.println("\nInvalid");
                break;
            }
        break;

        case 7:
            System.out.println("\nAll lowercase looks like this: \"" + PHRASE.toLowerCase() + "\"");
        break;

        case 8:
            System.out.println("\nAll uppercase looks like this: \"" + PHRASE.toUpperCase() + "\"");
        break;

        default:
            System.out.println("\nNot a valid number!");
        break;
    }

    // ===========================================        

        scanner.close();

    }

}

// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    The Hardest part of this lab was trying to remember each statements, although i easily solved most of the issue.
    The CompareTo and IndexOf was the most complicating and confusing one, upon researching from other sources, i found
    out that both of those statements have the result of numbers which is 0 for equal, positive for true and negative
    for false.

    i then used those numbers to range which is true, false, and equal.

2. What will you always remember (never forget) from this exercise?
    I will never forget how switch() can make your code look very nice to read in terms of creating a big block of code.
    If statements are good for short block of codes which i put into some of inside of the case:

    I will never forget the \" and \n which are pretty cool when manipulating the visuals of the output




*/
