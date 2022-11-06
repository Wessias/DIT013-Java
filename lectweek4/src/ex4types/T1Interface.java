package ex4types;

import static java.lang.System.out;

/*
    An interface introduces a reference type

    Interfaces specify operations but not implementations
    (i.e. no code to run for the operations)

 */
public class T1Interface {

    public static void main(String[] args) {
        new T1Interface().program();
    }

    // Declare interface type
    interface Sayable {
        String say();    // Define operation(s) (methods)
                         // No method body, no executable code.
    }

    void program() {
        // Have interface type, can declare variable
        Sayable any = null;       // Just a variable (no object yet)

        // Can't create interface objects no runnable code in methods
        // Would result in an useless object.
        //any = new Sayable();    // No

        /*
             VARIABLE TYPE DEFINES OPERATIONS
             -------------------------------
         */
        any.say();        // Allowed compile time (but NPE runtime right now)

        // To get something runnable, use class (object) implementing the interface
        // See below
        any = new Dog();        // This will be super = sub, more to come.

        out.println(any.say());  // Will run ok

        //any.getName();          // No, operation not declared in interface type
    }

    // ---------------- Classes -----------------------

    /*
        To get an object that runtime can execute the method
        declared in the interface, let some class implement
        interface
     */
    //  Class implements Sayable i.e. all methods in interface
    //  must be implemented in class (checked by compiler)
    class Dog implements Sayable {
        // @Override is an annotation telling the compiler that
        // we're trying to implement a method from the interface. Will
        // check that method heads are identical (else compile error)
        // Used for safety reasons, more to come.
        @Override
        public String say() {
            return "Voff";
        }  // Implemented!

        // ------ Other stuff in class ------------
        String name;
        String getName(){
            return name;
        }
    }



}















