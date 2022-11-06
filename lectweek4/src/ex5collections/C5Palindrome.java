package ex5collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    Application of Stack (there are shorter/better solutions to this)

    Check if a sentence (word) is a palindrome.
    https://en.wikipedia.org/wiki/Palindrome
 */
public class C5Palindrome {

    public static void main(String[] args) {
        new C5Palindrome().program();
    }

    Scanner sc = new Scanner(in);

    void program() {
        String[] strings = {"- Sirap i paris", "- Madam I'm Adam",
                "- Was It A Rat I Saw?", "- Can a get a hot dog?"};
        out.println("Some strings");
        for (String s : strings) {
            out.println(s + " ");
        }
        while (true) {
            out.print("Input a string (possibly any of the above) > ");
            String s = sc.nextLine();
            out.println(s + " is a palindrome: " + isPalindrome(s));
            out.println();
        }
    }

    // --------- Methods -------------------

    boolean isPalindrome(String str) {
        String tmp = removeNonLetters(str.toLowerCase());
        String rev = reverse(tmp);
        return rev.equals(tmp);
    }

    String removeNonLetters(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    String reverse(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    // ------ Cooler version ------------
    String reverse2(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
