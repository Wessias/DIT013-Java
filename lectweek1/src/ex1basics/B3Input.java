package ex1basics;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
     Java Input (using in-stream)

     NOTE: There is always an ending "enter character" (notes as \n) last
     in the input. Generated when we hit the enter key.
     May cause problems, see pitfalls below.

 */
public class B3Input {

    public static void main(String[] args) {
        new B3Input().program();
    }

    /*
        A Scanner is an object that can create values out of sequences of
        character codes from keyboard (each key press sends a character code).
        Codes (bytes) are transmitted via the input stream "in"
        in-stream is by default connected to keyboard
     */
    // Create Scanner, connect scanner and in-stream
    final Scanner sc = new Scanner(in);   // The name of the scanner is sc.

    void program() {

        // ------ Use Scanner to read --------------------
        // When running: Input some digits in bottom window, press enter

        out.println("Input an integer > ");  // Prompt user
        int n = sc.nextInt(); // Input some digits and hit enter. sc will read key codes and convert to int
        out.println(n);       // Print value in variable

        double d = sc.nextDouble();      // Read a double
        out.println(d);
        boolean b = sc.nextBoolean();    // Read a boolean
        out.println(b);
        //char ch = sc.nextChar();       // Not Possible, can't read single char
        String s = sc.nextLine();        // Read a full input line (incl. last enter char)

        // ------------ Pitfall ---------------------------

        // The below is needed only if reading a number *and then* a string
        // (because reading digits leaves enter key code last in input)
        out.println("Input an integer > ");
        n = sc.nextInt();                  // Read all digits but not the enter key
        sc.nextLine();                     // Read away the trailing enter key code!!!! ...
        out.println("Input a string > ");
        String str = sc.nextLine();        // ... else we will read enter here
        out.println(str);

        // ------------ Exceptions -----------------------
        /*
            NOTE: If NOT possible for the Scanner to convert input to
            the desired type, an exception occurs and program aborted (crash)
            Uncomment below and run.
        */
        //int j = sc.nextInt();  // Input a double 1.23 or "abc"
    }
}
