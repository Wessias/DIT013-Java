package ex2ifwhile;

import static java.lang.System.out;

/*
    To repeat a number of statements we may use the
    while statement (or for-statement see later)
    This is formally known as "iteration" and informally as "loops"

    NOTE: We always put the statements to repeat in a block
    even if there is only one statement to repeat.

    NOTE: Placement of { , first (opening) on same line

    TIP: To inspect the execution of this try the debugger (learn how to use a debugger)

 */
public class IW4WhileStatement {

    public static void main(String[] args) {
        new IW4WhileStatement().program();
    }

    void program() {

        // ----- while statement (loop) ------------


        // Going up
        int i = 0;    // Set start value for counter variable
        while (i < 5) {  // Is i < 5 true? ...
            out.println("i is : " + i);  // ... yes, do the block (else continue after block)
            i++;     // Increment counter (normally last)
        }            // Jump up to while and start over

        // Going down
        i = 5;
        while (i > 0) {
            out.println("i is : " + i);
            i--;   // Decrement counter
        }

        // Step
        i = 0;
        while (i < 10) {
            out.println("i is : " + i);
            i = i + 2;  // Step by 2
        }

        // NOTE: If using same i we have to reset value in between loops

        // ------- Pitfalls -----------------------
        // Non terminating loops

        /*
        double i = 0;
        while (i != 1.0) {   // doubles are approximation, don't use in loops
            i = i + 0.01;
        }
        */

        // Loops below will run forever because the condition will never be false
        // Uncomment and run to try
        /*value = 0;
        while (value >= 0) {    // True forever
            out.println("i is : " + value);
            value++;
        }*/

        /*
        int n = 0;
        while (n < 5) ;{   // <--------  No ; (will run the empty statement forever)
            out.print(n);
            n++;
        }
        */

    }
}
