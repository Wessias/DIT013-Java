package ex3supersub;

import java.util.Random;

import static java.lang.System.out;

/*
    We know that int values <: double values.
    How about int and double variables?
 */
public class SS2Variables {

    public static void main(String[] arg) {
        new SS2Variables().program();
    }

    void program() {
        int i = 2;
        double d = 2.0;


        // Replace super with sub ---------------------

        // An assignment that compiles.
        d = 3.0 * d;

        // Try to replace right side with sub i.e. d->i, ok (as before)
        d = 3.0 * i;

        // Try to replace left side with sub i.e. d->i, NO type error
        //i = 3.0 * d;

        // Replace sub with super ----------------------

        // An assignment that compiles.
        i = 2 + ~i;

        // Try to replace right side with super, NO (as before)
        //i = 2 + ~d;

        // Try to replace left side super, Ok
        d = 2 + ~i;

        /*
             DIFFERENT ROLES FOR A VARIABLE
            ------------------------------------
            The right part of assignment represents a value, super/sub for values apply
            The left side is **not** a value (it's a location), super/sub rules for
            values doesn't apply. Can't replace a variable "anywhere" so no super/sub for variables.

         */
        /*
            SUPER/SUB VARIABLES AND VALUES
            ------------------------------
            There is no super sub relation for variables but we can state some
            fundamental observation: For assignments the following must hold
            during compilation:

            super = sub        i.e. a variable of super type may store a value of subtype
            sub = (sub) super  a value of supertype may be cast to fit a variable of sub type

         */
        // ------ Implicit conversions --------------------
        // If super/sub relation there will be implicit conversions if needed (as before)

        d = 4;     // 4 -> 4.0 then stored
        d = i;
        char ch = 'A';
        i = ch;
        d = ch;     // Transitive

        //---- Explicit conversion  ------
        // If super/sub relation explicit conversions (cast) are allowed (as before)

        d = 2.5;
        i = (int) d;           // d = 2.5 -> 2 store in i (ok, but precision lost)
        //(double) i = 4.5;    // Values casted NOT variables

        // ---------- Non super sub relation variables  -----------------

        //boolean b = 2;           // Compile error
        //int j = (int) true;      // Can't cast.

        // ---------- Equality -----------

        boolean b = true;
        out.println( d == i );   // Have super/sub, ok
        //out.println(ch == b);     // No super sub


    }
}
