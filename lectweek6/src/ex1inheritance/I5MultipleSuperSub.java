package ex1inheritance;

/*
    Any class may have multiple super or subtypes by implements and/or
    extends (nothing to run here)

    implements = interface inheritance
    extends = implementation inheritance (inherit runnable code)

    Restrictions
    - Multiple interface inheritance allowed (implements)
    - Only single implementation inheritance allowed (extends). Multiple has some issues so banned in Java.
    - Combination of implementation and interface inheritance allowed (and common)
 */
public class I5MultipleSuperSub {

    public interface IX {
    }

    public interface IY {
    }

    public class A {
    }

    // Multiple interface inheritance and
    // single implementation allowed (combination of allowed)
    // Multiple supertypes to B is A, IX, IY
    public class B extends A implements IX, IY {

    }

    /*  Multiple implementation inheritance not allowed
    public class X extends A, B {
    }
     */

    // Multiple subtypes to IX
    public class C1 implements IX {
    }

    public class C2 implements IX {
    }

    // Multiple subtypes to A
    public class D1 extends A {
    }

    public class D2 extends A {
    }
}
