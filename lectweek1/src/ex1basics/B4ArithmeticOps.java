package ex1basics;

import static java.lang.System.out;

/*
 *  Arithmetic with Java, mostly as you are used to in math.
 */
public class B4ArithmeticOps {

    public static void main(String[] args) {
        new B4ArithmeticOps().program();
    }

    void program() {

        out.println(1 + 2);   // Addition.
        out.println(1 - 2);   // Subtraction
        out.println(6 * 2);   // Multiplication
        out.println(-1);      // Negation

        // ------- Division (pitfalls) ------------------

        out.println(5 / 2);           // This is integer division! (because both operands int)
        out.println(5.0 / 2);         // Real division, at least one double
        out.println((double) 5 / 2);  // Achieve real division by convert int value to double
        out.println(4 + 6 / 3 * 2);     // Whats is above/below the division sign???
        out.println((4 + 6) / (3 * 2)); // Use parentheses to get correct result!
        //out.println(3 ^ 4);          // This is *NOT* exponentiation (no such operator)

        out.println(1.0 / 0);         // Infinity (Nan)
        //out.println(1 / 0);         // Arithmetic Exception

        // --------- Modulo ---------------------

        out.println(12 % 3); // Remainder operator (modulo)

        // Common way to mask out digits
        out.println(12345 % 10); // Get last digit (5)
        out.println(12345 / 10); // Get all except last (1234)

        // ------  Arithmetic expressions and types --------------
        // Expressions (to the right of = ) represents values, must have a type

        int i = 2;
        int j = 4 + 6 / (i * 3) - i;  // Expression value 3, type int
        out.println(j);

        double d = 3;
        double k = 4 + 6 / (i * d) - i; // Expression value 3.0, type double
        out.println(k);

        // ---------- Pitfalls --------------

        //i = 4 + 6 / (i * d) - i;  // Expression type is double, variable is int


    }
}
