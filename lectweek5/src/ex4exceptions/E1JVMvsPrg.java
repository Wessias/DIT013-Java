package ex4exceptions;

import java.util.List;

import static java.lang.System.out;

/*

    Exceptions are used when the program is stuck and can't continue.
    Exceptions generated by JVM vs generated by program
 */
public class E1JVMvsPrg {

    public static void main(String[] args) {
        new E1JVMvsPrg().program();
    }

    void program() {

        // ---------- Java (JVM) throws exception -----------

        //out.println(1 / 0);

        // -------- Standard Java class throws exception --------------------

        List<Integer> l = List.of(1,2,3);
        //out.println(l.add(34));   // List immutable, exception

        // ------- Exception thrown by our program --------
        // Programmatic exception

        int i = 100;
        if( i > 10) {
            // Using keyword throw and create exception object
            // (program will crash)
            throw new IllegalArgumentException("That was a bad argument");
        }

    }

    // -------------- Methods ----------------

    // Shielding a method
    void doIt(int i){
        if( i <= 0 ){
            throw new IllegalArgumentException("Argument must be positive");
        }
        // Ok here, do something ...
    }

}
