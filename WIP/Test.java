import java.util.Random;


public class Test {

    static Random random = new Random();

    static int PlayerHealth = 100;
    static int PlayerLevel = 1;
    static String PlayerUsername = "Dummy";
    static int PlayerAge = 18;
    static int DescriptionNumber = random.nextInt(5)+1;

    public static void main(String[] args) {
        UserStat();

        UserStat();

        UserStat();
    }

    public static void UserStat() {
        System.out.println("\n|==============Player-Status============|");
        System.out.println("Health: " + PlayerHealth);
        System.out.println("Level: " + PlayerLevel);
        System.out.println("Username: " + PlayerUsername);
        System.out.println("Age: " + PlayerAge);
        System.out.println("Description:");
        if (DescriptionNumber == 1) {
            System.out.println("A tall guy with messy brown hair and a calm smile. He loves nature and often carries a small notebook wherever he goes.");
        } else if (DescriptionNumber == 2) {
            System.out.println("A cheerful girl with short black hair and bright eyes. She's always full of energy and loves talking to new people.");
        } else if (DescriptionNumber == 3) {
            System.out.println("A quiet person who wears glasses and prefers staying indoors. He enjoys reading books and fixing gadgets.");
        } else if (DescriptionNumber == 4) {
            System.out.println("A kind and gentle person who loves helping others. She often wears simple clothes and a small silver necklace.");
        } else if (DescriptionNumber == 5) {
            System.out.println("A confident and athletic guy who enjoys challenges. He has short blonde hair and usually wears a hoodie and sneakers.");
        } else {
            System.out.println("You have no description.");
        }
        System.out.println("|=======================================|");
    }

}
