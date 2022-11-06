package ex1inheritance;

/*
     Motivation to inheritance

     Problem!  Classes have identical code for instance
     variables and methods. Duplicated code! Bad!
 */
public class I1Motivation {

    public static void main(String[] args) {
        new I1Motivation().program();
    }

    void program() {
        Dog d = new Dog("Lassie", 4);
        Cat c = new Cat("Misse", 5, false);
    }

    //---------- Classes ----------------------------

    public class Dog {
        private String name;     // <------ Duplicate
        private int age;         // <------ Duplicate

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {  // <-------- Duplicate
            return name;
        }   // <------ Duplicate

        public int getAge() {    // <-------- Duplicate
            return age;
        }      // <------ Duplicate
    }

    public class Cat {

        private String name;      // <-------- Duplicate
        private int age;          // <------ Duplicate
        private boolean isEvil;

        public Cat(String name, int age, boolean isEvil) {
            this.name = name;
            this.age = age;
            this.isEvil = isEvil;
        }

        public boolean isEvil() {
            return isEvil;
        }

        public String getName() {  // <--------- Duplicate
            return name;
        } // <------ Duplicate

        public int getAge() {     // <-------- Duplicate
            return age;
        }      // <------ Duplicate
    }



}
