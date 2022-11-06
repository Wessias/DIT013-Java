package ex3supersub;

/*

   Super/sub relation for enums and wrapper types

 */
public class SS4EnumWrapper {

    public static void main(String[] arg) {
        new SS4EnumWrapper().program();
    }

    void program() {

        // ---------- enum ---------------------------

        // Compiles
        WorkingDay workingDay = WorkingDay.FRI;

        // Replace right, NO
        //workingDay = WeekDay.FRI;

        // Replace left, NO
        //WeekDay weekDay = WorkingDay.FRI;

        // Casting, NO
        //WeekDay weekDay = (WeekDay) WorkingDay.FRI;

        /*
            THE SUPER/SUB RELATION FOR ENUM TYPES
            ---------------------------------
            No super sub relation (same as classes, enums are class types)
        */


        // ------ Wrapper types ---------------

        Double d = 4.0;
        Integer i = 4;

        // Replace on any side, try to cast
        //d = i;               // No
        //i = d;               // No
        //i = (Integer) d;     // No
        //d = (Double) i;      // No

        /*
            THE SUPER/SUB RELATION FOR WRAPPER TYPES
            ---------------------------------
            No super sub relation (same as classes)

            NOTE:
            int value <: double value
            Integer value NOT <: Double value
        */

        // ----------- Pitfalls -------------------

        //d = 4;    // Will box 4 to Integer (not to 4.0 and then box)
        //i = 4.0;  // Will box 4.0 to Double then try to assign but no super/sub

         // ---------- Equality -----------

        /*if( d == i ) {   // No super/sub

        }*/

    }

    // ----------- Types ----------------

    enum WorkingDay {
        MON, TUE, WED, THU, FRI;   // Same values ...
    }

    enum WeekDay {
        MON, TUE, WED, THU, FRI;  // .. as here, but not same type.
    }


}
