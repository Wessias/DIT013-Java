package ex1basics;


import static java.lang.System.out;  // The out stream

/*
    Java Output (using the out-stream)

    IO = Input/output, input data to program (mostly from keyboard) and
    output data from program (to a window on the screen)

    IO is handled by "streams" in Java (a channel to send/receive bytes,
    i.e. like 01001100, 11011011, ... )

    NOTE: See import above, must be there to be able to access the streams by
    their (short) names
 */
public class B1Output {

    public static void main(String[] args) {
        new B1Output().program();
    }

    void program() {

        // -----   Use out-stream to write  -----

        // Name "out" represents the out-stream default connected to screen
        out.print(1);            // Print numerical value, NO new line
        out.println(23);         // ln = new line i.e. next output will start on next line
        out.print(1.0);          // Print a real number
        out.println(true);       // Print boolean value
        out.println('C');        // Print single character
        out.println('&');
        out.println("abc");      // Print String (sequence of characters)
        out.println(" c d e ");  // Spaces in strings preserved
        out.println();           // Just print new line
        out.println("Empty line above");


        /*
           Streams may be redirected for example to a file (more later)
         */
    }
}
