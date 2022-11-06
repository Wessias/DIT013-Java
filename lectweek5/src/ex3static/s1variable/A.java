package ex3static.s1variable;

/*
    A dummy class used to demonstrate the
    usage of class (static) variables
 */
public class A {

    private static int i;    // The class/static variable. Shared by all instances. Value = 0 default
    private int j;           // Instance variable

    public A(int j) {
        this.j = j;
    }

    // ------------- Setter/getters ------------------

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
