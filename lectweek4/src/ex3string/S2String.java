package ex3string;

import static java.lang.System.out;

/*
    String is a Java standard API for working  with texts.

    NOTE: Strings are immutable (i.e. can't modify, must/will create new object
    and copy chars)

 */
public class S2String {

    public static void main(java.lang.String[] args) {
        new S2String().program();
    }

    void program() {
        String str = "abcdef";               // Will create an immutable String object
        //String str = new String("abcdef"); // This is bad will create unnecessary extra objects

        // Compare strings
        out.println(str.equals("abcdef"));   // String is a reference type
        out.println("qwerty".equals(str));   // String literals are objects, have methods

        // Inspecting a string
        out.println(str.isEmpty());
        out.println(str.length());
        out.println(str.charAt(3));
        out.println(str.charAt(str.length() - 1));  // Last char!

        // Search inside a string
        str = "abcdefabcdef";
        out.println(str.indexOf('a') == 0);
        out.println(str.indexOf('X') == -1);     // Not found -1
        out.println(str.indexOf("fab") == 5);    // Matches String
        out.println(str.contains("cd"));
        out.println(str.startsWith("abc"));
        out.println(str.endsWith("def"));
        out.println(str.lastIndexOf("a") == 6);

        // Manipulate Strings (will create new Strings)
        str = "Success consists of going from failure" +
                " to failure without loss of enthusiasm";
        out.println(str.toLowerCase());
        out.println(str.toUpperCase());
        out.println("   abcde    ".trim().equals("abcde"));  // Remove leading/ending space
        out.println(str.replace("failure", "icecream"));
        out.println(str.replaceFirst("failure", "icecream"));
        out.println("abcdefaböab".replaceAll("ab", "X"));

        // Split sentence into words
        String[] strs = str.split(" "); // " " is a char-pattern. Split will happen at pattern
        for( String s : strs){
            out.println(s);
        }

        // --------- Comparisons ------------
        // Compare in lexicographic ordering i.e. compare
        // each character from left using the alphabet ordering

        out.println("abc".compareTo("bcd"));   // abc before bcd = -1
        out.println("abc".compareTo("abc"));   // equals = 0
        out.println("bcd".compareTo("abc"));   // bcd after = 1
        out.println("ab".compareTo("abc"));    // shorter before = -1

        // -------- Pitfalls  -------------------
        // Many operations create new objects

        out.println(str.substring(0, 4));  // Char's 0-3
        out.println(str);                 //  Original not changed!!!

        String subs = str.substring(0, 4);  // Must store the new (sub) string
        out.println(subs);
        out.println(!subs.equals(str));
    }
}
