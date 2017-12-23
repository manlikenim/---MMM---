public class Player {

    //    Health related parameters
    private int currHealth;
    private int maxHealth;
    private Spacesuit currSpacesuit;

    // Damage related parameters
    private int baseDamage;
    private int currDamage;
    private int experience;
    private Weapon currWeapon;

    // Usable item
    private Item currItem;

    // Current location in the game
    private Location currLocation;

    public Player(int maxHealth, Spacesuit currSpacesuit, int baseDamage,
                  Weapon currWeapon, Item currItem, Location currLocation) {
        this.currHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.currSpacesuit = currSpacesuit;
        this.baseDamage = baseDamage;
        this.currDamage = baseDamage + currWeapon.getDamage();
        this.currWeapon = currWeapon;
        this.currItem = currItem;
        this.currLocation = currLocation;
    }

    public Spacesuit getCurrSpacesuit() {
        return currSpacesuit;
    }

    public void setCurrSpacesuit(Spacesuit currSpacesuit) {
        this.currSpacesuit = currSpacesuit;
    }


    public void setExperience(int experience) {
        this.experience = experience;
    }


    public void setCurrWeapon(Weapon currWeapon) {
        this.currWeapon = currWeapon;
    }

    public Item getCurrItem() {
        return currItem;
    }

    public void setCurrItem(Item currItem) {
        this.currItem = currItem;
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

}
