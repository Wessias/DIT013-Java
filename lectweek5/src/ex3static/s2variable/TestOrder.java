package ex3static.s2variable;

import static java.lang.System.out;

/*
     Test Order class (using a static variable for order number, generation a
     sequence of ascending order numbers)
 */
public class TestOrder {

    public static void main(String[] args) {
        new TestOrder().program();
    }

    void program() {
        S2Order o1 = new S2Order();
        out.println(o1);
        S2Order o2 = new S2Order();
        out.println(o2);
        S2Order o3 = new S2Order();
        out.println(o3);
    }
}
