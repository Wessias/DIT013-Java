package ex2abstract;


/*
     Creating Pet objects is senseless. There should never be a Pet pet.
     Pet is just an category (and technically used for common code)

     Possible to make class abstract i.e. impossible to instantiate.
     Often used for base classes/inheritance

 */
public class A1AbstractClass {

    public static void main(String[] args) {
        new A1AbstractClass().program();
    }

    void program() {
        //Pet p = new Pet(...);   // Can't instantiate, compile error, class abstract

        Dog d = new Dog("Fido", 44);  // Ok
    }

    //---------- Classes ----------------------------

    // Probably senseless to create Pet-objects,
    // there's no Pet animal. Use an
    // abstract class, can't create instances.
    public abstract class Pet {
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

    // As before
    public class Dog extends Pet {
        public Dog(String name, int age) {    // Redundant code gone
            super(name, age);
        }
    }
    // As before
    public class Cat extends Pet {
        private boolean isEvil;

        public Cat(String name, int age, boolean isEvil) {
            super(name, age);
            this.isEvil = isEvil;
        }
        public boolean isEvil() {
            return isEvil;
        }
    }

}
