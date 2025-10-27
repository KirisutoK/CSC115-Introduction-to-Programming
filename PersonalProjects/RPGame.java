import java.util.Scanner;
import java.util.Random;

public class RPGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // Global Variables // Miscallenous //
    static int FastLoadingMessageMode = 0;
    static int NormalLoadingMessageMode = 2500;
    static int SlowLoadingMessageMode = 4000;

    static boolean AbletoPlay = true; // if the user is ready to play the game

    // Global Variables // User Stats //
    static String PlayerUsername;
    static int PlayerEXP = 0; // 1*100 = 100 // 2*100 = 200 // 3*100 = 300
    static int PlayerLevel = 1;
    static int PlayerHealth = 100;
    static int PlayerAge = 0;
    static int PlayerTrait = random.nextInt(5)+1;
    static int PlayerWeapon = 0; // 1 = Sword, 2 = Bow, 3 = Staff, 4 = Axe, 5 = Spear, 6 = Knife 7 = Hammer
    static int WeaponDamage = 0; // 30 Default

    public static void main(String[] args) {
        Introductions(FastLoadingMessageMode);

        if (AbletoPlay == true) {
            Chapter1(FastLoadingMessageMode);
        }

        PlayerStats();
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

        System.out.println("\nA wild mob has appearead!");

        ChooseWeapon();
    }   

    //============Player==============\\
    public static void PlayerStats() {
        System.out.println("\n|==============Player-Status============|");
        System.out.println(" Health: " + PlayerHealth);
        System.out.println(" Level: " + PlayerLevel);
        System.out.println(" Username: " + PlayerUsername);
        System.out.println(" Age: " + PlayerAge);
        PlayerWeapon();
        PlayerTrait();
        System.out.println("|=======================================|");
    }
    public static void ChooseWeapon() {
    System.out.println("\n|==============Please-Choose-a-Weapon-=============|");
        System.out.println(" 1. Wooden Sword            5. Wooden Axe           ");
        System.out.println(" 2. Wooden Bow              6. Wooden Spear         ");
        System.out.println(" 3. Wooden Staff            7. Wooden Knife         ");
        System.out.println(" 4. Wooden Hammer                                   ");
        System.out.println("|==================================================|\n");

        int WeaponNumber = scanner.nextInt();

        switch (WeaponNumber) {
            case 1:
                System.out.println("\nYou have chosen Wooden Sword");
                PlayerWeapon = 1;
                break;
            case 2:
                System.out.println("\nYou have chosen Wooden Bow");
                PlayerWeapon = 2;
                break;
            case 3:
                System.out.println("\nYou have chosen Wooden Staff");
                PlayerWeapon = 3;
                break;
            case 4:
                System.out.println("\nYou have chosen Wooden Axe");
                PlayerWeapon = 4;
                break;
            case 5:
                System.out.println("\nYou have chosen Wooden Spear");
                PlayerWeapon = 5;
                break;
            case 6:
                System.out.println("\nYou have chosen Wooden Knife");
                PlayerWeapon = 6;
                break;
            case 7:
                System.out.println("\nYou have chosen Wooden Hammer");
                PlayerWeapon = 7;
                break;
            case 8:
                System.out.println("\nYou have chosen Admin Weapon");
                PlayerWeapon = 8;
                break;
            default:
                System.out.println("\nInvalid choice. Please choose a valid weapon.");
                break;
        }
    }
    public static void PlayerWeapon() {
        switch (PlayerWeapon) {
            case 1:
                System.out.println(" Weapon: Wooden Sword");
                WeaponDamage = 30;
                break;
            case 2:
                System.out.println(" Weapon: Wooden Bow");
                WeaponDamage = 30;
                break;
            case 3:
                System.out.println(" Weapon: Wooden Staff");
                WeaponDamage = 30;
                break;
            case 4:
                System.out.println(" Weapon: Wooden Axe");
                WeaponDamage = 30;
                break;
            case 5:
                System.out.println(" Weapon: Wooden Spear");
                WeaponDamage = 30;
                break;
            case 6:
                System.out.println(" Weapon: Wooden Knife");
                WeaponDamage = 30;
                break;
            case 7:
                System.out.println(" Weapon: Wooden Hammer");
                WeaponDamage = 30;
                break;
            case 8:
                System.out.println(" Weapon: Admin Weapon");
                WeaponDamage = 999999999;
                break;
        }
    }
    public static void PlayerTrait() {
        switch (PlayerTrait) {
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
    }
    public static void PlayerLevel() {
         while (PlayerEXP >= 100 * PlayerLevel) {
            PlayerLevel++;
            PlayerEXP -= 100*PlayerLevel;
            System.out.println(" You leveled up! Your new level is " + PlayerLevel);
        }
    }
    //============Mobs==============\\
    public static void Mobs() {


    }

    //============Miscellaneous==============\\

    public static void EncounterMessage() {
        System.out.println("\nA wild mob has appeared!");
    }

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
