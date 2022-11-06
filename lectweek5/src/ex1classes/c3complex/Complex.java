package ex1classes.c3complex;

/*
    An immutable class for Complex numbers
    Another example of standard implementation of Java class
*/
public class Complex {

    private final double re;    // Immutable (final)!
    private final double img;

    // ---- Constructors --------------------

    public Complex(double re, double img) {
        this.re = re;
        this.img = img;
    }

    // Alt. constructor
    public Complex(Complex other) {   // Will create copy of other.
        this(other.re, other.img);
    }

     // Alt. constructor
    public Complex(double re) {
        this(re, 0);
    }

    // --- Instance methods ---------------

    // Return a new Complex object (because we normally assume operands won't change)
    public Complex add(Complex other) {
        return new Complex(re + other.re, img + other.img);
    }

    public Complex sub(Complex other) {
        return new Complex(re - other.re, img - other.img);
    }

    // --- Setter/Getters ---------------

    public double getRe() {    // Possible access parts if complex
        return re;
    }

    public double getImg() {
        return img;
    }

    // --------- Standard methods ----------------

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Complex complex = (Complex) o;

        return Double.compare(complex.re, re) == 0 &&
                Double.compare(complex.img, img) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(re);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(img);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        if (re == 0 && img == 0) {
            return "0";
        } else if (re == 0) {
            return img + "i";
        } else if (img == 0) {
            return Double.toString(re);
        } else if (img > 0) {
            return re + " + " + (img + "i");
        } else {
            return re + " - " + (-1 * img + "i");
        }
    }
}

