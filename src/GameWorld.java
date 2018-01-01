public class GameWorld {
    private Player player;

    public GameWorld() {
        this.player = new Player();
    }

    public void showTitle() {
        // Provide a title to the game
        Utils.displayStory("......................_______.._______." +
                "._______......................");
        Utils.displayStory(".....................(.......)(.......)" +
                "(.......).....................");
        Utils.displayStory(".....................|.().().||.().().|" +
                "|.().().|.....................");
        Utils.displayStory("._____.._____.._____.|.||.||.||.||.||.|" +
                "|.||.||.|._____.._____.._____.");
        Utils.displayStory("(_____)(_____)(_____)|.|(_)|.||.|(_)|.|" +
                "|.|(_)|.|(_____)(_____)(_____)");
        Utils.displayStory(".....................|.|...|.||.|...|.|" +
                "|.|...|.|.....................");
        Utils.displayStory(".....................|.)...(.||.)...(.|" +
                "|.)...(.|.....................");
        Utils.displayStory(".....................|/.....\\||/....." +
                "\\||/.....\\|.....................");
        display("");
    }

    public void chooseDifficulty() {
        String choice = "INVALID";
        String[] options = {"1", "EASY", "E", "1. EASY",
                            "2", "NORMAL", "N", "2. NORMAL",
                            "3", "HARD", "3. HARD"};

        while (choice.equals("INVALID")) {
            display(".......................Welcome to " +
                    "Musk's Mission to Mars!.......................");
            display("");
            display("Please choose a difficulty");
            display("1. Easy");
            display("2. Normal");
            display("3. Hard");
            choice = Utils.getInput(options);
        }

        if (choice.equals("1") || choice.equals("EASY") ||
            choice.equals("E") || choice.equals("1. EASY")) {

            display("EASY GAME");
            easyGame();
        } else if (choice.equals("2") || choice.equals("NORMAL") ||
                   choice.equals("N") || choice.equals("2. NORMAL")){

            display("NORMAL GAME");
            normalGame();
        } else {

            display("HARD GAME");
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
        // First location setup
        String dreicahmDes = "This type of aliens have " +
                " a short, muscular tail and long anal fin, two powerful side" +
                " fins and a wide, sail-like dorsal fin. They have four " +
                "eyes which sit delicately in their sockets and can often " +
                "make them appear to be upset. Their eyesight is not the " +
                "best.";
        Alien dreicahm = new Alien("Dreicahm", dreicahmDes,
                12, 7);

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
                20, 15);

        String sDes = "You stand in a flat area dotted with unusual dark " +
                "stones.  You can see a bog to the east. The temperature is" +
                " warm and the sky is mostly clear.";
        Location sLoc = new Location("Alabrook", sDes, erruhm);

        // Third Location setup


        String heliansDes = "This alien belongs to a race of telepathic and " +
                "aggressive reptiles. They share their home star system with " +
                "a race of enormous space-dwelling lifeforms, which they " +
                "harness and use as a means of transportation.";
        Alien helians = new Alien("Helians", heliansDes,
                                   25, 20);

        String tLocDes = "You stand in a mountainous terrain spotted with " +
                "unusual pale stones. The temperature is very warm and the " +
                "sky is partially cloudy.";
        Location tLoc = new Location("Inuthorp Pass", tLocDes, helians);

        // Fourth location setup
        String drozassiakDes = "This alien belongs to a race of arthropods " +
                "with one enormous eye. They have highly ordered and logical " +
                "minds, and they are obsessed with mathematics and statistics.";
        Alien drozassiak = new Alien("Drozassiak", drozassiakDes,
                                     15, 10);

        String foLocDes = "You stand in a flat region strewn with gigantic " +
                "dark rocks. The temperature is warm and the sky is partially" +
                " cloudy.";
        Location foLoc = new Location("Plitchmore", foLocDes, drozassiak);

        // Fifth location setup

        String nutzubmoraneDes = "This alien belongs to a race of arrogant " +
                "plants. They have a three-strike justice system in which " +
                "criminals are killed after their third conviction.";
        Alien nutzubmorane = new Alien("Nutzubmorane", nutzubmoraneDes,
                                        35, 13);

        String fiLocDes = "You stand in a flat region replete with " +
                "crystalline brown stones.  You can see a a fort not too far" +
                " away.  The temperature is hot and the sky is mostly clear.";
        Location fiLoc = new Location("Whaborn", fiLocDes, nutzubmorane);

        // Sixth location setup

        String ergathiDes = "A race of humanoid aliens who have compound eyes" +
                " and sharp talons. They drink a wine fermented from their " +
                "own droppings. The drink is a powerful intoxicant.";
        Alien ergathi = new Alien("Ergathi", ergathiDes,
                                   40, 40);

        String siLocDes = "You stand in a mountainous terrain scattered with " +
                "small dark rocks. The temperature is a little cool and the " +
                "sky is overcast.";
        Location siLoc = new Location("Apebrook", siLocDes, ergathi);

        // Seventh location setup


        String noukkulneaDes = "This alien belongs to a race of hairy" +
                " shape-shifters who wear protective face masks and wear" +
                " ceremonial robes.";
        Alien noukkulnea = new Alien("Noukkulnea", noukkulneaDes,
                60, 45);

        String seDes = "You stand in a flat area sprinkled with small gray " +
                "stones.  You can see a citadel to the west.  The temperature" +
                " is quite cool and the sky is overcast.";
        Location seLoc = new Location("Jihold Ford", seDes, noukkulnea);


        Exit f2s = new Exit(Exit.FORWARD, sLoc);
        fLoc.addExit(f2s);

        Exit s2t = new Exit(Exit.LEFT, tLoc);
        sLoc.addExit(s2t);

        Exit t2fo= new Exit(Exit.FORWARD, foLoc);
        tLoc.addExit(t2fo);

        Exit t2fi = new Exit(Exit.RIGHT, fiLoc);
        tLoc.addExit(t2fi);

        Exit fo2si = new Exit(Exit.RIGHT, siLoc);
        foLoc.addExit(fo2si);

        Exit fi2se = new Exit(Exit.FORWARD, seLoc);
        fiLoc.addExit(fi2se);

        Exit si2fi = new Exit(Exit.RIGHT, fiLoc);
        siLoc.addExit(si2fi);

        Exit si2se = new Exit(Exit.FORWARD, seLoc);
        siLoc.addExit(si2se);

        this.player = new Player(100, 10, fLoc);
    }

    private void hardGame() {
        // First location setup
        String dreicahmDes = "This type of aliens have " +
                " a short, muscular tail and long anal fin, two powerful side" +
                " fins and a wide, sail-like dorsal fin. They have four " +
                "eyes which sit delicately in their sockets and can often " +
                "make them appear to be upset. Their eyesight is not the " +
                "best.";
        Alien dreicahm = new Alien("Dreicahm", dreicahmDes,
                15, 10);

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
                20, 15);

        String sDes = "You stand in a flat area dotted with unusual dark " +
                "stones.  You can see a bog to the east. The temperature is" +
                " warm and the sky is mostly clear.";
        Location sLoc = new Location("Alabrook", sDes, erruhm);

        // Third Location setup


        String heliansDes = "This alien belongs to a race of telepathic and " +
                "aggressive reptiles. They share their home star system with " +
                "a race of enormous space-dwelling lifeforms, which they " +
                "harness and use as a means of transportation.";
        Alien helians = new Alien("Helians", heliansDes,
                25, 20);

        String tLocDes = "You stand in a mountainous terrain spotted with " +
                "unusual pale stones. The temperature is very warm and the " +
                "sky is partially cloudy.";
        Location tLoc = new Location("Inuthorp Pass", tLocDes, helians);

        // Fourth location setup
        String drozassiakDes = "This alien belongs to a race of arthropods " +
                "with one enormous eye. They have highly ordered and logical " +
                "minds, and they are obsessed with mathematics and statistics.";
        Alien drozassiak = new Alien("Drozassiak", drozassiakDes,
                35, 30);

        String foLocDes = "You stand in a flat region strewn with gigantic " +
                "dark rocks. The temperature is warm and the sky is partially" +
                " cloudy.";
        Location foLoc = new Location("Plitchmore", foLocDes, drozassiak);

        // Fifth location setup

        String nutzubmoraneDes = "This alien belongs to a race of arrogant " +
                "plants. They have a three-strike justice system in which " +
                "criminals are killed after their third conviction.";
        Alien nutzubmorane = new Alien("Nutzubmorane", nutzubmoraneDes,
                40, 20);

        String fiLocDes = "You stand in a flat region replete with " +
                "crystalline brown stones.  You can see a a fort not too far" +
                " away.  The temperature is hot and the sky is mostly clear.";
        Location fiLoc = new Location("Whaborn", fiLocDes, nutzubmorane);

        // Sixth location setup

        String ergathiDes = "A race of humanoid aliens who have compound eyes" +
                " and sharp talons. They drink a wine fermented from their " +
                "own droppings. The drink is a powerful intoxicant.";
        Alien ergathi = new Alien("Ergathi", ergathiDes,
                60, 60);

        String siLocDes = "You stand in a mountainous terrain scattered with " +
                "small dark rocks. The temperature is a little cool and the " +
                "sky is overcast.";
        Location siLoc = new Location("Apebrook", siLocDes, ergathi);

        // Seventh location setup
        String gzotaliiDes = "This alien belongs to a race of colour-blind " +
                "lifeforms with poisonous spines on their backs. Some members" +
                " of the species still choose to resolve disputes by " +
                "participating in dangerous duels.";
        Alien gzotalii = new Alien("Gzotalii", gzotaliiDes,
                                    40, 30);

        String seLocDes = "You stand in a mountainous terrain strewn with " +
                "unusual purplish rocks. The temperature is hot and the sky " +
                "is clear.";
        Location seLoc = new Location("Aveham", seLocDes, gzotalii);

        // Eighth location setup
        String similalitesDes = "This alien belongs to a race of proud " +
                "humanoid aliens who have poisonous spines on their backs. " +
                "The entire species is addicted to a plant pollen that is " +
                "common on their world.";
        Alien similalites = new Alien("Similalites", similalitesDes,
                                       40, 25);

        String eLocDes = "You stand in a broken terrain scattered with " +
                "gigantic bluish rocks. It's also scattered with grass and " +
                "foul-smelling wildflowers. The temperature is a little cool " +
                "and the sky is clear.";
        Location eLoc = new Location("Swildwick", eLocDes, similalites);

        // Ninth location setup
        String belletaniDes = "This alien belongs to a race of mind-controlling slugs " +
                "with two noses. They are afraid of water and carry " +
                "ceremonial knives. They produce a flammable liquid from " +
                "glands in their armpits.";
        Alien belletani = new Alien("Belletani", belletaniDes,
                                     45, 35);

        String nLocDes = "This alien belongs to a race of mind-controlling " +
                "slugs with two noses. They are afraid of water and carry " +
                "ceremonial knives. They produce a flammable liquid from " +
                "glands in their armpits.";
        Location nLoc = new Location("Fridown", nLocDes, belletani);

        // Tenth location setup
        String noukkulneaDes = "This alien belongs to a race of hairy" +
                " shape-shifters who wear protective face masks and wear" +
                " ceremonial robes.";
        Alien noukkulnea = new Alien("Noukkulnea", noukkulneaDes,
                40, 30);

        String teDes = "You stand in a flat area sprinkled with small gray " +
                "stones.  You can see a citadel to the west.  The temperature" +
                " is quite cool and the sky is overcast.";
        Location teLoc = new Location("Jihold Ford", teDes, noukkulnea);


        Exit f2s = new Exit(Exit.FORWARD, sLoc);
        fLoc.addExit(f2s);

        Exit s2t = new Exit(Exit.LEFT, tLoc);
        sLoc.addExit(s2t);

        Exit t2fo= new Exit(Exit.FORWARD, foLoc);
        tLoc.addExit(t2fo);

        Exit t2fi = new Exit(Exit.RIGHT, fiLoc);
        tLoc.addExit(t2fi);

        Exit fo2e = new Exit(Exit.RIGHT, eLoc);
        foLoc.addExit(fo2e);

        Exit fi2si = new Exit(Exit.FORWARD, siLoc);
        fiLoc.addExit(fi2si);

        Exit fi2se = new Exit(Exit.RIGHT, seLoc);
        fiLoc.addExit(fi2se);

        Exit si2fi = new Exit(Exit.FORWARD, fiLoc);
        siLoc.addExit(si2fi);

        Exit se2te = new Exit(Exit.LEFT, teLoc);
        seLoc.addExit(se2te);

        Exit e2n = new Exit(Exit.FORWARD, nLoc);
        eLoc.addExit(e2n);

        Exit n2te = new Exit(Exit.RIGHT, teLoc);
        nLoc.addExit(n2te);

        this.player = new Player(100, 10, fLoc);
    }

    public void startingScene() {
        // Provide a story behind the mission
    }


    public void startGame() {
        player.play();
    }

    private void display(String message) {
        System.out.println(message);
    }
}
