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

    public int getDamage() {
        return damage;
    }

    // Attack the given player
    public void attack(Player enemy) {
        display(">>>>>Alien Stats<<<<<");
        display("Name: " + name + " Health: " + health + " Damage: " + damage);

        enemy.takeDamage(damage);

        display(name + " attacked you and dealt a damage of " + damage + ".\n");
    }

    // Decreases the alien's health by taking into account the damage taken
    public void takeDamage(int damage) {
        this.health = Math.max(0, health - damage);
    }

    public boolean isAlive() {
        return health > 0;
    }

    private void display(String message) {
        System.out.println(message);
    }

    @Override
    public String toString() {
        return name;
    }
}
