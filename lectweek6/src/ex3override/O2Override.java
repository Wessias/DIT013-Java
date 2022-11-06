package ex3override;

import java.util.List;
import java.util.Random;

import static java.lang.System.out;

/*
    Method Overriding

    "Method overriding, in object-oriented programming, is a
    language feature that allows a subclass or child class
    to provide a specific implementation of a method that
    is already provided by one of its superclasses or parent classes.
    The implementation in the subclass overrides (replaces) the
    implementation in the superclass by providing a method that
    has same name, same parameters or signature, and same return
    type as the method in the parent class. The version of a
    method that is executed will be determined by the object that
    is used to invoke it." // Wikipedia

    NOTE: Inheritance MUST be involved when overriding!

 */
public class O2Override {

    public static void main(String[] args) {
        new O2Override().program();
    }

    private void program() {

        // ------- Remember -----------------
        Object o = new Object();
        out.println(o);    // Will call Object.toString implicitly

        o = new Dog();
        out.println(o);   // Will call Dog.toString implicitly!
        /*
            LATE (DYNAMIC) BINDING (used for overriding)
            ----------------------
            Type Pet has say() method, checked during compilation.
            But a Pet variable may reference any subtype object with
            own version of method using overriding (identical method heads).
            Compiler knows nothing about values (objects), so can't
            decide during compilation which method to execute.
            The issue is resolved during execution by looking at the type
            of the object and then pick the method. This is called late binding.
         */

        // Using overriding, each Pet know what to say, if new pets, no change to code!
        // The objects know how to behave!
        List<Pet> pets = List.of(getObject(), getObject(), getObject(), getObject());
        for (Pet pet : pets) {
            // Will check which type of object runtime. Then call method of that object.
            out.println(pet.say());
        }
    }

    // ------------- Classes ---------------------

    abstract class Pet {
        public String say() {
            return "Pet";
        }   // Useless more to come, see AbstractMethod
    }

    class Dog extends Pet {
        @Override
        public String say() {
            return "Dog";
        }
    }

    class Cat extends Pet {
        @Override
        public String say() {
            return "Cat";
        }
    }

    class Snake extends Pet {
        @Override
        public String say() {
            return "Snake";
        }
    }

    Pet getObject() {
        switch (new Random().nextInt(3)) {
            case 0:
                return new Dog();
            case 1:
                return new Cat();
            default:
                return new Snake();
        }
    }
}
