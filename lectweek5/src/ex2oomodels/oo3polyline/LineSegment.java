package ex2oomodels.oo3polyline;

/*
      Concept of a line segment in 2D
      Used by PolyLines
 */
public class LineSegment {
    private Point2D start;
    private Point2D end;

    // ------------ Constructors ---------------------
    public LineSegment(Point2D start, Point2D end) {
        this.start = start;
        this.end = end;
    }

    public LineSegment(LineSegment other) {
        this( new Point2D(other.start), new Point2D(other.end));
    }

    // ------------ Methods ---------------------
    public void translate(double dx, double dy) {
        start = new Point2D(start.getX() + dx, start.getY() + dy);
        end = new Point2D(end.getX() + dx, end.getY() + dy);
    }

    // ------------- Setter/Getters -------------------
    public Point2D getStart() {
        return start;
    }

    public Point2D getEnd() {
        return end;
    }

    // ------------ Standard methods ---------------------
    @Override
    public String toString() {
        return "{" + start + ", " + end + '}';
    }
}