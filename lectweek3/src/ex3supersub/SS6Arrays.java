package ex3supersub;

/*
      Subtyping primitive and reference type arrays
 */
public class SS6Arrays {

    public static void main(String[] arg) {
        new SS6Arrays().program();
    }

    void program() {

        //  ----- Primitive arrays ------------------------

        int[] ia = {1, 2, 3};
        double[] da = {1, 2.0, 3.0};  // NOTE: Conversion of 1 -> 1.0

        // Replace on any side, try to cast
        //da = ia;               // No
        //ia = da;               // No
        //ia = (int[]) da;       // No
        //da = (double[]) ia;    // No

        /*
            THE SUPER/SUB RELATION FOR PRIMITIVE ARRAY TYPES
            ---------------------------------
            No super sub relation

            NOTE:
            int value <: double value
            int var NOT <: double var
            int[] NOT <: double[]      (as variables)
        */


        // ---- Reference type arrays  ---------------------

        Integer[] iia = {1, 2, 3};
        Double[] dda = {1.0, 2.0, 3.0};

        // No super/sub for reference type arrays
        //iia = dda;
        //dda = iia;
        //iia = (Integer[]) dda;
        //dda = (Double[]) iia;
        /*
            BUT!!!!!!
            ---------
            If element types are reference types and has super sub
            then array types are super sub!  I.e. for reference types S and T:

            if S <: T then S[] <: T[]

         */
        // Integer <: Object and Double <: Object then
        // Integer[] <: Object[] and Double[] <: Object[] (in Java) !!!
        Object[] os;
        os = iia;              // super = sub
        iia = (Integer[]) os;  // sub = (sub) super

        /*
            THE ARRAY LOOP HOLE
            -------------------
            Allowing reference types arrays to be super sub creates
            a hole in the type system: An expression that compiles (without
            any cast) may lead to a runtime type error!!!
         */
        os = iia;        // Ok!
        os[0] = 4;       // Ok!
        os[1] = 4.5;     // Will compile, but runtime exception, the loop hole!

        /*
            RUNTIME CHECKS OF INSERTION INTO ARRAY
            --------------------------------------
            Because of the loop hole there is a runtime check for insertion
            of values into arrays (a cost). If trying to insert non sub type
            values an ArrayStoreException will occur
         */

         // ---------- Equality -----------

        /*
        if( da == ia ){ // No super/sub

        }

        if( iia == dda ) {   // No super/sub

        }
        */
        if( os == iia){   // Super/sub, ok

        }

        // ---- Pitfalls  -----------------

        // Boxing at initialization
        Integer[] ia1 = {1, 2, 3};     // Boxing
        Integer[] ia2 = {1, 2, null};  // Boxing. Compiles but bad!
        //out.println(ia2[0] + ia2[2]);  // NPE!

        //Integer[] ia3 = {1, 2.0, 3};  // Bad
        //Double[] ia4 = {1, 2.0, 3};   // Bad 1 boxed to Integer (not 1 -> 1.0)
        //Integer[] ia4 = new int[4];  // No super sub

    }

}
