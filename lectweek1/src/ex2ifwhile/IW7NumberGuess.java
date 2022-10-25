package ex2ifwhile;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
     Program for the number guess game.

     Full example of using everything so far (selection and iteration)

 */
public class IW7NumberGuess {

    public static void main(String[] args) {
        new IW7NumberGuess().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();

    void program() {
        int guess;          // Player guess
        int nGuesses = 0;   // Number of guesses
        int theNumber;      // Current number to guess

        out.println("Welcome to Number Guess");
        theNumber = rand.nextInt(100) + 1;    // Get random number 1-100
        out.println(theNumber);                      // To ease testing print answer, comment out later
        while (true) {                               // Or use guess != theNumber
            // ------ Input ----------
            out.print("Guess a number [1-100] > ");
            guess = sc.nextInt();

            // -- Process -----
            nGuesses++;

            // ---- Output -----------
            if (guess == theNumber) {
                break;
            } else if (guess < theNumber) {
                out.println("To small ");
            } else {
                out.println("To big ");
            }
        }

        out.println("Correct! Number of guesses needed " + nGuesses);
    }
}
