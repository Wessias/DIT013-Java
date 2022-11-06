package ex2methods;

import static java.lang.System.out;

/*
    Recursive method i.e. method calling itself

    NOTE: Senseless to use recursion in this course. Just
    to show trashing the call stack. Debug and watch call stack!

 */
public class M6Recursion {

    public static void main(String[] args) {
        new M6Recursion().program();
    }

    void program() {
        out.println(doItRec(5));
        //out.println(fibonacci(8));
    }

    // ---------- Methods --------------------

    // Bad, non terminating
    int doItRec(int i) {
        return doItRec(i);
    }

    // Get the nth fibonacci number
    // Recursive method (very inefficient)
    int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }


}







