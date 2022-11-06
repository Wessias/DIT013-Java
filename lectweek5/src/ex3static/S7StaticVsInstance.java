package ex3static;

import static java.lang.System.out;

/*
    A class using class variables and methods (static variables and methods)

    This shows:
    - An instance method can use/call instance and class
    variables and methods.
    - A class method can only call class methods and use
    class variables (no "this" in static methods).
    Class method can't know which object!

    It's possible to overload static methods
 */
public class S7StaticVsInstance {

    // A constant (application global values)
    public static final int MY_CONSTANT = 122;

    private static int i;    // A class variable (shared by all instances)
    private int j;           // Instance variable unique to each instance

    public void doIt() {       // Instance method
        out.println(i);
        out.println(j);
        out.println(this.i);     // Ok, but warning, don't use object
        out.println(i);          // Better
        out.println(this.j);     // Ok instance method have an instance this
        out.println(MY_CONSTANT);
        doOther();                // Call class method
    }

    public static void doOther() {   // Class method (static)
        out.println(i);
        //out.println(j);
        //out.println(this.i);     // No this in class method
        //out.println(this.j);
        out.println(MY_CONSTANT);
        //doIt();                 // Can't call instance method

        Object o = new S7StaticVsInstance().j;  // If object created, can use instance
        new S7StaticVsInstance().doIt();    // If object created, can use instance
        yetOther();           // Call other class method ok.
    }

    public static void yetOther() {
        out.println(MY_CONSTANT);
    }

    public static void doOther(int i) {    // Overloading of static method possible
        // ...
    }


}
