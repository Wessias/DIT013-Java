package ex5init;

import ex5init.classes.C;

import static java.lang.System.out;

/*
    This is the (close) to full process of initializing
    when inheritance and static is involved

    Order of initialization:
    - Any static initialization (for class) in written order (and class loading order)
    - Any instance variable initialization in written order
    - Finally constructor (if inheritance call super class constructor first)

    Dummy classes in classes/ directory
 */
public class I1Initialization {

    public static void main(String[] args) {
        new I1Initialization().program();
    }

    void program() {
        out.println("Progam starts");
        C c = new C(3, "Created in program");
    }
}

