package ex4methods;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
    Program for the guess game Bulls and Cows
    See: https://en.wikipedia.org/wiki/Bulls_and_Cows
    (a constraint is that we only use int's for the numbers
    i.e. a lot of % and / to decompose the numbers)
    This is so big you can't grasp the whole program. Have to break it down

    Example of methods and functional decomposition **and** testing!!


    NOTE: See BullsAndCows.pdf

 */
public class M3BullsAndCows {

    public static void main(String[] args) {
        new M3BullsAndCows().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();

    void program() {
        test();             // <--------- Comment uncomment to test!!!!

        out.println("Welcome to Bulls and Cows.");
        out.println("Try to guess a 4 digit number with digits 1-9");
        out.println("and no repeating digits (-1 to abort).");
        out.println("Bulls = correct digits in correct positions.");
        out.println("Cows = correct digits.");

        boolean aborted = false;
        int nGuess = 0;
        int guess;
        int nBulls;
        int nCows;

        //int number = 1234;               // Hard code during development ...
        int number = getNumber();      // ... later use method!
        out.println(number);

        while (true) {
            out.print("> ");
            guess = sc.nextInt();

            if (guess < 0) {
                aborted = true;
                break;
            }
            nGuess++;
            if (guess == number) {
                break;
            } else {
                nBulls = countBulls(guess, number);                 // Func decomp
                    nCows = countCowsAndBulls(guess, number) - nBulls;  // Func decomp

            }
            out.println("There are " + nBulls + " bull(s) and " + nCows + " cow(s)");
        }
        if (aborted) {
            out.println("Game aborted");
        } else {
            out.println("Done, number was " + number + " you needed " + nGuess + " guesses");
        }
    }

   // ------------------ Methods --------------------------------

    int countBulls(int guess, int answer) {
        int bulls = 0;
        int gDigit;
        int aDigit;
        while (guess > 0) {
            gDigit = guess % 10;   // Compare digit by digit from right
            aDigit = answer % 10;
            if (gDigit == aDigit) {
                bulls++;
            }
            guess = guess / 10;     // Remove last digit
            answer = answer / 10;
        }
        return bulls;
    }

    int countCowsAndBulls(int guess, int answer) {
        int cows_and_bulls = 0;
        int gDigit;
        while (guess > 0) {
            gDigit = guess % 10;         // Mask out digits from right
            if (numberContains(answer, gDigit)) {  // Func decomp
                cows_and_bulls++;
            }
            guess = guess / 10;
        }
        return cows_and_bulls;
    }

    int digitAt(int number, int index, int nDigits) {
        int digit = 0;
        int i = nDigits - index;
        while (i > 0) {
            digit = number % 10;   // Mask out digits from right
            number = number / 10;
            i--;
        }
        return digit;
    }

    boolean hasUniqueDigits(int number) {
        int d0 = digitAt(number, 0, 4);   // Func decomp
        int d1 = digitAt(number, 1, 4);
        int d2 = digitAt(number, 2, 4);
        int d3 = digitAt(number, 3, 4);
        // Bit ugly ...
        return !(d0 == d1 || d0 == d2 || d0 == d3 || d1 == d2 || d1 == d3 || d2 == d3);
    }

    boolean numberContains(int number, int digit) {
        int nDigit;
        while (number > 0) {
            nDigit = number % 10;  // Mask out digits from right
            if (nDigit == digit) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }

    // Brute force random generation (better implementation possible but not right now...)
    int getNumber() {
        int min = 1234;
        int max = 8642; // 9876 - 1234
        int n = -1;
        while (!hasUniqueDigits(n) || numberContains(n, 0)) {
            n = rand.nextInt(max + 1) + min;  // Must have 8643 to be able to get 8642
        }
        return n;
    }

    // ---------------  Testing of methods -----------------------------
    void test() {
        out.println(digitAt(1234, 0, 4) == 1);
        out.println(digitAt(1234, 2, 4) == 3);
        out.println(digitAt(12345, 4, 5) == 5);

        out.println(hasUniqueDigits(123));
        out.println(!hasUniqueDigits(1134));
        out.println(hasUniqueDigits(12534));

        out.println(countBulls(1234, 6784) == 1);
        out.println(countBulls(1234, 1267) == 2);
        out.println(countBulls(1234, 1235) == 3);

        out.println(countCowsAndBulls(1234, 6781) == 1); // One Cow
        out.println(countCowsAndBulls(1234, 2781) == 2); // Two Cow
        out.println(countCowsAndBulls(1234, 7281) == 2); // One cow onw bull

        out.println("Number " + getNumber());  // Manual test (not so good but if random used)
        out.println("Number " + getNumber());
        exit(0);                               // Will exit program
    }

}
