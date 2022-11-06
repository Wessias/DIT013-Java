package ex1classes;

/*
       Super/sub for generic classes
 */
public class C5GenericSuperSub {

    public static void main(String[] args) {
        new C5GenericSuperSub().program();
    }

    void program() {
        // Integer NOT <: Double
        Box<Integer> m1 = new Box<>();
        Box<Double> m2 = new Box<>();
        //m1 = m2;                    // No
        //m2 = m1;                    // No
        //m1 = (Box<Integer>) m2;     // No

        // Integer <: Object but Box<Integer> NOT <: Box<Object>
        // I.e. if generic type G with S <: T then G<S> NOT <: G<T>
        // No loop hole for generics (compare with arrays)

        //Box<Object> o1 = m1;       // No
        //o1 = (Box<Object>) m1;      // No

        // ------ Object ------------
        // Object is still super type to any type, also generic types

        Object o = m1;         // Just Object
        o = m2;
        m1 = (Box<Integer>) o;

        // ------- Equality ---------------
        /*
        if( m1 == m2){   // No

        }
        Box<Object> o2 = null;
        if( o2 == m1){    // No

        }
        */

    }

    // A generic class/type signaled by <T>, a type parameter
    class Box<T> {
        T toRemember;    // T is any reference type
    }


}
