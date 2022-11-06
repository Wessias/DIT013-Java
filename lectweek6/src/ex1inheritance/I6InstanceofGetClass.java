package ex1inheritance;


import static java.lang.System.out;

/*
    To examine types in running program operator instanceof or
    method getClass() may be used (RTTI = runtime type information).

    BUT! Avoid. Better use polymorphism (overriding, to come...).

 */
public class I6InstanceofGetClass {

    public static void main(String[] args) {
        new I6InstanceofGetClass().program();
    }

    private void program() {
        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        Van van = new Van();

        // ------------ instanceof ---------------------

        out.println(car instanceof Vehicle);// Is car Vehicle or subtype
        out.println(van instanceof Vehicle);
        out.println(vehicle instanceof Car);
        out.println(vehicle instanceof Van);

        if( vehicle instanceof Car){       // Typical usage
            Car c = (Car) vehicle;         // Safe.
        }

        // ----------- Pitfalls -----------------

        Object o = van;
        out.println( o instanceof Car);   // Ok!

        //out.println( van instanceof Car);  // No super sub
        //out.println( car instanceof Van);


        // ---------- GetClass ---------------------

        out.println(vehicle.getClass() == Vehicle.class);  // What's the type of the object?
        out.println(car.getClass() == Car.class);
        out.println(van.getClass() == Van.class);
        out.println(vehicle.getClass() == Car.class);  // False

        // ----------- Pitfalls -----------------

        o = van;
        out.println(o.getClass() == Car.class);   // Ok

        //out.println(van.getClass() == Car.class);    // No super/sub

    }

    // ------------ Classes --------------------------

    public class Vehicle {
    }

    public class Car extends Vehicle  {
    }

    public class Van extends Vehicle  {
    }
}
