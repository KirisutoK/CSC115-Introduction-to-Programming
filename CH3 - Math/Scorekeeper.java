
import java.text.DecimalFormat;

public class Scorekeeper {
    public static void main(String[] args) throws Exception {
        // int score = 0;
        // score = score - 1;
        // score = score + 2;
        // score = score + 3;
        // score = score + 5;
        // System.out.println(score);

        double total_cost = 0;
        int items_in_cart = 0;

        total_cost = total_cost + 6.45;
        items_in_cart = items_in_cart + 1;

        total_cost = total_cost + 2.95;
        items_in_cart = items_in_cart + 1;

        total_cost = total_cost + 0;
        items_in_cart = items_in_cart + 1;

        total_cost = total_cost + 0;
        items_in_cart = items_in_cart + 1;

        DecimalFormat DoubleDecimalPlaces = new DecimalFormat("0.00");

    // System.out.println(total_cost);
    //System.out.println(items_in_cart);
        System.out.printf("%.3f", total_cost);
        System.out.println("You have " + items_in_cart + " coffee in your order and the total cost of that would be " + DoubleDecimalPlaces.format(total_cost) + "$.");
    }
}
