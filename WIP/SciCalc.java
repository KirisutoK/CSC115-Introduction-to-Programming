
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

    // Global Variables \\
    static int FunctionChoice;

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

        switch (FunctionChoice) {
            case 1:
                int Result1 = SciCalc.add(FirstNumber, SecondNumber);
                System.out.println("\nThe result of " + FirstNumber + " + " + SecondNumber + " is " + Result1);
                break;

            case 2:
                int Result2 = SciCalc.sub(FirstNumber, SecondNumber);
                System.out.println("The result of " + FirstNumber + " - " + SecondNumber + " is " + Result2);
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
                    10. Find the smallest of the two numbers """);

        System.out.println("Please select a function:");
        FunctionChoice = scanner.nextInt();
    }

    // =================== Methods for the Switches(FunctionChoice) ===================//

    public static int add(int num1, int num2) {
        int Results = num1 + num2;
        return Results;
    }
    public static int sub(int num1, int num2) {
        int Results = num1 - num2;
        return Results;
    }
    public static int mult(int num1, int num2) {
        int Results = num1 * num2;
        return Results;
    }
    public static int div(int num1, int num2) {
        int Results = num1 / num2;
        return Results;
    }
    public static int mod(int num1, int num2) {
        int Results = num1 % num2;
        return Results;
    }
    public static double pow(int num1, int num2) {
        double Results = Math.pow(num1, num2);
        return Results;
    }
    public static double hyp(int num1, int num2) {
        double Results = Math.hypot(num1, num2);;
        return Results;
    }
    public static double hailed(int num) {
        if (num % 2 == 0) {
            int res
            
           return num / 2;
        } else {
            return num * 3 + 1;
        }
    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 *  The data types for math functions. sometimes theres a function that needs the method to be an int and then the variable to be a double,
 *  hailed was very confusing, i had a hard time figuring out how to define odds and even. i also had a hard time figuring out how to do the
 *  return thingy.
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 * 
 * 
 * 
 * 
 */
