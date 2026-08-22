import java.util.Random;

public class Player {
    static Random random = new Random();

    protected String UserName = " "; // Player's name

    protected int Health = 0; // Player's health
    protected String Pet = " "; // Player's pet
    protected int PetDamage = 0; // Player's pet damage

    protected int Level = 1; // Player's level
    protected int Experience = 0; // Player's experience points
    protected int ExperienceToNextLevel = 100; // Experience points needed for next level
    
    protected int MaxHealth = 0; // Player's maximum health to calculate HP and EXP Calculation

    public Player(String n, int h, String w, int wdmg) { // Constructor (Name, Health, Pet, PetDamage)
        this.UserName = n; // Shows in User Stats 
        this.Health = h; // Shows in User Stats 
        this.MaxHealth = h; // For HP and EXP Calculation
        this.Pet = w; // Shows in User Stats 
        this.PetDamage = wdmg; // Shows in User Stats 
    }

    //=================Setters and Getters=================\\
    public void setUserName(String name) { 
        this.UserName = name;
    }
    public void setHealth(int health) {
        this.Health += health;
    }
    public void setMaxHealth(int maxHealth) {
        this.MaxHealth += maxHealth;
    }
    public void setPet(String Pet) {
        this.Pet = Pet;
    }
    public void setPetDamage(int PetDamage) {
        this.PetDamage += PetDamage;
    }
    public void setAll(int health, String Pet, int PetDamage) {
        this.Health += health;
        this.MaxHealth += health;
        this.Pet = Pet;
        this.PetDamage += PetDamage;
    }
    //------------------------------------------------\\
    public String getUserName() {
        return UserName;
    }
    public int getHealth() {
        return Health;
    }
    public String getPet() {
        return Pet;
    }
    public int getPetDamage() {
        return PetDamage;
    }
    public int getLevel() {
        return Level;
    }
    public int getExp() {
        return  Experience;
    }
    public int getExpToNextLevel() {
        return ExperienceToNextLevel;
    }
    public int getMaxHealth() {
        return MaxHealth;
    }

    //=================Healing ReuseableMethods==============\\
    public void fullHeal() {
        this.Health = this.MaxHealth;
    }

    //=================Leveling ReuseableMethods==============\\
    public void addExp(int expGained) {
        this.Experience += expGained;
        Dialogue("\n+ Gained " + expGained + " EXP!");
        
        // Check if leveled up
        while (this.Experience >= this.ExperienceToNextLevel) {
            levelUp();
        }
    }
    // Level up method
    private void levelUp() {
        this.Level++;
        this.Experience -= this.ExperienceToNextLevel;
        this.ExperienceToNextLevel = (int)(this.ExperienceToNextLevel * 1.5); // Increase exp needed by 50%
        
        // Calculate 100% of current stats (double them)
        int healthIncrease = this.MaxHealth; // 100% of max health
        int damageIncrease = this.PetDamage; // 100% of damage
        
        // Apply increases
        this.MaxHealth += healthIncrease;  // Doubles max health
        this.Health += healthIncrease;      // Adds to current health
        this.PetDamage += damageIncrease;   // Doubles damage
        
        Dialogue("\n\n[" + getLevel() +"] LEVEL UP! " + "[" + getLevel() +"]");
        Dialogue("\n\nYour " + this.Pet + " is now Level " + this.Level + "!");
        Dialogue("\nHealth increased by " + healthIncrease + "! (New Max: " + this.MaxHealth + ")");
        Dialogue("\nDamage increased by " + damageIncrease + "! (New Damage: " + this.PetDamage + ")");
        Dialogue("\nNext level at: " + this.ExperienceToNextLevel + " EXP");
    }

    //=================Other ReuseableMethods=================\\

    public String getAttackMessage() {
        switch (this.Pet) {
            case "Cat":
                String[] catAttacks = {"scratched at", "pounces on", "swipes at", "lunges at", "claws", "bites", "hisses at"};
                return catAttacks[random.nextInt(catAttacks.length)];
            case "Dog":
                String[] dogAttacks = {"bites", "lunges at", "nips at", "pounces on", "snaps at", "growls at", "chews on"};
                return dogAttacks[random.nextInt(dogAttacks.length)];
            case "Squirrel":
                String[] squirrelAttacks = {"scratches at", "bites", "nibbles on", "lunges at", "pounces on", "chomps at", "scurries towards", "throws a nut at", "pees on"};
                return squirrelAttacks[random.nextInt(squirrelAttacks.length)];
            case "Crow":
                String[] crowAttacks = {"pecks at", "swoops down on", "scratches with its claws at", "lunges at", "caws at", "flaps wings at", "stabs with beak at"};
                return crowAttacks[random.nextInt(crowAttacks.length)];
            case "Hamster":
                String[] hamsterAttacks = {"nibbles on", "squeaks at", "rolls into", "wiggles nose at", "scurries at", "scratches weakly at"};
                return hamsterAttacks[random.nextInt(hamsterAttacks.length)];
            case "Cow":
                String[] cowAttacks = {"butts", "kicks", "tramples", "headbutts", "moos loudly at", "charges at", "rams"};
                return cowAttacks[random.nextInt(cowAttacks.length)];
            case "Pig":
                String[] pigAttacks = {"rams", "bites", "charges at", "squeals and tackles", "headbutts", "tusks at", "snorts at"};
                return pigAttacks[random.nextInt(pigAttacks.length)];
            case "Chicken":
                String[] chickenAttacks = {"clucks at", "pecks furiously at", "scratches with talons at", "flaps wings at", "charges at", "squawks at"};
                return chickenAttacks[random.nextInt(chickenAttacks.length)];
            case "Goat":
                String[] goatAttacks = {"headbutts", "rams", "kicks", "charges with horns at", "bleats and strikes at", "butts"};
                return goatAttacks[random.nextInt(goatAttacks.length)];
            case "Horse":
                String[] horseAttacks = {"kicks", "tramples", "bites", "rears and strikes at", "charges at", "bucks at", "neighs and stomps on"};
                return horseAttacks[random.nextInt(horseAttacks.length)];
            case "Tyrannosaurus Rex":
                String[] trexAttacks = {"chomps on", "tail-whips", "stomps on", "roars and bites", "crushes with jaws at", "slams into"};
                return trexAttacks[random.nextInt(trexAttacks.length)];
            default:
                String[] defaultAttacks = {"attacks", "strikes at", "hits", "charges at", "lunges at"};
                return defaultAttacks[random.nextInt(defaultAttacks.length)];
        }
    }
    public static String Dialogue(String Dialogue) { // Prints each word by word with a delay making it look like a typing effect
        try { 
            for (char Characters : Dialogue.toCharArray()) {
                System.out.print(Characters);
                Thread.sleep(25 * 1);
            }
        } catch (InterruptedException e) {
            Dialogue("An error occurred during loading.");
        }
        return Dialogue;
    }
}

