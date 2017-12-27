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

    public void setExperience(int experience) {
        this.experience = experience;
    }


    public Location getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
    }

    // Attack the enemy
    public void attack(Alien enemy) {
        enemy.takeDamage(currDamage);
    }

    // Decreases the player's health by taking into account the damage taken
    // and player's experience
    public void takeDamage(int damage) {
        this.currHealth = Math.max(0, currHealth - (damage / experience));
    }

    // Checks if the player has any health left
    private boolean isAlive() {
        return currHealth > 0;
    }

    public void play() {
        currLocation.showLocation();
        currLocation.fleeOrFight(this);
    }

    public void gameOver() {
        display("You have died! ☠");
        System.exit(0);
    }

    private void display(String message){
        System.out.println(message);
    }

}
