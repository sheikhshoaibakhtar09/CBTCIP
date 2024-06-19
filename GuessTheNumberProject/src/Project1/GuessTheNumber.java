package Project1;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static int targetNumber;
    private static int attempts;
    private static int score;

    public static void main(String[] args) {
        startNewGame();
    }

    public static void startNewGame() {
        Random random = new Random();
        targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
        attempts = 0;
        score = 0;
        System.out.println("A new game has started! Guess a number between " + LOWER_BOUND + " and "+UPPER_BOUND);
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                updateScore();
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
    }

    public static void updateScore() {
        int points = Math.max(0, (UPPER_BOUND - attempts) * 10);
        score += points;
        System.out.println("Your score is: " + score + " points.");
        askForAnotherRound();
    }

    public static void askForAnotherRound() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play another round? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if ("yes".equals(response)) {
            startNewGame();
        } else {
            System.out.println("Thanks for playing! Your final score is: " + score);
            System.exit(0);
        }
    }

}
