package ex3static;

import static java.lang.System.out;

/*
    Any Java program must have exactly one main method
    The program starts in the main method!

    Name of class with main method must be supplied when starting the virtual machine (JVM)
 */
public class S8MainMethod {

    // The main method is static because
    // this is the absolutely first code to execute
    // (so have no objects yet, must use a class method)
    // Method called when class loaded. Arguments supplied by
    // the operating system (from command line) OR
    // added in IntelliJ config (Edit configurations)
    public static void main(String[] args) {
        out.println("In IntelliJ arguments to program " +
                "added at Edit Configurations... > Program Arguments");
        out.println(args.length);
        for (int i = 0; i < args.length; i++) {
            out.println(args[i]);
        }
        //doIt();   // Can't call instance method from static

        // But if creating an object it's ok (the trick we have been using)
        new S8MainMethod().program();
    }


    void program(){
        // ... "The template for beginners" - hack
    }
}
