package ex2oomodels.oo3polyline;

import java.util.ArrayList;
import java.util.List;

/*
    Concept of a polyline composed of line segments
    Will exist in PolyLineWorld

 */
public class PolyLine {

    private final List<LineSegment> segments;

     // ------------ Constructors ---------------------
    public PolyLine(List<LineSegment> segs) {
        this.segments = segs;
    }

    public PolyLine(PolyLine other) {
        segments = new ArrayList<>();
        for (LineSegment s : other.segments) {
            segments.add(new LineSegment(s));
        }
    }

    // ------------ Methods ---------------------
    public boolean isCloseTo(double x, double y, double epsilon){
        for( LineSegment s : segments){
            if( s.getStart().isCloseTo(x, y, epsilon) || s.getEnd().isCloseTo(x, y, epsilon)){
                return true;
            }
        }
        return false;
    }

    public void concat(PolyLine other) {
        LineSegment thisLast = segments.get(segments.size() - 1);
        LineSegment otherFirst = other.segments.get(0);
        LineSegment connection = new LineSegment(thisLast.getEnd(), otherFirst.getStart());
        int last = segments.indexOf(thisLast);
        segments.add(last + 1, connection);
        segments.addAll(other.segments);
    }

    public PolyLine translate(double dx, double dy) {
        List<LineSegment> copy = new ArrayList<>();
        for (LineSegment s : segments) {
            Point2D start = new Point2D(s.getStart().getX() + dx, s.getStart().getY() + dy);
            Point2D end = new Point2D(s.getEnd().getX() + dx, s.getEnd().getY() + dy);
            copy.add(new LineSegment(start, end));
        }
        return new PolyLine(copy);
    }

    /* Alt. translate. Mutating existing objects
    public void translate(double dx, double dy) {
        for (LineSegment s : segments) {
            s.translate(dx, dy);
        }
    }*/


    // --------- Setter/Getters-----------------------------------------

    public List<LineSegment> getSegments() {
        return segments;
    }

    // ------------ Standard methods ---------------------------

    @Override
    public String toString() {
        return segments.toString();
    }
}