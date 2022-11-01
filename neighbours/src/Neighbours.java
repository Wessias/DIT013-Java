import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.exit;
import static java.lang.System.out;

/*
 *  Program to simulate segregation.
 *  See : http://nifty.stanford.edu/2014/mccown-schelling-model-segregation/
 *
 * NOTE:
 * - JavaFX first calls method init() and then method start() far below.
 * - To test methods uncomment call to test() first in init() method!
 *
 */
// Extends Application because of JavaFX (just accept for now)
public class Neighbours extends Application {

    class Actor {
        final Color color;        // Color an existing JavaFX class
        boolean isSatisfied;      // false by default

        Actor(Color color) {      // Constructor to initialize
            this.color = color;
        }  // Constructor, used to initialize
    }

    // Below is the *only* accepted instance variable (i.e. variables outside any method)
    // This variable may *only* be used directly in methods init() and updateWorld()
    Actor[][] world;              // The world is a square matrix of Actors

    // This is the method called by the timer to update the world
    // (i.e move unsatisfied) approx each 1/60 sec.
    void updateWorld() {
        // % of surrounding neighbours that are like me
        double threshold = 0.7;
        //List of null index, [[row, col]]
        int[][] nullCords = new int[world.length * world.length][2];
        int nullFound = 0;
        //List of dissatisfied index, [[row, col]]
        int[][] dissatisfiedCords = new int[world.length * world.length][2];
        int dissatisfiedFound = 0;



        // TODO
        // 1 Loop to find dissatisfied and nulls.

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world.length; j++) {
                //CHECK TYPE OF ACTOR (RED, BLUE, NULL), and save dissatisfied and null pos
                if (world[i][j] == null){
                    int[] nullPos = {i, j};
                    nullCords[nullFound] = nullPos;
                    nullFound++;
                } else if (world[i][j].color == Color.RED) {
                    System.out.println("RED");

                }
                else{
                    System.out.println("BLUE");
                }


                //
            }

        }


        //Shuffle nulls.

        //Swap nulls with dissatisfied.
    }

    // This method initializes the world variable with a random distribution of Actors
    // Method automatically called by JavaFX runtime
    // That's why we must have "@Override" and "public" (just accept for now)
    @Override
    public void init() {
        //test();    // <---------------- Uncomment to TEST, see below!

        // %-distribution of RED, BLUE and NONE
        double[] dist = {0.25, 0.25, 0.5};
        // Number of locations (places) in world (must be a square)
        int nLocations = 900;   // Should also try 90 000

        // TODO
        world = new Actor[(int) sqrt(nLocations)][(int) sqrt(nLocations)];
        world = populateWorld(dist, world);


        // Should be last
        fixScreenSize(nLocations);
    }

    // TODO Many methods here, break down of init() and updateWorld()
    Actor[][] populateWorld(double[] dist, Actor[][] emptyWorld){
        for (int i = 0; i < emptyWorld.length; i++) {
            for (int j = 0; j < emptyWorld.length; j++) {
                double rand = Math.random();
                if (rand < dist[0]){
                    emptyWorld[i][j] = new Actor(Color.RED);
                } else if (rand < dist[0] + dist[1]) {
                    emptyWorld[i][j] = new Actor(Color.BLUE);
                }
                else {
                    emptyWorld[i][j] = null;
                }
            }
        }

        return emptyWorld;
    }

    Boolean isSatisfied(Actor[][] world, double threshold){
        return false;
    }

    // Check if inside world
    boolean isValidLocation(int size, int row, int col) {
        return 0 <= row && row < size && 0 <= col && col < size;
    }

    Actor doIt(Actor[][] world){
        return world[0][0];
    }

    // ----------- Utility methods -----------------

    // TODO Method to change format of data, generate random etc.

    // ------- Testing -------------------------------------

    // Here you run your tests i.e. call your logic methods
    // to see that they really work. Important!!!!
    void test() {
        // A small hard coded world for testing
        Actor[][] testWorld = new Actor[][]{
                {new Actor(Color.RED), new Actor(Color.RED), null},
                {null, new Actor(Color.BLUE), null},
                {new Actor(Color.RED), null, new Actor(Color.BLUE)}
        };
        System.out.println(testWorld[0][1] == null);


        double th = 0.5;   // Simple threshold used for testing

        //out.println(doIt(testWorld).color == Color.RED);

        //int size = testWorld.length;
        //out.println(isValidLocation(size, 0, 0));   // This is a single test
        //out.println(!isValidLocation(size, -1, 0));
        //out.println(!isValidLocation(size, 0, 3));

        // TODO  More tests here. Implement and test one method at the time
        // TODO Always keep all tests! Easy to rerun if something happens



        exit(0);
    }

    // ******************** NOTHING to do below this row, it's JavaFX stuff  **************

    double width = 500;   // Size for window
    double height = 500;
    final double margin = 50;
    double dotSize;

    void fixScreenSize(int nLocations) {
        // Adjust screen window
        dotSize = (double) 9000 / nLocations;
        if (dotSize < 1) {
            dotSize = 2;
        }
        width = sqrt(nLocations) * dotSize + 2 * margin;
        height = width;
    }

    long lastUpdateTime;
    final long INTERVAL = 450_000_000;


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Build a scene graph
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a timer
        AnimationTimer timer = new AnimationTimer() {
            // This method called by FX, parameter is the current time
            public void handle(long now) {
                long elapsedNanos = now - lastUpdateTime;
                if (elapsedNanos > INTERVAL) {
                    updateWorld();
                    renderWorld(gc);
                    lastUpdateTime = now;
                }
            }
        };

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation");
        primaryStage.show();

        timer.start();  // Start simulation
    }


    // Render the state of the world to the screen
    public void renderWorld(GraphicsContext g) {
        g.clearRect(0, 0, width, height);
        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = (int) (dotSize * col + margin);
                int y = (int) (dotSize * row + margin);
                if (world[row][col] != null) {
                    g.setFill(world[row][col].color);
                    g.fillOval(x, y, dotSize, dotSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
