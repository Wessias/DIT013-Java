package ex3arraysfor;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    Array IO. Must read/write each element
    (except when using Arrays.toString() but then we
    will get a default style string)

 */
public class AF4ArraysIO {

    public static void main(String[] args) {
        new AF4ArraysIO().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Declare array variable and initialize it
        int[] arr = {7, 1, 0, 4, -2};

        // ------ Output ------------------

        out.println(arr);                  // Bad (strange) output ... (will print id of object in memory)
        out.println(Arrays.toString(arr)); // ... possibly, but format fixed.

        out.println("{ ");                 // Custom output
        for (int i = 0; i < 5; i++) {
            out.print(i + " ");
        }
        out.println("}");

        // ----  Input  --------------------------
        // Read strings into array

        String[] names = new String[3];
        out.print("Input 3 names (enter after each) > ");
        for (int i = 0; i < names.length; i++) {     // Must use loop
            names[i] = sc.nextLine();                // Read each element
        }
        out.println("Names are:");                  // Write content of array to screen
        for (int i = 0; i < names.length; i++) {
            out.println(names[i]);
        }
    }
}
