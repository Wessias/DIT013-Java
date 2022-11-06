package ex3static.s1variable;

import static java.lang.System.out;

/*
     Basic behavior of class variable (static variable)
     A class variable is shared by all instances, see class A

 */
public class S1Basics {

    public static void main(String[] args) {
        new S1Basics().program();
    }

    private void program() {
        A a1 = new A(1);          // Two objects
        A a2 = new A(2);

        a1.setJ(99);                 // Change this doesn't affect other object
        out.println(a1.getJ());
        out.println(a2.getJ());

        out.println(a1.getI());     // Check values. Note: Primitive type
        out.println(a2.getI());

        a1.setI(123);               // Change this **affect** other object!?!
        out.println(a1.getI());
        out.println(a2.getI());



    }


}
