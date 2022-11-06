package ex4algorithms;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

/*
     Fisher-Yates is an algorithm for permutation
     See: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
 */
public class A2FisherYates {

    public static void main(String[] args) {
        new A2FisherYates().program();
    }

    final Random rand = new Random();

    void program() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        out.print("Array is ");
        out.println(Arrays.toString(arr));

        shuffle(arr);

        out.print("Random permutation of array is ");
        out.println(Arrays.toString(arr));
    }

    // --------------- Methods -----------------------

    // Brute force approach (we don't want this)
    void shuffleBrute(int[] arr) {
        int n = 0;
        while (n < 100000) {
            int i = rand.nextInt(arr.length);
            int j = rand.nextInt(arr.length);
            int tmp = arr[j];  // Swap values
            arr[j] = arr[i];
            arr[i] = tmp;
            n++;
        }
    }

    // Fisher-Yates algorithm, original array changed
    void shuffle(int[] arr) {
        for (int i = arr.length; i > 1; i--) {
            int j = rand.nextInt(i);
            int tmp = arr[j];   // Swap values
            arr[j] = arr[i - 1];
            arr[i - 1] = tmp;
        }
    }

    // Fisher-Yates, original preserved
    int[] shuffleCopy(int[] arr) {
        int[] copy = new int[arr.length];  // Make a new array
        // Copy all elements
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        shuffle(copy);  // Reuse F-Y above
        return copy;
    }
}
