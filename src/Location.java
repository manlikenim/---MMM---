import java.util.ArrayList;
import java.util.Scanner;

public class Location {
    private String name;
    private String description;
    private Alien currAlien;
    private Item currItem;
    private ArrayList<Exit> exits;

    public Location(String name, String description, Alien currAlien, Item currItem) {
        this.name = name;
        this.description = description;
        this.currAlien = currAlien;
        this.currItem = currItem;
        this.exits = new ArrayList<>();
    }

    // Getter methods for the parameters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Alien getCurrAlien() {
        return currAlien;
    }

    public Item getCurrItem() {
        return currItem;
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }

    @Override
    public String toString() {
        return this.name;
    }

    // Add new exit to the location
    public void addExit(Exit newExit) {
        exits.add(newExit);
    }

    // Remove an existing exit from the location
    public void removeExit(Exit givenExit) {
        if (exits.contains(givenExit)) {
            exits.remove(givenExit);
        }
    }

    // Show the details of the current location
    public void showLocation() {
        display("You are now in " + name);
        display(description);
        display("You can see an alien. It has a name tag on it. It reads " +
                currAlien.getName());
    }

    // Show the details of the alien in the location
    public void fleeOrFight(Player enemy) {
        String choice = "INVALID";
        String[] options = {"FIGHT", "FLEE"};
        while (choice.equals("INVALID")) {
            display("");
            display("Do you want to fight " + currAlien.getName() + " or flee to " +
                    "the next location?");
            choice = Utils.getInput(options);

        }
        // given options to fight or flee
        // if fight is chosen call attack option in alien
        // if flee is chosen, go to the next location
    }

    // Start the fight between the alien and the player
    private void beginFight(Player enemy) {
        // Show a line saying the player attacks
        // player attacks
        // Show a line saying the alien attacks
        // alien attacks
    }

    // Move on to the next location
    private void flee(Player enemy) {
        // Update the player's location
    }

    private void display(String message){
        System.out.println(message);
    }

}
