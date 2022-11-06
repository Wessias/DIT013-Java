package ex1compiler;


import static java.lang.System.out;

/*
    A name is a term used for identification. Names can identify a
    class or category of things, or a single thing, either uniquely,
    or within a given context.

    What in the code below are names?
    - These are **not** names: public, void, 123, true, +, ...
    - These are names: program, s, i, doIt, Dog, ...

    Q: How can we distinguish a name?
    A: A name is *declared* somewhere (by us or someone else).
       A declaration introduces a name!

    Besides translating source code to byte code the compiler will keep
    track of all names:
    1) that they exists (are declared)
    2) what they represent (variable, method, class, ...)
    3) types

    During translation the compiler checks that the names are used in a
    correct/sound/meaningful way (compiler has a lot of built in rules).
    If bad usage, a compiler error will occur. This is a *great* service to us programmers.
    We don't need to run the program to check for errors (some types of).

 */
public class C1Names {

    public static void main(String[] args) {
        new C1Names().program();
    }

    void program() {

        // ------ Variable declarations ------------------

        String s = "Hello";   // s is a name representing a string variable (declare by us)
        final int i = 123;    // i is a name representing a final variable int (declared by us)
        boolean b = false;    // b is a boolean variable

        out.println(s);   // out and println are a names declared by someone else

        // -------------- Usage of names ---------------------

        // Compiler use declarations to track errors

        //out.println(n);  // n, unknown name, not declared!

        doIt(i);      // Name doIt declared as function, correct usage, call it

        //i++;         // i declared as final so can't use = or ++/--
        //i[0] = 2;   // i not an array

        //doIt(i) = i;   // Can't assign to the function, compile error

        //out.println( b++);       // Can't increment boolean
        //out.println( 2 * b);     // Can't multiply int and boolean
        b = 1.5 > 0;             // Ok

        //doOther();     // doOther unknown method not declared

        Dog d = new Dog();  // Name Dog declared as class. Ok, correct usage

        //Cat c;         // Unknown type name , not declared
    }

    // --------------- Method declarations ---------------

    // A method declaration because () and possible parameters
    // after name
    int doIt(int i) {
        return 2 * i;
    }

    // A class declaration, because of word class before name
    class Dog {
        String name;
        int age;
    }

}
