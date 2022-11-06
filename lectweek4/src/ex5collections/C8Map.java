package ex5collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/*
    Map is a mapping between a key and a value. Used to look up values given a key
    This is supplementary, covered in later courses

 */
public class C8Map {

    public static void main(String[] args) {
        new C8Map().program();
    }

    private void program() {
        // Map is the interface and HashMap is an implementation
        Map<Integer, String> literalNameSV = new HashMap<>();

        // Store key (int) and value (String)
        literalNameSV.put(1, "Ett");
        literalNameSV.put(2, "Två");
        literalNameSV.put(3, "Tre");

        // Retrieve value using key
        out.println(literalNameSV.get(1));
        out.println(literalNameSV.get(3));

        // Access all key's or all values
        Collection<Integer> keys = literalNameSV.keySet();
        Collection<String> values = literalNameSV.values();

        // Possible to traverse
        for(Map.Entry<Integer, String> e : literalNameSV.entrySet()){
            out.println(e.getKey() + "  " + e.getValue());
        }

        // ------ Other Map's  ---------------
        Map<String, Integer> m1;
        Map<String, Animal> m2;
        Map<String, List<String>> m3;


    }

    class Animal {
        // ...
    }

}
