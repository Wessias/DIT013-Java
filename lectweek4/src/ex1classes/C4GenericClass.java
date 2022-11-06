package ex1classes;

/*
    Have seen generic methods, also possible with generic classes
    (may have instance variables of any reference type)

    This is a big topic, just for general background here

 */
public class C4GenericClass {

    public static void main(String[] args) {
        new C4GenericClass().program();
    }

    void program() {

        // ----- Use generic type (generic class) -------------------

        Box<Integer> m1 = new Box<>();  // Same as: new Box<Integer>() (inferred by compiler)
        m1.toRemember = 4;
        //m1.toRemember = "Hej";   // Wrong type

        Box<String> m2 = new Box<>();
        m2.toRemember = "Abraxas";
        //m2.toRemember = 56;      // Wrong type

    }

    // A generic class/type signaled by <T>, a type parameter
    class Box<T> {
        T toRemember;    // T is any reference type
    }


}
