package ex2ifwhile;

import static java.lang.System.out;

/*
    Very common to change value of (numerical) variable with +/-1
    i.e increment (+1) and decrement (-1)
    The easiest way to do it, use the ++/-- operators


 */
public class IW3IncDec {

    public static void main(String[] args) {
        new IW3IncDec().program();
    }

    void program() {
        int a = 1;

        /*
            Side effect
            -----------
            When an expression is evaluated it produces a value (which has a type)
            That's the normal way but, ... some expression, besides, producing
            a value does something more (alter memory or other ...).
            This is called as side effect. The ++/-- operators have side effects

         */
        a++;              // This is an expression but value ignored
        out.println(a);   // 2

        out.println(a++);   // Value is old value, side effect: a incremented
        out.println(a);

        out.println(a--);   // Value is old value, side effect: a decremented
        out.println(--a);   // Value is new value, side effect: a decremented

        // ---------- Aside ---------------

        // Assignment is an expression, so has a value.
        // Assignment has a side effect (change value in variable)
        // We use assignment for the sake of the side effect
        // The value seldom used. The value is "the assigned" value
        int i;
        int j = i = 1;    // Value of i = 1 is 1, side effect alter i.
        // Finally value 1 assigned to j.

    }
}






