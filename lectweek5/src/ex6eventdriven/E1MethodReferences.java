package ex6eventdriven;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static java.lang.System.out;

/*
     Method references possible in Java.
     Used for callbacks, i.e. parameter is a method (like lambdas),
     The parameter (method) later called back from actual method
     (normally some time later)

     This is just background, we use in event driven programs (JavaFX)
     But in the labs everything is already implemented.
 */

public class E1MethodReferences {

    public static void main(String[] args) {
        new E1MethodReferences().program();
    }

    void program() {
        doIt(this::sayIt);  // method reference as parameter
    }

    //  -------------- Methods  -----------------------------

    void sayIt(String msg) {
        out.println("Got a callback ...");
        out.println(msg);
    }

    // Param type Consumer<String> is type for a
    // void method with single String param
    void doIt(Consumer<String> callBack) {
        int secondsToSleep = 3;
        try {
            // Delay program using Thread class
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        // Call back to sayIt()
        // Method accept defined in type Consumer.
        callBack.accept("Message from do it");
    }

}
