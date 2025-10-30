import java.util.Scanner;
import java.util.Random;

public class NoDinnerDebate {
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("    ---NO DINNER DEBATES---");
        System.out.println("Rolling the die...");
        rollDeliveryDice();

        System.out.println("\n---SKEWED DICE OPTION---");
        rollSkewedDice();

    }

    public static void rollDeliveryDice() {
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
        String FirstChoice = " ";
        String SecondChoice = " ";
        String ThirdChoice = " ";
        String FourthChoice = " ";

        boolean NextChoice1 = false;
        boolean NextChoice2 = false;
        boolean NextChoice3 = false;
        boolean NextChoice4 = false;

        int RankedFoodChoices1 = 0;
        int RankedFoodChoices2 = 0;
        int RankedFoodChoices3 = 0;
        int RankedFoodChoices4 = 0;

        int FoodID1 = 0;
        int FoodID2 = 0;
        int FoodID3 = 0;
        int FoodID4 = 0;



        System.out.print("What do you want in a ranked order?\n");
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

        RankedFoodChoices1 = scanner.nextInt();
        RankedFoodChoices2 = scanner.nextInt();
        RankedFoodChoices3 = scanner.nextInt();
        RankedFoodChoices4 = scanner.nextInt();

        while (NextChoice1 == false) {
            switch (RankedFoodChoices1) {
                case 1:
                    FirstChoice = "PIZZA 🍕";
                    NextChoice1 = true;
                    break;
                case 2:
                    FirstChoice = "BURGER 🍔";
                    NextChoice1 = true;
                    break;
                case 3:
                    FirstChoice = "CHINESE 🍜";
                    NextChoice1 = true;
                    break;
                case 4:
                    FirstChoice = "TACOS 🌮";
                    NextChoice1 = true;
                    break;
                case 5:
                    FirstChoice = "PASTA 🍝";
                    NextChoice1 = true;
                    break;
                case 6:
                    FirstChoice = "SUSHI 🍣";
                    NextChoice1 = true;
                    break;
                case 7:
                    FirstChoice = "ITALIAN 🍝";
                    NextChoice1 = true;
                    break;
                case 8:
                    FirstChoice = "BBQ 🍖";
                    NextChoice1 = true;
                    break;
                default:
                    System.out.println("Your first order is invalid, Please select a number between 1 and 8.");
                    RankedFoodChoices1 = scanner.nextInt();
                    NextChoice1 = false;
                    break;
            }
        }
        System.out.println("You choose " + FirstChoice + " as your first choice.");

        while (NextChoice2 == false) {
            switch (RankedFoodChoices2) {
                case 1:
                    FirstChoice = "PIZZA 🍕";
                    NextChoice2 = true;
                    break;
                case 2:
                    SecondChoice = "BURGER 🍔";
                    NextChoice2 = true;
                    break;
                case 3:
                    SecondChoice = "CHINESE 🍜";
                    NextChoice2 = true;
                    break;
                case 4:
                    SecondChoice = "TACOS 🌮";
                    NextChoice2 = true;
                    break;
                case 5:
                    SecondChoice = "PASTA 🍝";
                    NextChoice2 = true;
                    break;
                case 6:
                    SecondChoice = "SUSHI 🍣";
                    NextChoice2 = true;
                    break;
                case 7:
                    SecondChoice = "ITALIAN 🍝";
                    NextChoice2 = true;
                    break;
                case 8:
                    SecondChoice = "BBQ 🍖";
                    NextChoice2 = true;
                    break;
                default:
                    System.out.println("Your second order is invalid, Please select a number between 1 and 8.");
                    RankedFoodChoices2 = scanner.nextInt();
                    NextChoice2 = false;
                    break;
            }
        }
        System.out.println("You choose " +SecondChoice + " as your second choice.");

        while (NextChoice3 == false) {
            switch (RankedFoodChoices3) {
                case 1:
                    ThirdChoice = "PIZZA 🍕";
                    NextChoice3 = true;
                    break;
                case 2:
                    ThirdChoice = "BURGER 🍔";
                    NextChoice3 = true;
                    break;
                case 3:
                    ThirdChoice = "CHINESE 🍜";
                    NextChoice3 = true;
                    break;
                case 4:
                    SecondChoice = "TACOS 🌮";
                    NextChoice3 = true;
                    break;
                case 5:
                    ThirdChoice = "PASTA 🍝";
                    NextChoice3 = true;
                    break;
                case 6:
                    ThirdChoice = "SUSHI 🍣";
                    NextChoice3 = true;
                    break;
                case 7:
                    ThirdChoice = "ITALIAN 🍝";
                    NextChoice3 = true;
                    break;
                case 8:
                    SecondChoice = "BBQ 🍖";
                    NextChoice3 = true;
                    break;
                default:
                    System.out.println("Your third order is invalid, Please select a number between 1 and 8.");
                    RankedFoodChoices3 = scanner.nextInt();
                    NextChoice3 = false;
                    break;
            }
        }
        System.out.println("You choose " +ThirdChoice + " as your third choice.");

        while (NextChoice4 == false) {
            switch (RankedFoodChoices4) {
                case 1:
                    FourthChoice = "PIZZA 🍕";
                    NextChoice4 = true;
                    break;
                case 2:
                    FourthChoice = "BURGER 🍔";
                    NextChoice4 = true;
                    break;
                case 3:
                    FourthChoice = "CHINESE 🍜";
                    NextChoice4 = true;
                    break;
                case 4:
                    FourthChoice = "TACOS 🌮";
                    NextChoice4 = true;
                    break;
                case 5:
                    FourthChoice = "PASTA 🍝";
                    NextChoice4 = true;
                    break;
                case 6:
                    FourthChoice = "SUSHI 🍣";
                    NextChoice4 = true;
                    break;
                case 7:
                    FourthChoice = "ITALIAN 🍝";
                    NextChoice4 = true;
                    break;
                case 8:
                    FourthChoice = "BBQ 🍖";
                    NextChoice4 = true;
                    break;
                default:
                    System.out.println("Your third order is invalid, Please select a number between 1 and 8.");
                    RankedFoodChoices4 = scanner.nextInt();
                    NextChoice4 = false;
                    break;
            }
        }
        System.out.println("You choose " +FourthChoice + " as your fourth choice.");

        int SkewedTonightDinner = random.nextInt(4)+1;

        switch (SkewedTonightDinner) {
            case 1:
                System.out.println("\nTonight's dinner will be: " + FirstChoice);
                break;
            case 2:
                System.out.println("\nTonight's dinner will be: " + SecondChoice);
                break;
            case 3:
                System.out.println("\nTonight's dinner will be: " + ThirdChoice);
                break;
            case 4:
                System.out.println("\nTonight's dinner will be: " + FourthChoice);
                break;
        }
        // Further implementation needed to complete the skewed dice logic
    }
}

// If user choose 4 foods, then the rest will not be in a dinner.
// code will get the 4 id from the rank.
// the randomizer will only have 4
// after