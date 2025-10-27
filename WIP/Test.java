import java.util.Random;

public class Test {

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
        System.out.println("Player Level is " + PlayerLevel);

        PlayerEXP += 1050;
        PlayerLevel();

        System.out.println("Player Level is " + PlayerLevel);
    }

    // =================Methods=================\\
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

    public static void PlayerLevel() {
        while (PlayerEXP >= 100 * PlayerLevel) {
            PlayerLevel++;
            PlayerEXP -= 100*PlayerLevel;
            System.out.println(" You leveled up! Your new level is " + PlayerLevel);
        }
    }
}
