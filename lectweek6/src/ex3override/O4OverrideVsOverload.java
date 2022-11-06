package ex3override;


import static java.lang.System.out;

/*
    Overriding vs Overloading
    Confusion may occur because of inheritance

    NOTE: Inheritance MUST be involved when overriding!
    NOTE: Inheritance SHOULD NOT (but may by mistake, or as demo here) be involved
    when overloading!

 */
public class O4OverrideVsOverload {

    public static void main(String[] args) {
        new O4OverrideVsOverload().program();
    }

    private void program() {

        // ---------- Overloading ----------------
       
        A a = new B();
         /*
            EARLY (STATIC) BINDING
            ----------------------
            Because method heads are **not** identical
            compiler is able to decide which method to call
            during compilation (using the variable type)
         */
        a.doIt(5);   // If 5 -> 5.0 (sub->super) method in A is the one! Done!
        // a.doIt();    // No such method in A

        B b = new B();
        b.doIt(5);    // Has overloaded methods (by inheritance). Exact match for doIt(int). Done!
        b.doIt(5.0);  // Exact match for doIt(double). Done!

        // ---------- Overriding ----------------
        // Overriding is runtime

        C c = new D();      // Value (object) unknown to compiler. C or a D?
        c.doIt(5.0);     // Many identical method, use object at runtime to decide

    }


    // --------- Classes ----------------

    class A {
        void doIt(double d) {
            out.println("doIt A");
        }
    }

    class B extends A {
        // Overload (method heads not identical)
        // Have two overloaded methods here
        void doIt(int i) {        // NOT override
            out.println("doIt B");
        }
        /*void doIt(double d) {
            out.println("doIt A");
        }*/
    }

    class C {
        void doIt(double d) {
            out.println("doIt C");
        }
    }

    class D extends C {
        // Override from C
        @Override
        void doIt(double d) {      // Exactly same method head
            out.println("doIt D");
        }
    }



}
