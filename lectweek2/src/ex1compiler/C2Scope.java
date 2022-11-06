package ex1compiler;

import static java.lang.System.out;

/*
    In computer programming, the scope of a name such as a variable,
    is the region of a program where the name can be used to refer to the entity
    (where the name is visible).

    Scopes are used to:
    - Be able to reuse a name
    - Limit the access to something (reduce risk that something
    is (accidentally) misused by someone somewhere).

    In Java the most common scope is between { and } (i.e. a block,
    Java is a block scoped language)

    Inside a scope names must normally be unique (compiler will record in which
    scope the name is declared)

 */
public class C2Scope {  // Start of the outermost scope

    public static void main(String[] args) {
        new C2Scope().program();
    }

    int m = 1;          // m declared in outermost scope (avoid for now)

    void program() {    // Scope directly inside outermost scope

        int i = 0;      // Declared in "program" scope
        //int i = 1;     // Error, same name in same scope

        while( i < 5) {
            //int i = 2;     // Error. Names declared before and in enclosing scope visible
            int j = 9;       // Scope in "while". New name only visible in block
            i++;             // Ok to use. Name before and in enclosing scope
        }
        //int i = 3;   // Error, same name in same scope
        int j = 6;     // Ok, j in inner block not in same scope.

        for( int n = 0 ; n < 3 ; n++){  // scope for n is the loop
            out.print(n);
        }
        //out.println(n);    // Not in scope

        // -------- Which variable to chose? -----------------

        out.println(m);  // Ok, declared in outer scope, visible
        int m = 3;       // Ok, compiler treats outermost scope in a special way.
        out.println(m);  // Q: Which m will be used? A: Closest declaration!

    }

    // Add declared directly in outermost scope (all methods must be declared like this)
    int add(int a ){
        //return a + i;   // i not in scope, not visible
        return a + m;     // m in outermost scope visible
    }


}  // End outermost scope
