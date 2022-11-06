package ex1enumwrapper;

import static java.lang.System.out;

/*

    Wrapper types are reference versions (class types) wrapping
    primitive type values. All primitive types have a corresponding
    wrapper type:

    int -> Integer
    double -> Double
    boolean -> Boolean
    char -> Character
    etc.

    Wrapper types behave as class types (objects) i.e. assignment
    and equals by reference (some pitfalls).

    Wrapper types needed for generic methods and classes. More to come.

 */
public class EW3WrapperTypes {

    public static void main(String[] arg) {
        new EW3WrapperTypes().program();
    }

    void program() {

        // -------- Primitive vs Wrapper types ---------------

        int i = 12345;
        int j = 12345;
        out.println(i == j);     // Equal by value

        // Below is deprecated, shouldn't do like this
        // Used only for demonstration
        Integer ii = new Integer(i);    // Create wrapper object for i
        Integer jj = new Integer(j);    // Create wrapper object for j (same value)

        out.println(ii == jj);       // Same values but false by reference!
        out.println(ii.equals(jj));  // Have to use equals, to compare actual values

        // ------ Boxing/unboxing--------------
        // (Automatic) Conversion between primitive and wrapper

        ii = 4;          // Boxing, int 4 boxed to Integer object
        j = ii;          // Unboxing, Integer object ii unboxed to int j

        //ii = 6.0;          // Bad (more to come)
        double d = 5;        // Ok ... but
        //Double dd = 5;     // ... this is bad (more to come)

        // Inc/Dec
        ii++;    // Immutable! But sequence unbox/inc/box makes it seems mutable

        // ------------- Conversions --------

        Integer kk = 1;
        d = kk;            // From Integer to double, unboxing then conversion
        Double dd = d;
        i = dd.intValue();   // From Double to int (will lose information)

        // ----- Pitfalls -----------------------------
        // When (un)boxing?

        Double d1 = 5.0;
        Double d2 = 5.0;

        out.println(d1 == 5.0);       // Unboxing, then compare
        out.println(d1 <= d2);        // Unboxing, then compare
        out.println(d1 >= d2);        // Unboxing
        out.println(d1 == d2);        // No unboxing!

        out.println(d2 == 0 + d2);    // Unboxing
        Double d3 = 1.0;
        out.println(d1 == d2 * d3);    // Unboxing (multiplication of values not references)


        // ---  Pitfalls, caching of values < 128 ----------------

        Integer i1 = 99;  // Wrapper object with value 99 (created and cached beforehand)
        Integer i2 = 99;  // Will uses same wrapper object!
        out.println(i1 == i2);   // Yes! Same object


    }
}
