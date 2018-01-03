import java.util.ArrayList;

public interface Location {

    String getName();

    boolean isFinalLocation();

    void addExit(Exit newExit);

    void removeExit(Exit givenExit);

    void showLocation();

    void showOptions(Human human);

    void changeLocation(Human human);
}
