package ex3string;

import static java.lang.System.out;

/*
    Character is a standard Java API. Useful when working with
    individual characters

 */
public class S1Character {

    public static void main(String[] args) {
        new S1Character().program();
    }

    void program() {
        out.println(Character.isDigit('1'));
        out.println(Character.isLetter('X'));
        out.println(Character.isLetterOrDigit('2'));
        out.println(Character.isLowerCase('c'));
        out.println(Character.isUpperCase('P'));
        out.println(Character.isWhitespace(' '));
        out.println(Character.getNumericValue('2'));
        out.println(Character.toString('Z').equals("Z"));
        // ... more ...
    }
}
