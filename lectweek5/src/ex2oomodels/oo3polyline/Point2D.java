package ex2oomodels.oo3polyline;

import static java.lang.Math.sqrt;

/*

    Concept of immutable position in plane
    Used by LineSegment
*/
public class Point2D {
    private final double x;
    private final double y;

    // ------------ Constructors ---------------------
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D p) {
        this(p.x, p.y);
    }

    // ------------ Methods ---------------------
    public boolean isCloseTo(double x, double y, double epsilon) {
        // Pythagoras
        return sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y)) < epsilon;
    }



    // ------------- Setter/Getters -------------------
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // ------------ Standard methods ---------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2D point2D = (Point2D) o;

        if (Double.compare(point2D.x, x) != 0) return false;
        return Double.compare(point2D.y, y) == 0;
    }


    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}


