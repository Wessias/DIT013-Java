package breakout.model;

import java.util.Random;

/*
 *    A Ball for the Breakout game
 */


public class Ball extends Sprite implements IPositionable, IMovable {


    private static final double radius = 7.5;

    public Ball(double x, double y) {
        super(x, y, 2 * radius, 2 * radius,
                Math.pow(-1, (new Random()).nextInt(1, 3)) * (new Random()).nextDouble(1), -0.75);
    }


    //Returns [bool,bool] first is true if hit, second if hit is from top/bottom.
    //Ball should probably be able to tell if it hit something.
    public boolean[] isHit(IPositionable object) {
        boolean[] isHitOnTop = {false, true};
        //!( over || under || right of || left of)
        if (!(getY() >= object.getY() + object.getHeight() || getY() <= object.getY() || getX() <= object.getX() || getX() >= object.getX() + object.getWidth())) { //over || under || left || right
            isHitOnTop[0] = true;
            if ((Math.round(getX()) == object.getX() - getWidth() || Math.round(getX()) == object.getX() + object.getWidth())) {
                isHitOnTop[1] = false;
            }
        }


        return isHitOnTop;
    }

    public void move() {
        setX(getX() + getDx());
        setY(getY() + getDy());
    }

}
