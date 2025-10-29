import java.util.Random;

public class Player {

    Random random = new Random();

    public String PlayerUsername;
    public int PlayerEXP = 0; // 1*100 = 100 // 2*100 = 200 // 3*100 = 300
    public int PlayerLevel = 1;
    public int PlayerHealth = 100;
    public int PlayerAge = 0;
    public int PlayerTrait = random.nextInt(5)+1;
    public int PlayerWeapon = 0; // 1 = Sword, 2 = Bow, 3 = Staff, 4 = Axe, 5 = Spear, 6 = Knife 7 = Hammer
    public double WeaponDamage = 0; // 30 Default

}
