package ex5classes;

import static java.lang.System.out;

/*
    To package data of *possibly different* types we use class objects
    (remember: arrays may only use same type of data). The data should in some
    sense "belong together". I.e. a class objects is a package of variables of
    describing some concept (a car, a dog, a hero, ... any noun ...)

    To create class objects we first must declare a class describing the variables packaged (the
    instance variables). I.e. a class is a blue print of the objects to be created.

    The class describes all objects i.e. the class describes a set of objects
    i.e. a class introduces a **new type** (remember a set is a type in programming)!
    When declaring a class we also automatically define a new type (so we can declare a variable
    for a class object, remember, must specify type at variable declaration).

    When the class is declared we may create objects (= instantiate), using the new-operator
    and the class name with parentheses appended (more to come)

    When we have an object we may access the packaged variables in the object using
    dot-notation (.) on the variable.

 */
public class C1ClassObjects {
    public static void main(String[] args) {
        new C1ClassObjects().program();
    }

    // --- A class declaration -----
    // Class declaration specifies a name for the class
    // and instance variables (the packaged variables).
    // This class captures the concept of a dog
    class Dog {
        // Two instance variables (each object created will have own of these)
        String name;   // A Dog has a name and... (default value null)
        int age;       // ... and age (default value 0)
    }

    void program() {
        // A class also introduces a new typ (Dog). Declare a variable of type Dog.
        Dog d1 = new Dog();  // Instantiate (create an object using new and method named like class)

        // d1[0] = "Lassie";   // No allowed, this is not like an array!

        out.println(d1.age);  // Get value of contained variable using '.' "dot"-notation and variable name.

        d1.name = "Fido";    // Assign values to variables in dog object, use "dot"-notation
        d1.age = 3;
        d1.age++;            // Getting older ...

        out.println(d1.name + " " + d1.age);  // Must output each variable

        Dog d2 = new Dog(); // Create another dog object. Same class used (class is a blue print)!
        d2.name = "Lassie";
        d2.age = 14;

        if( d1.age > d2.age){
            out.println(d1.name + " is older");
        }else {
            out.println(d2.name + " is older");
        }

    }

}
