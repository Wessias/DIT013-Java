package ex4types;

import static java.lang.System.out;

/*
    Similar to a generic class, a generic interface
    Just for general background here
 */
public class T4GenericInterface {

    public static void main(String[] args) {
        new T4GenericInterface().program();
    }

    void program() {
        IRememberable<String> rs = new Box<>("Hello");
        out.println(rs.getRemembered());

        IRememberable<Integer> ri = new Box<>(123);
        out.println(ri.getRemembered());

    }

    //--------- Generic interface-------------

    interface IRememberable<T> {
        T getRemembered();
    }

    //--------- Class -------------

    // Class implements generic interface
    class Box<T> implements IRememberable<T> {
        T toRemember;    // T is any reference type

        public Box(T toRemember) {
            this.toRemember = toRemember;
        }

        @Override
        public T getRemembered() {
            return toRemember;
        }
    }

}















