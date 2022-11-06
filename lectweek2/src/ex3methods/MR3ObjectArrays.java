package ex3methods;

import java.util.Scanner;

import static java.lang.System.in;

/*
    Object arrays as parameters and return types.
 */
public class MR3ObjectArrays {

    public static void main(String[] args) {
        new MR3ObjectArrays().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        Dog[] dogs = getDogs();
        Dog d = findOldest(dogs);
    }

    // ------------- Methods ------------------------------

    Dog findOldest(Dog[] dogs) {  // Return reference to complex object
        int index = 0;
        int maxAge = dogs[index].age;
        for (int i = 0; i < dogs.length; i++) {
            if (dogs[i].age > maxAge) {
                index = i;
                maxAge = dogs[i].age;
            }
        }
        return dogs[index];
    }


    Dog[] getDogs() {
        final int maxDog = 3;
        Dog[] dogs = new Dog[maxDog];
        for( int i = 0 ; i < maxDog; i++) {
            String name = sc.nextLine();
            int age = sc.nextInt();
            sc.nextLine();
            dogs[i] = new Dog(name, age);
        }
        return dogs;  // Return reference to complex object
    }

    // ------------- Class ------------------------------

    class Dog {
        String name;
        int age;

        Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

}






