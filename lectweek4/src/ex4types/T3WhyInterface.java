package ex4types;

import static java.lang.System.out;

/*
    One motivation for interfaces.

    Interfaces makes it possible to handle objects of different
    types in a uniform way (by focusing on only one aspect,
    the interface operations)

 */
public class T3WhyInterface {


    public static void main(String[] args) {
        new T3WhyInterface().program();
    }

    void program() {

        Dog d = new Dog();
        Cat c = new Cat();
        Pig p = new Pig();

        /*
            Would like to have *one* method able to handle
            any object that can say something
         */
        doSay(c);
        //doSay(c);
        //doSay(p);     // No!
    }

    // Works only for dogs
    /*void doSay(Dog d) {
        out.println(d.say());
    }*/

    // Try a generic method but ...
    /*<T> void doSay( T t ){
        out.println(t.say());  // ... can't guarantee say() method for typ T
    }*/

    // Use Object as param type ...
    /*void doSay(Object o){
        // No say method for type Object
    }*/


    // This works for all because all implements Sayable
    // Abstraction: Don't care what it is, just that it can say()
    void doSay(Sayable s) {
        out.println(s.say());
        // s.age++;  // Can't do ..
    }

    // ----  Interface -----------------------------

    interface Sayable {
        String say();
    }

    // ------- Classes -------------

    class Cat implements Sayable {
        @Override
        public String say() {
            return "Mjau";
        }
    }

    class Dog implements Sayable {
        int age;
        @Override
        public String say() {
            return "Voff";
        }
    }

    class Pig{
    }

}















