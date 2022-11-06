package ex3static.s4init;

import static java.lang.System.out;

/*
     Demo class
 */
class B {

    private static B b = new B();     // Called at class load time (only)

    B() {
        out.println("Instantiating B");
    }
}
