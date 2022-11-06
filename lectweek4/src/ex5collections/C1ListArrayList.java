package ex5collections;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/*

    Lists are like "smart" array objects, many useful operations provided.

    Lists are part of the common Java Collection Framework (many kinds of list etc.)
    see ex5collections.pdf

 */

public class C1ListArrayList {

    public static void main(String[] args) {
        new C1ListArrayList().program();
    }

    void program() {
        // Below we use a variable of an interface type (List) and an
        // object of implementing type (ArrayList). We always adhere to this!
        List<Integer> list = new ArrayList<>();

        // Here, the list exits but no positions or elements
        //out.println(list.get(0));     // IndexOutOfBondsException

        // Start adding elements (and thus creating positions)
        list.add(111);                // Add last in list
        list.add(0, 222);   // Ok, first moved right
        //list.set(13,111);              // Can't set arbitrary index

        // Quick way to get a list with positions and elements
        // Drawback: fixed size (see below how to make modifiable)
        list = List.of(1, 2, 3, 4, 5);

        // --------- All collections have toString-method -------

        out.println(list);  // Implicit call to toString

        // ------- Inspecting a list -------------

        out.println(list.isEmpty());
        out.println(list.size());
        out.println(list.indexOf(3));
        out.println(list.lastIndexOf(3));
        out.println(list.indexOf(list.size() - 1));  // Last element.

        // --------- Search -------------------------

        out.println(list.contains(4));
        out.println(list.indexOf(4));

        // ----------- Manipulate ---------------------

        list = new ArrayList<>(list);  // Make list non-fixed size

        list.add(300);                // Add last in list, size = size + 1
        list.add(0, 100);// Values moved to right, index change, size change
        list.set(1, 200);             // Will overwrite, no index change, no size change
        list.addAll(List.of(66, 77, 88)); // Add last in list
        out.println(list);

        list.remove(0);    // Remove using index, return value see below
        Integer n = 5;
        list.remove(n);         // Remove using object, return value see below
        out.println(list);
        list.clear();           // Remove everything

        // -------  Strange (AVOID)  --------
        // Allowed probably for some good reason but
        // should really avoid (let method check)

        Integer i = null;
        list.add(i);         // Comment / uncomment
        int m = list.size();
        m = list.indexOf(i);      // Ok
        boolean b = list.contains(i); // Ok
        list.add(999);
        m = list.size();

        // -------  Pitfalls --------

        list = new ArrayList<>(List.of(1, 2, 3, 4, 5));  // Another list

        // This is hazardous, sublist just a view of original!
        List<Integer> sub = list.subList(1, 3);
        out.println(sub);
        list.add(999);      // Modify original ...
        //out.println(sub);  // ... will raise ConcurrentModificationException

        // -------- Return values -----------------

        list = new ArrayList<>(List.of(1, 2, 3, 4, 5));  // Another list

        if (list.add(6)) {        // Boolean return value used to signal outcome
            out.println("success");
        } else {
            out.println("fail");
        }

        i = list.remove(0);  // Return value is removed object
        if( i == null){
            // ....
        }

        if (list.remove(i)) {        // Boolean return value used to signal outcome
            out.println("success");
        } else {
            out.println("fail");
        }

        // ----- Lists with other element types ---------

        List<String> sList = new ArrayList<>();
        List<Double> dList = new ArrayList<>();
        List<Character> chList = new ArrayList<>();
    }


}
