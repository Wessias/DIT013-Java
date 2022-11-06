package ex1enumwrapper;

/*
     Motivation for enumeration types (upcoming)

     Suppose working with small sets of data
     How to represent that data?
 */
public class EW1MotivationEnum {

    public static void main(String[] arg) {
        new EW1MotivationEnum().program();
    }

    void program() {
        /*
             Program needs days, should we use Strings to represent days?
         */
        final String mon = "monday";    // Like this ...
        final String tue = "tuesday";
        final String wed = "wednesday";
        // etc...

        // ... problem using strings. Compiler can't catch misspellings
        String weekday = " monday";   // Leading space!
        if( weekday.equals(mon)) {    // Fail ...
            // ...
        }

        /*
            Program needs directions, should we use int's to represent?
         */
        final int north = 0;
        final int east = 1;
        final int south = 2;
        final int west = 3;

        // ... problems! Compiler can't catch bad values.
        // Remember compiler sees no values (types are ok)!
         int direction = east + 3;  // Try to turn, but fails
         if( direction == north){   // Always false...
             // ...
         }

         // SUMMARY: Using numbers or strings not (type) safe.

    }


}
