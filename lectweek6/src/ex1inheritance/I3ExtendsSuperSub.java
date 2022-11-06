package ex1inheritance;


/*
     A subclass introduces a subtype!

     I.e. if class B extends A then B <: A
     Very natural because B inherits all non private operations
     from A we can always replace an A objects with an B object
     Object of type B have at least all the operations in A.

 */
public class I3ExtendsSuperSub {

    public static void main(String[] args) {
        new I3ExtendsSuperSub().program();
    }

    void program() {
        Dog d = new Dog("Lassie", 4);
        Cat c = new Cat("Misse", 5, false);

        Pet p = d;   // super = sub, established by "extends"
        p = c;

        /*
            VARIABLE TYPE DEFINES OPERATIONS
            --------------------
            But never any problem with inheritance, Cat object have
            all operations that variable type declares because
            they are inherited.
         */
        p.getName();    // p references Cat object
        p.getAge();

        // --------- Casting -----------------

        c = (Cat) p;
        //d = (Dog) p;   // sub = (sub) super, compile ok but runtime exception
    }

    // ---------------- Classes -----------------

    public class Pet {
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

    public class Dog extends Pet {
        public Dog(String name, int age) {    // Redundant code gone
            super(name, age);
        }
    }

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
