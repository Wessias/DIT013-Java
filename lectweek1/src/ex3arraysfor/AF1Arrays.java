package ex3arraysfor;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    To package variables of the *same type* we use an Array. An array is an
    object containing a consecutive "row" of variables (elements) of the same type.
    To access individual variables we use indices (the order number for the variable).
    - Indexing starts at 0! So last element index is (length - 1)
    - If using index outside, an exception will be thrown (program crash)

    Arrays types are constructed from some base type (primitive or other) by adding []
    after the base type, some possible array types are:
    - int[], int array
    - double[], double array
    - char[],
    - etc. for all primitive type
    - String[], array of strings

    The length of the array (the number of variables) must be specified during
    the initialization of any array variable (i.e. variable having an array type)
    Done by using an initialization list or an integer. Later we can read the length
    of the array object by using arr.length, see below
    The length is **fixed**, not possible to change (must create new array).

 */
public class AF1Arrays {

    public static void main(String[] args) {
        new AF1Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Declare array variable arr1 and initialize it
        // Will create 5 int variables (with the common name "arr") and
        // set values at index 0 to 4 (simplified more to come)
        int[] arr1 = {7, 1, 0, 4, -2};
        out.println(arr1.length);        // Possible to get length (length fixed)!

        out.println(Arrays.toString(arr1)); // Get an readable output by converting to String

        // --- Assignments (same as single variables) ------------

        arr1[0] = 2;
        arr1[2] = arr1[3];
        int n = 3;
        arr1[n] = 1;
        int m = arr1[n];
        arr1[n] = arr1[n + 1];           // Note!

        // -----  In/decrement (same as single variables) ----------

        arr1[2]++;
        --arr1[1];

        // --- Create arrays in running code, i.e. NOT at declaration ------

        // Create new array with 6 variables with value 0 (default initialization)
        // for the previously declared variable (i.e. replace old)
        arr1 = new int[6];
        // Create another new array with 5 initialized variables
        arr1 = new int[]{2, 9, 0, 1, -4};

        int length = sc.nextInt();
        arr1 = new int[length];      // Use variable for length when creating

        // ------------ Resizing ------------------

        // Would like to delete last element from this array
        int[] arr2 = {1, 2, 3};
        int[] arr3 = new int[arr2.length - 1];  // Create one shorter array
        arr3[0] = arr2[0];        // Copy values
        arr3[1] = arr2[1];
        arr2 = arr3;             // Overwrite arr2.
        out.println(Arrays.toString(arr2));

        // --------- Pitfalls -----------

        //arr3[5]++;      // ArrayIndexOutOfBoundsException, index outside
        int k = -1;
        //arr3[k]++;     // ArrayIndexOutOfBoundsException

    }
}
