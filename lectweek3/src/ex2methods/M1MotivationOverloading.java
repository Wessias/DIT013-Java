package ex2methods;

import static java.lang.System.out;

/*

    Remember: Same name in same scope normally not allowed.
    So can't have same name for methods (all at top level scope) or ..???

    If doing the same operation (method) with different parameter lists
    (types, number of params), tiresome to have to invent new names
    (...but, not needed, more to come ...)

 */
public class M1MotivationOverloading {

    public static void main(String[] args) {
        new M1MotivationOverloading().program();
    }

    void program() {

        out.println(absInt(1));      // Tiresome ...
        //out.println(absInt(1.0));
        out.println(absDouble(1.0));  // ... and here
        //out.println(absFloat(5.0));
        out.println(absFloat(5.0f));     // .. and here

        // Strangely this works, more to come...
        out.println(absDouble(1));   // Send int value to double parameter
    }

    // -------- The same operation for different types of values  ----------------------
    // This isn't really necessary .. more to come.

    int absInt(int i) {
        /*
            Using an if-expression, an if construct that represents a value
            Syntax is:

            boolean expression ? value if true : value if false;

         */
        return i < 0 ? -i : i;  // if true -i else i
        /*
            The above same effect as if this statement (statement = no value)

            if( i < 0){
               return -i;
            } else {
               return i;
            }

         */
    }

    double absDouble(double i) {
        return i < 0 ? -i : i;
    }

    float absFloat(float i) {
        return i < 0 ? -i : i;
    }


}

