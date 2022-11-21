package breakout.model;

/*
 *   A brick for the rows of bricks
 */

public class Brick extends Sprite implements IPositionable {

    public static final double BRICK_WIDTH = 20;  // Default values, use in constructors, not directly
    public static final double BRICK_HEIGHT = 10;

    double worth;

    public Brick(double x, double y, double worth) {
        super(x, y);
        width = BRICK_WIDTH;
        height = BRICK_HEIGHT;
        this.worth = worth;
    }

    public double getWorth(){
        return worth;
    }

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

