import java.util.Scanner;
import java.util.Random;

public class RPGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    // Classes \\ Java OOP
    // static Player player = new Player();

    // Global Variables // Miscallenous //
    static int DialogueSpeed = 0; // speed of the loading message
    static boolean AbletoPlay = false; // if the user is ready to play the game
    static boolean AbletoPlayStory = true; // if the user is able to play the story (age restriction)

    // Global Variables // User Stats //
    static String PlayerUsername;
    static int PlayerEXP = 0; // 1*100 = 100 // 2*100 = 200 // 3*100 = 300
    static int PlayerLevel = 1;
    static int PlayerHealth = 100;
    static int PlayerAge = 0;
    static int PlayerTrait = random.nextInt(5)+1;
    static int PlayerWeapon = 0; // 1 = Sword, 2 = Bow, 3 = Staff, 4 = Axe, 5 = Spear, 6 = Knife 7 = Hammer
    static double WeaponDamage = 0; // 30 Default
    public static void main(String[] args) {
        StartGame();

        if (AbletoPlay == true) {
            LoadingScreen();
            Introductions();
        }
        if (AbletoPlayStory == true) {
            Chapter1();

            WorkInProgressMessage();
        }
        
        //Player p1 = new Player(10);

        //p1.setHealth(100);

    }

    //-----------------------------------------------------------------------------\\
    //===================================METHODS===================================\\
    //-----------------------------------------------------------------------------\\

    //============Story==============\\
    public static void StartGame() {
        System.out.println("Would you like to start the game? (Y/N)");
        char StartGame = scanner.next().charAt(0);

        if (StartGame == 'Y' || StartGame == 'y') {
            AbletoPlay = true;
        } else {
            AbletoPlay = false;
            StartGame();
            return;
        }
    }
    public static void LoadingScreen() {
        System.out.println("\nChoose how fast would you like to proceed in the story:");
        System.out.println(" 1. Fast");
        System.out.println(" 2. Normal");
        System.out.println(" 3. Slow\n");
        
        Boolean ValidChoice = false;
        while (ValidChoice == false) {
            int DialogueSpeedChoice = scanner.nextInt();
            switch (DialogueSpeedChoice) {
                case 1:
                    DialogueSpeed = 1;
                    ValidChoice = true;
                    break;
                case 2:
                    DialogueSpeed = 2;
                    ValidChoice = true;
                    break;
                case 3:
                    DialogueSpeed = 3;
                    ValidChoice = true;
                    break;
                case 4:
                    DialogueSpeed = 0;
                    ValidChoice = true;
                    break;
            
                default:
                    Dialogue("Invalid choice, please choose again.");
                    break;
            }
        }

        PlayerTrait(); // runs the PlayerTrait method to assign the trait effects to the players
    }
    public static void Introductions() { 
        Dialogue("\n\nWelcome… lost soul. You drift through the endless veil between worlds, and yet… your spirit still burns. ");
        
        Dialogue("\n\nI am Thesis, the Goddess of Creation, the one who breathes life into stars, and silence into shadows.");
        
        Dialogue("\n\nYou stand now upon the threshold of Eclipsera, a world once radiant… now trembling beneath the shadow of ruin.");
        
        Dialogue("\n\nEclipsera was forged in harmony, where light and darkness coexisted, bound by balance. But that balance… was shattered.");
        
        Dialogue("\n\nAn ancient being, once mortal, has seized the throne of chaos, the Eclipse Lord, Varyn. With every kingdom he conquers,");
        Dialogue("the sky dims, and the stars forget their light.");
        
        Dialogue("\n\nAnd you… are not here by chance. You were torn from your world, from Earth, because destiny chose you.");
        
        Dialogue("\n\nTell me, traveler… what do they call you in your realm? What name shall echo across Eclipsera?\n");
        scanner.nextLine();
        PlayerUsername = scanner.nextLine();
            
        Dialogue("\n\nAnd your age… how long has your soul walked among the living?\n");
        PlayerAge = scanner.nextInt();
        if (PlayerAge > 70) {
            Dialogue("\nYou are too old");
            AbletoPlayStory = false;
            End(0);
            return;
        } else if (PlayerAge <= 5) {
            Dialogue("\nYou are too young");
            AbletoPlayStory = false;
            End(0);
            return;
        }

        Dialogue("\n\nHm… a mortal, fragile in form, yet the flame within you refuses to yield. That resolve… may be the key.");
        
        Dialogue("\n\nListen well Traveler " + PlayerUsername  + ". In order to return to your world, you must restore what was lost. You must defeat Varyn,");
        Dialogue("the Eclipse Lord, and shatter the chains he has bound around this realm.");
        
        Dialogue("\n\nNow Traveler " + PlayerUsername + ", Depart from your adventures, explore the world of Eclipsera, and defeat the Eclipse Lord!");
        
        Dialogue("\n\n");
        
        Dialogue("\n");

        LoadingMessageEffect();

        LoadingMessageEffect();

        LoadingMessageEffect();
        
    }
    public static void Chapter1() {
        Dialogue("\n==========Chapter 1: The Beginning=========="); 
        
        Dialogue("""
                \nThe whisper of the wind brushed against your ears…
                The rustling of grass, the distant calls of unknown creatures — all weaving together into an eerie symphony of life.
                """);
        
        Dialogue("""
                \nYour eyes flutter open.
                Light filters through towering trees, their leaves shimmering like emerald glass.
                You find yourself lying amidst a dense forest, alive with motion and mystery.
                """);
        
        Dialogue("\nWhere… am I?");
        
        Dialogue("""
                \nYou slowly rise, heart pounding, scanning the unfamiliar world around you.
                Then—something flickers before your eyes.
                """);
        
        Dialogue("\nThis...");
        Dialogue("\n\na... screen?");
        
        Dialogue(" ");

        PlayerStats();

        Dialogue(" ");
        
        Dialogue("\n\nAs you read the contents of your profile, you suddenly heard rustling from the bushes.");

        Dialogue("\n\nA wild mob has appearead!");

        ChooseWeapon();
    }   
    public static void End(int num) {
        int RandomEndNumber = random.nextInt(3) + 1;

        switch (RandomEndNumber) { // Randomizes Death Messages
            case 1:
                Dialogue("\n\nYour journey ends here... but your story will be remembered.");
                break;
            case 2:
                Dialogue("\n\nYou have failed... but perhaps fate will give you another chance.");
                break;
            case 3:
                Dialogue("\n\nYour will was strong, but the world proved stronger.");
                break;
        }

        Dialogue("\n\nWould you like to try again? (Y/N)\n");
        char RetryChoice = scanner.next().charAt(0);

        int RestartChoice = 0;
        Dialogue("\n|==========Would-you-like-to===========|");
        Dialogue("\n       1. Restart the game");
        Dialogue("\n 2. Respawn in the current chapter");
        Dialogue("\n|======================================|\n\n");
        RestartChoice = scanner.nextInt();
        

        if (RetryChoice == 'Y' || RetryChoice == 'y') {
            switch (num) {
                case 0:
                    if (RestartChoice == 1) {
                        ResetPlayerStats();
                        StartGame();
                    } else if (RestartChoice == 2) {
                        Introductions();
                    } else {
                        Dialogue("\n\nInvalid choice. Exiting game.");
                    }
                    break;
                case 1: 
                    if (RestartChoice == 1) {
                        ResetPlayerStats();
                        StartGame();
                    } else if (RestartChoice == 2) {
                        Chapter1();
                    } else {
                        Dialogue("\n\nInvalid choice. Exiting game.");
                    }
                    break;
            }
        } else {
            Dialogue("\n\nThank you for playing. Farewell, traveler.");
        }
    }
    //============Player==============\\
    public static void PlayerStats() {
        Dialogue("\n\n|==============Player-Status============|");
        Dialogue("\n Username: " + PlayerUsername);
        Dialogue("\n Health: " + PlayerHealth);
        Dialogue("\n Level: " + PlayerLevel);
        Dialogue("\n Age: " + PlayerAge);
        Dialogue("\n Weapon: " + PrintPlayerWeapon());
        Dialogue(PrintPlayerTrait());
        Dialogue("\n|=======================================|");
    }
    public static void ResetPlayerStats() {
        PlayerEXP = 0;
        PlayerLevel = 1;
        PlayerHealth = 100;
        PlayerTrait = random.nextInt(5)+1;
        PlayerWeapon = 0; 
        WeaponDamage = 0; 

        DialogueSpeed = 0; 
        AbletoPlay = false; 
        AbletoPlayStory = true; 
    }
    public static void ChooseWeapon() {
    Dialogue("\n\n|==============Please-Choose-a-Weapon-=============|");
        Dialogue("\n 1. Wooden Sword            5. Wooden Axe           ");
        Dialogue("\n 2. Wooden Bow              6. Wooden Spear         ");
        Dialogue("\n 3. Wooden Staff            7. Wooden Knife         ");
        Dialogue("\n 4. Wooden Hammer                                   ");
        Dialogue("\n|==================================================|\n\n");

        int WeaponNumber = scanner.nextInt();
        
        boolean EquipedWeapon = false;
        while (EquipedWeapon == false) {
            switch (WeaponNumber) {
                case 1:
                    Dialogue("\n\nYou have chosen Wooden Sword");
                    WeaponDamage = 30;
                    PlayerWeapon = 1;
                    EquipedWeapon = true;
                    break;
                case 2:
                    Dialogue("\n\nYou have chosen Wooden Bow");
                    WeaponDamage = 30;
                    PlayerWeapon = 2;
                    EquipedWeapon = true;
                    break;
                case 3:
                    Dialogue("\n\nYou have chosen Wooden Staff");
                    WeaponDamage = 30;
                    PlayerWeapon = 3;
                    EquipedWeapon = true;
                    break;
                case 4:
                    Dialogue("\n\nYou have chosen Wooden Hammer");
                    WeaponDamage = 30;
                    PlayerWeapon = 4;
                    EquipedWeapon = true;
                    break;
                case 5:
                    Dialogue("\n\nYou have chosen Wooden Axe");
                    WeaponDamage = 30;
                    PlayerWeapon = 5;
                    EquipedWeapon = true;
                    break;
                case 6:
                    Dialogue("\n\nYou have chosen Wooden Spear");
                    WeaponDamage = 30;
                    PlayerWeapon = 6;
                    EquipedWeapon = true;
                    break;
                case 7:
                    Dialogue("\n\nYou have chosen Wooden Knife");
                    WeaponDamage = 30;
                    PlayerWeapon = 7;
                    EquipedWeapon = true;
                    break;
                case 8:
                    Dialogue("\n\nYou have chosen Admin Weapon");
                    WeaponDamage = 999999999;
                    PlayerWeapon = 8;
                    EquipedWeapon = true;
                    break;
                default:
                    Dialogue("\n\nInvalid choice. Please choose a valid weapon.");
                    break;
            }
        }
    }
    public static String PrintPlayerWeapon() { //Prints the weapon name (Does not affect anything)
        switch (PlayerWeapon) {
            case 1:
                return "Wooden Sword";
            case 2:
                return "Wooden Bow";
            case 3:
                return "Wooden Staff";
            case 4:
                return "Wooden Axe";
            case 5:
                return "Wooden Spear";
            case 6:
                return "Wooden Knife";
            case 7:
                return "Wooden Hammer";
            case 8:
                return "Admin Weapon";
            default:
                return "None";
        }
    }
    public static void PlayerTrait() {
        switch (PlayerTrait) {
            case 1: // Confident and Brave => 2x Damage Boost
                WeaponDamage *= 1.5;
                break;
            case 2: // Energetic and Enthusiastic => 2x Health
                PlayerHealth *= 1.5;
                break;
            case 3: // Curious and Observative 2x Exp
                break;
            case 4: // Lucky and Fortunate => 2x Crit Chance
                if (random.nextInt(2)+1 == 2) // so that it repeats instead of permament
                 WeaponDamage *= 2;
                break;
            case 5: // No Buff
                break;
        }
    }
    public static String PrintPlayerTrait() { //Prints the trait name (Does not affect anything)
        switch (PlayerTrait) {
            case 1:
                return "\n Trait: Confident and Brave."; // 2x Damage Boost
            case 2:
                return "\n Trait: Energetic and Enthusiastic"; // 2x Health
            case 3:
                return "\n Trait: Curious and Aware"; // 2x Exp
            case 4:
                return "\n Trait: Lucky"; // 2x Crit Chance
            case 5:
                return "\n Trait: None"; // No Buff
            default:
                return "\n Trait: None";
        }
    }
    public static void PlayerLevel() {
         while (PlayerEXP >= 100 * PlayerLevel) {
            PlayerLevel++;
            PlayerHealth += 10*PlayerLevel;
            PlayerEXP -= 100*PlayerLevel;
            Dialogue(" You leveled up! Your new level is " + PlayerLevel);
        }
    }
    //============Mobs==============\\
    public static void Mobs() {


    }

    //============Miscellaneous==============\\

    public static void EncounterMessage() { // when the player encounters a mob
        Dialogue("\nA wild mob has appeared!");
    }
    public static String Dialogue(String Dialogue) { // Prints each word by word with a delay making it look like a typing effect
        try { 
            for (char Characters : Dialogue.toCharArray()) {
                System.out.print(Characters);
                Thread.sleep(25 * DialogueSpeed);
            }
        } catch (InterruptedException e) {
            Dialogue("An error occurred during loading.");
        }
        return Dialogue;
    }
    public static void LoadingMessageEffect() { // Prints 3 dots with a delay
        try {
            for(int i = 1; i <= 3; i++) {
                System.out.print(".");
                Thread.sleep(1000); // 2500 is the default which is 2.5 seconds
            }
        } catch (InterruptedException e) {
            Dialogue("DELAY ERROR!");
        }
    }
    public static void WorkInProgressMessage() { // Message displayed at the end of the game
        System.out.println("\n");
        LoadingMessageEffect();
        System.out.println("\n");
        LoadingMessageEffect();
        DialogueSpeed = 2;
        Dialogue("Dear " + PlayerUsername + ",");
        Dialogue("""
            \n\nThank you.. truly.. for taking the time to experience my game.
            Every moment you spent here means more than you know.

            This project is a journey I've poured my heart into, and knowing that you've reached this point makes it all worth it.
            Your curiosity, your patience, and your time are deeply appreciated.

            I hope this world gave you even a small spark of joy or inspiration today.
            Please check back from time to time — I'm still building, improving, and bringing this dream closer to completion.

            Until then, take care of yourself, keep chasing what you love, and never stop exploring.

            Thank you, and see you again soon. 🌟
                """);
    }
}
