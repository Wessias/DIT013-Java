package breakout.model;

import java.util.Random;

/*
 *    A Ball for the Breakout game
 */


public class Ball extends Sprite implements IPositionable, IMovable {


    private static final double radius = 7.5;

    public Ball(double x, double y) {
        super(x, y, 2 * radius, 2 * radius,
                Math.pow(-1, (new Random()).nextInt(1, 3)) * (new Random()).nextDouble(1), -0.8);
    }


    //Returns [bool,bool] first is true if hit, second if hit is from top/bottom.
    //Ball should probably be able to tell if it hit something.
    public boolean isHit(IPositionable object) {
        //!( under || over || left of || right of)
        return !(object.getY() + object.getHeight() < getY()
                || object.getY() > getY() + getHeight()
                || object.getX() + object.getWidth() < getX()
                || object.getX() > getX() + getWidth());
    }

    public void move() {
        setX(getX() + getDx());
        setY(getY() + getDy());
    }

}
