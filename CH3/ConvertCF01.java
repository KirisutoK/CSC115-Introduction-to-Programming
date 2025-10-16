// FILE NAME - TriangleArea.java

/**
 * Convert Celcius to Fahrenheit Assignment
 * 
 * @author Christ Aerjil Dampog
 * @since September 18, 2025
 */

import java.util.Scanner; // You can ignore this line - we haven't covered this yet.

public class ConvertCF01 {
    
    public static void main (String[] args) {
        ConvertCtoF();
    }
    
    public static void ConvertCtoF() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a temperature in Celsius:");
        int Celsius = scanner.nextInt();
        
        ///////////////////////    INSERT YOUR CODE BELOW THIS LINE    ///////////////////////
        
        scanner.close(); 

            double Fahrenheit = Celsius * 9/5. + 32.;
            System.out.println(Celsius + " degrees Celsius is " + Fahrenheit + " degrees Fahrenheit.");
        
        ///////////////////////    INSERT YOUR CODE ABOVE THIS LINE    /////////////////////// 
    }
}


// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    I found out the PEMDAS logic also applies into programming. I was comfortable in most of the part, just math logics was the issue.

2. What will you always remember (never forget) from this exercise?
    if you do System.out.println(), you can add a decimal at the end of a whole number to get the a decimal answer, if not then 
    you get a whole number.

    The term for decimal values are double or float while whole numbers are called integers in short of int.
*/