package ex1classes;


import static java.lang.System.out;

/*
      Cool hack, ... let methods return "this".
      Makes it possible to chain calls

      - Convenient to use
      - Readable code.
      - No new objects created
 */
public class C3ChainedCalls {

    public static void main(String[] args) {
        new C3ChainedCalls().program();
    }

    void program() {

        // --- Version 1 (sequential calls)---------
        Counter c1 = new Counter();
        c1.inc();    // void method, must make each call in turn
        c1.inc();
        c1.inc();
        out.println(c1.getCount());

        // ------- Version 2 (nested calls) ------

        Counter c2 = new Counter();
        c2.incN(c2.incN(c2.incN(1)));  // Possible use nested calls, hard to read
        out.println(c2.getCount());

        // -------- Version 3 (chained calls) ---------------
        Counter c3 = new Counter();
        out.println(c3.incC().incC().incC().getCount());  // Chained calls. Readable!

    }


    class Counter {
        int count;  // Default 0

        // This method not able to nest nor chain
        void inc() {
            count++;
        }

        // Method able to nest but not chain (has side effect :-( )
        int incN(int i) {
            count += i;
            return i;
        }

        // Chainable method (has side effect :-( )
        Counter incC() {
            count++;
            return this;   // Return this (the counter object)!
        }

        int getCount() {
            return count;
        }
    }


}






