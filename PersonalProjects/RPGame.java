import java.util.Scanner;
import java.util.Random;

public class RPGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // Global Variables // User Stats //
    static String Username;
    static int Level = 1;
    static int Health = 100;
    static int Age;

    // Global Variable // Mob Stats

    public static void main(String[] args) {
        Introductions();

        Mobs();
    }

    public static void Introductions() {
        System.out.println("Would you like to start the game? (Y/N)");
        char StartGame = scanner.next().charAt(0);

        if (StartGame == 'y' || StartGame == 'Y') {
            System.out.println("\nWelcome… lost soul. You drift through the endless veil between worlds, and yet… your spirit still burns. ");

            System.out.println("\nI am Thesis, the Goddess of Creation, the one who breathes life into stars, and silence into shadows.");

            System.out.println("\nYou stand now upon the threshold of Eclipsera, a world once radiant… now trembling beneath the shadow of ruin.");

            System.out.println("\nEclipsera was forged in harmony, where light and darkness coexisted, bound by balance. But that balance… was shattered.");

            System.out.println("\nAn ancient being, once mortal, has seized the throne of chaos, the Eclipse Lord, Varyn. With every kingdom he conquers,");
            System.out.println("the sky dims, and the stars forget their light.");

            System.out.println("\nAnd you… are not here by chance. You were torn from your world, from Earth, because destiny chose you.");

            System.out.println("\nTell me, traveler… what do they call you in your realm? What name shall echo across Eclipsera?");
            String Username = scanner.nextLine();

            System.out.println("\nAnd your age… how long has your soul walked among the living?");
            int Age = scanner.nextInt();
            if (Age >= 70) {
                System.out.println("\nYou are too old");
                End();
                return;
            } else if (Age <= 5) {
                System.out.println("\nYou are too young");
                End();
                return;
            }

            System.out.println("\nHm… a mortal, fragile in form, yet the flame within you refuses to yield. That resolve… may be the key.");

            System.out.println("\nListen well. To return to your world, you must restore what was lost. You must face Varyn,");
            System.out.println("the Eclipse Lord, and shatter the chains he has bound around this realm.");
        } else {
            Introductions();
            return;
        }
    }

    public static void Mobs() {
    }

    public static void End() {
        int RandomEndNumber = random.nextInt(3) + 1;

        switch (RandomEndNumber) {
            case 1:
                System.out.println("Your journey ends here... but your story will be remembered.");
                break;
            case 2:
                System.out.println("You have failed... but perhaps fate will give you another chance.");
                break;
            case 3:
                System.out.println("Your will was strong, but the world proved stronger.");
                break;
        }
    }

}
