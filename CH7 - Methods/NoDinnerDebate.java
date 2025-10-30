import java.util.Scanner;
import java.util.Random;

public class NoDinnerDebate {
    public static void main(String[] args) {
        System.out.println("    ---NO DINNER DEBATES---");
        System.out.println("Rolling the die...");
        rollDeliveryDice();

        System.out.println("\n---SKEWED DICE OPTION---");
        rollSkewedDice();

    }

    public static void rollDeliveryDice() {
        Random random = new Random();
        int DiceNumber = random.nextInt(8) + 1;

        String RandomFood;

        switch (DiceNumber) {
            case 1:
                RandomFood = "PIZZA 🍕";
                break;
            case 2:
                RandomFood = "BURGER 🍔";
                break;
            case 3:
                RandomFood = "CHINESE 🍜";
                break;
            case 4:
                RandomFood = "TACOS 🌮";
                break;
            case 5:
                RandomFood = "PASTA 🍝";
                break;
            case 6:
                RandomFood = "SUSHI 🍣";
                break;
            case 7:
                RandomFood = "ITALIAN 🍝";
                break;
            case 8:
                RandomFood = "BBQ 🍖";
                break;
            default:
                RandomFood = "ERROR";
                break;
        }

        System.out.println("Tonight's dinner will be: " + RandomFood);
    }

    public static void rollSkewedDice() {
        Scanner scanner = new Scanner (System.in);

        // List of 4 Ranked in order choices
        int FirstChoice = 1;
        int SecondChoice = 2;
        int ThirdChoice = 3;
        int FourthChoice = 4;

        boolean NextChoice1 = false;
        boolean NextChoice2 = false;
        boolean NextChoice3 = false;
        boolean NextChoice4 = false;


        System.out.print("What do you want in a ranked order?");
        System.out.println("""
                1. PIZZA 🍕
                2. BURGER 🍔
                3. CHINESE 🍜
                4. TACOS 🌮
                5. PASTA 🍝
                6. SUSHI 🍣
                7. ITALIAN 🍝
                8. BBQ 🍖
                """ );

        int RankedFoodChoices1 = scanner.nextInt();
        while (NextChoice1 == false) {
            switch (RankedFoodChoices1) {
                case 1:
                    System.out.println("You choose PIZZA 🍕");
                    NextChoice1 = true;
                    FirstChoice = 1;
                    break;
                case 2:
                    System.out.println("You choose BURGER 🍔");
                    FirstChoice = 2;
                    NextChoice1 = true;
                    break;
                case 3:
                    System.out.println("You choose CHINESE 🍜");
                    FirstChoice = 3;
                    NextChoice1 = true;
                    break;
                case 4:
                    System.out.println("You choose TACOS 🌮");
                    FirstChoice = 4;
                    NextChoice1 = true;
                    break;
                case 5:
                    System.out.println("You choose PASTA 🍝");
                    FirstChoice = 5;
                    NextChoice1 = true;
                    break;
                case 6:
                    System.out.println("You choose SUSHI 🍣");
                    FirstChoice = 6;
                    NextChoice1 = true;
                    break;
                case 7:
                    System.out.println("You choose ITALIAN 🍝");
                    FirstChoice = 7;
                    NextChoice1 = true;
                    break;
                case 8:
                    System.out.println("You choose BBQ 🍖");
                    FirstChoice = 8;
                    NextChoice1 = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 8.");
                    NextChoice1 = false;
                    break;
            }
        }
        System.out.println(RankedFoodChoices1 + " is your first choice.");

        
        // Further implementation needed to complete the skewed dice logic
    }
}
