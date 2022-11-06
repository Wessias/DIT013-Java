package ex3static.s4init;

import static java.lang.System.out;

/*
     Demo class
 */
public class A {

    private A a = new A();   // Called at every instantiation

    A() {
        out.println("Instantiating A");
    }


}
