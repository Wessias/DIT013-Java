package ex2abstract;


/*
    To eliminate "implements" on every sub class. Let abstract base class implement
    interface and sub classes inherit abstract base class. See HERE below

    - All possibly shared (redundant) code may be placed in the abstract base class
    - By transitivity all sub classes are subtypes to the interface type

 */
public class A2AbstractImplements {

    public static void main(String[] args) {
        new A2AbstractImplements().program();
    }

    void program() {
        // Interface type for variable
        Sayable s = new Dog("Lassie", 4);
        s = new Cat("Misse", 5, false);
    }

    // ----------- Classes ------------------

    // Let base class implement interface
    // This class need not to implement method say() because it's
    // abstract
    public abstract class Pet implements Sayable {   // <--------------- HERE!!
        private String name;
        private int age;

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

    }

    public interface Sayable {
        String say();
    }

    public class Dog extends Pet /*implements Sayable*/ {   //<--- Better let bas class implement
        public Dog(String name, int age) {    // Redundant code gone
            super(name, age);
        }

        // Must implement method (else must be  abstract class)
        @Override
        public String say() {   // This is subtype to Pet and Sayable, must implement method!
            return "Voff";
        }
    }

    public class Cat extends Pet /*implements Sayable*/ {

        private boolean isEvil;

        public Cat(String name, int age, boolean isEvil) {
            super(name, age);
            this.isEvil = isEvil;
        }

        public boolean isEvil() {
            return isEvil;
        }

        @Override
        public String say() {
            return "Mjau";
        }


    }


}
