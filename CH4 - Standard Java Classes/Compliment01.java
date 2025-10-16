/**
 * Circles02 Lab Work
 *
 * @author Christ Aerjil Dampog
 * @since September 25, 2006
 */

import java.util.Scanner;

public class Compliment01 {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // ========== INSERT YOUR CODE HERE ==========

        System.out.println("What is your age?");
        int Age = sc.nextInt();

        System.out.println("What is your name?");
        sc.nextLine();
        String Name = sc.nextLine();

        System.out.println("Hello, " + Name + ". You are very smart for someone who is " + Age + " years old.");

    // ===========================================        

    // close the scanner
        sc.close();

    }

}


// =============== LAB SUMMARY ===============

/*
1. What was the hardest part of this lab?
    Using the right terms and words for the data types. By doing nextInt() it would return an Int value so i put a nextString() for the next scanner
    expecting it to also response as a string or a letter and found out the results was an error. searched it up and found out there is no such thing as nextString()
    rather to use nextLine(). 

2. What will you always remember (never forget) from this exercise?
    The Data types, i will never forget what are the data types for string, int, double, char, and that there are more different tpes of data such as byte, long, short, 
    and many more that i am unaware of.

*/
