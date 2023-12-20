import java.util.Random;
import java.util.Scanner;

/**
 * Class that contains the number guessing game.
 *
 * @author Mason Burns
 * @version 12/19/2023
 * This class contains a number guessing game that checks the user's input against the randomly generated number.
 * If the user guess the number correctly then points are awarded based on how many attempts were used out of three.
 */
public class Game {
    //initializing a new random object for the project.
    Random rand = new Random();
    //initializing a new scanner object for the project.
    Scanner scanner = new Scanner(System.in);
    //previous score to keep track of the last rounds score.
    int previousScore;
    //variable to keep track of the highest score earned while playing.
    int highScore;

    /**
     * Void method to print out the game's instructions.
     */
    private void gameInstructions() {
        System.out.println("""
                A random number will be generated between 1 and 10\s
                You will have 3 attempts to guess this number. The more guesses you use the less points you earn.
                If all attempts are used then the game will end.
                """);
    }

    /**
     * Void method to print out the main menu options when the program is run.
     */
    private void menu() {
        System.out.println("""
                Welcome to the Number Guessing Game!
                Enter the number that corresponds with your choice
                0: Game Instructions
                1: Start Game
                2: Previous Game Score
                3: Check High Score
                4: Exit Game""");
    }

    /**
     * Void method that contains the main menu logic using an advanced switch statement so the user can select between the instructions,
     * starting the game, and exiting the game.
     */
    public void runGame() {
        //boolean variable to determine when the game is over via user input in case 4.
        boolean notDone = false;

        while (!notDone) {
            menu();
            switch (scanner.nextInt()) {
                case 0 -> gameInstructions();

                case 1 -> guessingGame();

                case 2 -> System.out.println("The last games score was: " + previousScore + "\n");

                case 3 -> getHighScore();

                case 4 -> notDone = true;
            }
        }
    }

    /**
     * Int method to calculate the score to add to the current score based on how many attempts are remaining.
     * The more attempts left the higher the score that is added.
     *
     * @param remAttempts the number of attempts left from the current game
     * @return returning the score to be added to the total score.
     */
    private int calculateScore(int remAttempts) {
        //Variable that is returned and contains the score to be added to the current score.
        int addScore = 0;

        if (remAttempts == 1) {
            addScore = 100;
        } else if (remAttempts == 2) {
            addScore = 75;
        } else if (remAttempts == 3) {
            addScore = 50;
        }
        return addScore;
    }

    /**
     * Void method to check if the current score is a new high score or not.
     *
     * @param score the current score to check against the high score.
     */
    private void checkHighScore(int score) {
        if (score > highScore) {
            highScore = score;
            System.out.println("New High Score!");
        }
    }

    /**
     * Void method to print out the high score when called.
     */
    private void getHighScore() {
        System.out.println("The current high score is: " + highScore + "\n");
    }

    /**
     * Void method containing the guessing game logic. The game continues to play until either the program is stopped or
     * the user runs out of guesses, to which the user will go back to the main menu.
     */
    public void guessingGame() {
        //Creating variables to hold the user's guess, the randomly generated number, the number of allowed attempts, the score,
        // and a boolean to determine if the game is done.
        int user_guess;
        int random_number;
        int attempts = 3;
        int score = 0;
        boolean gameDone = false;

        while (!gameDone) {
            System.out.println("I'm thinking of a number between 1 and 10");
            random_number = rand.nextInt(10) + 1;

            for (int i = 1; i <= attempts; i++) {
                System.out.println("What is your guess?");
                user_guess = scanner.nextInt();

                //Correct guess
                if (user_guess == random_number) {
                    System.out.println("You got it! The number was " + random_number + "\n");
                    score += calculateScore(i);
                    System.out.println("Current Score: " + score + "\n");
                    break;
                }
                //Running out of guesses
                else if (i == attempts) {
                    System.out.println("You ran out of guesses! The correct number was: " + random_number + "\nBetter luck next time!");
                    System.out.println("Your score was: " + score + "\n");
                    previousScore = score;
                    checkHighScore(score);
                    runGame();
                    gameDone = true;
                }
                //Hints to what the number is (higher or lower)
                else if (user_guess < random_number) {
                    System.out.println("The number is larger.");
                } else {
                    System.out.println("The number is smaller.");
                }
            }
        }
    }

    public static void main(String[] args) {
        //Keeping the main method clean by making the game a method call.
        Game game = new Game();
        game.runGame();
    }
}
