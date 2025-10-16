
/**
 * Radius to Area using PI? Assignment
 *
 * @author Christ Aerjil Dampog
 * @since September 23, 2025
 */

import java.util.Scanner;

public class Circles01 {

    public static void main(String[] args) {
        circleArea();    
    }

    public static void circleArea() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Radius: ");
        double radius = scanner.nextDouble();

        System.out.println();

        // ========== INSERT YOUR CODE HERE ==========
           
        scanner.close();
            double pi = 3.14;
            
            double area = pi * radius * radius;
            System.out.print("AREA = " + area);

        // ===========================================        

  }

}


// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    The hardest part of this lab is trying to implement the formula and the process of way on how calculation works based on the original formula



2. What will you always remember (never forget) from this exercise?
    I will never forget about the types of data such as Int (Integer) which defines as whole number, Double or Float which defines the number with
    decimal points, and lastly String which defines words, letters, or characters.

    Char can also be a data type which can only hold 1 character of the alphabet.
*/

