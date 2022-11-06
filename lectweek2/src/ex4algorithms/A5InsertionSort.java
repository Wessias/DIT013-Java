package ex4algorithms;

import java.util.Arrays;

import static java.lang.System.out;

/*
    Insertion sort, a better sorting algorithm
 */
public class A5InsertionSort {

    public static void main(String[] args) {
        new A5InsertionSort().program();
    }

    void program() {
        int[] arr1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};   // Sorted desc.
        int[] arr2 = {5, 7, 6, 1, 0, 9, 9, 1, 3, 7};   // Random
        int[] arr3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};   // Sorted asc.

        insertionSort(arr2);
        out.println(Arrays.toString(arr2));
    }

    // ----------- Methods ---------------------------

    // Will be more efficient then Bubble sort if
    // data random or slightly sorted
    void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            // Loop not run if element in correct order
            while (j > 0 && arr[j - 1] > arr[j]) {
                int tmp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }
    }

}
