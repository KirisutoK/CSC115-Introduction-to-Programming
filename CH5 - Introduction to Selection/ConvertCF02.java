
/**
 * ConvertCF02
 * Convert Celcius to Fahrenheit Assignment
 * Have the user pick an option to choose which converter to use.
 *
 * @author Christ Aerjil C. Dampog
 * @since Octobor 15, 2025
 */



import java.util.Scanner;

public class ConvertCF02 {
    public static void main(String[] args) {
        System.out.println("===== Temperature Converter =====\n");
        System.out.println("  1. Convert from Celsius to Fahrenheit");
        System.out.println("  2. Convert from Fahrenheit to Celsius\n");

        convert();
    }

    public static void convert() {

    // ========== INSERT YOUR CODE HERE ========== //

    Scanner scanner = new Scanner(System.in);

    System.out.println("Please choose from the above menu:");
    int CHOICE = scanner.nextInt();

    System.out.println("");

    System.out.println("Enter a temperature to convert:");
    int TEMPERATURE = scanner.nextInt();

    System.out.println("");

    scanner.close();

    int RESULT;

    if (CHOICE == 1) { 
        RESULT = (TEMPERATURE * 9/5) + 32;
        System.out.println((double)TEMPERATURE + " degrees Celcius is " + (double)RESULT + " degrees Fahrenheit.");
    } else if (CHOICE == 2) {
        RESULT = (TEMPERATURE - 32) * 5/9;
        System.out.println((double)TEMPERATURE + " degrees Fahrenheit is " + (double)RESULT + " degrees Celcius.");
    }

    // ===========================================        


    }
}

// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    Trying to remember how to change data type




2. What will you always remember (never forget) from this exercise?
    You can always change the data type of a variable by putting ()variable next to it




*/

