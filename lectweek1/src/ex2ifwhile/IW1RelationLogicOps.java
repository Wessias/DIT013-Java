package ex2ifwhile;

import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.System.in;
import static java.lang.System.out;

/*
      Relational and Logical operators
 */
public class IW1RelationLogicOps {

    public static void main(String[] args) {
        new IW1RelationLogicOps().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // ----   Relational operators  -------
        // (don't care about the yellow warnings for now)

        out.println(1 == 1);  // Equal. NOTE two "=" !!!
        out.println(1 != 2);  // Not equal
        out.println(2 > 1);   // Bigger than etc.
        out.println(1 < 2);
        int i = 1;
        out.println(1 <= i);
        out.println(i >= 1);

        // ----- Logical operators ------------------------

        boolean b1 = false;
        boolean b2 = true;
        out.println(!b1);         // Negation
        out.println(!b2);

        out.println(b1 && b2);   // Logical and
        out.println(b1 || b2);  // Logical or

        // ----  Intervals -----------------------
        // NOTE: Written as number axis

        int n = 4;
        out.println( ( 1 <= n && n <= 8));  // i in closed interval [1,8]
        out.println( n < 1 || 8 < n);       // i is *not* in closed interval [1,8]

        int x1 = 3;    // Interval one
        int x2 = 5;
        int x3 = 4;    // Interval two
        int x4 = 7;
        boolean overlaps = x1 < x2 && x3 < x4 && !( x2 <= x3 || x1 >= x4);
        out.println("The intervals overlaps " + overlaps);

        // ------------------- Lazy evaluation ------------------------

        // Only first from left evaluated because it's true (|| true if any is true)
        out.println( 1 < 2 || !(3 < 5) || 12 / 3 == 2 && 0 > 1);

        double d = 3;
         // Only first from left evaluated because it's false (&& is false if any is false)
        out.println( 1 > 2 && !(d < 5) || 12 / d == 2 || 0 > 1);

        // ------------- Pitfalls --------------------------------------

        // Comparing doubles
        double d1 = 1.0 - 0.7 - 0.3;  // = 0 (?)
        double d2 = 1.0 - 0.6 - 0.4;  // = 0 (?)
        out.println(d1 == d2); // False!! Rounding error!
        // Should use
        double epsilon = 0.000001;
        out.println(abs(d1 - d2) < epsilon);  // abs from Math

        // Comparing strings
        // For Strings == and != do normally not give the correct answer
        // Must use .equals(...)

        out.print("Input string: abc > ");
        String s = sc.nextLine();
        out.println(s == "abc");        // False, even if user typed abc
        out.println(s.equals("abc"));   // True, assume user typed abc.

        // This will work but it's a special case,
        // don't use == to compare strings (more later)
        out.println("abc" == "abc");
    }
}
