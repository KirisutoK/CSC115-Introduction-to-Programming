
/**
 * Circles02 Lab Work
 *
 * @author Christ Aerjil Dampog
 * @since September 25, 2006
 */

import java.util.Scanner;

public class Circles02 {

    public static void main(String[] args) {
        circleMath(); 
    }

    public static void circleMath() {

    Scanner sc = new Scanner(System.in);

        double pi = Math.PI;

        System.out.println("Radius:");
        double Radius = sc.nextDouble();

    // ========== INSERT YOUR CODE HERE ==========

        double Area = pi * Radius * Math.pow(Radius, 1);
        double Circumference = 2 * pi * Radius;
        double Rounded = Math.round(Area);


        System.out.println("CIRCUMFERENCE = " + Circumference);
        System.out.println("AREA = " + Area);
        System.out.println("ROUNDED AREA = " + (int)Rounded);

    // ===========================================        

    // close the scanner
        sc.close();

    }

}


// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    The Math.pow(), i did not know hat by doing Math.power(variable, 2) is equivalent to variable^3,
    so i changed it to Math.power(variable, 1) which is equivalent to variable^2

    The value on the left defines how many times it it multiplited by itself

2. What will you always remember (never forget) from this exercise?
    I will never forget casting, i just found out that the original value which is a double can be casted into int value. 
    this can also be used by other data types which is super effiecent and awesome!

*/

