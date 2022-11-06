package ex1enumwrapper;

import static java.lang.System.out;

/*
    Enum (enumeration) are types for small set of values (a restricted class type).
    All values that belong to the type is explicitly written out when enum declared
    (so set must be small). By convention upper case is used for the values.

    Enums are used because they are type safe (as seen using String or int to represent
    is not safe, i.e. compiler can't catch misspellings or invalid numbers)

    Enum's introduce a reference type, the values are (final) reference variables
    referencing unique immutable (not possible to change) objects. So equality is
    by reference '==' (in fact it's identity)

 */

public class EW2Enum {

    public static void main(String[] args) {
        new EW2Enum().program();
    }

    // Declare enum type
    enum WeekDay {
        MON, TUE, WED, THU, FRI, SAT, SUN  // List all values that belong to type
    }

    // Declare other enum type
    enum Dir {
        N, E, S, W     // List all values that belong to type
    }

    void program() {
        // NO! enum objects already created (referenced by N,E,S,W)
        //Dir d = new Dir();
        //Dir d = new E();

        // -------- Variables, assignment and equality -------
        // (Same as classes)

        // enum introduce new type, declare variable of type
        WeekDay d1;

        //d1 = 0;               // No 0 is a int, wrong type
        //d1 = "SUN";           // No SUN is a string, wrong type

        d1 = WeekDay.FRI;           // Assign value FRI. Must prefix value with type
        WeekDay d2 = WeekDay.THU;

        out.println(d1 == d2);  // False references different objects
        d1 = d2;
        out.println(d1 == d2);  // True, identity.

        out.println(d1.equals(d2));  // Possible, but == normally used

        // ------ Some extra features for enum's------------------

        out.println(d1.ordinal());  // Values are numbered, starting at 0
        out.println(d2.ordinal());

        Dir[] dirs = Dir.values();  // Possible to loop through all values
        for (int i = 0; i < dirs.length; i++) {
            out.print(dirs[i]);       // Will automatically convert to String
        }

    }
}



