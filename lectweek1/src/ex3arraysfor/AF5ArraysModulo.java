package ex3arraysfor;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    When traversing an array sometimes would like to start over
    from the beginning, if so use modulo on length.
 */
public class AF5ArraysModulo {

    public static void main(String[] args) {
        new AF5ArraysModulo().program();
    }

    void program() {
        final int max = 13;
        int[] arr = {1, 2, 3, 4, 5};

        int i = 0;
        int n = 0;
        while (n < max) {
            out.print(arr[i] + " ");
            i = (i + 1) % arr.length;  // i: 0,1,2,3,4,0,1,2,3,...
            n++;
        }
    }
}
