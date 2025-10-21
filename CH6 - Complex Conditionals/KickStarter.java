/**
 * KickStarter Lab
 * A TableTop game where when a user contributes a specific number, they will be given results.
 * Must use switch statement
 *
 * @author Christ Aerjil Dampog
 * @since Oct 20, 2025
 */

import java.util.Scanner;

public class KickStarter {
    public static void main (String[] args) {

    // ========== INSERT YOUR CODE HERE ==========

    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Kickstarter!");
    System.out.println("How much would you like to contribute to the 'Cones of Dunshire' project?");
    int CONTRIBUTION = scanner.nextInt();

    switch(CONTRIBUTION) {
        case 150: System.out.println("You will receive the 'Cone of Dunshire' hat.");
        case 100: System.out.println("You will receive the Founders Edition of the tabletop version of 'Cones of Dunshire'.");
        case 50: System.out.println("You will receive a copy of the tabletop version of 'Cones of Dunshire'.");
        case 20: System.out.println("You will receive a copy of the mobile app version of 'Cones of Dunshire'.");
        case 5: System.out.println("You will have your name put on a list of backers on our website.");
        case 1: System.out.println("You will receive a thank-you email.\n");
        break;

        default: System.out.println("You did not enter a valid amount\n");
    }

    System.out.println("Thanks for backing 'Cones of Dunshire'.");

    // ===========================================      


    }
}

/*
1. What was the hardest part of this lab?
    Nothing was particulary hard on this lab, rather i misread the guide and wasted my time putting if statements
    planning to change an integer into a specific integer for the case choices. As i read the objectives on
    brightspace again, i realized that it was unnecessary.



2. What will you always remember (never forget) from this exercise?
    Without the break; the code executes consequently from the top to the bottom.




*/


