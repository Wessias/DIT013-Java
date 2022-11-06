package ex5collections;

import java.util.ArrayList;
import java.util.List;

/*
    Collections and types

    Remember: S <: T then  C<S> NOT <: C<T> (generic classes no super/sub)
 */
public class C6CollectionsTypes {

    public static void main(String[] args) {
        new C6CollectionsTypes().program();
    }

    void program() {

        // --------- Super sub for Collections -----------
        //(as generic types, no super/sub)

        List<Sayable> ss = new ArrayList<>();
        List<Dog> ds = new ArrayList<>();
        List<Cat> cs = new ArrayList<>();
        //ds = cs;     // No
        //ss = ds;     // No

        // --- Collection and Elements ----------------------

        ds.add(new Dog());
        // ds.add(new Cat());   // Not sub
        //ds.add(new Pig());    // Not sub
        Dog d = ds.remove(0);
        //d = cs.remove(0);     // Not super

        ss.add(new Dog());
        ss.add(new Cat());      // This will be a heterogeneous collection
        //ss.add(new Pig());    // Not sub

        Sayable s = ss.remove(0);    // Always ok
        d = (Dog) ss.remove(0);      // Possible
        Cat c = (Cat) ss.remove(0);  // Possible
        Pig p = (Pig) ss.remove(0);  // Cast to interface always allowed! Exception

        // ---------- Object (and more) --------------

        List<Object> os = new ArrayList<>();
        os.addAll(ss);
        //ss.addAll(os);

        List<Jumpable> js = new ArrayList<>();
        //js.addAll(ss);
        //ss.addAll(js);
        os.addAll(js);
        //js.addAll(os);
    }
    // ----  Interfaces -----------------------------

    interface Sayable {
        String say();
    }

    interface Jumpable {       // Other interface
        void jump();
    }

    // ------- Classes, all implements Sayable -------------

    class Cat implements Sayable {

        public String say() {
            return "Mjau";
        }
    }

    class Dog implements Sayable {

        public String say() {
            return "Voff";
        }
    }

    class Pig implements Jumpable {
        int y;

        public void jump() {
            y = 100;
        }
    }


}
