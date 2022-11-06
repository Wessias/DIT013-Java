package ex2methods;

import static java.lang.System.out;

/*

    A method with a side effect
    We really try to avoid this (but often used in imperative/OO-programming)

    Also: Testing! If using instance variables can't replace with
    test (or dummy) data. Method depends on data outside method!

 */
public class M5SideEffect {

    public static void main(String[] args) {
        new M5SideEffect().program();
    }

    void program() {

        out.println(getValue1());
        out.println(getValue2());

        out.println(getValue1() - getValue1());   // Normally should be 0
        out.println(getValue2() - getValue2());   // Normally should be 0
    }

    // All methods dependant on this variable
    int n = 0;        // Variable outside any method (instance variable)

    int getValue1() {
        return ++n;      // Side effect
    }

    int getValue2() {
        return n + 1;    // No side effect
    }

}

/*
    A quote
    "Now, scale that down. If you were fairly good at writing side-effect free code,
    how much faster would you be at reasoning at what some existing code did?
    How much faster could you write unit tests? How confident would you feel that
    the code with no side-effects was guaranteed bug-free, and that users could limit
    their exposure to any bugs it did have?

    If code has no side-effects, the compiler also may have additional optimizations
    that it could perform. It may be much easier to implement those optimizations.
    It may be much easier to even conceptualize an optimization for side-effect free code,
    which means that your compiler vendor might implement optimizations that are
    difficult-to-impossible in code with side effects.

    Concurrency is also drastically simpler to implement, to automatically generate,
    and to optimize when code has no side-effects. This is because all the pieces can
    be safely evaluated in any order."

 */







