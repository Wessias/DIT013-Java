package breakout.model;


import breakout.event.EventBus;
import breakout.event.ModelEvent;

import java.util.ArrayList;
import java.util.List;

/*
 *  Overall all logic for the Breakout Game
 *  Model class representing the full game
 *  This class should use other objects delegate work.
 *
 *  NOTE: Nothing visual here
 *
 */
public class Breakout {

    public static final double GAME_WIDTH = 400;
    public static final double GAME_HEIGHT = 400;
    public static final double BALL_SPEED_FACTOR = 1.1; // Increase ball speed
    public static final long SEC = 1_000_000_000;  // Nano-seconds used by JavaFX

    private int nBalls = 5;
    int playerPoints;
    List<IPositionable> objects = new ArrayList<>();
    Ball ball;
    Paddle paddle;
    List<Wall> walls;
    List<Brick> bricks;

    // TODO Constructor that accepts all objects needed for the model
    public Breakout(Ball ball, List<Wall> walls, Paddle paddle, List<Brick> bricks) {
        this.ball = ball;
        this.walls = walls;
        this.paddle = paddle;
        this.bricks = bricks;
        objects.add(ball);
        objects.add(paddle);
        objects.addAll(walls);
        objects.addAll(bricks);
    }


    // --------  Game Logic -------------

    private long timeForLastHit;         // To avoid multiple collisions
    private boolean paddleMoving;
    private boolean moveLeft;

    public void update(long now) {
        // TODO  Main game loop, start functional decomposition from


        updateBallPos((Ball) objects.get(0));

        //Update Paddle movement
        if (paddleMoving) {
            if (moveLeft) {
                paddle.setMovingLeft(true);
                paddle.move();
            } else {
                paddle.setMovingLeft(false);
                paddle.move();
            }
        }

        //WALL COLLISION FOR BALL
        //1. Get position of ball
        //2. Check if position collides with anything
        //3. IF COLLIDES SEND IT FLYING, IF UPPER WALL dy -> -dy, IF SIDES dx -> -dx
        for (Wall wall :
                walls) {

            if (ball.isHit(wall)) {
                if (wall.getDirection() == Wall.Dir.HORIZONTAL) {
                    ball.setDy(-1 * ball.getDy());
                } else {
                    ball.setDx(-1 * ball.getDx());
                }
            }

        }

        //Check paddle hit
        if (ball.isHit(paddle)) {
            ball.setDy(-BALL_SPEED_FACTOR * ball.getDy());
            EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.BALL_HIT_PADDLE, "data"));
        }

        //Check brick hit
        for (Brick brick :
                bricks) {
            if (now - timeForLastHit > SEC / 20) {
                if (ball.isHit(brick)) {
                    timeForLastHit = now;
                    playerPoints += brick.getWorth();
                    bricks.remove(brick);
                    objects.remove(brick);
                    ball.setDy(-1 * ball.getDy());
                    EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.BALL_HIT_BRICK, "data"));
                    break;
                }
            }
        }


        //Check if ball leaves screen
        if (!isOnScreen(ball)) {
            if (nBalls > 0) {
                createNewBall();
                //Update reference. Could use a for loop to find the ball but w/e keep it at index 0.
                objects.set(0, ball);
                nBalls--;
            }
        }




        if (playerPoints == 9600) {
            //end?
        }


    }

    // ----- Helper methods--------------

    // Used for functional decomposition


    private boolean isOnScreen(IPositionable object) {
        return !(object.getY() > GAME_HEIGHT + 15 || object.getY() < -15 || object.getX() > GAME_WIDTH + 15 || object.getX() < -15);
    }

    private void createNewBall() {
        ball = new Ball(200, 200);
    }

    private void updateBallPos(Ball b) {
        b.move();
    }

    public void paddleMoving(Boolean isMove, Boolean isLeft) {
        paddleMoving = isMove;
        moveLeft = isLeft;
    }


    // --- Used by GUI  ------------------------

    public List<IPositionable> getPositionables() {

        // TODO return all objects to be rendered by GUI
        return objects;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getnBalls() {
        return nBalls;
    }


}
