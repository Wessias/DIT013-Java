package ex3static.s3variable;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.InputStream;

/*
    Testing the class with static variable (Cow class)
 */
public class TestCow extends Application {

    // Class has static variable Random rand.
    private S3Cow cow1 = new S3Cow(250, 200);
    private S3Cow cow2 = new S3Cow(200, 200);

    private long timeForLastTurn;

    // Called by JavaFX timer
    private void update(long now) {
        cow1.move();
        cow2.move();
        if (now - timeForLastTurn > 700_000_000) {
            cow1.turnRandom();
            cow2.turnRandom();
            timeForLastTurn = now;
        }
    }

    // --------  JavaFX stuff, graphics a timer -----------------------

    private void render() {
        gc.clearRect(0, 0, 500, 500);
        render(cow1);
        render(cow2);
    }

    private void render(S3Cow gameCharacter) {
        gc.setFill(Color.BROWN);
        double x = gameCharacter.getX();
        double y = gameCharacter.getY();
        gc.drawImage(i, x, y);
    }

    private Image i;
    @Override
    public void init() {
       InputStream input = this.getClass().getResourceAsStream("cow.png");
       i = new Image(input, 30, 30, true, true);
    }

    // ------- Start up graphics -------------------

    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();  // The Layout
        Canvas canvas = new Canvas(500, 500);  // Drawing area
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();  // Toolbox for drawing (on drawing area)
        AnimationTimer timer = new AnimationTimer() {      // If animating, time must pass
            @Override
            public void handle(long now) {
                update(now);
                render();
            }
        };

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cows moving Random");
        primaryStage.show();
        timer.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
