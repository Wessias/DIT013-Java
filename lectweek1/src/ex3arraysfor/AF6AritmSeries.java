package ex3arraysfor;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    Program to decide if an array of integers is an
    arithmetic series. See AritmSeries.pdf
 */
public class AF6AritmSeries {

    public static void main(String[] args) {
        new AF6AritmSeries().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        int[] series = new int[10];                     // Declare array variable, create array

        // ---- Input ---------
        out.println("Arithmetic series");
        out.print("Input 10 integers (space between) > ");
        for (int i = 0; i < series.length; i++) {
            series[i] = sc.nextInt();                   // Read into array
        }

        // ----- Process ----------------------
        boolean isArithmetic = true;                    // Boolean variable
        int k = series[1] - series[0];

        for (int i = 0; i < series.length - 1; i++) {   // Traverse ...NOTE: length -1
            if (series[i+1] != series[i] + k) {       // ... and check difference
                isArithmetic = false;
                break;
            }
        }

        // ----- Output ------------
        out.println("Series is " + Arrays.toString(series));
        if (isArithmetic) {
            out.println("Series is arithmetic");
        } else {
            out.println("Series is NOT arithmetic");
        }
    }


}
