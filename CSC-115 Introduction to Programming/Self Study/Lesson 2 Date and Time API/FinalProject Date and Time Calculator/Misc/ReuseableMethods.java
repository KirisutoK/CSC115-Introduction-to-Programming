package Misc;// Creation Date: August 21, 2026. at 10:50 PM
// Last Modified: August 27, 2026. at 10:10 AM

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReuseableMethods {
    //=======VARIABLES=======//
    static Scanner input = new Scanner(System.in);

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public static int getAnswer(int start, int end) {
        boolean ValidAnswer = false; //... Placeholders
        int Answer = 0; //... Placeholders
        while (!ValidAnswer) {
            try {
                System.out.print("Answer: ");
                Answer = input.nextInt();
                input.nextLine(); // Refreshes buffer
                if (Answer < start || Answer > end) {
                    throw new InputMismatchException();
                }

                ValidAnswer = true;
            } catch (InputMismatchException e) {
                System.out.println("Please choose between "+start+" through "+end);
                input.nextLine(); // Refreshes buffer
            }
        }

        return Answer;
    }
    public static String lineAutoSpacing(String line, int width) {
        // DISPLAY
        int totalWidth = width;
        int spacesNeeded = Math.max(0, totalWidth - line.length() - 1); // NOTE: (spacesNeeded = totalWidth - prefixLength - usernameLength - 1) <========= FORMULA BY CLAUDE
        String padding = " ".repeat(spacesNeeded);

        return line + padding + line.toCharArray()[0];
    }
    public static boolean passwordValidation(String Password, int minimum, int maximum, int specialCharacters, int Numbers){

        // Count how many Characters, how many special characters, and numbers
        int CharacterCounts = 0;
        int SpecialCaracterCounts = 0;
        int NumberCharacterCounts = 0;
        for (int i = 0; i < Password.length(); i++) {
            CharacterCounts++;

            // If the character is a special character
            if (!(Character.isLetterOrDigit(Password.charAt(i)) || Character.isWhitespace(Password.charAt(i)))) {
                SpecialCaracterCounts++;
            }

            // If the character is a number
            if (Character.isDigit(Password.charAt(i))) {
                NumberCharacterCounts++;
            }
        }

        // Do Checks
        if (!((CharacterCounts >= minimum && CharacterCounts <= maximum) && SpecialCaracterCounts >= specialCharacters && NumberCharacterCounts >= Numbers)) {
            System.out.println("[ERROR] Invalid Password! must have:");
            System.out.println(minimum+" minimum characters,");
            System.out.println(maximum+" maximum characters,");
            System.out.println(specialCharacters+" special characters minimum,");
            System.out.println(Numbers+" number characters minimum.");
            return false;
        }


        return true;
    }


    // ================================================== OTHER CLASSES ================================================== \\
}

// NOTE: THIS IS JUST TO STORE METHODS THAT ARE UNIVERSALLY USED THROUGHOUT CLASSES
// NOTE: THIS IS A `REUSABLE METHODS FILE`