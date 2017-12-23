public class Alien {

    // Description of the alien
    private String name;
    private String description;

    // Health and damage status of the alien
    private int health;
    private int damage;

    public Alien(String name, String description, int health, int damage) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Attack the given player
    public void attack(Player enemy) {
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
