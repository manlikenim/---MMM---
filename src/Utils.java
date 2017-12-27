import java.util.Scanner;

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

    private static void display(String message){
        System.out.println(message);
    }
}
