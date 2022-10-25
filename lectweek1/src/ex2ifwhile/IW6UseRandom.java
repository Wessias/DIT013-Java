package ex2ifwhile;

import java.util.Random;

import static java.lang.System.out;

/*
     Usage of random numbers common in programming, in particular
     games. To get a random number we use a random number generator

     There are many Random generator in Java. We will use "Random".

 */
public class IW6UseRandom {

    public static void main(String[] args) {
        new IW6UseRandom().program();
    }

    // Create a random generator object named rand
    final Random rand = new Random();

    void program() {

        // Use random generator to get random numbers
        out.println(rand.nextInt(100));  // Range 0 <= n < 100
        out.println(rand.nextInt(6) + 1); // Range 1 <= n <= 6
        out.println(5 - rand.nextInt(10)); // Range -4 <= n <= 5

        // Many dice rolls
        int i = 0;
        while (i < 20) {
            out.print(rand.nextInt(6) + 1);  // Simulate a dice
            out.print(" ");  // Layout
            i++;
        }

        // Other kind of random values
        out.println(rand.nextBoolean());  // true/false
        out.println(rand.nextDouble());   // 0.0 <= n < 1.0

    }
}
