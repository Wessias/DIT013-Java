package ex4algorithms;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

/*
      Using an array "the other way round" i.e.
      using indices as values
 */
public class A6Frequencies {

    public static void main(String[] args) {
        new A6Frequencies().program();
    }

    final Random rand = new Random();

    private void program() {
        // Array has values 0-9 (i.e. length 10)
        int[] arr = generateArray(10, 10);
        out.println("Values " + Arrays.toString(arr));
        out.println("Frequencies " + Arrays.toString(getFreq(arr, 10)));
    }

    // ----------- Methods ---------------------------
    // upperBound is the biggest value in arr. Lower bound is 0.
    int[] getFreq(int[] arr, int upperBound) {
        int[] freq = new int[upperBound];        // Frequency table
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;                    // Inc frequency
        }
        return freq;
    }

    int[] generateArray(int size, int upperBound) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(upperBound);
        }
        return arr;
    }

}
