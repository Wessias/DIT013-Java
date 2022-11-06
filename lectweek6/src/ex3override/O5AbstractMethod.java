package ex3override;

import static java.lang.System.out;

/*
     Abstract method may be used to force sub classes to implement
     (override) a method.

     This allows us to use a base type variable (because variable type
     defines operations) without any "useless" implementation.
     All implementations are in sub classes
 */
public class O5AbstractMethod {

    public static void main(String[] args) {
        new O5AbstractMethod().program();
    }

    void program() {
        Pet p = new Dog("Lassie", 4);
        p.doIt();    // Ok, method in type, but object version called

        p = new Cat("Misse", 5, false);
        p.doIt();   // Ok, method in type, but object version called

    }

    public abstract class Pet {
        private String name;
        private int age;

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Abstract method, so class must be abstract
        // Will force subclasses to override (else they also must be abstract)
        // (no useless code for doIt in class)
        public abstract void doIt();
    }

    public class Dog extends Pet {
        public Dog(String name, int age) {    // Redundant code gone
            super(name, age);
        }

        // Implement
        @Override
        public void doIt() {
            out.println("Mjau");
        }
    }


    public class Cat extends Pet {

        private boolean isEvil;

        public Cat(String name, int age, boolean isEvil) {
            super(name, age);
            this.isEvil = isEvil;
        }

        @Override
        public void doIt() {
             out.println("Voff");
        }

        public boolean isEvil() {
            return isEvil;
        }

    }


}
