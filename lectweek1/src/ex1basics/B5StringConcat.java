package ex1basics;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*

        String and the + operator (string concatenation)

        A String is a sequence of characters enclosed in double quotes
 */
public class B5StringConcat {

    public static void main(String[] args) {
        new B5StringConcat().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {

        String str = "Please input two values (space separated) > ";
        out.println(str);
        int i = sc.nextInt();
        int j = sc.nextInt();
        /*
            + used with at least one String-operand
            is concatenation (merging strings).
            I.e. + has different meaning depending on
            type of operands (= overloaded operator).
            + is addition *OR* concatenation!
            + is the only overloaded operator in Java
         */
        out.println("Value was " + i + " and " + j);  // Concatenation
        out.println(i + j + " was the values");       // This is very different!
    }
}
