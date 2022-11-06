package ex3methods;

import static java.lang.System.out;

/*
    Call methods with primitive vs reference parameters
 */
public class MR1Swap {

    public static void main(String[] args) {
        new MR1Swap().program();
    }

    void program() {
        /*
           Our aim is to swap the values of two variables
         */

        // ------- Using primitive types ------------------

        int a = 1;         // Values to swap
        int b = 2;
        swap(a, b);        // Will not work
        out.println(a + " " + b);

        // ----- Using reference typ array --------------

        int[] arr = {1, 2};    // Values to swap
        swapArr(arr);          // Works, because we use references (accessing the object outside the method)
        out.println(arr[0] + " " + arr[1]);

        // ---- Using reference type object -----------

        Pair p = new Pair(1, 2);// Values to swap
        swapObject(p);               // Works, because we use references
        out.println(p.a + " " + p.b);


    }

    // -------- Methods ----------

    // This will not work in Java.
    // Can't change variables outside the method
    void swap(int a, int b) {
        int tmp = a;    // Just swapping local variables with copied of values
        a = b;
        b = tmp;
    }

    // Possible to change variables of an object
    // outside method
    void swapArr(int[] arr) {
        int tmp = arr[0];    // Swap variables in object
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    // Possible to change variables of an object
    // outside method
    void swapObject(Pair pair) {
        int tmp = pair.a;   // Swap variables in object
        pair.a = pair.b;
        pair.b = tmp;
    }

    // ------- Class --------------------

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}






