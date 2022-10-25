package ex3arraysfor;

import static java.lang.System.out;

/*
    To repeat a number of statements we may use the
    for statement (also an iteration, a loop like while)

    while vs for - loops
    - while: Used when we don't know the number of iterations
    - for: Used when we **do know** the number of iterations.

    NOTE: We always put the statements to repeat in a block
    even if there is only one statement to repeat.

    NOTE: Placement of { , first (opening) on same line


 */
public class AF2ForStatement {

    public static void main(String[] args) {
        new AF2ForStatement().program();
    }

    void program() {

        // --- for loop -------------------

        // Going up (NOTE: int i = 0 only executed once, at loop entry)
        for (int i = 0; i < 5; i++) {   // If i < 5 is true ...
            out.println("i is : " + i);    // ... execute the block (else continue after loop)
            // <------ i++ is in fact done here (last), but written on first line
        }  // Jump up to i < 5, and start over

        // Going down
        for (int i = 10; i >= 0; i--) {
            out.println("i is : " + i);
        }

        // Step
        for (int i = 0; i < 20; i = i + 2) {   // Step by 2
            out.println("i is : " + i);
        }
    }
}
