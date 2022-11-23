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
    boolean moveLeft;

    public Paddle(double x, double y) {
        super(x, y);
        height = PADDLE_HEIGHT;
        width = PADDLE_WIDTH;
        dx = PADDLE_SPEED;
    }


    @Override
    public void move() {
        if(moveLeft && x >= 0){
            x -= dx;
        } else if (x <= 400 - width) {
            x += dx;
        }

    }

    public void setMovingLeft(boolean moveLeft){
        this.moveLeft = moveLeft;
    }

}
