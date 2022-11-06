package ex2references;




import java.awt.*;

import static java.lang.System.out;

/*
    Very natural that constructor parameters have the same names as the
    instance variables in the object. May produce a name clash between instance
    variables and parameters in constructor.

    Issue resolved by prefixing instance variables with "this".
    "this" is a (hidden) final reference variable to the actual
    object. All objects have "this", "this" also used for other purposes, more later.

    NOTE: IntelliJ can generate constructors. Right click > Generate
    Will use the prefix pattern described above
 */

public class R4This {

    public static void main(String[] args) {
        new R4This().program();
    }

    void program() {
        // Use constructor
        Cat cat = new Cat("Olle", Color.BLACK);

        out.println(cat.owner);     // owner set by constructor
        out.println(cat.color);     // color set by constructor

        //out.println(cat.this);    // Bad! Scope in class methods only

    }

    // ------- Classes ----------------------

    class Cat {
        String owner;   // Instance variable
        Color color;

        // IntelliJ can generate this constructor
        Cat(String owner, Color color) {
            // 'this' used because of name clashes, owner/owner and color/color
            // this.owner is the instance variable, owner is the parameter
            this.owner = owner;
            this.color = color;
        }
    }

}



