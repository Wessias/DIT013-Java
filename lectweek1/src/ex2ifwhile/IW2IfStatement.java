package ex2ifwhile;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    To select between different statements we use the if statement (selection)
    What will be executed is controlled by a boolean condition

    NOTE: We always put the statements to select in a block even if
    there is only one statement.

    NOTE: Placement of { and } on same line except for last one

 */
public class IW2IfStatement {

    public static void main(String[] args) {
        new IW2IfStatement().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        out.println("Input an integer > ");
        int i = sc.nextInt();

        // ---  If statement  -------------
        // Boolean condition in parentheses

        if (i == 2) {                       // if i equals 2 true ...
            out.println("i is 2");          // .. do this. Continue after '}'
        }                                   // <--- NO ';' after closing '}'

        // ---- If-else statement ---------------------------

        if (i > 2) {                              // if i > 2 true ...
            out.println("i bigger than 2");       //... do this...
        } else {                                  // ... else ...
            out.println("i is not bigger than 2");// ... do this. Continue after }
        }

        // ----  If-else if-statement (else if-ladder). -----------
        // NOTE: Only one of alternatives is executed! If one true found
        // no other tested. If none found the else branch is executed.

        if (i < 2) {                          // NOTE: Order matters
            out.println("i less than 2");
        } else if (i < 5) {
            out.println("i less than 5");
        } else if (i < 100) {
            out.println("i less than 100");
        } else {
            out.println("i bigger than 100");
        }

        // ----- Style ----------------------

        boolean b = false;
        if (b == true) {      // Bad style
            out.println(b);
        }

        if (b) {             // Better, i.e. no == used with booleans
            out.println(b);
        }

        // --------- Pitfalls ------------------
        // Just ; is the empty statement. Noting will happen.

        if (i < 2);{                    // <---- No ; . Will execute the empty statement
            out.println("i less than 2");
        }


    }
}
