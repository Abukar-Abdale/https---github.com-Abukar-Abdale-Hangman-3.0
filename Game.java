import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Word word;
    WordList wordList;
    ArrayList<String> history;
    Player player;
    int remainingGuesses;

    public Game() {
        wordList = new WordList();
        word = new Word(wordList.getRandomWord());
        player = new Player("Player 1");
        history = new ArrayList<>();
        remainingGuesses = 6;
    }

    public void startGame() {
        while (remainingGuesses > 0 && !word.hasGuessed()) {
            // Print current state of the game
            System.out.println("Current word: " + word.getVisibleWord());
            System.out.println("Remaining guesses: " + remainingGuesses);

            // Ask player for a guess
            char guess = askForGuess();

            // Check if letter has already been guessed
            if (history.contains(Character.toString(guess))) {
                System.out.println("You have already guessed that letter.");
                continue;
            }

            // Add letter to list of guessed letters
            history.add(Character.toString(guess));

            // Check if letter is in the word
            if (word.containsLetter(guess)) {
                word.updateVisibleWord(guess);
                System.out.println("Correct guess!");
            } else {
                remainingGuesses--;
                System.out.println("Wrong guess.");
            }
        }

        // Print result of the game
        if (word.hasGuessed()) {
            System.out.println("Congratulations, you won!" + " The word was: " + word.getWord());
            player.increasePoints();
            System.out.println("Your score is: " + player.getPoints());
        } else {
            System.out.println("Game over, the word was: " + word.getWord());
        }
    }

    private char askForGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess a letter: ");

        // Keep asking for a guess if the input is not a single letter
        while (true) {
            String guess = null;

            // Check if there is input available
            if (scanner.hasNextLine()) {
                guess = scanner.nextLine().toLowerCase();
            } else {
                System.out.println("Waiting for input...");
                continue;
            }

            if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
                System.out.println("Invalid input, please enter a single letter.");
                System.out.print("Guess a letter: ");
            } else {
                return guess.charAt(0);
            }
        }
    }


}
    

