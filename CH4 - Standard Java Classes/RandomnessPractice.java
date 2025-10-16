import java.util.Random; //import Random class

/**
 * 🎯 a class to practice generating random values
 * 5️⃣ five examples - learn them all!!!
 * ❓ PLEASE ask questions if you do not understand!
 */


public class RandomnessPractice {
    private static final Random random = new Random();

    /** 
     * EXAMPLE 1
     * generates a random decimal - 0.0 (inclusive) to 1.0 (exclusive)
     * @return a random double
     */
    public static double generateRandomDecimal() {
        return random.nextDouble();
    }

    /**
     * EXAMPLE 2
     * simulates a 6-sided die roll (1-6)
     * @return a random integer 1, 2, 3, 4, 5, 6
     */
    public static int rollDie() {
        // nextInt(6) generates 0-5... +1 to generate 1-6
        return random.nextInt(6) + 1;
    }

    /**
     * EXAMPLE 3
     * simulates a percentile dice roll - rolling two dice
     * each roll is 0-9
     * @return a random integer between 1 and 100 - inclusive
     */
    public static int rollPercentileDice() {
        int tensPlace = random.nextInt(10); //generates 0-9
        int onesPlace = random.nextInt(10); //generates 0-9
        int percentileDiceRoll = tensPlace * 10 + onesPlace;
        if (percentileDiceRoll == 0) {
            percentileDiceRoll = 100;
        }
        return percentileDiceRoll;
    }

    /**
     * EXAMPLE 4
     * generates a random lowercase letter (a-z)
     * @return a random lowercase character - type char
     */
    public static char generateRandomLowercaseLetter() {
        // nextInt(26) generates 0-25
        // add 97 as this is ascii 'a'
        return (char) (97 + random.nextInt(26));
    }

    /**
     * EXAMPLE 5
     * generates a random uppercase letter (A-Z)
     * @return a random uppercase character - type char
     */
    public static char generateRandomUppercaseLetter() {
        // nextInt(26) generates 0-25
        // add 65 as this is ascii 'A'
        return (char) (65 + random.nextInt(26));
    }

    public static void main(String[] args) {

        System.out.println("🎲 🔮 RANDOM PRACTICE RESULTS 🔮 🎲");

        // EXAMPLE 1. Random Decimal (double)
        double decimal = generateRandomDecimal();
        System.out.println("1. Decimal (0.0 to 1.0): " + decimal);

        // EXAMPLE 2. Standard Die Roll (1-6)
        int dieRoll = rollDie();
        System.out.println("2. Standard Die Roll (1-6): " + dieRoll);

        // EXAMPLE 3. Percentile Dice Roll (1-100)
        int percentileRoll = rollPercentileDice();
        System.out.println("3. Percentile Dice Roll (1-100): " + percentileRoll);

        // EXAMPLE 4. Random Lowercase Letter
        char lower = generateRandomLowercaseLetter();
        System.out.println("4. Lowercase Letter: " + lower);

        // EXAMPLE 5. Random Uppercase Letter
        char upper = generateRandomUppercaseLetter();
        System.out.println("5. Uppercase Letter: " + upper);
    }
}