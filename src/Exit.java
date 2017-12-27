public class Exit {

    // Numerical codes
    public static final int UNDEFINED = 0;
    public static final int FORWARD = 1;
    public static final int BACKWARD = 2;
    public static final int LEFT  = 3;
    public static final int RIGHT  = 4;
    public static final int IN = 5;
    public static final int OUT = 6;

    // String codes
    public static final String[] dirName =
            {
                    "UNDEFINED",
                    "FORWARD",
                    "BACKWARD",
                    "LEFT",
                    "RIGHT",
                    "IN",
                    "OUT"
            };

    public static final String[] shortDirName =
            {
                    "NULL",
                    "F",
                    "B",
                    "L",
                    "R",
                    "I",
                    "O"
            };

    // Member variables
    private int direction;
    private Location leadsTo;

    // Full name of direction
    private String directionName;

    // Shortened version of direction
    private String shortDirectionName;


    // Full constructor
    public Exit( int direction, Location leadsTo )
    {
        //Assign direction
        this.direction = direction;

        // Assign location
        this.leadsTo = leadsTo;

        // Assign direction names
        if (direction <= dirName.length )
            this.directionName = dirName[direction];
        if (direction <= shortDirName.length )
            this.shortDirectionName = shortDirName[direction];

    }

    public Location getLeadsTo() {
        return leadsTo;
    }

    public String getDestinationName() {
        return leadsTo.getName();
    }

    public int getDirection() {
        return direction;
    }

    public String getDirectionName() {
        return directionName;
    }

    public String getShortDirectionName() {
        return shortDirectionName;
    }

    @Override
    public String toString() {
        return this.directionName;
    }
}
