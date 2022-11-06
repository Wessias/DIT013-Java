package ex3string;

import static java.lang.System.out;

/*
    A StringBuilder will not create new objects and copying characters when
    manipulating texts (contrary to String with +-operator)

    Use a StringBuilder for mutable texts (avoid new objects and copying char's)

 */
public class S3StringBuilder {

    public static void main(String[] args) {
        new S3StringBuilder().program();
    }

    void program() {

        // Create a StringBuilder
        StringBuilder sb = new StringBuilder();

        // Add at end of text, no new objects!
        sb.append('a').append('b').append('c');  // StringBuilder using chained calls

        // Convert to String
        String s = sb.toString();
        out.println(s);

        out.println(generateLongString('X', 500));

        // ------ Clear (empty it) ----------
        // Like below or just create a new fresh StringBuilder

        sb.setLength(0);

        // ------- Pitfalls --------------

        StringBuilder sb1 = new StringBuilder("Hello World !");
        StringBuilder sb2 = new StringBuilder("Hello World !");

        out.println(sb1 == sb2);
        out.println(sb1.equals(sb2));   // Possible surprise..(false)!?

    }

    // ------------ Methods ----------------------

    // In method we use a StringBuilder to add chars to a text.
    String generateLongString(char c, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(c);   // Much more efficient, no copying, just add last.
        }
        return sb.toString();
    }

    /*
      This would have been bad
      String s = "";
      for( .... ){
         s = s + ch;    // BAD! New string created then copy all chars in each iteration!
      }

    */

}
