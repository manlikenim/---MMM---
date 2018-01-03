import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Utils {

    // This is an utility function that handles the input from the user
    // provided that the set of valid input inputs is given
    public static String getInput(String[] options) {
        // Getting an input from the user
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        // Parse user input
        if (choice.length() == 0) {
            display("Huh? Invalid command!");
            display("");
            return "INVALID";
        }

        // Convert to uppercase for comparison
        choice = choice.toUpperCase();

        // Check to see if user wants to quit
        if (choice.equals("QUIT")) {
            display("You have chosen to exit the game. Bye!");
            System.exit(0);
        }

        // Search for an option match
        for (String currOption: options) {
            if (currOption.equals(choice)) {
                return choice;
            }
        }

        // If no valid commands, warn the user is invalid
        display("Huh? Invalid command!");
        display("");
        return "INVALID";
    }

    public static void displayStory (String description)
    {
        // Parameter to control the speed of text on the output
        int interval = 40;

        // Parameter to control the width on the output
        int width = 80;

        PrintStream output = new PrintStream(System.out);

        // Start at zero
        int currentWidth =  0;

        // Create a string tokenizer object
        StringTokenizer tokenizer = new StringTokenizer ( description );

        // Continue till there are words in the string
        while ( tokenizer.hasMoreTokens() )
        {
            // Get a word
            String token = tokenizer.nextToken();

            // Print on the new line if the current word exceeds the width
            if (currentWidth + token.length() >= width)
            {
                // Print a newline
                output.println ();
                currentWidth = 0;
            }

            // Print token
            String fullToken = token + " ";

            // Create a delay in printing characters
            for (char currentChar: fullToken.toCharArray()) {
                output.print(currentChar);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Update the currentWidth to include the fullToken
            currentWidth += fullToken.length();
        }
        output.println();
        output.flush();
    }

    // Helper function to ease printing
    private static void display(String message){
        System.out.println(message);
    }
}
