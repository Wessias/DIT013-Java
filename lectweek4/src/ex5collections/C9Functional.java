package ex5collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import static java.lang.System.out;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/*
     Functional approach for Lists (ideas from functional
     programming realized in Java)

     This is general background more in later courses
 */

public class C9Functional {

    public static void main(String[] args) {
        new C9Functional().program();
    }

    void program() {

        // --------- Lambdas ---------------
        // Lambdas are anonymous (no name) methods, looking
        // like free standing functions (but are not, there are hidden objects)
        /*
            General form is:
            (params) -> { body }   // Braces only if more statements

            Some examples of lambdas

            (List list) -> list.isEmpty()
            () -> new Apple()
            (Apple a) -> { out.println(a.getWeight()); }
            (String s) -> s.length()
            (a, b) -> a * b
            (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())

        */
        // Lambdas makes it possible to handle methods/functions as data.
        // Use functions as parameters and return values, more to come (in JavaFX)

        // ----- Traversing  ----------------------

        List<Integer> list = List.of(1, 2, 3, 4, 5);

        list.forEach(e -> out.print(e));  // Use function as parameter
        out.println();

        // ---- Filtering  --------------

        list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        list.removeIf(e -> e >= 4);     // Use lambda as parameter
        out.println(list);

        // More advanced filtering
        List<String> slist = List.of("John", "Eva", "Johnny", "Alex");
        List<String> startsWithJ = slist.stream()
                .filter((str) -> str.startsWith("J"))
                .collect(toList());
        out.println(startsWithJ);

        // ------------ List Comprehension --------------

        List<Integer> ns = range(0, 30)
                .filter(x -> x * x > 3)
                .map(x -> x * 2)
                .boxed()            // Boxing int to Integer
                .collect(toList());
        out.println(ns);

        out.println(pyhagoreanTriplets(20));


    }

    List<List<Integer>> pyhagoreanTriplets(int n) {
        return range(1, n).mapToObj(x -> range(x, n)
                .mapToObj(y -> range(y, n)
                        .mapToObj(z -> new Integer[]{x, y, z})))
                .flatMap(identity())   // List of list to List
                .flatMap(identity())
                .filter(a -> a[0] * a[0] + a[1] * a[1] == a[2] * a[2])
                .map(Arrays::asList)
                .collect(toList());
    }


}
