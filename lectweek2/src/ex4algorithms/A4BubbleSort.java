package ex4algorithms;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Bubble sort. Simple to understand but inefficient sorting algorithm
 */
public class A4BubbleSort {

    public static void main(String[] args) {
        new A4BubbleSort().program();
    }

    void program() {
        int[] arr1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};   // Sorted desc.
        int[] arr2 = {5, 7, 6, 1, 0, 9, 9, 1, 3, 7};   // Random
        int[] arr3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};   // Sorted asc.


        out.print("Array is ");
        out.println(Arrays.toString(arr2));

        bubbleSort(arr2);

        out.print("Sorted array is ");
        out.println(Arrays.toString(arr2));
    }

    // ----------- Methods ---------------------------

    // Bubble sort (original changed)
    void bubbleSort(int[] arr) {
        // Loops are executed no matter what (i.e. inefficient if array close to sorted)
        for (int i = 0; i < arr.length - 1; i++) {          // The repeat loop
            for (int j = 0; j < arr.length - 1 - i; j++) {  // The swap loop
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];     // Swap values
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
