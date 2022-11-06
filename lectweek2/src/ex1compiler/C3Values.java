package ex1compiler;


import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    Compiler can't see values.
    Values (often right side of = ) are *runtime* (i.e. non-existing during compilation).

    Compiler can see type of value but **not** the value!

 */
public class C3Values {

    public static void main(String[] args) {
        new C3Values().program();
    }

    final Random rand = new Random();
    final Scanner sc = new Scanner(in);

    void program() {
        int i;

        // What value will be in i? Don't know at compile time!
        // (but do know at compile time that types are ok)
        i = rand.nextInt(100);  // Value??
        //i = rand.nextBoolean();      // Type error

        i = sc.nextInt();    // Value?? But types ok!
        i = abs(i);          // Value?? But types ok!

        out.println(i);
    }

    // --------------- Method declarations ---------------

    int abs(int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }
}
