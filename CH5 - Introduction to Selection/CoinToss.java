
/**
 * CoinToss Labs
 * User inputs a seed and generate a random integer from 0-9.
 * If less than 5 then its considered heads, else its tails.
 *
 * @author Christ Aerjil Dampog
 * @since Oct 14, 2025
 */
import java.util.Scanner;
import java.util.Random;

public class CoinToss {
    public static void main(String[] args) {
        headsOrTails();
    }

    public static void headsOrTails() {

        // ========== INSERT YOUR CODE HERE ========== //

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a seed:");
        int SEED = scanner.nextInt();

        System.out.println("\nWhat is your guess (H or T)?");
        char GUESS = scanner.next().charAt(0);

        scanner.close();

        if (GUESS == 't'){GUESS = 'T';} else if (GUESS == 'h'){GUESS = 'H';}

        Random random = new Random(SEED);


        int RANDOMNUMBER = random.nextInt(10);
        char HEADSORTAILS;

        if (RANDOMNUMBER < 5) {
            HEADSORTAILS = 'H';
        } else {
            HEADSORTAILS = 'T';
        }

        System.out.println("The computer got " + HEADSORTAILS + ".");
        
        if (GUESS == HEADSORTAILS) {
            System.out.println("You guessed right!");
        } else {
            System.out.println("Sorry, try again!");
        }


        // ===========================================

    }

}

// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    I had a hard time figuring out what was the proper way to range and then i realized that the
    objective was 0-9, not 1-9. 

    I originally had Random.nextInt(9) + 1 which means 1-9
    now i changed it to Random.nextInt(10) meaning its 0-9




2. What will you always remember (never forget) from this exercise?
    i will never forget that by choosing 10, the range will be 0-9 instead of 1-10.
    the range will always start from 0 and end before the choosen number.




*/
