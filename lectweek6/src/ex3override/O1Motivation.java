package ex3override;

import java.util.List;

import static java.lang.System.out;

/*
    Bad code because we have to examine the types of the objects to
    decide what to do.
 */
public class O1Motivation {

    public static void main(String[] args) {
        new O1Motivation().program();
    }

    private void program() {
        List<Pet> pets = List.of(new Cat(), new Dog(), new Snake(), new Cat());

        // Non overriding style, if another Pet added have to change code, add a new else if.
        // This could possibly spread to many parts of program!
        for (Pet p : pets) {
            if (p instanceof Cat) {   // Is p a Cat or any subtype of?
                Cat c = (Cat) p;
                out.println(c.say());
            } else if (p instanceof Dog) {
                Dog d = (Dog) p;
                out.println(d.say());
            } else if (p instanceof Snake) {
                ((Snake) p).say();
            // } else if ( ... ) {            <----- Must modify if another Pet added
            } else {
                out.println("Unknown pet");
            }
        }


    }

    // ------------- Classes ---------------------

    abstract class Pet {
        private String name;

        public String getName() {
            return name;
        }
    }

    class Dog extends Pet {
        String say() {
            return "Voff";
        }
    }

    class Cat extends Pet {
        String say() {
            return "Mjau";
        }
    }

    class Snake extends Pet {
        void say(){
            out.println("Snake");
        }
    }
}
