package ex4types;


import java.util.ArrayList;
import java.util.List;

/*
    Using super/sub types with collections/elements of collections

    What to put into collection, what to get from.

 */
public class T3CollectionsSubtyping {

    public static void main(String[] args) {
        new T3CollectionsSubtyping().program();
    }

    void program() {
        Dog d = new Dog("Fido", 3);
        Cat c = new Cat("Missan", 4, false);

        List<Pet> pets = new ArrayList<>();
        pets.add(d);             // Ok, Dog is a Pet
        pets.add(c);             // Ok, Cat is a Pet
        pets.get(0).getName();
        pets.get(0).say();       // Ok, implement sayable

        List<Sayable> sayables = new ArrayList<>();
        sayables.add(d);      // Ok, Dog is sayable
        sayables.add(c);       // Ok, Cat is sayable
        sayables.get(0).say();
        //sayables.get(0).getName();   // No such method

        //sayables = pets;    // No, generic types, no subtype relation!
        //pets = sayables;

        //pets.add(sayables.get(0));  // A sayable may not be a Pet
        sayables.add(pets.get(0));    // Any pet is sayable

        sayables.addAll(pets);
        //pets.addAll(sayables);

        for (Sayable s : sayables) {
            if (s instanceof Pet) {    // Check if object is Pet or subclass to
                pets.add((Pet) s);
            }
        }
    }

    // --------------- Types -----------------

    public abstract class Pet implements Sayable {
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

        @Override
        public String say() {   // This is subtype to Pet and Sayable, must implement method!
            return "Voff";
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

        @Override
        public String say() {
            return "Mjau";
        }


    }

    public interface Sayable {
        String say();
    }


}
