import java.util.Scanner;

public class GuessTheWordGame {
    private static final String[] WORDS = {"apple", "banana", "cherry", "orange", "strawberry"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = getRandomWord();
        char[] guessedWord = new char[wordToGuess.length()];
        int tries = 0;
        boolean gameWon = false;

        // Initialize guessedWord with underscores
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '_';
        }

        System.out.println("Welcome to Guess the Word!");
        printWordStatus(guessedWord);

        while (tries < MAX_TRIES) {
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            if (containsLetter(wordToGuess, guess)) {
                updateGuessedWord(wordToGuess, guessedWord, guess);
            } else {
                tries++;
                System.out.println("Incorrect guess. Tries remaining: " + (MAX_TRIES - tries));
            }

            printWordStatus(guessedWord);

            if (isWordGuessed(guessedWord)) {
                gameWon = true;
                break;
            }
        }

        if (gameWon) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("You ran out of tries. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static String getRandomWord() {
        int randomIndex = (int) (Math.random() * WORDS.length);
        return WORDS[randomIndex];
    }

    private static void printWordStatus(char[] guessedWord) {
        System.out.println("Word: " + String.valueOf(guessedWord));
    }

    private static boolean containsLetter(String word, char letter) {
        return word.indexOf(letter) != -1;
    }

    private static void updateGuessedWord(String word, char[] guessedWord, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                guessedWord[i] = letter;
            }
        }
    }

    private static boolean isWordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
