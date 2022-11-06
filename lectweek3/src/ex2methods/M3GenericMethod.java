package ex2methods;


import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

/*
    Generic Method can handle data of any **reference** type
    Here we make a generic version of Fisher-Yates

    NOTE: Fisher-Yates doesn't need any information about the object.
    Algorithm just shuffles references.

 */
public class M3GenericMethod {

    public static void main(String[] arg) {
        new M3GenericMethod().program();
    }

    final Random rand = new Random();

    void program() {
        // Must use reference types for generic methods
        Integer[] iia = {1, 2, 3};      // Wrapper types are references
            Double[] dda = {1.0, 2.0, 3.0};
        String[] sa = {"a", "b", "c"};  // as are Strings
        Color[] colors = {Color.RED, Color.BLUE,
                Color.YELLOW, Color.GREEN, Color.BLACK}; // ... as are enums.

        // ---------- Shuffle any reference array!  ----------------

        shuffle(iia);
        out.println(Arrays.toString(iia));
        shuffle(dda);
        out.println(Arrays.toString(dda));
        shuffle(sa);
        out.println(Arrays.toString(sa));
        shuffle(colors);
        out.println(Arrays.toString(sa));
    }

    // ---------------- Methods --------------------------------

    // Generic version of Fisher Yates. <T> tells it's a generic method
    // T stands for any reference type (a type parameter)
    <T> void shuffle(T[] arr) {
        for (int i = arr.length; i > 1; i--) {
            int j = rand.nextInt(i);
            T tmp = arr[j];          // T is any type
            arr[j] = arr[i - 1];
            arr[i - 1] = tmp;
        }
    }

    // enum type
    enum Color {
        RED, BLUE, YELLOW, GREEN, BLACK
    }


    // -------- Overloading shortcoming  --------------
    // Could have array of any (not yet defined) typ

    void shuffle(int[] arr) {     // Overloaded methods

    }
    void shuffle(double[] arr) {

    }
    void shuffle(String[] arr) {

    }
    // Etc ... pui ...
}
