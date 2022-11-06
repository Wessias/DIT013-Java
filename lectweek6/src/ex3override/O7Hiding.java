package ex3override;


import static java.lang.System.out;

/*

     Variables are **not** overridden.
     Overriding is only applicable to methods.
     When an instance variable in a child class has the same
     name as an instance variable in a parent class, then the
     instance variable is chosen from the *reference type*.

 */
public class O7Hiding {

    public static void main(String[] args) {
        new O7Hiding().program();
    }

    private void program() {
        A a1 = new A();
        out.println(a1.i);  // 1

        A a2 = new B();
        out.println(a2.i); // 1, no override for variables. Variable type rules.


        out.println(((B) a2).i);  // 2, because of casting

        B b1 = new B();
        out.println(b1.i);  // 2

    }

    class A {
        int i = 1;
    }

    class B extends A {
        int i = 2;  // Hides parent class.
    }


}
