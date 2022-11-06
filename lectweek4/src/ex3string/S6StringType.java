package ex3string;

import static java.lang.System.out;

/*
        Super/sub and conversions to/from String

        NOTE: Possible to add conversion from (own) objects to String
        see far below
 */
public class S6StringType {

    public static void main(String[] arg) {
        new S6StringType().program();
    }

    void program() {

        String s;

        // -------- String super/sub types -------------------------

        //s = 1;              // No super subtype relation between String and other
        //s = 1.0;
        //s = true;
        //s = (String) 34;
        //s = (String) true;

        // --------- Implicit conversion using + --------------------
        // Any type implicitly converted to String if one operand is String

        s = "Hello ";
        int i = 4;

        out.println(i);
        out.println(s + i);  // int to Integer then to String
        out.println(1 + 2 + s + 3 + 4);  // Evaluation left to right i.e. 3s34

        // ----  Explicit conversions  -------------------

        // From primitive to String
        s = String.valueOf(45);      // Using String
        s = String.valueOf(true);
        s = String.valueOf(1.45);
        s = String.valueOf('X');

        s = Integer.toString(45);    // Same as using wrapper types
        s = Boolean.toString(true);
        s = Double.toString(1.45);
        s = Character.toString('X');

        // From String to primitive or wrapper types
        Integer j = Integer.valueOf("678");
        int jj = Integer.parseInt("678");
        Double d = Double.valueOf("4.57");
        double dd = Double.parseDouble("4.57");
        Boolean b = Boolean.valueOf("false");
        boolean bb = Boolean.parseBoolean("false");

        // Explicit conversion enum
        String day = WeekDay.FRI.toString();
        WeekDay w = WeekDay.valueOf("FRI");
        //w = WeekDay.valueOf("Fri");    // Runtime exception

        // ------ Reference types to String --------------------

        Dog dog = new Dog();
        out.println(dog);       // Normally useless output

        Car car = new Car();
        out.println(car); // Class has toString method, implicit call
    }

    // ------------- Classes -------------

    class Dog {
        String name;
        int age;
    }

    class Car {
        String brand;
        int year;

        // By adding this method we'll get a nice String
        // representation of objects i.e. the object as a String
        // Method called implicit for + and out.println()
        // More to come
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", year=" + year +
                    '}';
        }
    }

    enum WeekDay {
        MON, TUE, WED, THU, FRI;
    }

}
