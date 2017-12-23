public class Entity {

    private String name;
    private int health;
    private int damage;

    public Entity(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void reduceHealth(int hit) {
        this.health -= hit;
    }

    public void gainHealth(int potion) {
        this.health += potion;
    }
}
