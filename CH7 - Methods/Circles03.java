
/**
 * Circles03 Lab Work
 *Using the built-in Math.PI constant, find the circumference and area of a circle with a radius that is provided by the user. Also provide the rounded approximation of the area (to the nearest integer). Note: this is NOT truncating.
 *This will be an updated version of our earlier Circles lab - make it better by using more methods!
 * @author Christ Aerjil Dampog
 * @since October 23, 2025
 */

import java.util.Scanner;

public class Circles03 {
    static Scanner scanner = new Scanner(System.in);

    // Global Variables \\
    static double pi = Math.PI;
    static double Radius;
    static double area;

    public static void main(String[] args) {
        Scanner();
        Print();
    }

    public static void Scanner() { // Scans user inputs
        System.out.println("Radius:");
        Radius = scanner.nextDouble();

        scanner.close();
    }

    public static void Print() { // Prints the results
        double CIRCUMFERENCE = Circumference(Radius);
        double AREA = Area(Radius);
        double ROUNDEDAREA = RoundedArea(AREA);

        System.out.println("CIRCUMFERENCE = " + CIRCUMFERENCE);
        System.out.println("AREA = " + AREA);
        System.out.println("ROUNDED AREA = " + (int) ROUNDEDAREA);
    }

    public static double Circumference(double num) { // Calculates Circumference
        double circumference = 2 * pi * num;
        return circumference;
    }

    public static double Area(double num) { // Calculates Area
        area = pi * num * Math.pow(num, 1);
        return area;
    }

    public static double RoundedArea(double num) { // Calculates RoundedArea
        double rounded = Math.round(area);
        return (int) rounded;
    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 * creating methods and trying to attain their variables and definitions from
 * methods to methods. I also had a hard time figuring out
 * the Method(num), i honestly do not know what num is until i found out its
 * just a undefined variable.
 * 
 * so when a method is called its usally just the method itself, now if you put
 * a value inside of the parenthesis, that value will go to
 * that "num" variable.
 * 
 * 2. What will you always remember (never forget) from this exercise?
 * calling the class name then the child of it is like file explorer. you can
 * also use it to find a specific variable in a specific method.
 * I especially like using static(Global) more rather than calling the class
 * then the child of it because its easier to read and understand.
 * 
 */
