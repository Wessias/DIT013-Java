package ex4types;

import java.util.Random;

/*
     Super/sub for interfaces and implementing classes
 */
public class T2InterfaceSuperSub {

    public static void main(String[] args) {
        new T2InterfaceSuperSub().program();
    }

    void program() {

        // ---------- Interfaces ------------
        Sayable s = null;
        Jumpable j = null;

        //s = j;          // No, no super/sub
        //j = s;          // No, no super/sub

        /*
            SUPER / SUB FOR INTERFACE TYPES
            ------------------------------
            Casting from/to interface allowed for any type
            **regardless** of super/sub. More to come ...

            *** Anything goes!!! ***
         */

        Pig p = (Pig) s;            // From interface to class
        s = (Sayable) new Random(); // From class to interface (runtime exception here)

        /*
            IMPLEMENTING TYPE IS SUB to INTERFACE
            -------------------------------------
            Implementing class is subtype

         */
        Sayable sayable = new Cat();  // super = sub
        sayable = new Dog();          // super = sub
        sayable.say();                // Works for any: Dog, Cat
        //sayable = new Pig();        // No! Doesn't implement

        // --------- Object -----------

        Object o = sayable;   // Object super to any

        // ----------- Equality ---------

        if (s == j) {   // NO Super/sub, but allowed!!
        }

        Cat cat = new Cat();
        if (j == cat) {
        }

        if (j == p) {

        }
    }

    // ----  Interfaces -----------------------------

    interface Sayable {
        String say();
    }

    interface Jumpable {
        // ...
    }

    // ------- Classes -------------

    class Cat implements Sayable {
        @Override
        public String say() {
            return "Mjau";
        }
    }

    class Dog implements Sayable {
        @Override
        public String say() {
            return "Voff";
        }
    }

    class Pig {
    }

}















