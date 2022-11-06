package ex3supersub;

import java.util.Random;

/*
     Type Object (built in to Java) is super typ to any reference type

     Nameless "null type" is sub type to any reference
     type (contains the single value null)

 */
public class SS5ObjectNull {

    public static void main(String[] args) {
        new SS5ObjectNull().program();
    }

    void program() {

        // ----- Object super type to any -------

        Object o;
        o = "Any";                // super = sub
        o = new Dog();            // super = sub
        o = WeekDay.MON;          // super = sub
        o = new int[]{1, 2, 3};   // super = sub
        o = 4;           // Will box to Integer, so a reference type


        // ---------- Pitfalls (casting) -------------
        // Dog <: Object and Player <: Object

        Object object = new Dog();     // super = sub
        Dog dog = (Dog) object;        // sub = (sub) super, OK

        Player player = (Player) object;   // sub = (sub) super BUT runtime exception!
                                          // Can't transform Dog object to Player object

        /*
             CASTING OF REFERENCE TYPES
             --------------------------
             Casting may lead to runtime errors (ClassCastException)
             When casting we take the responsibility, we turn off
             the type checker (in the compiler). It's our fault!
             Casting is always dangerous, avoid!
         */
        /*
            SUPER/SUB VARIABLES AND VALUES DURING EXECUTION
            ------------------------------------------------
            The following must hold during execution else ClassCastException

            super = sub        i.e. a variable of super type may store a value of subtype

         */

        //--------- null ----------------
        // Null n;           // Bad, no null type, type is nameless

        o = null;            // super = sub
        int[] a = null;      // super = sub
        String s = null;
        WeekDay w = null;
        Dog d = null;
        Player p = (Player) null;    // Ok but senseless...null sub to any!
        //int i = null;    // i not reference type

        /*
            VARIABLE TYPE DEFINES OPERATIONS
            -------------------
            As before: Declared variable type governs which operations allowed
         */
        dog = new Dog();
        dog.age++;

        o = dog;         // super = sub
        //o.age++;       // No age for type Object! Operation not accessible


        // ---------- Equality -----------

        if( d == o ) {   // Have super/sub ok

        }

        if( d == null){  // Have super/sub ok

        }
    }

    // ----------- Types ----------------

    enum WeekDay {
        MON, TUE, WED, THU, FRI;
    }

    class Player {
        String name;
        int age;
    }

    class Dog {
        String name;
        int age;
    }
}
