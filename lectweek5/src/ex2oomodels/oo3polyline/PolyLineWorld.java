package ex2oomodels.oo3polyline;

import java.util.ArrayList;
import java.util.List;

/*
      This is where all the PolyLines live, the universe
      Representing the over all OO-model
 */
public class PolyLineWorld {

    // The lines in this world (empty at start)
    private final List<PolyLine> polyLines = new ArrayList<>();

    // ------------ Constructors ---------------------
    public PolyLineWorld() {
    }

    public PolyLineWorld(List<Point2D> selectedPts) {
        List<LineSegment> segs = new ArrayList<>();
        for (int i = 0; i < selectedPts.size() - 1; i++) {
            segs.add(new LineSegment(selectedPts.get(i), selectedPts.get(i + 1)));
        }
        polyLines.add(new PolyLine(segs));
    }

    // ------------ Methods ---------------------
    public boolean addPolyLine(PolyLine polyLine) {
        return polyLines.add(polyLine);
    }

    public boolean removePolyLine(PolyLine polyLine) {
        return polyLines.remove(polyLine);
    }

    public PolyLine getClosestTo(double x, double y, double epsilon) {
        for (PolyLine p : polyLines) {
            if (p.isCloseTo(x, y, epsilon)) {
                return p;
            }
        }
        return null;
    }

    public void concat(PolyLine p1, PolyLine p2) {
        p1.concat(p2);              // Mutating
        polyLines.remove(p2);
    }

    public void reset() {
        polyLines.clear();
    }

    // ---------- Setter/getters -----------------
    // Used by GUI
    public List<PolyLine> getPolyLines() {
        return polyLines;
    }
}
