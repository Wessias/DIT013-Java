package ex3supersub;

import static java.lang.System.out;

/*
       Super/sub type-relation for values (literals)
 */
public class SS1Values {

    public static void main(String[] arg) {
        new SS1Values().program();
    }

    void program() {

        // An expression that compiles (& and ~ are bitwise operators)
        out.println((1 & 2) + 2.0 / ~4);

        // Is it possible to replace any double value with an int value
        // in the (any) expression and it will still compile?
        out.println((1 & 2) + 2 / ~4);    // Replace 2.0 Ok!
        // ... answer is : yes!

        // Is it possible to replace any int value with a double and still compile?
        // Answer is : NO! (bitwise operations not allowed for double values)
        //out.println((1.0 & 2) + 2.0 / ~4);   // Replace 1. Compile error


        /*
            THE SUPER/SUB RELATION FOR VALUES
            ---------------------------------
            The fact that we can replace double values with int values without
            getting a compile error makes int values a subtype to double values
            Written: int value <: double value
            Also: double values are supertype to int values

            It's always allowed to use a subtype value instead of a supertype. Will never
            cause any type errors because there are more allowed operations for the subtype
            (we can get bad values, but never any illegal operations, no compile error).
            double operations = { +,-,*,/,%, ... }
            int operations    = { +,-,*,/,%, ... ~,^,|,&}

            For primitive types the following super/sub relation is built into Java

            - byte <: short <: char <: int <: long <: float <: double
            - boolean has no super/sub relation to any type

        */

        // ---------- Implicit conversion of values ------------
        // Sub type values are always implicitly converted to super type if needed
        // (to evaluate expression for example)

        out.println(1 + 2.0);   // 1 -> 1.0 -> 1.0 + 2.0 -> 3.0 resulting typ double.
        out.println(~1 + 2.0);   // ~1 (highest precedence) yields -2 (int) converted to -2.0 (double)
        //out.println(~(1 + 2.0));  // No! can't apply ~ to double value

        // ---------- Explicit conversion of values ------------
        // If super sub relation then allowed to cast (change type of) super type value to sub
        // Using the cast operator ( ... ). NOTE: May lose information!

        out.println(1 + (int) 2.0);   // Ok. 2.0 to 2 then +, result type int

        // ---------- Non super sub relation values -----------------

        //out.println((boolean) 4.5);     // Compile error

        // ---------- Equality -----------

        out.println( 1 == 2.0 );   // Have super/sub, ok
        //out.println(true == 1);     // No super sub
        //out.println(true == (boolean) 1);  // Can't cast if no super/sub
    }

}

