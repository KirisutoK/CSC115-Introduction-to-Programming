
/**
 * SciCalc Project
 * 
 *
 * @author Christ Aerjil C. Dampog
 * @since Oct 23, 2025
 */

import java.util.Scanner;
import java.util.Random;

public class SciCalc {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("=======================");
        System.out.println("        SCICALC        ");             
        System.out.println("=======================");
        System.out.println(" ");     

        // ========== INSERT YOUR CODE HERE ==========

        System.out.println("Enter the first number:");
        int FirstNumber = scanner.nextInt();

        System.out.println("Enter the second number:");
        int SecondNumber = scanner.nextInt();

        displayMenu();

        System.out.println("Please select a function:");
        int FunctionChoice = scanner.nextInt();

        switch(FunctionChoice) {
            case 1:
            break;

            case 2:
            break;

            case 3:
            break;

            case 4:
            break;

            case 5:
            break;

            case 6:
            break;

            case 7:
            break;

            case 8:
            break;

            case 9:
            break;

            case 10:
            break;
        }

        System.out.println("\nThank you for using =====SCICALC=====");

        // You will also need to include at least 11 methods (displayMenu() and
        // methods to handle each choice from the switch statement).

        // ===========================================
    }

    public static void displayMenu() {
        System.out.println("""
                \nPlease choose from the following menu:
                    1. Add two numbers
                    2. Subtract two numbers
                    3. Multiply two numbers
                    4. Divide two numbers
                    5. Mod two numbers
                    6. Exponentiate two numbers
                    7. Find next Hailstone numbers for each of the two numbers
                    8. Find the hypotenuse using two numbers as legs of a right triangle
                    9. Find the largest of the two numbers
                    10. Find the smallest of the two numbers
                            """);
    }

    // Methods for the Switches(FunctionChoice)
    public static int choice1(int num1, int num2) {
        int Choice1Results = num1 + num2;
        return Choice1Results;
    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 * 
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 * 
 * 
 * 
 * 
 */
