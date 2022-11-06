package ex1inheritance;

import static java.lang.System.out;

/*
    When creating an object of some subtype, *only* one
    object created i.e. no super class object created

    To see this we print out the (fairly) unique "id" number for the object
    and the class name using inherited methods from Object

    NOTE: "this" in superclass may reference subclass object
    (though declared typ of this variable is Pet)

 */
public class I4WhatObject {

    public static void main(String[] args) {
        new I4WhatObject().program();
    }

    void program() {
        Cat c = new Cat("Missan", 5, false);  // Only one Cat object created.

    }

    // ----------- Classes --------------

    public class Pet {
        private String name;
        private int age;

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
            // Will return unique "id" number for object
            out.println("In Pet id is " + this.hashCode());
            out.println("In Pet class is " + this.getClass().getSimpleName());  // NOTE! "this" is a Cat object!!
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean isOld(int oldAge) {
            return age >= oldAge;
        }
    }

    public class Cat extends Pet {

        private boolean isEvil;  // Unique for Cat.

        public Cat(String name, int age, boolean b) {
            super(name, age);
            this.isEvil = b;
            // Will return same as above "id" number i.e. same object
            out.println("In Cat id is " + this.hashCode());
            out.println("In Cat class is " + this.getClass().getSimpleName());
        }

        public boolean isEvil() {
            return isEvil;
        }
    }
}

