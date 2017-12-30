public class GameWorld {
    private Player player;

    public GameWorld() {
        this.player = new Player();
    }

    public void chooseDifficulty() {
        String choice = "INVALID";
        String[] options = {"1", "EASY", "E", "1. EASY",
                            "2", "NORMAL", "N", "2. NORMAL",
                            "3", "HARD", "3. HARD"};

        while (choice.equals("INVALID")) {
            display("Welcome to Musk's Mission to Mars!");
            display("Please choose a difficulty");
            display("1. Easy");
            display("2. Normal");
            display("3. Hard");
            choice = Utils.getInput(options);
        }

        if (choice.equals("1") || choice.equals("EASY") ||
            choice.equals("E") || choice.equals("1. EASY")) {

            easyGame();
        } else if (choice.equals("2") || choice.equals("NORMAL") ||
                   choice.equals("N") || choice.equals("2. NORMAL")){

            normalGame();
        } else {

            hardGame();
        }
    }

    private void easyGame() {
        // First location setup
        String dreicahmDes = "This type of aliens have " +
                " a short, muscular tail and long anal fin, two powerful side" +
                " fins and a wide, sail-like dorsal fin. They have four " +
                "eyes which sit delicately in their sockets and can often " +
                "make them appear to be upset. Their eyesight is not the " +
                "best.";
        Alien dreicahm = new Alien("Dreicahm", dreicahmDes,
                                   10, 5);

        String fDes = "You stand in a hilly region dotted with diverse pale" +
                " stones. It's also covered with various alien plants.  You " +
                "can see a mountain miles away. The temperature is cold and" +
                " the sky is mostly clear.";
        Location fLoc = new Location("Sleldfield Dyke", fDes, dreicahm);

        // Second location setup
        String erruhmDes = "This alien is a mind-controlling humanoid who " +
                "have two thumbs on each hand and no noses. Its limbs are " +
                "able to survive for several hours after being severed from " +
                "the body.";
        Alien erruhm = new Alien("Erruhm", erruhmDes,
                                 15, 10);

        String sDes = "You stand in a flat area dotted with unusual dark " +
                "stones.  You can see a bog to the east. The temperature is" +
                " warm and the sky is mostly clear.";
        Location sLoc = new Location("Alabrook", sDes, erruhm);

        // Third Location setup
        String noukkulneaDes = "This alien belongs to a race of hairy" +
                " shape-shifters who wear protective face masks and wear" +
                " ceremonial robes.";
        Alien noukkulnea = new Alien("Noukkulnea", noukkulneaDes,
                                     30, 20);

        String tDes = "You stand in a flat area sprinkled with small gray " +
                "stones.  You can see a citadel to the west.  The temperature" +
                " is quite cool and the sky is overcast.";
        Location tLoc = new Location("Jihold Ford", tDes, noukkulnea);

        Exit f2s = new Exit(1, sLoc);
        fLoc.addExit(f2s);

        Exit s2t = new Exit(3, tLoc);
        sLoc.addExit(s2t);

        this.player = new Player(50, 12, fLoc);

    }

    private void normalGame() {
        // Decent number of locations and some strong enemies
    }

    private void hardGame() {
        // Many locations and strong enemies
    }

    public void startGame() {
        player.play();
    }

    private void display(String message) {
        System.out.println(message);
    }
}
