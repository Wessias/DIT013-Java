package ex2abstract;


/*
    Possible with more abstract classes (different classifications)

 */
public class A3AbstractExtends {

    public static void main(String[] args) {
        new A3AbstractExtends().program();
    }

    void program() {
        // Interface type for variable
        Dog d = new Dog("Lassie", 4);
        Snake sn = new Snake("Misse", 5, 5);

        Sayable s = sn;
        s = d;

        Pet p = sn;
        p = d;

        //HairyPet hp = sn;    // NO
        HairyPet hp = d;
        p = hp;

    }

    // ----------- Classes ------------------

    public interface Sayable {
        String say();
    }

    // A category, we don't need object of this class
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

    // Another category, no object from this class either
    public abstract class HairyPet extends Pet {
        private String howHairy;

        public HairyPet(String name, int age, String howHairy) {
            super(name, age);
            this.howHairy = howHairy;
        }
    }

    public class Dog extends HairyPet {
        public Dog(String name, int age) {    // Redundant code gone
            super(name, age, "somewhat");
        }

        @Override
        public String say() {   // This is subtype to Pet and Sayable, must implement method!
            return "Voff";
        }
    }

    public class Snake extends Pet  {

        private int length;

        public Snake(String name, int age, int length) {
            super(name, age);
            this.length = length;
        }
        @Override
        public String say() {
            return "Zzzzzzz";
        }
    }
}
