public class Alien {

    // Description of the alien
    private String name;
    private String description;

    // Health and damage status of the alien
    private int health;
    private int damage;
    private boolean metEnemy;

    public Alien(String name, String description, int health, int damage) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.damage = damage;
        this.metEnemy = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Start a fight with the given player
    public void fight(Player enemy) {
        if (!metEnemy) {
            // System.out.println("You are now facing " + );
            // show the name
            // show the description
            // show the stats of the enemy
        }
        attack(enemy);
    }

    // Attack the given player
    public void attack(Player enemy) {
        // show a line saying the enemy has attacked you
        enemy.takeDamage(damage);
    }

    // Decreases the alien's health by taking into account the damage taken
    public void takeDamage(int damage) {
        this.health = Math.max(0, health - damage);
    }

    private boolean isAlive() {
        return health > 0;
    }
}
