package ex2references;


import static java.lang.System.out;

/*
    Arrays are handled as references to array objects!
 */
public class R2Arrays {

    public static void main(String[] arg) {
        new R2Arrays().program();
    }

    void program() {
        // We declare a1, a single variable holding a reference to
        // a nameless array object containing 3 nameless variables.
        // Only way to access the object and the variables are through
        // the variable a1. a1 is a reference variable (it has a reference type)
        int[] a1 = new int[]{1,2,3};

        // Row reads: Follow the reference in a1 to the object
        // and apply the indexing operator to select
        // the first nameless variable in the object. Following
        // the reference to the object is called to dereference
        // (this in done automatically in Java but not in all languages)
        a1[0] = 99;
        out.println(a1[0]);

        // a2 referencing **another** object, with same values
        int[] a2 = new int[]{1,2,3};

        // ------- Assignment and equality ---------------

        // This is false because the variables have different
        // values i.e. references (points at) different objects
        // Content of array objects not compared!
        out.println(a1 == a2);       // False

        // Assignment means copy from right hand to left
        // So *reference* in a1 will be copied to a2 (normally 64 bits)
        // NOTE: a2 object unreachable after this!
        a2 = a1;

        // True because they have the same value,
        // the references points to the same object
        out.println(a1 == a2);         // True

        // ------ Alias problem ------------

        // Change object referenced by a2
        a2[2] = 777;
        // Because a1 reference the same object
        // the effect will be noticed when using a1
        out.println(a1[2] == 777);  // a1 changed, alias! May lead to confusing errors!

        // -------- Final reference variables ---------

        // Variable a3 final
        final int[] a3 = {1, 2, 3};
        //a3 = a1;    // No, compile error

        // But variables in referenced object not final
        // Possible to change
        a3[0] = 21;



    }
}
