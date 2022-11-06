package ex3string;

import static java.lang.System.out;

/*
    Working with texts, some examples using Character, String and StringBuilder
 */
public class S4WorkWithText {

    public static void main(String[] args) {
        new S4WorkWithText().program();
    }

    void program() {

        String str = "abc 123 _.! ABC";

        // -- Remove all white space in str -------------------
        // Possible to use ordinary for-loop but short often suffices.

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {      // Traverse
            if (!Character.isWhitespace(ch)) {
                sb.append(ch);
            }
        }
        out.println(sb.toString());

        // ------- Change all lowercase chars to upper ---------

        sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(ch);
            }
        }
        out.println(sb.toString());

        // ---------- Split into words --------------------------
        // split method uses "regular expressions" (string patterns) to
        // find where to split, more in later courses.

        String quote = "Before you judge a man, walk a mile in his shoes. " +
                "After that who cares?... " +
                "He’s a mile away and you’ve got his shoes";

        // Split into words (Strings)
        String[] strs = quote.split(" ");  // " " regex is a pattern that matches exact one space.
        for (String word : strs) {
            out.println(word);
        }

    }
}
