package ex3override;

import static java.lang.System.out;

/*
        Possible to make mistakes when overriding
        resulting in overloading (because of inheritance)

        NOTE: Overloading between super/sub classes bad
        Overloading should be in same class!

 */
public class O3OverrideMistake {

    public static void main(String[] args) {
        new O3OverrideMistake().program();
    }

    public void program() {
        A a = new B();
        out.println("Ten times as much is " + a.longAndHardToSpellName(5.0));
    }

    // --------------- Classes -------------------------

    class A {
        // Possible to override
        public double longAndHardToSpellName(double d) {
            return d;
        }

    }

    class B extends A {
        // No override! Instead inherited method from A.
        // i.e. two overloaded methods here
        // Should have used @Override!
        public double longAndHardToSpelName(double d) {
            return 10 * d;
        }

        // Or like this other param type (obvious here but if a lot of code
        // and many programmers, not).
        //@Override
        public double longAndHardToSpellName(float f) {
            return f / 10;
        }

    }
}
