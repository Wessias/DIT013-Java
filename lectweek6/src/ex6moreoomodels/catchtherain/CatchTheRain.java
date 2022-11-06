package ex6moreoomodels.catchtherain;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
    This class represents the overall game
    (no look here)

    Run CatchTheRainGUI to run game.

 */
public class CatchTheRain {

    // Global read only data
    public static final double GAME_WIDTH = 500;
    public static final double GAME_HEIGHT = 500;
    public static final long HALF_SEC = 500_000_000;

    // This is other parts of the OO model
    private final List<Positionable> drops;
    private final Ground ground;
    private final Bucket bucket;

    // Administration
    private int points = 0;
    private long timeForLastDrop;  // Use time supplied by JavaFX
    private List<Positionable> toRemove = new ArrayList<>();

    // Constructor to connect objects to a connected model
    public CatchTheRain(List<Positionable> drops, Ground ground, Bucket bucket) {
        this.drops = drops;
        this.ground = ground;
        this.bucket = bucket;
    }

    // The main "game loop" that makes everything happens
    // Called by GUI timer approx. 1/60 sec.
    void update(long now) {
        bucket.move();   // No check for hitting left/right margin

        for (Positionable d : drops) {
            RainDrop r = (RainDrop) d;
            r.move();
            if (r.intersects(ground) || r.intersects(bucket)) {
                toRemove.add(d);
                if (r.intersects(bucket)) {
                    points += r.getDy();
                }
            }
        }
        drops.removeAll(toRemove);
        toRemove.clear();

        if (now - timeForLastDrop > HALF_SEC) {
            drops.add(createRainDrop());
            timeForLastDrop = now;
        }

    }

    private final Random rand = new Random();

    // Create Raindrop with random size, speed, color
    private RainDrop createRainDrop() {
        double x = 50 + rand.nextInt((int) GAME_WIDTH - 100);
        double y = -rand.nextInt(20);
        double width = 5 + rand.nextInt(20);
        double height = width;
        double dy = 1 + rand.nextInt((int) (60 / width));
        Color color = Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
        return new RainDrop(x, y, width, height, dy, color);
    }

    // --------- Used by GUI for rendering -------------------------

    public List<Positionable> getDrops() {
        return drops;
    }

    public Positionable getBucket() {
        return bucket;
    }

    public Positionable getGround() {
        return ground;
    }

    public int getPoints() {
        return points;
    }

    // ------------ From GUI to model ---------------

    public void setBucketSpeed(double speed){
        bucket.setDx(speed);
    }


}
