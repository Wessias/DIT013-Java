package ex4exceptions;

import java.io.IOException;

import static java.lang.System.out;

/*
    Exception catching and flow

    If an exception occurs and program doesn't handle it
    the program will be terminated (crash)
    Not an acceptable behaviour, ... so we must handle exceptions

    To handle an exception we use the try/catch statement
    - Embed statements that may trow exceptions into the try-part.
    - If exception program will jump directly to catch-part where we
    possibly can do something sensible (often not). In catch part we will get
    an object representing the exception (info). Object automatically created
    - If no exception the catch-part is not executed, program continues
    after the try/catch-statement

    If exception the normal flow of the program is altered.
    - The program unwinds the call stack (jumps through method calls)
    until if find a try/catch statement (if any). This behavior is
    called non-local jump (and is considered a problem)

    Debug this to see the flow

 */
public class E2CatchFlow {

    public static void main(String[] args) {
        new E2CatchFlow().program();
    }

    void program() {

        // --------- Catching an exception ---------------------

        try {
            out.println(1 / 0);              // Exception ...
        } catch (ArithmeticException e) {    // Exceptions have types!! e is object of type ArithmeticException
            out.println(e.getMessage());     // ...catched here
        }
        // .. program will *not* crash, continue here

        // ---------- Flow if exception occurs ---------------

        A a = new A();
        try {
            a.doIt();                        // Will possible throw exception
        } catch (IllegalStateException e) {  // Exception travels all the way to here
            out.println(e.getMessage());     // (unwind the call stack)
        }

        // -------- Checked exceptions -------------

        // Some exception classes represents checked exceptions
        // **Must** be catched, compiler checks
        try {
            // IOException a checked exception
            // Must have try/catch else compile error
            throw new IOException("Can't find the keyboard");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    // --------------- Classes -----------------

    class A {
        B b = new B();

        int doIt() {
            b.doOther();  // No catch here!
            out.println("A: doIt");
            return 1;
        }
    }

    class B {
        C c = new C();

        int doOther() {
            c.doYetOther();    // No catch here!
            out.println("B: doOther");
            return 2;
        }
    }

    class C {
        int doYetOther() {
            out.println("C: doYetOther");
            // No catch here! Check if exception handler in calling method?
            // Else continue upwards in call stack ...
            throw new IllegalStateException("Exception thrown");
            //return 3;   // No unreachable.
        }
    }

}
