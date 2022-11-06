package ex3static;

import static java.lang.System.out;

/*
    Usages of static methods from Java APIs
 */
public class S6StaticInJava {

    public static void main(String[] args) {
        new S6StaticInJava().program();
    }

    void program() {
        // Class variables from Java
        out.println(Integer.MIN_VALUE);
        out.println(Math.PI);

        // Class methods from Java
        out.println(Integer.bitCount(123));
        out.println(Character.isUpperCase('X'));

        // Math m = new Math();    // Bad! Pure static class, private constructor
        out.println(Math.sqrt(4));   // Better import static
        out.println(Math.pow(4, 2));

        Integer i = 5;
        int j = i.reverseBytes(i);   // Possible but bad (warning),... skip object!!
        j = Integer.reverseBytes(i);   // Call like this, just class name

    }



}
