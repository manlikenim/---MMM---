import java.util.ArrayList;

public class Player {

    //    Health related parameters
    private int currHealth;
    private int maxHealth;

    // Damage related parameters
    private int baseDamage;
    private int currDamage;
    private int experience;

    // Current location in the game
    private Location currLocation;

    public Player() {
        this.currHealth = 100;
        this.maxHealth = 100;
        this.baseDamage = 10;
        this.currDamage = 10;
        this.experience = 1;
        this.currLocation = null;
    }

    public Player(int maxHealth, int baseDamage, Location currLocation) {
        this.currHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.baseDamage = baseDamage;
        this.currDamage = baseDamage;
        this.experience = 1;
        this.currLocation = currLocation;
    }

    public void increaseExperience() {
        this.experience++;
    }


    public Location getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
    }

    public int getCurrDamage() {
        return currDamage;
    }

    // Attack the enemy
    public void attack(Alien enemy) {
        display("=====Your Stats=====");
        display("Health: " + currHealth + " Damage: " + currDamage);

        enemy.takeDamage(currDamage);

        display("You attacked " + enemy.getName() +
                " and dealt a damage of " + currDamage + ".");
    }

    // Decreases the player's health by taking into account the damage taken
    // and player's experience
    public void takeDamage(int damage) {
        this.currHealth = Math.max(0, currHealth - (damage / experience));
    }

    // Checks if the player has any health left
    public boolean isAlive() {
        return currHealth > 0;
    }

    public void play() {
        currLocation.showLocation();
        currLocation.escapeOrFight(this);
    }

    public void gameCompleted() {
        display("Congratulations! You have successfully completed the game.");
        System.exit(0);
    }

    public void gameOver() {
        display("You have died! ☠");
        System.exit(0);
    }

    private void display(String message) {
        System.out.println(message);
    }

}
