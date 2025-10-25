import java.util.Scanner;
import java.util.Random;

public class RPGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // Global Variables // Miscallenous //
    static int FastLoadingMessageMode = 0;
    static int NormalLoadingMessageMode = 2500;
    static int SlowLoadingMessageMode = 4000;

    static boolean AbletoPlay = true;

    // Global Variables // User Stats //
    static String PlayerUsername;
    static int PlayerLevel = 1;
    static int PlayerHealth = 100;
    static int PlayerAge = 0;
    static int DescriptionNumber = random.nextInt(5)+1;

    // Global Variable // Mobs //
    static int goblin; //--Chapter 1 Mobs
    static int bee;
    static int slime;
    static int wolves;
    static int boar; // The mobs will be an int value in order to specify the random chances.

    static int elves;
    static int vampires;
    static int orc;


    public static void main(String[] args) {
        Introductions(FastLoadingMessageMode);

        if (AbletoPlay == true) {
            Chapter1(FastLoadingMessageMode);
        }
    }

    //-----------------------------------------------------------------------------\\
    //===================================METHODS===================================\\
    //-----------------------------------------------------------------------------\\

    //============Story==============\\
    public static void Introductions(int num) {
        System.out.println("Would you like to start the game? (Y/N)");
        char StartGame = scanner.next().charAt(0);

        if (StartGame == 'y' || StartGame == 'Y') {
            
            System.out.println("\nWelcome… lost soul. You drift through the endless veil between worlds, and yet… your spirit still burns. ");
            LoadingMessageEffect(num);
            System.out.println("\nI am Thesis, the Goddess of Creation, the one who breathes life into stars, and silence into shadows.");
            LoadingMessageEffect(num);
            System.out.println("\nYou stand now upon the threshold of Eclipsera, a world once radiant… now trembling beneath the shadow of ruin.");
            LoadingMessageEffect(num);
            System.out.println("\nEclipsera was forged in harmony, where light and darkness coexisted, bound by balance. But that balance… was shattered.");
            LoadingMessageEffect(num);
            System.out.println("\nAn ancient being, once mortal, has seized the throne of chaos, the Eclipse Lord, Varyn. With every kingdom he conquers,");
            System.out.println("the sky dims, and the stars forget their light.");
            LoadingMessageEffect(num);
            System.out.println("\nAnd you… are not here by chance. You were torn from your world, from Earth, because destiny chose you.");
            LoadingMessageEffect(num);
            System.out.println("\nTell me, traveler… what do they call you in your realm? What name shall echo across Eclipsera?");
            scanner.nextLine();
            PlayerUsername = scanner.nextLine();
            
            System.out.println("\nAnd your age… how long has your soul walked among the living?");
            PlayerAge = scanner.nextInt();
            if (PlayerAge >= 70) {
                System.out.println("\nYou are too old");
                AbletoPlay = false;
                End();
                return;
            } else if (PlayerAge <= 5) {
                System.out.println("\nYou are too young");
                AbletoPlay = false;
                End();
                return;
            }

            System.out.println("\nHm… a mortal, fragile in form, yet the flame within you refuses to yield. That resolve… may be the key.");
            LoadingMessageEffect(num);
            System.out.println("\nListen well Traveler " + PlayerUsername  + ". In order to return to your world, you must restore what was lost. You must defeat Varyn,");
            System.out.println("the Eclipse Lord, and shatter the chains he has bound around this realm.");
            LoadingMessageEffect(num);
            System.out.println("\nNow Traveler " + PlayerUsername + ", Depart from your adventures, explore the world of Eclipsera, and defeat the Eclipse Lord!");
            LoadingMessageEffect(num);
            System.out.println("\n");
            LoadingMessageEffect(num);
            System.out.println("\n");
            LoadingMessageEffect(num);
        } else {
            Introductions(num);
            return;
        }
    }
    public static void Chapter1(int num) {
        System.out.println("\n==========Chapter 1: The Beginning=========="); 
        LoadingMessageEffect(num);
        System.out.println("""
                \nThe whisper of the wind brushed against your ears…
                The rustling of grass, the distant calls of unknown creatures — all weaving together into an eerie symphony of life.
                """);
        LoadingMessageEffect(num);
        System.out.println("""
                \nYour eyes flutter open.
                Light filters through towering trees, their leaves shimmering like emerald glass.
                You find yourself lying amidst a dense forest, alive with motion and mystery.
                """);
        LoadingMessageEffect(num);
        System.out.println("\nWhere… am I?");
        LoadingMessageEffect(num);
        System.out.println("""
                \nYou slowly rise, heart pounding, scanning the unfamiliar world around you.
                Then—something flickers before your eyes.
                """);
        LoadingMessageEffect(num);
        System.out.println("\nThis...");
        System.out.println("a... screen?");
        LoadingMessageEffect(num);
        System.out.println(" ");

        PlayerStats();

        System.out.println(" ");
        LoadingMessageEffect(num);
        System.out.println("\nAs you read the contents of your profile, you suddenly heard rustling from the bushes.");


    }   

    //============Entities==============\\
    public static void PlayerStats() {
        System.out.println("\n|==============Player-Status============|");
        System.out.println(" Health: " + PlayerHealth);
        System.out.println(" Level: " + PlayerLevel);
        System.out.println(" Username: " + PlayerUsername);
        System.out.println(" Age: " + PlayerAge);
        switch (DescriptionNumber) {
            case 1:
                System.out.println(" Trait: Confident and Brave."); // 2x Damage Boost
                break;
            case 2:
                System.out.println(" Trait: Energetic and Enthusiastic"); // 2x Health
                break;
            case 3:
                System.out.println(" Trait: Curious and Aware"); // 2x Exp
                break;
            case 4:
                System.out.println(" Trait: Lucky"); // 2x Crit Chance
                break;
            case 5:
                System.out.println(" Trait: None"); // No Buff
                break;
        }
        System.out.println("|=======================================|");
    }
    

    public static void Mobs() {
    }

    //============Miscellaneous==============\\

    public static void LoadingMessageEffect(int num) {
        try {
            for(int i = 1; i <= 3; i++) {
                System.out.print(".");
                Thread.sleep(num); // 2500 is the default which is 2.5 seconds
            }
        } catch (InterruptedException e) {
            System.out.println("DELAY ERROR!");
        }
    }
    public static void End() {
        int RandomEndNumber = random.nextInt(3) + 1;

        switch (RandomEndNumber) {
            case 1:
                System.out.println("\nYour journey ends here... but your story will be remembered.");
                break;
            case 2:
                System.out.println("\nYou have failed... but perhaps fate will give you another chance.");
                break;
            case 3:
                System.out.println("\nYour will was strong, but the world proved stronger.");
                break;
        }
    }
}
