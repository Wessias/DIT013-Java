package ex2methods;


import java.util.Arrays;

import static java.lang.System.out;

/*
    Generic methods for searching and sorting

    If the algorithm needs information about objects (equality, ordering, etc)
    then the method must know something about the objects, see below

    This is just to get some background, covered in later courses.

 */
public class M4GenericSearchSort {

    public static void main(String[] arg) {
        new M4GenericSearchSort().program();
    }

    void program() {

        Integer[] iia = {1, 2, 3};
        Double[] dda = {1.0, 2.0, 3.0};
        String[] sa = {"a", "b", "c"};
        Dog[] dogs = {new Dog("Fido"), new Dog("Lassie"), new Dog("Pluto")};

        // ---  Here we need some information about the objects  ----------------

        // Here we need equals() to find by value
        out.println(find(sa, "b"));

        Dog d = new Dog("Fido");
        out.println(find(dogs, d));     // Not found! Possibly problems with equals.

        // Find max in array (needs >,< >= or <=)
        out.println(max(iia));
        out.println(max(dda));

        // Sort array (needs  >,< >= or <=)
        Integer[] arr = {15, 3, -1, 0, 7, 4, 13};
        bubbleSort(arr);
        out.println(Arrays.toString(arr));

        //bubbleSort(dogs);           // Not Comparable

    }

    // --------------- Methods ------------------------

    // Here we assume all objects can use equals (which they can,
    // more to come) Possibly reference equality is used. Do we want that?.
    <T> int find(T[] arr, T value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {       // Need equals!
                return i;
            }
        }
        return -1;
    }


    // This method needs to compare elements
    // by value, but how to do it?
    <T> T max(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
           /*if (arr[i] > max) {       // Operator > not defined for all types
                max = arr[i];
            }
            */
        }
        return max;
    }

    // To solve the problem above, we put in extra information
    // about the type. We say that T i Comparable i.e.
    // it's possible to compare a T object with other T objects
    // Comparable will guarantee there is a compareTo method.
    <T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {   // Here! Use method guaranteed to exist, more to come.
                max = arr[i];
            }
        }
        return max;
    }

    // Bubble sort must also know how to compare.
    <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ------------------------------------------------------

    class Dog {
        String name;
        Dog(String name) {
            this.name = name;
        }
    }

}
