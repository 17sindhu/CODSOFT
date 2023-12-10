// TASK 1- GUESS THE NUMBER
import java.util.Random;
import java.util.Scanner;

public class Guessthenumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number game!");

        while (true) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int roundsWon = 0;
            System.out.print("Do you want to play a round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your total rounds won: " + roundsWon);
                break;
            }

            while (true) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();
                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + secretNumber +
                            " in " + (attempts + 1) + " attempts.");
                    roundsWon++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                attempts++;
                if (attempts == 5) {
                    System.out.println("Sorry, you've reached the maximum attempts. The correct number was " +
                            secretNumber + ".");
                    break;
                }
            }
            System.out.println("Rounds won: " + roundsWon);
        }
        scanner.close();
    }
}
  

