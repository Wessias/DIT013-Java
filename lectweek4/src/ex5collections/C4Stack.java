package ex5collections;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.System.out;

/*
    Using a Stack. A data structure with Last in/First out (LIFO) behaviour
    https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
 */

public class C4Stack {

    public static void main(String[] args) {
        new C4Stack().program();
    }

    void program() {
        // Stack has a "strange" type in Java
        // Interface is Deque and implementation (class) is ArrayDeque
        Deque<Integer> stack = new ArrayDeque<>();

        out.println(stack.isEmpty());  // [ ]    (the empty stack)

        stack.push(1);                 // [ 1 ] add on top (index 0)
        out.println(stack.peek());         // Just read top
        stack.push(2);                  // [ 2, 1 ] add on top
        out.println(stack.peek());
        stack.push(3);                  // [ 3, 2, 1, ] add on top
        out.println(stack.peek());
        out.println(stack.size() == 3);   // true

        int i = stack.pop();              // [ 2, 1 ], remove 3 from top
        out.println(i == 3);
        out.println(stack.size() == 2);  // true

        stack.pop();                     // [ 1 ], remove from top
        stack.pop();                     // [ ], remove from top
        out.println(stack.isEmpty());    // true

        stack.push(99);                   // [ 99 ]
        stack.push(100);                  // [ 100, 99  ]
        stack.clear();                    // [ ]
        out.println(stack.isEmpty());     // true

        // ----- Stack with other element types -------------

        Deque<String> sStack = new ArrayDeque<>();
        Deque<Double> dStack = new ArrayDeque<>();
        Deque<Character> chStack = new ArrayDeque<>();
    }

}
