// FILE NAME - TriangleArea.java

/**
 * Convert Celcius to Fahrenheit Assignment
 * 
 * @author Christ Aerjil Dampog
 * @since September 18, 2025
 */

import java.util.Scanner;

public class InchesToFeet {
    public static void main (String[] args) {
        InchesToFeetConverter();
    }
    
    public static void InchesToFeetConverter() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of inches:");
        int Inches = scanner.nextInt();
        
        ///////////////////////    INSERT YOUR CODE BELOW THIS LINE    ///////////////////////
        
        scanner.close(); 

            int Feet = Inches/12;
            int InchesRemainder = Inches % 12;
            System.out.println(Inches + " inches is " + Feet + " feet, and " + InchesRemainder + " inches");
            
        ///////////////////////    INSERT YOUR CODE ABOVE THIS LINE    /////////////////////// 
    }
}


// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    Trying to print out the remainder of the division.

2. What will you always remember (never forget) from this exercise?
    "/" to divide numbers and "%" to get the remainder.
*/