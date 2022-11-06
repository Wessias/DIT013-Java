package ex4algorithms;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    Nested loops very common. Here nested for-loops
    Tip: Use debugger
 */
public class A3NestedLoops {

    public static void main(String[] args) {
        new A3NestedLoops().program();
    }

    void program() {
        // Plot a half square
        for (int i = 0; i < 10; i++) {
            for (int j = i; j < 10; j++) {  // Sometimes inner loop depends on outer
                out.print("X");
            }
            out.println();
        }
    }
}
