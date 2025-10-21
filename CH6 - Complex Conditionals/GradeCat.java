

/**
 * GradeCat lab
 * Add a grading system where theres specific letters for 90>, 80>, 70>, 65>, 64<.
 * 
 * @author Christ Aerjil Dampog
 * @since Oct 20, 2025
 */
import java.util.Scanner;

public class GradeCat {
    public static void main(String[] args) {
        gradeCat();
    }

    public static void gradeCat() {

        // ========== INSERT YOUR CODE HERE ==========

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a grade (0-100):");
        int GRADE = scanner.nextInt();

        char LETTER;

        switch (GRADE / 10) {
            case 9:
                LETTER = 'A';
                break;

            case 8:
                LETTER = 'B';
                break;

            case 7:
                LETTER = 'C';
                break;

            case 6:
                if (GRADE >= 65) {
                    LETTER = 'D';
                } else {
                    LETTER = 'F';
                }
                break;

            default:
                LETTER = 'F';
                break;
        }

        System.out.println(LETTER);

        // Solution must leverage a switch statement

        // ===========================================

    }
}

// =============== LAB SUMMARY ===============

/*
 * 1. What was the hardest part of this lab?
 *  Figuring out how to make a condition where the program has to identify and compare the numbers (><=).
 *  It was hard since switch does not work the same as if statements, rather they work by a single
 *  integer values. 
 * 
 * 
 * 
 * 2. What will you always remember (never forget) from this exercise?
 *  I will never forget that math equations can make the program shorter. It maybe very hard to read
 *  when you are editing it but if you do the calculation. it totaly make sense, i also had an error 
 *  where my variable LETTER did not work and with the help of ChatGPT to analayze whats the problem
 *  of my code, i efficiently solved it. (I needed to put a default on the switch statement)
 * 
 * 
 * 
 */
