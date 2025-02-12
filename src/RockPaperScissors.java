import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};

        System.out.println("Welcome to Rock, Paper, Scissors!");

        // User's choice
        int userChoice = 0;

        // Loop to ensure valid input
        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.print("Your choice (1-3): ");

            // Check if the input is a valid integer
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();

                // Validate the range of the user's input
                if (userChoice >= 1 && userChoice <= 3) {
                    break; // Exit the loop if input is valid
                } else {
                    System.out.println("Invalid choice. Please choose a valid option (1-3).");
                }
            } else {
                // If input is not an integer, ask the user to enter a valid number
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Computer's random choice
        int computerChoice = random.nextInt(3) + 1;

        System.out.println("You chose: " + choices[userChoice - 1]);
        System.out.println("Computer chose: " + choices[computerChoice - 1]);

        // Determine the winner
        String result = determineWinner(userChoice, computerChoice);
        System.out.println(result);

        // End the game after the first round
        System.out.println("\nThanks for playing! The game is over.");

        scanner.close();
    }

    // Method to determine the winner based on user and computer choices
    public static String determineWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return "It's a tie!";
        }

        // Check if the user won (Rock > Scissors, Paper > Rock, Scissors > Paper)
        if ((userChoice == 1 && computerChoice == 3) || // Rock beats Scissors
                (userChoice == 2 && computerChoice == 1) || // Paper beats Rock
                (userChoice == 3 && computerChoice == 2)) { // Scissors beats Paper
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}