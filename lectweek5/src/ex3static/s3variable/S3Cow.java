package ex3static.s3variable;

import java.util.Random;

/*
        Example of reasonable usage of static variables
        sharing a random number generator

        A 2D cow for some simulation
 */
public class S3Cow {
    /*
        All cows needs a random generator, but not exclusively,
        they can all share the same. Make it a class (static) variable
     */
    private final static Random rand = new Random();   // Shared!
    private final double width;
    private final double height;
    private double x;        // Upper left corner
    private double y;
    private double dx;
    private double dy;

    // --------- Constructors ---------------------

    public S3Cow(double x, double y, double width, double height, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = dx;
        this.dy = dy;
    }

    public S3Cow(double x, double y) {
        this(x, y, 10, 10, 0, 0);
    }

    // ---------- Methods --------------------

    public void move() {
        x += dx;
        y += dy;
    }

    public void turnRandom() {
        dx = 1 - rand.nextInt(3);  // Use shared object
        dy = 1 - rand.nextInt(3);  // No impact for other objects
    }

    // -------- Setters/getters --------------------

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}