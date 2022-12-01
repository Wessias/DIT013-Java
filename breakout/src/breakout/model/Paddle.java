package breakout.model;

import static breakout.model.Breakout.GAME_HEIGHT;
import static breakout.model.Breakout.GAME_WIDTH;

/*
 * A Paddle for the Breakout game
 *
 */
public class Paddle extends Sprite implements IPositionable, IMovable{

    public static final double PADDLE_WIDTH = 60;  // Default values, use in constructors, not directly
    public static final double PADDLE_HEIGHT = 10;
    public static final double PADDLE_SPEED = 5;
    private boolean moveLeft;

    public Paddle(double x, double y) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_SPEED, 0);
    }


    @Override
    public void move() {
        if(moveLeft && getX() >= 0){
            setX(getX() - getDx());
        } else if (getX() <= 400 - getWidth()) {
            setX(getX() + getDx());
        }

    }

    public void setMovingLeft(boolean moveLeft){
        this.moveLeft = moveLeft;
    }

}
