import java.util.ArrayList;

public class Location {
    private String name;
    private String description;
    private Alien currAlien;
    private ArrayList<Exit> exits;

    public Location(String name, String description, Alien currAlien) {
        this.name = name;
        this.description = description;
        this.currAlien = currAlien;
        this.exits = new ArrayList<>();
    }

    // Getter methods for the parameters
    public String getName() {
        return name;
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

    public boolean isFinalLocation() {
        return exits.size() == 0;
    }

    // Show the details of the current location
    public void showLocation() {
        display("You are now in " + name);
        display(description);
        display("You can see an alien. It has a name tag on it. It reads " +
                currAlien.getName());
    }
    // Show the details of the alien in the location

    public void fleeOrFight(Player player) {
        String choice = "INVALID";
        if (isFinalLocation()){
            display("This is the final location!");
            display("You have to beat the main boss to complete the game...");
            beginFight(player);
        } else {
            String[] options = {"FIGHT", "FLEE"};
            while (choice.equals("INVALID")) {
                display("Do you want to fight " + currAlien.getName() + " or flee to " +
                        "the next location?");
                choice = Utils.getInput(options);
            }
            if (choice.equals("FIGHT")) {
                display("You are now");
                beginFight(player);
            } else {
                flee(player);
            }
        }
    }
    // Start the fight between the alien and the player

    private void beginFight(Player player) {
        String aliensName = currAlien.getName();
        while (player.isAlive()) {
            // Player attacks the alien
            if (currAlien.isAlive()){
                player.attack(currAlien);
            } else {
                display("You have defeated " + aliensName + "!");
                player.increaseExperience();

                if (isFinalLocation()) {
                    player.gameCompleted();
                }
                break;
            }

            // Alien attacks the player
            if (player.isAlive()){
                currAlien.fight(player);
            } else {
                player.gameOver();
                break;
            }
            display("");
        }
    }

    // Move on to the next location
    private void flee(Player player) {
        String choice = "INVALID";
        while (choice.equals("INVALID")) {
            display("You have chosen to flee!");
            display("The available exists are:");

            // Iterating through available exists and showing them to the user
            // for input
            ArrayList<String> options = new ArrayList<>();
            for (Exit currExit : exits) {

                // Both full direction and short direction names are added so
                // that users can make use of both e.g. L or Left are both
                // understood as left
                options.add(currExit.getDirectionName());
                options.add(currExit.getShortDirectionName());

                display(currExit.getDirectionName() + " leading to " +
                        currExit.getLeadsTo());
            }
            choice = Utils.getInput(((String[]) options.toArray()));
        }

        // Iterating through the lists of exits to find the one chosen by the
        // user
        for (Exit currExit : exits) {
            Location nextLocation = currExit.getLeadsTo();
            if (choice.equals(currExit.getDirectionName()) ||
                    choice.equals(currExit.getShortDirectionName())) {
                display("You chose to go " + currExit.getDirectionName());
                display("You have now left " + name);
                player.setCurrLocation(nextLocation);
                break;
            }
        }

        // Start the game in the new location
        player.play();
    }

    private void display(String message){
        System.out.println(message);
    }

    @Override
    public String toString() {
        return name;
    }

}
