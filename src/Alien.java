public interface Alien {

    String getName();

    String getDescription();

    int getHealth();

    boolean isAlive();

    void takeDamage(int damage);

    void interact(Human human);

}
