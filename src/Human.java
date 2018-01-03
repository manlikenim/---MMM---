public interface Human {

    int getHealth();

    boolean isAlive();

    void increaseExperience();

    void setCurrLocation(Location currLocation);

    void interact(Alien alien);

    void takeDamage(int damage);

    void play();

    void gameCompleted();

    void gameOver();
}
