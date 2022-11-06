package ex4types;


import static java.lang.System.out;

/*
    Casting to interface types is always allowed
    even if NO super sub relation!

    Q: Why?
    A: Any reference variable may reference some
       sub type object implementing the interface
 */
public class T1CastToInterface {

    public static void main(String[] args) {
        new T1CastToInterface().program();
    }

    private void program() {

        Car car = new Car();
        Sayable s1 = (Sayable) car;  // Allowed but runtime error ... (Car not subtype)

        car = new TalkingCar();     // super = sub
        Sayable s2 = (Sayable) car; // ... because could be like this, TalkingCar implements
        out.println(s2.say());

    }

    public interface Sayable {
        String say();
    }

    public class Car {
        // Class has **nothing** to do with Sayable
    }

    // Subtype to Car and Sayable
    public class TalkingCar extends Car implements Sayable {
        @Override
        public String say() {
            return "Honk honk";
        }
    }

}
