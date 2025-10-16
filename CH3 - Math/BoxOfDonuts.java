/**
 * Box of Donuts Assignment
 *
 * @author Christ Aerjil Dampog
 * @since September 23, 2025
 */

import java.util.Scanner;

public class BoxOfDonuts {
    public static void main(String[] args) {
        boxOfDonuts();
    }

    public static void boxOfDonuts() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many donuts would you like today?");
        int Donuts = scanner.nextInt();

        scanner.close();

        // INSERT YOUR CODE HERE =================================

            int Boxes = Donuts / 12;
            int Bag = Donuts % 12;

            System.out.println("You will need " + Boxes + " boxes and " + Bag + " will go into a bag.");

        // =======================================================

    }
}

// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    The calculation from google was not the same as the calculation of the output in java so i got a little bit confused on finding the right formula.



2. What will you always remember (never forget) from this exercise?
    Sometimes, java and the calculator has different answers.




*/
