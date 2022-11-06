package ex1classes.c2person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/*
    Testing the Person class (class not declared here, but possible to create object here, class
    is public)
 */
public class TestPerson {

    public static void main(String[] args) {
        new TestPerson().program();
    }

    void program() {

        // Possible to access class Person in file Person.java (because a public class)
        // Test different constructors
        Person p1 = new Person("Fia", 24, 12000);
        Person p2 = new Person("Sven");

        //out.println(p1.name);        // No, can't access directly, private
        //out.println(p1.age);         // No, private

        out.println(p1.getName());     // Must use setter/getter to access, but ...
        out.println(p1.getAge());

        p2.setAge(76);

        // ... better let object do the work!
        out.println(p1.isRetired(65));
        out.println(p2.isRetired(65));

        // Override toString
        out.println(p1);
        Object o = p1;
        out.println(o);   // NOTE: Method in Person executed!

        // Override equals
        out.println(p1.equals(p2));

        // Add Fia and Sven to list
        List<Person> persons = List.of(p1, p2);
        out.println(persons.contains(p1));         // p1 found (identity)

        // To be found by value in collections
        // must implement own equals hashCode
        Person p3 = new Person("Fia", 24, 12000); // Another object with same data
        out.println(persons.contains(p3));    // True
        out.println(persons.indexOf(p3) );

        Map<Person, String> map = new HashMap<>();
        map.put(p3, "Soliciter");
        out.println(map.get(p3));   // Must have hashCode method to be able to find


    }


}
