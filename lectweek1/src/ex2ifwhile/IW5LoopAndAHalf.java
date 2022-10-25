package ex2ifwhile;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    Loop and a half (using the break statement)

    This is used when the termination of the loop depends on
    some value (input) *in* the loop (i.e. NOT before the loop)

 */
public class IW5LoopAndAHalf {

    public static void main(String[] args) {
        new IW5LoopAndAHalf().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {

        // Loop termination depends on user input
        while (true) {    // Infinite loop (but not really)
            out.print("Input positive int > ");    // Try negatives when running!
            int i = sc.nextInt();
            if (0 < i ) {
                break;    // Break in middle (half) of loop. Jump out of directly *enclosing* loop
            }
        }
        out.print("Loop ended"); // <--------- break jumps to here!

    }
}
