package ex3supersub;

import java.util.Random;

/*
    Super/sub types for parameters and return types of methods

    Very similar to variables (assignment of arguments to parameters)

 */
public class SS7ParamsReturn {

    public static void main(String[] arg) {
        new SS7ParamsReturn().program();
    }

    final Random rand = new Random();

    void program() {
       /*
            SUPER/SUB FOR PARAMETERS AND RETURN TYPES
            ------------------------------
            For incoming data to a method the following must hold:

            Argument value type <: Parameter type

            For out going data the

            Return value type <: Declared return type

         */
        // -------- Parameters ---------

        doIt1(1);                 // Ok!  int <: double
        //doIt2(1.0);                // Bad  double NOT <: int
        //doIt3(WorkingDay.WED);     // No, super/sub
        doIt4(WorkingDay.WED);       // Ok!  WorkingDay <: Object
        doIt4(new Dog());            // OK!  Dog <: Object
        //doIt5(new int[3]);         // No super/sub
        //doIt5(new Double[3]);      // No super/sub

        // ------- Return values see methods below --------
    }

    // ---------------- Parameters -----------------------

    void doIt1(double d) {
    }

    void doIt2(int i) {
    }

    void doIt3(WeekDay wd) {
    }

    void doIt4(Object o) {
        // Can only do operations defined on Object
        //o.FRI;     // NO!
    }

    void doIt5(double[] arr) {
    }

    // -----------  Return values --------
    /*
    int doIt6(){
        return 1.0;   // No double NOT <: int
    }*/
    double doIt7() {
        return 1;      // Ok. int <: double
    }

    /*
    Double doIt8(){
        return 1;      // No, will box to Integer NOT <: Double
    }
    Player doIt9(){
        return new Dog();    // No super/sub
    }
    */

    /*
          COMPILER CAN'T SEE VALUES
          ----------------------------
          Values are runtime!
    */
    // What is the value (object references) of o?? Don't know, but type ok
    Object o = doIt10();

    Object doIt10() {
        if (rand.nextBoolean()) {
            return new Dog();     // Sub of return type
        } else {
            return new Player();  // Sub of return type
        }
    }

    // ------------------- Types ----------------------------

    class Player {
        String name;
        int age;
    }

    class Dog {
        String name;   // Same content as Player but not same type
        int age;
    }

    enum WorkingDay {
        MON, TUE, WED, THU, FRI;   // Same values ...
    }

    enum WeekDay {
        MON, TUE, WED, THU, FRI;  // .. as here, but not same type.
    }

}
