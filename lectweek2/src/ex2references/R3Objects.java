package ex2references;


import static java.lang.System.out;

/*
    Objects are also handled as references.
 */
public class R3Objects {

    public static void main(String[] arg) {
        new R3Objects().program();
    }

    void program() {

        // ---------- Class objects -------------------

        // d1 is a reference variable referencing a class
        // object with two variables.
        // d1 has a reference type, so a reference variable
        Dog d1 = new Dog();

        // Dereference (automatically) and apply dot-operator and
        // variable name on object to access variables
        d1.name = "fido";

        // ----- Assignment and equality --------------

        Dog d2 = new Dog();     // Other Dog object
        d1.name = "fido";

        // Referencing two different objects
        out.println(d1 == d2);   // false

        // Assignment copies reference
        // NOTE: d1 object unreachable after this!
        d1 = d2;

        // Referencing same object
        out.println(d1 == d2);    // true

    }


    class Dog {
        String name;
        int age;
    }


}
