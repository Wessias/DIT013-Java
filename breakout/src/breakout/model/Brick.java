package breakout.model;

/*
 *   A brick for the rows of bricks
 */

public class Brick extends Sprite implements IPositionable {

    public static final double BRICK_WIDTH = 20;  // Default values, use in constructors, not directly
    public static final double BRICK_HEIGHT = 10;

    private final double worth;

    public Brick(double x, double y, double worth) {
        super(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        this.worth = worth;
    }

    public double getWorth(){
        return worth;
    }
}

