package ex3arraysfor;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    To visit all variables in an array once (left to right or the reverse)
    is called traversing. To traverse an array we use a for-loop
    (because we know how many iterations i.e. the length)

 */
public class AF3ArraysTraversing {

    public static void main(String[] args) {
        new AF3ArraysTraversing().program();
    }

    void program() {
        // Declare array variable and initialize it
        int[] arr1 = {7, 1, 0, 4, -2};

        // ------- Traversing -----------------

        // Going left to right. Use for loop and length of array to traverse.
        for (int i = 0; i < arr1.length; i++) {  // NOTE: Strictly less!
            out.println(arr1[i]);     // Print values
        }
        out.println();             // Just formatting

        // Going right to left
        for (int i = arr1.length - 1; i >= 0; i--) {  // NOTE: length-1 !
            out.println(arr1[i]);     // Print values
        }

        // --------- Pitfalls -----------

        for( int i = 0 ; i <= arr1.length; i++){
           //out.println(arr1[i]);           // ArrayIndexOutOfBoundsException
        }

    }
}
