package ex1basics;

import static java.lang.Math.*;
import static java.lang.System.out;

/*
     All the common mathematical function are supplied by Java

     NOTE: Must have import static java.lang.Math.*; above
 */
public class B6Math {

    public static void main(String[] args) {
        new B6Math().program();
    }

    void program() {

        double d = 2.1;
        out.println("Square root " + sqrt(d));
        out.println("Square " + pow(d, 2));
        out.println("Floor " + floor(d));
        out.println("Ceil " + ceil(d));
        out.println("Round " + round(d));
        out.println("Absolute value " + abs(-d));
        // etc. many more ... type Math. (dot) and they will show up ...

        // Pythagoras ... (nested calls)...
        out.println(sqrt(pow(3, 2) + pow(4, 2)) == 5);

        // ... often written as (bit more efficient, doesn't matter for now)
        out.println(sqrt(3 * 3 + 4 * 4) == 5);

        // Some values also supplied
        out.println(PI);      // 3.141...
        out.println(E);       // 2.7182 ...
    }
}
