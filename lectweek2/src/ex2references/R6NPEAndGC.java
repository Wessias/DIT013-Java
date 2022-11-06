package ex2references;

import static java.lang.System.out;
/*

    Null pointer exception and Garbage collection

    Java uses the special value null for a reference not referencing any object.
    To dereference (use) a null value will throw an exception, NullPointerException
    (NPE). NPEs very common...

    No memory problems if losing all references to an object. Java uses
    garbage collection to remove unreachable objects (a major problem with
    languages with no garbage collection like C/C++).

 */
public class R6NPEAndGC {

    public static void main(String[] arg) {
        new R6NPEAndGC().program();
    }

    void program() {

        // ------------- NullPointerException --------------------
        int[] a = null;
        String s = null;

        // Can't do (dereference) anything with the null value
        a[0]++;                   // NullPointerException (NPE)
        out.println(a.length);    // NPE
        s.length();               // NPE
        out.println(s);           // Possible to print value

        // Always careful with null. Avoid if possible
        int[] i = getIt();          // Could result be null??
        //out.println(i[2]);        // Yes, NullPointerException

        if (i != null) {            // Often have to check
            out.println(i[2]);
        }

        // ----------- Garbage collector GC ---------------------

        int[] arr1 = new int[1_000_000];

        // Object reference by arr1 lost! 4 Mb now inaccessible (to any program)
        arr1 = new int[10];   // No problem, garbage collection (GC) will return lost memory


    }

    int[] getIt() {
        return null; // Very bad, just demonstration
    }

}
