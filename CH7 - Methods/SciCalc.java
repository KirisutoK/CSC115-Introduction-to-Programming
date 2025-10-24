
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
                System.out.println("\nThe result of " + FirstNumber + " - " + SecondNumber + " is " + Result2);
                break;

            case 3:
                int Result3 = SciCalc.mult(FirstNumber, SecondNumber);
                System.out.println("\nThe result of " + FirstNumber + " * " + SecondNumber + " is " + Result3);
                break;

            case 4:
                double Result4 = SciCalc.div(FirstNumber, SecondNumber);
                System.out.println("\nThe result of " + FirstNumber + " / " + SecondNumber + " is " + Result4);
                break;

            case 5:
                int Result5 = SciCalc.mod(FirstNumber, SecondNumber);
                System.out.println("\nThe result of " + FirstNumber + " % " + SecondNumber + " is " + Result5);
                break;

            case 6:
                double Result6 = SciCalc.pow(FirstNumber, SecondNumber);
                System.out.println("\nThe result of " + FirstNumber + " ^ " + SecondNumber + " is " + Result6);
                break;

            case 7:
                int Result7A = SciCalc.hailed(FirstNumber);
                int Result7B = SciCalc.hailed(SecondNumber);
                System.out.println("\nThe result of " + FirstNumber + " hailed is " + Result7A + " and the result of " + SecondNumber + " hailed is " + Result7B);
                break;

            case 8:
                double Result8 = SciCalc.hyp(FirstNumber, SecondNumber);
                System.out.println("\nThe hypotenuse of a right triangle with legs " + FirstNumber + " and " + SecondNumber + " is " + Result8);
                break;

            case 9:
                int Result9 = SciCalc.max(FirstNumber, SecondNumber);
                System.out.println("\nThe largest number of " + FirstNumber +" and " + SecondNumber + " is " + Result9);
                break;

            case 10:
                int Result10 = SciCalc.min(FirstNumber, SecondNumber);
                System.out.println("\nThe smallest number of " + FirstNumber +" and " + SecondNumber + " is " + Result10);
                break;

            default:
                System.out.println("\nYou did not enter a valid choice.");
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
    public static int hailed(int num) {
        if (num % 2 == 0) {
            int Results = num / 2;
           return Results;
        } else {
            int Results = num * 3 + 1;
            return Results;
        }
    }
    public static double hyp(int num1, int num2) {
        double Results = Math.hypot(num1, num2);
        return Results;
    }
    public static int max(int num1, int num2) {
        if (num1 > num2) {
            int Results = num1;
            return Results;
        } else {
            int Results = num2;
            return Results;
        }
    }
    public static int min(int num1, int num2) {
        if (num1 > num2) {
            int Results = num2;
            return Results;
        } else {
            int Results = num1;
            return Results;
        }
    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 *  The data types for math functions. sometimes theres a function that needs the method to be an int and then the variable to be a double,
 *  hailed was very confusing, i had a hard time figuring out how to define odds and even. i also had a hard time figuring out how to do the
 *  return thingy for the fist 5 minutes.
 * 
 * 
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 *  I am starting to get used between local variables and global variables. 
 *  local variables are variables inside a method and only used in that specific method
 *  while global variables are variables that are used from methods to methods.
 *  
 *  
 * 
 * 
 * 
 */
