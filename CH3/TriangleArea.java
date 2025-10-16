/**
 * Triangle Area Assignment
 * 
 * @author Christ Aerjil Dampog
 * @since September 18, 2025
 */
 
import java.util.Scanner;

public class TriangleArea {
    public static void main (String[] args) {
        findArea();
    }
    
    public static void findArea() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the height:");
        int height = scanner.nextInt();

        System.out.println("Enter the base:");
        int base = scanner.nextInt();
        
        ///////////////////////    INSERT YOUR CODE BELOW THIS LINE    ///////////////////////
        
        scanner.close(); 

            double total = base * height * 1/2.;
            System.out.println("the area of the triangle is " + total);
        
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