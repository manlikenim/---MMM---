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
        display("You are now in " + name);
        display("Zip2 reads: " + description);
        display("\nYou can see an alien. It has a name tag on it. It reads " +
                currAlien.getName() + ".");
        display("Zalien reads: " + currAlien.getDescription() + "\n");
    }

    // Show the details of the alien in the location
    public void escapeOrFight(Player player) {
        String choice = "INVALID";
        if (isFinalLocation()){
            display("This is the final location!");
            display("You have to beat the main boss to complete the game...\n");
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
                flee(player);
            }
        }
    }
    // Start the fight between the alien and the player

    private void beginFight(Player player) {
        display("====================FIGHT====================");
        String aliensName = currAlien.getName();
        display("You are now facing " + aliensName + "!\n");

        while (player.isAlive()) {
            // Player attacks the alien
            if (currAlien.isAlive()){
                player.attack(currAlien);
            } else {
                display("You have defeated " + aliensName + "!");
                player.increaseExperience();
                display("=============================================\n");


                if (isFinalLocation()) {
                    player.gameCompleted();
                } else {
                    changeLocation(player);
                }
                break;
            }

            // Alien attacks the player if both are still alive
            if (currAlien.isAlive() & player.isAlive()){
                currAlien.attack(player);
            }

            // Game is over if the player is no longer alive
            if (!player.isAlive()) {
                player.gameOver();
                break;
            }
            display("");
        }
    }

    // Move on to the next location
    private void flee(Player player) {
        display("You have chosen to flee!");
        changeLocation(player);
    }

    private void changeLocation(Player player){
        String choice = "INVALID";
        while (choice.equals("INVALID")) {
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
            choice = Utils.getInput(options.toArray(new String[options.size()
                    ]));
        }

        // Iterating through the lists of exits to find the one chosen by the
        // user
        for (Exit currExit : exits) {
            Location nextLocation = currExit.getLeadsTo();
            if (choice.equals(currExit.getDirectionName()) ||
                    choice.equals(currExit.getShortDirectionName())) {
                display("You chose to go " + currExit.getDirectionName() + ".");
                display("You have now left " + name + ".\n");
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
