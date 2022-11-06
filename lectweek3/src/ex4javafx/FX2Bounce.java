package ex4javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/*
     Somewhat fancier animation.
     Just for the curious, will not show up on exam!
 */
public class FX2Bounce extends Application {

    // Have to find the values (possibly better ways to do it)
    private static final double GRAVITY = 2;
    private static final double BOUNCE_REDUCE = 0.9;

    Room room = new Room(500, 500);

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Build a scene graph
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a timer
        AnimationTimer timer = new AnimationTimer() {
            // Real time is the frequency for how often
            // JavaFX calls this method
            public void handle(long now) {
                room.update();
                Ball b = room.getBall();
                gc.clearRect(0, 0, 500, 500);
                gc.fillOval(b.x, b.y, 2 * b.radius, 2 * b.radius);
            }
        };

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bounce");
        primaryStage.show();

        timer.start();  // Start simulation
    }

    // ------------------ Classes -------------------------

    class Room {
        double width;
        double height;
        Ball ball = new Ball(50, 50, 10, 2, 2);
        boolean gravityOn = true;

        public Room(double width, double height) {
            this.width = width;
            this.height = height;
        }

        void update() {
            if (gravityOn) {
                ball.vy += GRAVITY;
                ball.vx = 0.995 * ball.vx;
            }
            ball.move();
            // Hit walls
            if (ball.x <= ball.radius || width <= ball.x + 2 * ball.radius) {
                ball.vx = -ball.vx;
            }
            // Hit ceiling
            if (ball.y - ball.radius <= 0) {
                ball.y = ball.radius;
                ball.vy = -ball.vy;
            }
            // Hit floor
            if (height <= ball.y + 2 * ball.radius) {
                // out.println("floor");
                if (gravityOn) {
                    ball.y = height - 2 * ball.radius;
                    ball.vy = -ball.vy * BOUNCE_REDUCE;
                } else {
                    ball.vy = -ball.vy;
                }
            }
        }

        public Ball getBall() {
            return ball;
        }
    }

    class Ball {
        double x;
        double y;
        double radius;
        double vx;
        double vy;

        public Ball(double x, double y, double radius, double vx, double vy) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.vx = vx;
            this.vy = vy;
        }
        void move() {
            x = x + vx;
            y = y + vy;
        }
    }
}
