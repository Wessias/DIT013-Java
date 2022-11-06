package ex4types;


/*

      Casting from interface types is always allowed
      even if NO super sub relation!

      Q: Why?
      A: If an interface type to the right any implementing
         object may extend the left side variable type


 */
public class T2CastFromInterface {

    public static void main(String[] args) {
        new T2CastFromInterface().program();
    }

    private void program() {

        IX ix = null;   // To the right something that implements IX (null for now)
                        // (but what it may extend we don't know?)

        A a = (A) ix;   // No super sub, but allowed?!?!

        ix = new B();   // ... because could be like this i.e.
                        // A has subtype (extends) that implements IX

    }

    // -------------- Classes -------------------

    public interface IX {
    }

    public class A {
        // Class has **nothing** to do with IX
    }

    public class B extends A implements IX{
    }

}
