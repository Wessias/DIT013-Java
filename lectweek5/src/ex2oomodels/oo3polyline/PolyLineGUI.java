package ex2oomodels.oo3polyline;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static java.lang.System.out;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;

/*
    A view of the PolyLine OO model (a JavaFX GUI).
    Not part of OO-model
    Handles interaction between user and model and creates
    the (initial) model

    No data or logic here!

 */
public class PolyLineGUI extends Application {

    private final double epsilon = 3;  // Distance to be set by GUI or user (hard coded for now)

    // The OO model
    private final PolyLineWorld world = new PolyLineWorld();

    // Temps used by GUI to store result of user actions.
    private final List<Point2D> selectedPts = new ArrayList<>();
    private final Deque<PolyLine> selectedPolyLines = new ArrayDeque<>();

    // --------------- Called when buttons clicked -----------------

    public void createPolyline(MouseEvent me) {
        List<LineSegment> segs = new ArrayList<>();
        for (int i = 0; i < selectedPts.size() - 1; i++) {
            segs.add(createSegment(selectedPts.get(i), selectedPts.get(i + 1)));
        }
        PolyLine polyLine = new PolyLine(segs);
        world.addPolyLine(polyLine);
        //out.println("Polyline created " + polyLine);
        selectedPts.clear();
    }

    // Private helper method
    private LineSegment createSegment(Point2D start, Point2D end){
        return new LineSegment(start, end);
    }

    public void translatePolyline(MouseEvent me) {
        // This is mutating
        /*if (!selectedPolyLines.isEmpty()) {
            String result = showOffsetInputDialog();
            double dx = Double.valueOf(xAndY[0]);
            double dy = Double.valueOf(xAndY[1]);
            PolyLine p = selectedPolyLines.pop();
            p.translate(dx, dy);
        }*/
        // This is creating new objects
        if (!selectedPolyLines.isEmpty()) {
            String result = showOffsetInputDialog();
            String[] xAndY = result.split(" ");
            double dx = Double.valueOf(xAndY[0]);
            double dy = Double.valueOf(xAndY[1]);
            PolyLine p = selectedPolyLines.pop();
            PolyLine newP = p.translate(dx,dy);
            world.removePolyLine(p);
            world.addPolyLine(newP);
        }
    }

    public void concatPolyline(MouseEvent me) {
        if (selectedPolyLines.size() >= 2) {
            PolyLine second = selectedPolyLines.pop();
            PolyLine first = selectedPolyLines.pop();
            world.concat(first, second);   // Reversed order
        }
    }


    public void handleCanvasClick(MouseEvent me) {
        if (me.isControlDown()) {
            PolyLine p = world.getClosestTo(me.getX(), me.getY(), epsilon);
            if (p != null) {
                selectedPolyLines.push(p);
                //out.println("PolyLines Selected " + selectedPolyLines);
            }
        } else {
            Point2D p = new Point2D(me.getX(), me.getY());
            selectedPts.add(p);
            //out.println(p);
            renderPoint(p);
        }
    }

    public void reset(MouseEvent me) {
        world.reset();
        selectedPolyLines.clear();
        selectedPts.clear();
    }

    // --------------------- JavaFX stuff, graphics and event handling ---------------------

    private GraphicsContext gc;
    public static final int WIDTH = 400;  // Global variables
    public static final int HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        canvas.setOnMouseClicked(this::handleCanvasClick);
        gc = canvas.getGraphicsContext2D();

        Button create = new Button("Create PolyLine");
        create.setOnMouseClicked(this::createPolyline);
        Button translate = new Button("Translate");
        translate.setOnMouseClicked(this::translatePolyline);
        Button concat = new Button("Concat");
        concat.setOnMouseClicked(this::concatPolyline);
        Button reset = new Button("Reset");
        reset.setOnMouseClicked(this::reset);
        Button update = new Button("Update view");
        update.setOnMouseClicked(this::render);

        HBox buttons = new HBox();
        buttons.getChildren().addAll(create, translate, concat, reset, update);

        BorderPane root = new BorderPane();
        root.setTop(new Label("Click to set points for polyline."
                +  "Use ctrl/click to select polyline"));
        root.setBottom(buttons);
        root.setCenter(canvas);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("View PolyLine OO Model");
        primaryStage.show();
    }

    private void render(MouseEvent me) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        for (PolyLine pl : world.getPolyLines()) {
            for (LineSegment s : pl.getSegments()) {
                renderSegment(s);
            }
        }
    }

    private void renderSegment(LineSegment s) {
        gc.setFill(RED);
        gc.fillOval(s.getStart().getX() - 3,
                s.getStart().getY() - 3, 6, 6);
        gc.setFill(BLACK);
        gc.strokeLine(s.getStart().getX(), s.getStart().getY(),
                s.getEnd().getX(), s.getEnd().getY());
        gc.setFill(RED);
        gc.fillOval(s.getEnd().getX() - 3,
                s.getEnd().getY() - 3, 6, 6);
    }

    private void renderPoint(Point2D p) {
        gc.setFill(RED);
        gc.fillOval(p.getX() - 3, p.getY() - 3, 6, 6);
    }

    private String showOffsetInputDialog() {
        TextInputDialog dialog = new TextInputDialog("0 0");
        dialog.setTitle("Enter offset");
        dialog.setHeaderText("Input like \"30 23\"");
        dialog.setContentText("Offset:");
        return dialog.showAndWait().get();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
