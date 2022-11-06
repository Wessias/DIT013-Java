package ex5collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

/*
    Q: Why declare variables/parameters as interface types?
    A: Gives flexibility, may change implementation (class) without affecting
    rest of program (no need to change in code).
 */

public class C2WhyDeclare {

    public static void main(String[] args) {
        new C2WhyDeclare().program();
    }

    void program() {
        // -------- Bad style ----------------------
        ArrayList<Integer> al =  new ArrayList<>();   // Bad restriction of variable type
        LinkedList<Integer> ll =  new LinkedList<>(); // Bad restriction of variable type

        doIt(al);       // Can only handle specific type
        //doIt(ll);
        //doOther(al);
        doOther(ll);

        doYetOther(al);  // Can handle any type that implements List, fair
        doYetOther(ll);

        // ---------- Good style -----------------------

        // Interface type for variable
        List<Integer> l1 = new ArrayList<>();    // Change this line to change to switch to other list
        doYetOther(l1);  // As above ...

        // Assume we changed out mind, better use a LinkedList
        l1 = new LinkedList<>();

        doYetOther(l1);   // No change in program (except one row)
    }

    void doIt(ArrayList<Integer> list) {   // Bad restriction of parameter type
        // Works only for ArrayList
        out.println(list.isEmpty());
    }

    void doOther(LinkedList<Integer> list) {   // Bad restriction of parameter type
        // Works only for LinkedList
        out.println(list.isEmpty());
    }

    void doYetOther(List<Integer> list) {    // Good parameter, handle any implementation of List
        // Works for any of
        out.println(list.isEmpty());
    }

}
