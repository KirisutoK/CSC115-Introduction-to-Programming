
/**
 * Taxes Lab
 * To receive full credit, your code must contain multiple methods that complete
 * the major steps of the program. Each method should be focused on a singular
 * task, and have a comment that gives a description of what the method does.
 * Also include comments in your main method.
 *
 * @author Christ Aerjil Dampog
 * @since October 23, 2025
 */
import java.util.Scanner;

public class Taxes {

    // Global Variables \\
    static double income;
    static double FinalTax;

    public static void main(String[] args) {

        // ========== INSERT YOUR CODE HERE ==========

        Scanner();
        Print();

        // ===========================================
        
    }

    public static void Scanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your yearly income:");
        income = scanner.nextDouble();

        scanner.close();
    }

    public static void Print() {
        if (income <= 50000) {
            FinalTax = Taxes.Bracket1(income);
        } else if (income >= 50000 && income < 100000) {
            FinalTax = Taxes.Bracket2(income);
        } else if (income >= 100000) {
            FinalTax = Taxes.Bracket3(income);
        }

        System.out.println("You owe $" + FinalTax + " in Federal taxes.");
    }

    public static double Bracket1(double num) { // calculates taxes & income lower than 50000
        System.out.println("\nIncome Bracket 1");
        double taxes = num * 0.15;
        taxes = taxes * 100;
        taxes = Math.round(taxes) / 100.0;
        return taxes;
    }

    public static double Bracket2(double num) { // calculates taxes & income from 50000 to 99999
        System.out.println("\nIncome Bracket 2");
        double taxes = num * 0.15;
        taxes = taxes * 100;
        taxes = Math.round(taxes) / 100.0;
        return taxes;
    }

    public static double Bracket3(double num) { // calculates taxes & income greater than 100000
        System.out.println("\nIncome Bracket 3");
        double taxes = num * 0.15;
        taxes = taxes * 100;
        taxes = Math.round(taxes) / 100.0;
        return taxes;
    }

}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 * Figuring out the formula for the final tax and organizing it to make it
 * easily understandable.
 * 
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 * i will never forget that If statements are flexible in many ways while the
 * switch statement is usually just for users in which they must choose a
 * certain num,category, or stuff
 * 
 * 
 * 
 * 
 */
