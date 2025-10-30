public main Character {

    protected int health = 10;
    
    public Character () //super() Create Character with health of ten
    {

    }

    public Character (int health) //super(100) Create Character with health 100
    {
        this.health = health;
    }

    //Accessors
    public int getHealth()
    {
        return health;
    }

    //Mutator
    public void setHealth(int health) //Character.setHealth(500) Changes health based on actions on the board. Take damages/heal
    {
        this.health = health;
    }
}