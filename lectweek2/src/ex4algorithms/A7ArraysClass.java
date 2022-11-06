package ex4algorithms;

import java.util.Arrays;

import static java.lang.System.out;

/*
     Arrays is a standard Java utility class for handling arrays
     Sadly usually not allowed on exam.
 */
public class A7ArraysClass {

    public static void main(String[] args) {
        new A7ArraysClass().program();
    }

    private void program() {
        int[] arr = {1, 2, 3, 4, 5};

        // How do the methods really work?
        Arrays.binarySearch(arr, 3);
        Arrays.sort(arr);
        int[] arr1 = Arrays.copyOf(arr, 2 * arr.length);
        Arrays.equals(arr, arr1);
        out.println(Arrays.toString(arr1));
        // Etc.
    }


}
