package ex2shortforswitch;

import java.util.Arrays;

import static java.lang.System.out;

/*
    A short for loop is simpler to write and use but has some limitations.
    - You only travers from left to right one element at the time
    - If you need an index for some reason, you can't use short the for-loop
    - If elements has primitive types, can't modify them (loop uses a copy of value).
    - If references possible to modify object, but not the reference.
    - Also issues when removing from objects from collections, more to come.

 */
public class FS1ShortForLoop {

    public static void main(String[] args) {
        new FS1ShortForLoop().program();
    }

    void program() {
        int[] iArr = {1, 2, 3};
        Integer[] iiArr = {1, 2, 3};

        // ------- Short for loop and primitive array -----------------------

        for (int i : iArr) {  // Each value in iArr copied to i
            out.print(i);
            i++;             // Senseless it's copy
        }
        //i++;           // No, scope just in loop
        out.println(Arrays.toString(iArr));

        // ------- Short for loop and reference array -----------------------

        for (Integer ii : iiArr) {
            out.print(ii);
            ii = 45;     // Senseless, variable will point at new object
        }
        out.println(Arrays.toString(iiArr));

         // ------- Short for and object arrays -----------------------

        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
        for (Dog d : dogs) {
            d.age = 5;          // OK! Will set value in objects!
        }
        out.println(dogs[0].age);
        out.println(dogs[1].age);

    }

    class Dog {
        String name;
        int age;    // Default 0
    }

}
