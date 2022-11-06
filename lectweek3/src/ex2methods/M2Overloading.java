package ex2methods;

import java.util.Arrays;
import static java.lang.Math.*;

import static java.lang.System.out;

/*
    Overloading solves the problem of same name for different methods.
    It's a convenience.

    We can give different methods the same name (in the same scope)
    if the parameter lists differs (types, number of params, NOTE: names of
    params doesn't count).

    Typical usage: Need to do "same" operation on arguments with different types

 */
public class M2Overloading {

    public static void main(String[] args) {
        new M2Overloading().program();
    }

    void program() {
        int i1 = 4;
        int i2 = 5;

        // ----- Overloading -------------------------

        out.println(max(i1, i2));                       // Call ..
        out.println(max(2.5 * i1, 3.1 * i2));     // ... call overloaded

        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 4};
        out.println(Arrays.toString(max(a1, a2)));    // ... call overloaded


        // ----------- Overloaded method from Java Math ----------------
        // Result ignored for now

        abs(1);     // Absolute value of int
        abs(1L);    // long
        abs(1.0);   // double
        abs(1.0f);  // float


        // ---- Pitfalls (see below) --------------------

        //double d = add(1, 1);     // Ambiguous method call, both add() possible, see below

    }

    // -------- Methods ----------------------

    int max(int i, int j) {
        return i > j ? i : j;
    }

    /*  Not overloaded! Same as above, parameter names not counted
     int max(int a, int a) {
        return a > b ? a : b;
    }
    */

    // Overloaded
    double max(double i, double j) {
        return i > j ? i : j;
    }

    /*
         Return value *not* considered .. if so

         double d = max(1,2);   // Which method?
                                // return int may be converted to double
         double max(int i, int j) {  // Compile error, name clash
               return i > j ? i: j;}
    */

    // Overloaded
    int[] max(int[] arr1, int arr2[]) {
        return sum(arr1) > sum(arr2) ? arr1 : arr2;
    }

    // Helper
    int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i];
        }
        return s;
    }

    // --------------- Pitfalls ----------------------

    double add(int i, double d) {
        return i + d;
    }

    // Overloaded
    double add(double d, int i) {
        return d + i;
    }


}

