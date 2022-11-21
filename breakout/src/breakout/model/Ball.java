package breakout.model;

import java.util.Random;

/*
 *    A Ball for the Breakout game
 */


public class Ball extends Sprite implements IPositionable, IMovable {
    private final double radius = 7.5;


    public Ball(double x, double y) {
        super(x,y);

        width = 2 * radius;
        height = width;

        dy = -0.75;
        Random rando = new Random();
        dx = Math.pow(-1, rando.nextInt(1, 3)) * rando.nextDouble(1);
    }


    //Returns [bool,bool] first is true if hit, second if hit is from top/bottom.
    //Ball should probably be able to tell if it hit something.
    public boolean[] isHit(IPositionable object){
        boolean[] isHitOnTop = {false, true};
        //!( over || under || right of || left of)
        if ( !(y >= object.getY() + object.getHeight()|| y <= object.getY() || x <= object.getX() || x >= object.getX() + object.getWidth())  ){ //over || under || left || right
            isHitOnTop[0] = true;
            if ( ( Math.round(x) == object.getX() - width || Math.round(x) == object.getX() + object.getWidth())){
                isHitOnTop[1] = false;
            }
        }


        return isHitOnTop;
    }

    public void move() {
        x += dx;
        y += dy;
    }
    @Override
    public double getDx() {
        return dx;
    }

    @Override
    public void setDx(double dx) {
        this.dx = dx;
    }


    @Override
    public double getDy() {
        return dy;
    }

    @Override
    public void setDy(double dy) {
        this.dy = dy;
    }


    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }
}
