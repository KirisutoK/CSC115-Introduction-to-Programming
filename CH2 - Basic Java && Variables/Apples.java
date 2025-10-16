/**
 * Calculate and display apple information 🍎
 * For a local apple orchard
 * @author Christ Aerjil Dampog
 * @since September 16, 2025
 */
import java.util.Scanner;

public class Apples {
	public static void main(String[] args) {
        displayInfo();
		calculate();
        car();
	}
   public static void displayInfo() {
        System.out.println("🍏🍎 Welcome to Johnny Apple Seeds! 🍎🍏");
        System.out.println("We have been open since the 1890s");
        System.out.println("We are open from 5am to 11pm");
        System.out.println("We charge 21$ per 5 apples");
   }

   public static void car() {
        System.out.println("We charge 21$ per 5 apples");
   }

   // The calculate method determines how much the apples will cost
   public static void calculate() {

	   // Create a new Scanner to read in input from user
      Scanner scanner = new Scanner(System.in);
      
      // Prompt the user and then store their input in 'smallBuckets'
      System.out.println("Enter the number of small buckets:");
      int SmallBucket= scanner.nextInt();

      System.out.println("Enter the number of AppleCider:");
      int AppleCider= scanner.nextInt();

      System.out.println("Enter the number of large bucket:");
      int LargeBucket= scanner.nextInt();

      // Close the scanner object
      scanner.close(); 

      double total = SmallBucket * 4.99 + LargeBucket * 9.99 + AppleCider * 2.99;
              System.out.println(total);
    }
}


/*
 * Johnny Apple Seeds
 * 1890s
 * Slight name change
 * 5AM-11PM
 * 21$ per 5 apples
 * 28$ seasonal 20$
 */