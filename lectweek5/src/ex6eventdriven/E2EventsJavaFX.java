package ex6eventdriven;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static java.lang.System.out;

/*
    Basic event driven JavaFX application

    "In computer programming, event-driven programming is a
    programming paradigm in which the flow of the program
    is determined by events such as user actions (mouse clicks, key presses),
    sensor outputs, or messages from other programs or threads.
    Event-driven programming is the dominant paradigm used in graphical
    user interfaces and other applications" /Wikipedia

    Used in labs (but already implemented)
 */
public class E2EventsJavaFX extends Application {


    // ---------- Handle keyboard -----------------------

    // Automatically called by JavaFX  when key event emitted
    // Name of method doesn't matter but parameter must be like this
    void keyPressed(KeyEvent event) {
        out.println(event.getCode() + " pressed");
    }

    void keyReleased(KeyEvent event) {
        out.println(event.getCode() + " released");
        gc.clearRect(0, 0, 500, 500);
    }

    // ------------- Handle mouse --------------------

    // Automatically called by JavaFX when event mouse event emitted
    // Name of method doesn't matter but parameter must be like this
    private void onMouseReleased(MouseEvent mouseEvent) {
        out.println("Mouse released");
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        gc.setFill(Color.DARKGREEN);
        gc.strokeText("x=" + x + " y=" + y, x, y);
        gc.fillOval(x, y, 30, 30);
    }

    private void onMouseDrag(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        gc.setFill(Color.ROYALBLUE);
        gc.fillOval(x, y, 2, 2);
    }

    // --------  JavaFX, setup graphics, event handling -----------------------

    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Canvas canvas = new Canvas(500, 500);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        // Set up event handling
        // Connect event listeners (methods)
        // to the scene using method references
        scene.setOnKeyPressed(this::keyPressed);
        scene.setOnKeyReleased(this::keyReleased);
        scene.setOnMouseDragged(this::onMouseDrag);
        scene.setOnMouseReleased(this::onMouseReleased);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Event demo");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
