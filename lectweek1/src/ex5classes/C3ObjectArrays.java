package ex5classes;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    Array may contain arbitrary data. Arrays with class objects very common.
 */
public class C3ObjectArrays {

    public static void main(String[] args) {
        new C3ObjectArrays().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Array created from the class type, have Dog-type from class
        Dog[] dogs = new Dog[2]; // No dogs yet, just the array

        String name = sc.nextLine();
        int age = sc.nextInt();
        Dog d1 = new Dog(name, age);       // Create a dog object, using constructor

        dogs[0] = d1;                 // Store dog in array
        out.println(dogs[0]);

        dogs[1] = new Dog("Bertil", 1);  // Store another dog in array

        out.println("Dogs are: ");
        for (int i = 0; i < dogs.length; i++) {
            // First index to get a single dog then dot operator to select value of variable
            out.println(dogs[i].name + ", " + dogs[i].age);
        }

        // Also possible
        Dog[] otherDogs = {new Dog("Fido", 2), new Dog("Pluto", 5)};

    }

    // --- Classes  -----

    class Dog {
        String name;
        int age;
        public Dog(String n, int a) {  // Constructor
            name = n;
            age = a;
        }
    }


}
