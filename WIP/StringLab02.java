package WIP;


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
            System.out.println("\nEnter a number between 0 and 13:");
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
                    System.out.println("Which index (between 0 and " + (PHRASE.length()-1) +") would you like to start with?");
                    int PHRASESUBSTRING6 = scanner.nextInt();

                    if (PHRASESUBSTRING6 < 0) {
                        System.out.println("Invalid");
                    }

                    System.out.println("The new phrase is: \"" + PHRASE.substring(PHRASESUBSTRING6) + "\"");
                break;

                case 2:
                break;

                default: System.out.println("Invalid");
                break;

            }

        break;

        case 7:
        break;

        case 8:
        break;

        default:
            System.out.println("Not a valid number!");
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
