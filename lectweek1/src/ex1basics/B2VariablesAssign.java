package ex1basics;


import static java.lang.System.out;

/*
   Variables and assignment

   All values in Java belongs to some set. In programming (Java) a set is
   called a type. The primitive (built in, predefined) types in Java are
   - int, the (finite) set of integers
   - double, the (finite) set of real numbers.
   - boolean, the set of truth values
   - char, the set of a single characters
   - and a few more (we don't need)

   String (a text) is *NOT* a primitive type (more to come)!

   A literal is a fixed value in the code, like 6.7, 'S' or 396 (light blue in IntelliJ)
   A literal never changes. A literal represents a value so it must belong
   to some type. Literals are automatically assigned types
   - 45 will be an int
   - 3.6 will be an double. Note decimal separator is '.' (dot)
   - false will be a boolean
   - 'X' will be a single char (single quotes)
   - "Hello" will be a String (double quotes). Zero or more characters.

 */
public class B2VariablesAssign {

    public static void main(String[] args) {
        new B2VariablesAssign().program();
    }

    void program() {

        // ----------- Variables ----------------
        /*
            A variable in Java is a alterable container for a value.
            So a variable represents a value (except when on left side of assignment, see below)
            i.e. the variable must have a type.
            To be able to use a variable it must be declared
         */
        int a;   // A variable declaration. State type and name.
        /*
           It's possible (sometimes mandatory) at the declaration to
           give the variable a start value i.e to initialize the variable.
           Initialization is done using the = operator (assignment operator)
         */
        int b = 3;        // Declare and initialize, value must be compatible with variable type.

        // ------------- Assignment ---------------------------
        /*
            To change the value of of a variable we use = ,the assignment
            operator again. First the right side of = is evaluated, then the
            value is copied to the left side (which should be a variable)

            *** Read assignments right to left! ***
        */
        a = 14;          // Copy 14 to a (previously declared) variable
        out.println(a);
        a = b;          // Copy value of b to a, old value of a gone!
        out.println(a);

        a = 2 * b + 10;  // Right side calculated, then value copied to a
        out.println(a);
        a = a + 1;       // Read value of a, add 1, and copy back to a
        out.println(a);

        // To swap the values of two variables we must use one extra variable
        // Else one value will be lost (overwritten)
        int tmp;         // The extra temporarily variable
        tmp = a;         // Store value in a
        a = b;           // Overwrite value in a
        b = tmp;         // Overwrite value in b with stored a-value


        // -- Other types of variable declarations  -----------------------------

        // All uninitialized
        int i;
        boolean b1;
        double d;
        char ch;

        // --------- final variables ---------------

        // Can't change final variables
        final int n = 12;
        //n = 4;              // No, compile error already assigned once

        // ------- Pitfalls --------------------------------------
        // Variables and values must be "compatible" at assignment
        // initialization and assignment, more to come.

        //int j = 2.4;   // Bad initialization not an int.
        i = 1;         // Ok
        //i = 1.0;     // 1.0 is not an integer value
        b1 = false;
        //b1 = 0;      // 0 is not a boolean value
        d = 1.0;
        d = 1;         // Ok! 1 converted to 1.0 then copied to d, more to come
        ch = 'X';
        ch = 97;       // 97 will be interpreted as a character code for 'a'
        out.print(ch);

    }
}

