public class Player implements Human {

    // Player parameters that change through our the game
    private int health;
    private int damage;
    private int experience;

    // Current location in the game
    private Location currLocation;

    private int numLocations;

    // Trivial constructor without a location
    public Player() {
        this.health = 100;
        this.damage = 10;
        this.experience = 1;
        this.currLocation = null;
        this.numLocations = 100;
    }

    // Non-trivial constructor where all the parameters are provided
    public Player(int maxHealth, int baseDamage, Location currLocation,
                  int numLocations) {
        this.health = maxHealth;
        this.damage = baseDamage;
        this.experience = 1;
        this.currLocation = currLocation;
        this.numLocations = numLocations;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    // Increase player's experience after defeating an enemy
    public void increaseExperience() {
        this.experience++;
    }

    @Override
    // Change the player's location
    public void setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
    }

    @Override
    public void interact(Alien alien) {
//            BadAlien enemy = (BadAlien) alien;
            attack(alien);
    }

    // Attack the enemy
    public void attack(Alien enemy) {
        display("=====Your Stats=====");
        display("Health: " + health + " Damage: " + damage);

        enemy.takeDamage(damage);

        display("You attacked " + enemy.getName() +
                " and dealt a damage of " + damage + ".");
    }

    @Override
    // Decreases the player's health by taking into account the damage taken
    // and player's experience
    public void takeDamage(int damage) {
        this.health = Math.max(0, health - (damage / experience));
    }

    @Override
    // Checks if the player has any health left
    public void play() {
        currLocation.showLocation();
        currLocation.showOptions(this);
    }

    @Override
    // Shown at the end of the game's completion
    public void gameCompleted() {
        if (numLocations == experience - 1) {
            display("Well done! You have collected all the required samples.");
        }
        display("Congratulations! You have successfully completed the game.");
        System.exit(0);
    }

    @Override
    // Shown when the player dies
    public void gameOver() {
        display("You have died! ☠");
        System.exit(0);
    }



    // Helper function to ease printing
    private void display(String message) {
        System.out.println(message);
    }

}
