
/**
 * Password Project
 * STEP 1: Display a menu of options

    The menu of options (see the Sample Output for details) should provide three options:

    Choice1:
    Show the password specifications

    Choice2: Generate a random password
    The first two characters are lowercase letters
    The second two characters are uppercase letters
    The third two characters are numbers (0 - 9)
    The fourth two characters are any valid character

    Choice3: Valid or Invalid
    It must be at least 8 characters long
    At least one letter must be capitalized
    It must contain at least 2 numbers

    STEP 2: Run the appropriate code based on the input from the user

    if statements will be used to decide which method will be called.
 *
 * @author Christ Aerji Dampog
 * @since Oct 23, 2025
 */

import java.util.Scanner;
import java.util.Random;

public class Password {

    // ======== Global Variable ========\\
    static int Seed;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayMenu();

        System.out.println("Please make your selection:");
        int choice = scanner.nextInt();

        if (choice == 1) { // display password specifications to the user
            showPasswordSpecifications();
        } else if (choice == 2) { // generate a random password for the user
            System.out.println("\nEnter Seed:");
            Seed = scanner.nextInt();

            String RandomGeneratedPassword = Password.generateRandomPassword(Seed);

            System.out.println("\nYour password is: " + RandomGeneratedPassword);
        } else if (choice == 3) { // ask the user to input a password and test for validity
            System.out.println("\nEnter a password to test:");
            scanner.nextLine();
            String UserPassword = scanner.nextLine();

            if (verifyPasswordSpecifications(UserPassword) == true) {
                System.out.println("\nYour password is valid.");
            } else {
                System.out.println("\nYour password is NOT valid.");
            }
        } else {
            System.out.println("\nSorry! That was an invalid option.");
        }

        scanner.close();
    }

    // ===========================Methods===========================\\
    
    public static void displayMenu() {
        System.out.println("""
                \nHere is your menu of options:
                    1. See the password rules
                    2. Generate a random password
                    3. Test the validity of a password
                            """);
    }

    public static void showPasswordSpecifications() {
        System.out.println("""
                \nThe rules for your password are:
                    1. It must be at least 8 characters long
                    2. At least one letter must be capitalized
                    3. It must contain at least 2 numbers
                              """);

    }

    public static String generateRandomPassword(int num) {
        Random random = new Random(num);

        String RNGPassword = "";

        // ASCII Lowercase Letters (97-122)
        RNGPassword += (char) (random.nextInt(25 + 1) + 97);
        RNGPassword += (char) (random.nextInt(25 + 1) + 97);
        // ASCII Uppercase Letters (65-90)
        RNGPassword += (char) (random.nextInt(25 + 1) + 65);
        RNGPassword += (char) (random.nextInt(25 + 1) + 65);
        // ASCII Numbers (48-57)
        RNGPassword += (char) (random.nextInt(9 + 1) + 48);
        RNGPassword += (char) (random.nextInt(9 + 1) + 48);
        // ASCII Special Characters (33-126)
        RNGPassword += (char) (random.nextInt(93 + 1) + 33);
        RNGPassword += (char) (random.nextInt(93 + 1) + 33);

        return RNGPassword;

    }

    public static boolean verifyPasswordSpecifications(String input) {

        //===============Verificaiton 1===============\\

        Boolean Verification1;

        if (input.length() >= 8) {
            Verification1 = true;
        } else {
            Verification1 = false;
        }

        //===============Verificaiton 2 and 3===============\\
        
        int UppercaseValidPoints = 0;
        int NumberValidPoints = 0;

        int Line = 0;
        int TotalLine = input.length();

        Boolean Verification2;
        Boolean Verification3;

        while (Line < TotalLine) {  
            int CharactersDecimal = input.charAt(Line); // Turns Char into Decimals?
            char Words = (char)CharactersDecimal; // Decimals into Char?

            //ASCII Uppercase (65-90)
            if (CharactersDecimal >= 65 && CharactersDecimal <= 90) {
                UppercaseValidPoints++;
            } else if (CharactersDecimal >= 48 && CharactersDecimal <= 57) {
                NumberValidPoints++;
            }
            Line++;
        }
          
            
        if (UppercaseValidPoints > 0) {
            Verification2 = true;
        } else {
            Verification2 = false;
        }

        if(NumberValidPoints >= 2) {
            Verification3 = true;
        } else {
            Verification3 = false;
        }

        //===============Final Verification===============\\

        Boolean FinalVerification;

        if (Verification1 == true && Verification2 == true && Verification3 == true) {
            FinalVerification = true;
        } else {
            FinalVerification = false;
        }

        return FinalVerification;

        /* How does the Choice 3 works?
         * 
         * First Phase: 
         *  User input is gathered.
         * 
         * Second Phase:
         *  It analayzes and defines the length of the string which is Verification1.
         * 
         * Third Phase:
         *  The string is checked by each single char using CharAt(location) to locate each Char inside a 
         *  string while using the While statement and add location++ until its greater than the length of
         *  the input. 
         *  
         *  by locating each char in a string. the char is then concaneted into an int which can be defined as ASCII.
         *  
         *  ASCII Uppercase (65-90)
         *  ASCII Numbers (48-57)
         *  
         *  If the int is in one of those range, it will add a point to a variable.
         *  
         *  UppercasePoints
         *  NumberPoints
         *  
         *  If UppercasePoints is greater than 0 then it passess the verification.
         *  if Numberpoitns if greater or equal to 2 then it passes the verification.
         *  
         * Fourth Phase:
         *  Each 3 specifications are gathered and if all 3 specifications are true, then it will return as Valid.
         *  if 1 of the specifications are wrong, then its NOT valid.
         * 
         */

    }

}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 * Step 3 is the hardest part. I totally had no idea what is valid and invalid.
 * 
 * I had a hard time figuring out the last 2 characters for Choice 2. i did not
 * know what was the right range in order to get the desired output.
 * After testing and trying out different ranges. i found out that all the
 * typeable characters are 33-126 rather than 32-126. i did not know that
 * space was not included in it.
 * 
 * For Choice 2. i had a hard time making the program to define each char in a string. I was planning to use substring but then i found out charAt() was better.
 * I used charAt() to locate each char in a string and turned thos char into decimals. then used the decimals to make an if statements base on ASCII Table.
 * 
 * the other difficult part that i had was that my code was so hard to read. often forgeting how to use most of what i learned like global variables and 
 * local variables. I had put some data types in every single if statements block making it local.
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 *  I learned how to do While statements trying to define each single char inside a string.
 *  While is a loop statement where it is triggered until it meets what it desires while if statement is only triggered only once.
 * 
 * I will never forget that in order to make a variable into a global variable its data type must be defined and remove its data type in local blocks of code.
 * 
 * 
 * 
 * 
 */
