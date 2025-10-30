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

        int RankedFoodChoices = scanner.nextInt();

        switch (RankedFoodChoices) {
            case 1:
                System.out.println("You choose PIZZA 🍕");
                break;
            case 2:
                System.out.println("You choose BURGER 🍔");
                break;
            case 3:
                System.out.println("You choose CHINESE 🍜");
                break;
            case 4:
                System.out.println("You choose TACOS 🌮");
                break;
            case 5:
                System.out.println("You choose PASTA 🍝");
                break;
            case 6:
                System.out.println("You choose SUSHI 🍣");
                break;
            case 7:
                System.out.println("You choose ITALIAN 🍝");
                break;
            case 8:
                System.out.println("You choose BBQ 🍖");
                break;
            default:
                System.out.println("Invalid choice. Please select a number between 1 and 8.");
                break;
        }



        // Further implementation needed to complete the skewed dice logic
    }
}
