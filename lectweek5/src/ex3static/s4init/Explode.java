package ex3static.s4init;

/*
     Static initialization is at class load time!! Done once!
 */
public class Explode {

    public static void main(String[] args) {
        new Explode().program();
    }

    void program() {
        /*
               Initialization when?
               --------------------
               static variables at class load time
               instance variables at object creation

         */

        // Uncomment and run each row in turn
        // A a = new A();   // Explodes
        B b = new B();   // Ok!
    }
}

