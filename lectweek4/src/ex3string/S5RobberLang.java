package ex3string;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    Working with texts, example, translate to Robber language
    See: https://en.wikipedia.org/wiki/R%C3%B6varspr%C3%A5ket

    Tests (expected results)
    out.println(toRobber("Jag talar rövarspråket")
                .equals("JoJagog totalolaror rorövovarorsospoproråkoketot"));
    out.println(toRobber("I speak robber language")
                .equals("I sospopeakok rorobobboberor lolanongoguagoge"));

 */
public class S5RobberLang {

    public static void main(String[] args) {
        new S5RobberLang().program();
    }

    Scanner sc = new Scanner(in);

    void program() {
        while (true) {
            out.print("Input som text > ");
            String line = sc.nextLine();
            if( "bye".equals(line)){
                break;
            }
            out.println("Translated to Robber language:");
            out.println(toRobber(line));
            out.println();
        }
    }

    // ---------- Methods --------------------------

    String toRobber(String text) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (isVowel(ch) || Character.isWhitespace(ch)) {
                sb.append(ch);
            } else {
                sb.append(ch).append("o").append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }

    boolean isVowel(char ch) {
        return "aeiouyåäöAEIOUYÅÄÖ".indexOf(ch) > -1;
    }
}
