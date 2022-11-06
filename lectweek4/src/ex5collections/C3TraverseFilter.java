package ex5collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;

/*
    Traversing and Filtering (find element and possibly do something with it)
 */

public class C3TraverseFilter {

    public static void main(String[] args) {
        new C3TraverseFilter().program();
    }

    void program() {

        // ----- Traversing  ----------------------

        List<Integer> list = List.of(1, 2, 3, 4, 5);  // Create unmodifiable

        for (Integer i : list) {   // Use short for-loop ...
            out.print(i);
        }

        for (int i = 0; i < list.size(); i++) {   // ... or normal for loop
            out.print(list.get(i));
        }

        // ---- Filtering  --------------

        list = new ArrayList<>(List.of(1, 2, 3, 4, 5));  // Another list, make it modifiable, clumsy

        // Simple and safe way to remove elements ---------------------
        List<Integer> toRemove = new ArrayList<>();  // Temp list
        for (Integer i : list) {
            if (i >= 3) {
                toRemove.add(i);   // Collect all to remove
            }
        }
        list.removeAll(toRemove);  // Finally remove all
        out.println(list);

        // Bad using short for-loop -----------------------------------
        /*for( Integer i : list){   // Can't remove in short for loop
            if( i >= 3){
                list.remove(i);       // ConcurrentModificationException
            }
        }*/

        // Bad using indexed for loop ---------------------------------
        /*
        list = new ArrayList<>(List.of(1, 2, 3, 4, 5));  // Yet another list
        for (int i = 0; i < list.size(); i++) {          // BAD!
            // Uncomment and inspect, will skip one
            if (list.get(i) == 2 || list.get(i) == 3) {
                list.remove(i);
            }
        }
        out.println(list);
        */
    }
}
