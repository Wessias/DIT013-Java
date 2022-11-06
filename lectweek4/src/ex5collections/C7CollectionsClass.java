package ex5collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

/*
    Standard Java class Collections. Very handy methods.
    Normally not allowed on exam.

 */
public class C7CollectionsClass {

    public static void main(String[] args) {
        new C7CollectionsClass().program();
    }

    void program() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> dest = new ArrayList<>();

        // ------- Many useful methods ---------------
        // As usual: How do the methods really work?

        out.println(Collections.max(list));
        out.println( Collections.frequency(list, 1));
        Collections.copy(dest, list);
        out.println(Collections.disjoint(dest, list));
        Collections.replaceAll(list, 2, 99);
        Collections.shuffle(list);
        Collections.sort(list);


        // Etc.

    }


}
