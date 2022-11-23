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
    public static final double BALL_SPEED_FACTOR = 1.05; // Increase ball speed
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

        //WALL COLLISION FOR BALL
        //1. Get position of ball
        //2. Check if position collides with anything
        //3. IF COLLIDES SEND THAT BITCH FLYING, IF UPPER WALL dy -> -dy, IF SIDES dx -> -dx
        for (Wall wall :
                walls) {
            boolean[] isHitOnTop = ball.isHit(wall);
            if (isHitOnTop[0]) {
                if (isHitOnTop[1]) {
                    ball.setDy(-1 * ball.getDy());
                } else {
                    ball.setDx(-1 * ball.getDx());
                }
            }
        }
        if (ball.isHit(paddle)[0]) {
            ball.setDy(-1.1 * ball.getDy());
            EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.BALL_HIT_PADDLE, "data"));
        }


        for (Brick brick :
                bricks) {
            boolean[] isHitOnTop = ball.isHit(brick);
            if (now > timeForLastHit + 1000) {
                if (isHitOnTop[0]) {
                    timeForLastHit = now;
                    playerPoints += brick.getWorth();
                    bricks.remove(brick);
                    objects.remove(brick);
                    EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.BALL_HIT_BRICK, "data"));
                    if (isHitOnTop[1]) {
                        ball.setDy(-1 * ball.getDy());
                    } else {
                        ball.setDx(-1 * ball.getDx());
                    }

                }
            }
        }



        //Check if ball leaves screen
        if (!isOnScreen(ball)) {
            if (nBalls > 0 ) {
                createNewBall();
                //Update reference. Could use a for loop to find the ball but w/e keep it at index 0.
                objects.set(0, ball);
                nBalls--;
            }
        }

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
