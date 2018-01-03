public class GameWorld {
    private Player player;

    public GameWorld() {
        this.player = new Player();
    }

    // Provides a back story to the game
    public void startingScene() {
        Utils.displayStory("It is hard to believe that just a few " +
                "decades ago Mars was a lifeless place. Around the turn of " +
                "the millennium, a time when space programs were stagnating " +
                "due to a lack of vision by those in power, no human had even" +
                " set foot on the then Red Planet. Dust storms were torturing" +
                " the arid landscape, it's stark beauty unseen by human eyes.");
        display("");

        Utils.displayStory("Only a few people were aware of the " +
                "immense promise of terraforming Mars. With environmental " +
                "problems on the home world running out of control, even the" +
                " thought of modifying another planet was like blasphemy to " +
                "many other earthlings' ears. Still, it happened.");
        display("");

        Utils.displayStory("Just over two decades later, life forms" +
                " are evolving in the muddy rivers and forests are working " +
                "their way up on magnificent slopes.This Modified Mars is " +
                "only occupied by alien fugitives at the moment due to it's " +
                "under developed atmosphere.");
        display("");

        Utils.displayStory("Back on Earth, efforts have been made " +
                "to sample the planet to check whether human habitation would" +
                " be possible anytime soon. In the midst of this Earth's tech" +
                " prodigy, Tony Musk, volunteers to fly his new spaceship and" +
                " collect samples required for the habitation test.");
        display("");

        Utils.displayStory("The day of the launch is here. Everyone" +
                " has high hopes from Tony. Will he be able to carry out this" +
                " mission on his own???");
        display("");

        Utils.displayStory("3..2..1.... The spaceship takes off into" +
                " space.");
        display("");

        Utils.displayStory("...");
        display("");

        Utils.displayStory("It has been 5 months since Tony had " +
                "left Earth. He finally lands on Mars and begins his " +
                "exploration...");
        display("");
    }

    // Shows an ASCII art of ---MMM---
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

    // Allows the user to choose the length and difficulty of gameplay
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

            display("You have selected EASY mode.");
            easyGame();
        } else if (choice.equals("2") || choice.equals("NORMAL") ||
                   choice.equals("N") || choice.equals("2. NORMAL")){

            display("You have selected NORMAL mode.");
            normalGame();
        } else {

            display("You have selected HARD mode.");
            hardGame();
        }
    }

    // Setting up the game in EASY mode
    private void easyGame() {
        //  ---------- First location setup ----------
        String dreicahmDes = "This type of aliens have " +
                " a short, muscular tail and long anal fin, two powerful side" +
                " fins and a wide, sail-like dorsal fin. They have four " +
                "eyes which sit delicately in their sockets and can often " +
                "make them appear to be upset. Their eyesight is not the " +
                "best.";
        Alien dreicahm = new BadAlien("Dreicahm", dreicahmDes,
                                   10, 5);

        String fDes = "You stand in a hilly region dotted with diverse pale" +
                " stones. It's also covered with various alien plants.  You " +
                "can see a mountain miles away. The temperature is cold and" +
                " the sky is mostly clear.";
        Location fLoc = new EnemyLocation("Sleldfield Dyke", fDes, dreicahm);

        //  ---------- Second location setup ----------
        String erruhmDes = "This alien is a mind-controlling humanoid who " +
                "have two thumbs on each hand and no noses. Its limbs are " +
                "able to survive for several hours after being severed from " +
                "the body.";
        Alien erruhm = new BadAlien("Erruhm", erruhmDes,
                                 15, 10);

        String sDes = "You stand in a flat area dotted with unusual dark " +
                "stones.  You can see a bog to the east. The temperature is" +
                " warm and the sky is mostly clear.";
        Location sLoc = new EnemyLocation("Alabrook", sDes, erruhm);

        //  ---------- Third Location setup ----------
        String noukkulneaDes = "This alien belongs to a race of hairy" +
                " shape-shifters who wear protective face masks and wear" +
                " ceremonial robes.";
        Alien noukkulnea = new BadAlien("Noukkulnea", noukkulneaDes,
                                     30, 20);

        String tDes = "You stand in a flat area sprinkled with small gray " +
                "stones.  You can see a citadel to the west.  The temperature" +
                " is quite cool and the sky is overcast.";
        Location tLoc = new EnemyLocation("Jihold Ford", tDes, noukkulnea);

        // Linking the locations with exits
        Exit f2s = new Exit(1, sLoc);
        fLoc.addExit(f2s);

        Exit s2t = new Exit(3, tLoc);
        sLoc.addExit(s2t);

        this.player = new Player(50, 12, fLoc, 3);

    }

    // Setting up the game in NORMAL mode
    private void normalGame() {
        // ---------- First location setup ----------
        String dreicahmDes = "This type of aliens have " +
                " a short, muscular tail and long anal fin, two powerful side" +
                " fins and a wide, sail-like dorsal fin. They have four " +
                "eyes which sit delicately in their sockets and can often " +
                "make them appear to be upset. Their eyesight is not the " +
                "best.";
        Alien dreicahm = new BadAlien("Dreicahm", dreicahmDes,
                12, 7);

        String fDes = "You stand in a hilly region dotted with diverse pale" +
                " stones. It's also covered with various alien plants.  You " +
                "can see a mountain miles away. The temperature is cold and" +
                " the sky is mostly clear.";
        Location fLoc = new EnemyLocation("Sleldfield Dyke", fDes, dreicahm);

        // ---------- Second location setup ----------
        String erruhmDes = "This alien is a mind-controlling humanoid who " +
                "have two thumbs on each hand and no noses. Its limbs are " +
                "able to survive for several hours after being severed from " +
                "the body.";
        Alien erruhm = new BadAlien("Erruhm", erruhmDes,
                20, 15);

        String sDes = "You stand in a flat area dotted with unusual dark " +
                "stones.  You can see a bog to the east. The temperature is" +
                " warm and the sky is mostly clear.";
        Location sLoc = new EnemyLocation("Alabrook", sDes, erruhm);

        //  ---------- Third Location setup ----------
        String heliansDes = "This alien belongs to a race of telepathic and " +
                "aggressive reptiles. They are known to harness enormous " +
                "space-dwelling life forms and use them as a means of " +
                "transportation.";
        Alien helians = new BadAlien("Helians", heliansDes,
                                   25, 20);

        String tLocDes = "You stand in a mountainous terrain spotted with " +
                "unusual pale stones. The temperature is very warm and the " +
                "sky is partially cloudy.";
        Location tLoc = new EnemyLocation("Inuthorp Pass", tLocDes, helians);

        //  ---------- Fourth location setup ----------
        String drozassiakDes = "This alien belongs to a race of arthropods " +
                "with one enormous eye. They have highly ordered and logical " +
                "minds, and they are obsessed with mathematics and statistics.";
        Alien drozassiak = new BadAlien("Drozassiak", drozassiakDes,
                                     15, 10);

        String foLocDes = "You stand in a flat region strewn with gigantic " +
                "dark rocks. The temperature is warm and the sky is partially" +
                " cloudy.";
        Location foLoc = new EnemyLocation("Plitchmore", foLocDes, drozassiak);

        //  ---------- Fifth location setup ----------
        String nutzubmoraneDes = "This alien belongs to a race of arrogant " +
                "plants. They have a three-strike justice system in which " +
                "criminals are killed after their third conviction.";
        Alien nutzubmorane = new BadAlien("Nutzubmorane", nutzubmoraneDes,
                                        35, 13);

        String fiLocDes = "You stand in a flat region replete with " +
                "crystalline brown stones.  You can see a a fort not too far" +
                " away.  The temperature is hot and the sky is mostly clear.";
        Location fiLoc = new EnemyLocation("Whaborn", fiLocDes, nutzubmorane);

        //  ---------- Sixth location setup ----------
        String ergathiDes = "A race of humanoid aliens who have compound eyes" +
                " and sharp talons. They drink a wine fermented from their " +
                "own droppings. The drink is a powerful intoxicant.";
        Alien ergathi = new BadAlien("Ergathi", ergathiDes,
                                   40, 40);

        String siLocDes = "You stand in a mountainous terrain scattered with " +
                "small dark rocks. The temperature is a little cool and the " +
                "sky is overcast.";
        Location siLoc = new EnemyLocation("Apebrook", siLocDes, ergathi);

        //  ---------- Seventh location setup ----------
        String noukkulneaDes = "This alien belongs to a race of hairy" +
                " shape-shifters who wear protective face masks and wear" +
                " ceremonial robes.";
        Alien noukkulnea = new BadAlien("Noukkulnea", noukkulneaDes,
                60, 45);

        String seDes = "You stand in a flat area sprinkled with small gray " +
                "stones.  You can see a citadel to the west.  The temperature" +
                " is quite cool and the sky is overcast.";
        Location seLoc = new EnemyLocation("Jihold Ford", seDes, noukkulnea);


        // Linking the locations with exits
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

        this.player = new Player(100, 10, fLoc, 7);
    }

    // Setting up the game in HARD mode
    private void hardGame() {
        //  ---------- First location setup ----------
        String dreicahmDes = "This type of aliens have " +
                " a short, muscular tail and long anal fin, two powerful side" +
                " fins and a wide, sail-like dorsal fin. They have four " +
                "eyes which sit delicately in their sockets and can often " +
                "make them appear to be upset. Their eyesight is not the " +
                "best.";
        Alien dreicahm = new BadAlien("Dreicahm", dreicahmDes,
                15, 10);

        String fDes = "You stand in a hilly region dotted with diverse pale" +
                " stones. It's also covered with various alien plants.  You " +
                "can see a mountain miles away. The temperature is cold and" +
                " the sky is mostly clear.";
        Location fLoc = new EnemyLocation("Sleldfield Dyke", fDes, dreicahm);

        //  ---------- Second location setup ----------
        String erruhmDes = "This alien is a mind-controlling humanoid who " +
                "have two thumbs on each hand and no noses. Its limbs are " +
                "able to survive for several hours after being severed from " +
                "the body.";
        Alien erruhm = new BadAlien("Erruhm", erruhmDes,
                20, 15);

        String sDes = "You stand in a flat area dotted with unusual dark " +
                "stones.  You can see a bog to the east. The temperature is" +
                " warm and the sky is mostly clear.";
        Location sLoc = new EnemyLocation("Alabrook", sDes, erruhm);

        //  ---------- Third Location setup ----------
        String heliansDes = "This alien belongs to a race of telepathic and " +
                "aggressive reptiles. They are known to harness enormous " +
                "space-dwelling life forms and use them as a means of " +
                "transportation.";
        Alien helians = new BadAlien("Helians", heliansDes,
                25, 20);

        String tLocDes = "You stand in a mountainous terrain spotted with " +
                "unusual pale stones. The temperature is very warm and the " +
                "sky is partially cloudy.";
        Location tLoc = new EnemyLocation("Inuthorp Pass", tLocDes, helians);

        //  ---------- Fourth location setup ----------
        String drozassiakDes = "This alien belongs to a race of arthropods " +
                "with one enormous eye. They have highly ordered and logical " +
                "minds, and they are obsessed with mathematics and statistics.";
        Alien drozassiak = new BadAlien("Drozassiak", drozassiakDes,
                35, 30);

        String foLocDes = "You stand in a flat region strewn with gigantic " +
                "dark rocks. The temperature is warm and the sky is partially" +
                " cloudy.";
        Location foLoc = new EnemyLocation("Plitchmore", foLocDes, drozassiak);

        //  ---------- Fifth location setup ----------
        String nutzubmoraneDes = "This alien belongs to a race of arrogant " +
                "plants. They have a three-strike justice system in which " +
                "criminals are killed after their third conviction.";
        Alien nutzubmorane = new BadAlien("Nutzubmorane", nutzubmoraneDes,
                40, 20);

        String fiLocDes = "You stand in a flat region replete with " +
                "crystalline brown stones.  You can see a a fort not too far" +
                " away.  The temperature is hot and the sky is mostly clear.";
        Location fiLoc = new EnemyLocation("Whaborn", fiLocDes, nutzubmorane);

        //  ---------- Sixth location setup ----------
        String ergathiDes = "A race of humanoid aliens who have compound eyes" +
                " and sharp talons. They drink a wine fermented from their " +
                "own droppings. The drink is a powerful intoxicant.";
        Alien ergathi = new BadAlien("Ergathi", ergathiDes,
                60, 60);

        String siLocDes = "You stand in a mountainous terrain scattered with " +
                "small dark rocks. The temperature is a little cool and the " +
                "sky is overcast.";
        Location siLoc = new EnemyLocation("Apebrook", siLocDes, ergathi);

        //  ---------- Seventh location setup ----------
        String gzotaliiDes = "This alien belongs to a race of colour-blind " +
                "lifeforms with poisonous spines on their backs. Some members" +
                " of the species still choose to resolve disputes by " +
                "participating in dangerous duels.";
        Alien gzotalii = new BadAlien("Gzotalii", gzotaliiDes,
                                    40, 30);

        String seLocDes = "You stand in a mountainous terrain strewn with " +
                "unusual purplish rocks. The temperature is hot and the sky " +
                "is clear.";
        Location seLoc = new EnemyLocation("Aveham", seLocDes, gzotalii);

        //  ---------- Eighth location setup ----------
        String similalitesDes = "This alien belongs to a race of proud " +
                "humanoid aliens who have poisonous spines on their backs. " +
                "The entire species is addicted to a plant pollen that is " +
                "common on their world.";
        Alien similalites = new BadAlien("Similalites", similalitesDes,
                                       40, 25);

        String eLocDes = "You stand in a broken terrain scattered with " +
                "gigantic bluish rocks. It's also scattered with grass and " +
                "foul-smelling wildflowers. The temperature is a little cool " +
                "and the sky is clear.";
        Location eLoc = new EnemyLocation("Swildwick", eLocDes, similalites);

        //  ---------- Ninth location setup ----------
        String belletaniDes = "This alien belongs to a race of mind-controlling slugs " +
                "with two noses. They are afraid of water and carry " +
                "ceremonial knives. They produce a flammable liquid from " +
                "glands in their armpits.";
        Alien belletani = new BadAlien("Belletani", belletaniDes,
                                     45, 35);

        String nLocDes = "This alien belongs to a race of mind-controlling " +
                "slugs with two noses. They are afraid of water and carry " +
                "ceremonial knives. They produce a flammable liquid from " +
                "glands in their armpits.";
        Location nLoc = new EnemyLocation("Fridown", nLocDes, belletani);

        //  ---------- Tenth location setup ----------
        String noukkulneaDes = "This alien belongs to a race of hairy" +
                " shape-shifters who wear protective face masks and wear" +
                " ceremonial robes.";
        Alien noukkulnea = new BadAlien("Noukkulnea", noukkulneaDes,
                40, 30);

        String teDes = "You stand in a flat area sprinkled with small gray " +
                "stones.  You can see a citadel to the west.  The temperature" +
                " is quite cool and the sky is overcast.";
        Location teLoc = new EnemyLocation("Jihold Ford", teDes, noukkulnea);


        // Linking the locations with exits
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

        this.player = new Player(100, 10, fLoc, 10);
    }


    public void startGame() {
        display("");
        Utils.displayStory("Seems like you are playing this game " +
                "for the first time.");

        String[] options = new String[]{"YES","Y","NO","N"};
        String choice = "INVALID";
        while (choice.equals("INVALID")) {
            display("Would you like to go through a tutorial? YES/NO");
            choice = Utils.getInput(options);
            display("");
            display("");
        }

        if (choice.equals("YES") || choice.equals("Y")) {
            runTutorial();
        }

        player.play();
    }

    private void runTutorial() {
        display("");
        Utils.displayStory("Hi there! Let me just walk you through" +
                "          the basics of the game:");
        display("");
        Utils.displayStory("1. Your mission is to go to as many " +
                "locations as possible and collect samples.");
        display("");
        Utils.displayStory("2. For your convenience, you have " +
                "access to Zip2 and Zalien. Zip2 provides you with " +
                "information regarding the location, while Zalien provides " +
                "you information about the alien that's within the location.");
        display("");
        Utils.displayStory("3. On your journey you will have to face" +
                "lots of monsters. Make sure you beat the monsters or else " +
                "they will not let you take the samples.");
        display("");
        Utils.displayStory("4. On every location you can either " +
                "FIGHT the enemy and move to next location or directly ESCAPE" +
                " to another location.");
        display("");
        Utils.displayStory("5. You will be provided with a list of " +
                "EXITS telling you which directions to travel on in order " +
                "to get to the corresponding locations.");
        display("");
        Utils.displayStory("6. Once you move from a location, you " +
                "will not be able to return back.");
        display("");
        Utils.displayStory("7. The commands that you will be able " +
                "to use will be displayed in uppercase e.g. ESCAPE, FORWARD." +
                "In order to execute the desired command, you may enter it in" +
                " full or just type the command initials, in lower or upper " +
                "case e.g. e/E/escape/Escape/ESCAPE for ESCAPE and so on.");
        display("");
        Utils.displayStory("8. If you wish to leave the game at any" +
                "point during the game, please enter QUIT.");
        display("");
        Utils.displayStory("This is the end of the tutorial. Please" +
                " enjoy the game!");
        display("");
    }

    private void display(String message) {
        System.out.println(message);
    }
}
