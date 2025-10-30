import java.util.Scanner;
import java.util.Random;

public class NoDinnerDebate {
    public static void main(String[] args) {
        System.out.println("    ---NO DINNER DEBATES---");
        System.out.println("Rolling the die...");
        rollDeliveryDice();

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
        }

        System.out.println("Tonight's dinner will be: ");
    }
}
