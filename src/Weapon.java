public class Weapon {

    // Description of the weapon
    private String name;
    private String description;
    private int damage;

    public Weapon(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
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
}
