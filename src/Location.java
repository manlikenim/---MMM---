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

    // Show the details of the current location and alien in it
    public void showLocation() {
        Utils.displayStory("You are now in " + name);
        Utils.displayStory("Zip2 reads: " + description);
        display("");
        Utils.displayStory("You can see an alien. It has a name " +
                "tag on it. It reads " +  currAlien.getName() + ".");
        Utils.displayStory("Zalien reads: " +
                            currAlien.getDescription() + "");
        display("");
    }

    // Show the details of the alien in the location
    public void escapeOrFight(Player player) {
        String choice = "INVALID";
        if (isFinalLocation()){
            Utils.displayStory("This is the final location!");
            Utils.displayStory("You have to beat the main boss to " +
                    "           complete the game...");
            display("");
            beginFight(player);
        } else {
            String[] options = {"FIGHT", "F", "ESCAPE", "E"};
            while (choice.equals("INVALID")) {
                display("Do you want to FIGHT " + currAlien.getName() +
                        " or ESCAPE to the next location?");
                choice = Utils.getInput(options);
            }
            if (choice.equals("FIGHT") || choice.equals("F")) {
                beginFight(player);
            } else {
                escape(player);
            }
        }
    }
    // Start the fight between the alien and the player

    private void beginFight(Player player) {
        display("======================================FIGHT===============" +
                "======================");
        String aliensName = currAlien.getName();
        Utils.displayStory("You are now facing " +
                            aliensName + "!\n");

        while (player.isAlive()) {
            // Player attacks the alien
            if (currAlien.isAlive()){
                player.attack(currAlien);
            } else {
                Utils.displayStory("You have defeated " +
                                    aliensName + "!");
                player.increaseExperience();
                display("===================================================" +
                        "=============================\n");


                // Jump to the end scene one final location has been cleared
                // else go to the next location
                if (isFinalLocation()) {
                    player.gameCompleted();
                } else {
                    changeLocation(player);
                }
            }

            // Alien attacks the player if both are still alive
            if (currAlien.isAlive() & player.isAlive()){
                currAlien.attack(player);
            }

            // Game is over if the player is no longer alive
            if (!player.isAlive()) {
                player.gameOver();
            }
            display("");
        }
    }

    // Move on to the next location
    private void escape(Player player) {
        Utils.displayStory("You have chosen to escape!");
        display("");
        changeLocation(player);
    }

    private void changeLocation(Player player){
        String choice = "INVALID";
        while (choice.equals("INVALID")) {
            Utils.displayStory("The available exists are:");

            // Iterating through available exists and showing them to the user
            // for input
            ArrayList<String> options = new ArrayList<>();
            for (Exit currExit : exits) {

                // Both full direction and short direction names are added so
                // that users can make use of both e.g. L or Left are both
                // understood as left
                options.add(currExit.getDirectionName());
                options.add(currExit.getShortDirectionName());

                Utils.displayStory(currExit.getDirectionName() +
                                    " leading to " + currExit.getLeadsTo());
            }
            choice = Utils.getInput(options.toArray(new String[options.size()
                    ]));
        }
        display("");

        // Iterating through the lists of exits to find the one chosen by the
        // user
        for (Exit currExit : exits) {
            Location nextLocation = currExit.getLeadsTo();
            if (choice.equals(currExit.getDirectionName()) ||
                    choice.equals(currExit.getShortDirectionName())) {
                Utils.displayStory("You chose to go " +
                                    currExit.getDirectionName() + ".");
                Utils.displayStory("You have now left " + name + ".");
                display("");
                player.setCurrLocation(nextLocation);
                break;
            }
        }

        // Start the game in the new location
        player.play();
    }


    // Helper function to ease printing
    private void display(String message){
        System.out.println(message);
    }

    @Override
    public String toString() {
        return name;
    }

}
