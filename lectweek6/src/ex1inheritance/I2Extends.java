package ex1inheritance;


import static java.lang.System.out;

/*
     Have seen all classes inherit from Object. Possible to
     let own classes inherit other own class

     This shows eliminating duplicate code using an own "base class" and let
     own sub classes inherit. This is the correct use of "extends" in Java!

     NOTE: Inheritance also makes overriding (polymorphism possible) more to come

 */
public class I2Extends {

    public static void main(String[] args) {
        new I2Extends().program();
    }

    void program() {
        Dog d = new Dog("Lassie", 4);
        Cat c1 = new Cat("Misse", 5, false);
        Cat c2 = new Cat("Heidegger", 2, true);


        Pet p = new Pet("???", -123);

        // ---------- Call inherited methods -------------

        out.println(d.getName() + ":" + d.getAge());
        out.println(d.getName() + "is old " + d.isOld(10));

        // All cats (and dogs) of course have their own variables (values)
        // c1.getName() will use value from c1 object
        out.println(c1.getName() + ":" + c1.getAge());
        // c2.getName() will use value from c2 object
        out.println(c2.getName() + ":" + c2.isEvil());
    }

    //---------- Classes ----------------------------

    // The base class (super class)
    // All common code for Cat and Dog here,
    // instance variables, methods
    public class Pet {
        private String name;   // Common
        private int age;       // Common

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }  // Common

        public int getAge() {
            return age;
        } // Common

        public boolean isOld(int oldAge){
            return age >= oldAge;
        }
    }

    // Dog extends, is subclass, to Pet, will inherit all
    // non-privates from Pet (super class). Redundant code gone
    // NOTE: See below
    public class Dog extends Pet {

        // All dogs of course have their own variables
        // at runtime (just "the written code" that is inherited)
        // Code is redundant not the variables and methods

        // Constructor
        public Dog(String name, int age) {
            // Must call constructor of superclass
            // first of all to initialize variables
            // declared in super class (because we don't see them here)
            super(name, age);
        }
        // getName(), getAge(), isOld() inherited
    }

    // Cat is subclass too
    public class Cat extends Pet {

        private boolean isEvil;  // Unique for Cat.

        // Constructor
        public Cat(String name, int age, boolean isEvil) {
            super(name, age);
            this.isEvil = isEvil;
        }

        public boolean isEvil() {
            return isEvil;
        }

        // getName(), getAge(), isOld() inherited

    }

    /*
        A NOTE ON WHAT'S INHERITED
        --------------------------
        The Java specification clearly states that privates (variable, methods)
        are NOT inherited.
        But, ... of course they are there as "non-accessible parts" of the sub object
        created from the super class. Must use setter/getter from super class to access.

     */


}
