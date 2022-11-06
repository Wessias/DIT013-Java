package ex3override;


import static java.lang.System.out;

/*
    Some special points for inheritance, overloading and overriding
    - Is static inherited? (yes)
    - Is is possible to override static? (no, will be hiding)
    - Is it possible to overload static? (yes)
    - Possibly more, ... try to find some weired combination


 */
public class O6Specials {

    public static void main(String[] args) {
        new O6Specials().program();
    }

    private void program() {

        // ---------- Static -------------

        A.doOther();
        B.doOther();      // Hiding
        B.doYetOther();  // Inherited

        // ---------- Instances ------------

        A a = new A();
        B b = new B();

        out.println(a.s);
        a.doIt();


        a = b;
        out.println(a.s); // No override, declared type rules!
        a.doIt();         // Override

        // No override, declared type rules!
        a.doOther();      // Bad call style (don't use object), just for demo here
        b.doOther();
    }


    // --------- Classes ----------------
    // static class is just because the classes have static
    // methods AND are inside another class (i.e. this program)
    // Don't care, doesn't impact.

    static class A {
        String s = "super";

        void doIt() {
            out.println("doIt A " + s);
        }

        static void doOther() {
            out.println("doOther A");
        }

        static void doYetOther() {
            out.println("doYetOther A ");
        }
        // Overloading ok
        static void doYetOther(int i) { out.println("doYetOther B "); }
    }

    static class B extends A {
        //@Override           // No override for variables (this is hiding)
        String s = "sub";    // Possible but bad!

        @Override
        void doIt() {
            out.println("doIt B " + s);  // Use closest (super.b to access super)
        }

        //@Override           // No override for static. This is hiding
        static void doOther() {
            out.println("doOther B ");
        }
    }

}
