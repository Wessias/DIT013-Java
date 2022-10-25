package ex1basics;

import java.util.Scanner;       // To be able to use resources from Java

import static java.lang.System.in;
import static java.lang.System.out;

/*
     Program to calculate the slope of a line

     NOTE: Structure of program: in -> process -> out, See Slope.pdf
     NOTE: Coding standard
     - The { }
     - variables start with lowercase (composites use Camel Case, see web)
 */
public class B7Slope {
    // Don't care for now
    public static void main(String[] args) {
        new B7Slope().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {     // Our program starts here

        // ---- Input ---------
        out.println("Calculate slope of line"); // Statement, write to screen

        out.print("Input x1 y1 > ");   // More statements
        double x1 = sc.nextDouble();   // Read from keyboard
        double y1 = sc.nextDouble();

        out.print("Input x2 y2 > ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        // ------ Process --------
        double slope = (y2 - y1) / (x2 - x1);  // NOTE: / tricky.

        // ----- Output ------------
        out.println("Slope = " + slope);
    }                                    // Program ends here

}
