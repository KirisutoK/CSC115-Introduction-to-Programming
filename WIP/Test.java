import java.util.Random;
import java.util.Scanner;

public class Test {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // Global Variables uSERS \\
    static String PlayerUsername;
    static int PlayerEXP = 0; // 1*100 = 100 // 2*100 = 200 // 3*100 = 300
    static int PlayerLevel = 1;
    static int PlayerHealth = 100;
    static int PlayerAge = 18;
    static int PlayerTrait = random.nextInt(5) + 1;
    static int PlayerWeapon = 8; // 1 = Sword, 2 = Bow, 3 = Staff, 4 = Axe, 5 = Spear, 6 = Knife 7 = Hammer
    static int WeaponDamage = 30; // 30 Default

    public static void main(String[] args) {
        PlayerLevel();
        ChooseWeapon();

        System.out.println("Weapon is " + PrintPlayerWeapon() + " Damage is " + WeaponDamage);


        System.out.println("Player Level is " + PlayerLevel);

    }

    // =================Methods=================\\
    public static void PlayerTrait() {
        switch (PlayerTrait) {
            case 1:
                System.out.println(" Trait: Confident and Brave."); // 2x Damage Boost
                WeaponDamage = WeaponDamage * 2;
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
                WeaponDamage = 30;
                PlayerWeapon = 1;
                break;
            case 2:
                System.out.println("\nYou have chosen Wooden Bow");
                WeaponDamage = 30;
                PlayerWeapon = 2;
                break;
            case 3:
                System.out.println("\nYou have chosen Wooden Staff");
                WeaponDamage = 30;
                PlayerWeapon = 3;
                break;
            case 4:
                System.out.println("\nYou have chosen Wooden Axe");
                WeaponDamage = 30;
                PlayerWeapon = 4;
                break;
            case 5:
                System.out.println("\nYou have chosen Wooden Spear");
                WeaponDamage = 30;
                PlayerWeapon = 5;
                break;
            case 6:
                System.out.println("\nYou have chosen Wooden Knife");
                WeaponDamage = 30;
                PlayerWeapon = 6;
                break;
            case 7:
                System.out.println("\nYou have chosen Wooden Hammer");
                WeaponDamage = 30;
                PlayerWeapon = 7;
                break;
            case 8:
                System.out.println("\nYou have chosen Admin Weapon");
                WeaponDamage = 999999999;
                PlayerWeapon = 8;
                break;
            default:
                System.out.println("\nInvalid choice. Please choose a valid weapon.");
                WeaponDamage = 30;
                break;
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
    public static void PlayerLevel() {
        while (PlayerEXP >= 100 * PlayerLevel) {
            PlayerLevel++;
            PlayerEXP -= 100*PlayerLevel;
            System.out.println(" You leveled up! Your new level is " + PlayerLevel);
        }
    }
}
