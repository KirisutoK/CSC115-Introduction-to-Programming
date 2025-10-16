/**
 * Math Functions Java (Addition, Subtraction, Multiplication, Division, Modulo)
 * 
 * @author Christ Aerjil Dampog
 * @since September 23, 2025
 */

import java.util.Scanner;

public class MathFunctions {
    public static void main (String[] args) {
        mathFunctions();
    }

    public static void mathFunctions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int A = scanner.nextInt();
        System.out.println("Enter another number:");
        int B = scanner.nextInt();

        scanner.close();
        // -------------------- INSERT YOUR CODE HERE --------------------

        int Addtion = A + B;
        int Subtraction = A - B;
        int Multiplication = A * B;
        int Division = A / B;
        int Modulo = A % B;

        System.out.println("\nSum of " + A + " and " + B + ": " + Addtion);
        System.out.println("Difference of " + A + " and " + B + ": " + Subtraction);
        System.out.println("Product of " + A + " and " + B + ": " + Multiplication);
        System.out.println("Quotient of " + A + " and " + B + ": " + Division);
        System.out.println("Modulo of " + A + " and " + B + ": " + Modulo);

        //----------------------------------------------------------------
    }
}


// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    Adjusting and the output and matching it up into CodeGrade's autotest eligibilty.



2. What will you always remember (never forget) from this exercise?
    \n is so useful when creating empty spaces below.



*/