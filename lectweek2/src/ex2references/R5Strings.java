package ex2references;


import static java.lang.System.out;

/*

    Strings are objects, also handled as references.

 */
public class R5Strings {

    public static void main(String[] arg) {
        new R5Strings().program();
    }

    void program() {

        // -------- Strings -------------------

        String s1 = "Hello ";
        String s2 = "world";

        // ----- Assignment and equality --------------

        // Applying + operator. New String object created and
        // char's copied from s1, s2 to s3! The value of s1 + s2 is reference
        // to a new object.
        String s3 = s1 + s2;
        s1 = "zzz";
        s2 = "zzz";
        out.println(s3);  // s3 not affected if changing s1 and s2;


        // Below should be false **but** Java optimizes
        // Using the same object for any same string
        // literal (string objects can't be changed so no problem)
        out.println(s1 == s2);

        // Avoid optimization (bad, just used for demonstration)
        out.println(s1 == new String(s2));      // Still same characters, but false.
        out.println(s1.equals(new String(s2))); // True, compare content in object
    }

}
