package ex3methods;

import static java.lang.System.out;

/*
    Using references as return values
 */
public class MR2ReturnValues {

    public static void main(String[] args) {
        new MR2ReturnValues().program();
    }


    void program() {
        /*
            Different possibilities for the return value if
            using references
         */
        // -------- Alt.1 in/out parameter  ------------
        // No return value (void)

        int[] arr = {1, 2};
        arrSwap1(arr);          // Original object changed
        out.println(arr[0] + " " + arr[1]);

        // --- Alt.2 return in parameter ------------

        int[] arr1 = arrSwap2(arr);         // Original object changed
        out.println(arr == arr1);           // True, return incoming reference value
        out.println(arr[0] + " " + arr[1]);

        // --- Alt.3 return new reference ------------

        int[] arr2 = arrSwap3(arr);        // Original object **not** changed
        out.println(arr != arr2);           // False, return reference to created object
        out.println(arr[0] + " " + arr[1]);
        out.println(arr1[0] + " " + arr1[1]);

        /*
            Alternatives are the same for objects, see below
         */
    }

    // ------------- Methods ------------------------------

    // In/out parameter (NOTE: final doesn't protect the object)
    void arrSwap1(final int[] arr) {
        int tmp = arr[0];  // Change original (incoming) object
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    // Return in parameter
    int[] arrSwap2(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
        return arr;
    }

    // Original unchanged. Return reference to new object
    int[] arrSwap3(int[] arr) {
        int[] tmpArr = new int[arr.length];
        tmpArr[0] = arr[1];
        tmpArr[1] = arr[0];
        return tmpArr;
    }

    // Return reference to modified original object
    Pair incPair(Pair pair) {
        pair.a++;
        pair.b++;
        return pair;
    }

    // Return reference to new object
    Pair incPair2(Pair pair) {
        Pair p = new Pair(pair.a, pair.b);
        p.a++;
        p.b++;
        return p;
    }

    // ------- Class --------------------

    class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}






