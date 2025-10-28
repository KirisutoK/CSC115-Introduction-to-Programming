import java.util.Random;
import java.util.Scanner;

public class Test2 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        End();
}


// METHODS \\

    public static void End(int ReturnValue) {
        int RandomEndNumber = random.nextInt(3) + 1;

        switch (RandomEndNumber) {
            case 1:
                Dialogue("\nYour journey ends here... but your story will be remembered.");
                break;
            case 2:
                Dialogue("\nYou have failed... but perhaps fate will give you another chance.");
                break;
            case 3:
                Dialogue("\nYour will was strong, but the world proved stronger.");
                break;
        }

        Dialogue("\n\nWould you like to try again? (Y/N)");
        char RetryChoice = scanner.next().charAt(0);

        if (RetryChoice == 'Y' || RetryChoice == 'y') {
            switch (ReturnValue) {
                case 0:
                    main(new String[0]);
                    break;
                case 1: 
                    Intro
                    break;
                case 2:
                    // Call Chapter 2 method here
                    break;
                case 3:
                    // Call Chapter 3 method here
                    break; 
            }
        } else {
            Dialogue("\n\nThank you for playing. Farewell, traveler.");
        }
    }
    public static String Dialogue(String Dialogue) {
        try { 
            for (char Characters : Dialogue.toCharArray()) {
                System.out.print(Characters);
                Thread.sleep(25);
            }
        } catch (InterruptedException e) {
            Dialogue("An error occurred during loading.");
        }
        return Dialogue;
    }
}