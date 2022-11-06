package ex6moreoomodels.imagewiz;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
    GUI for image viewer using JavaFX
    Application view and handling user input.

    Image found in resources/img

 */
public class ImageWizGUI extends Application {

    private Stage stage;     // Global JavaFX stuff
    private ImageView imageView; // Layout for the image
    private ImageWiz iWiz;

    // --- Filer button handling -----------------

    // Apply a filter for actual image
    private void apply(Event e) {
        String filterName = ((Button) e.getTarget()).getText();
        imageView.setImage(iWiz.apply(filterName));
    }

    // Revert last applied filter
    private void undo(Event e) {
        imageView.setImage(iWiz.undo());
    }

    // -------- Menu handling -----------------
    private void exit(Event e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Do you really want to exit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    private void open(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            iWiz.setActual(FileService.load(file));
            imageView.setImage(iWiz.getActual());
        }
    }

    private void save(Event e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                FileService.save(file, iWiz.getActual());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // -------- JavaFX -------------

    private final int width = 800;
    private final int height = 600;

    @Override
    public void start(final Stage primaryStage) {
        stage = primaryStage;

        String[] filterNames = FilterLoader.getFilterNames(FilterLoader.FILTER_DIR);
        Filter[] filters = FilterLoader.getFilters(FilterLoader.FILTER_DIR, filterNames);
        Map<String, Filter> nameFilter = new HashMap<>();
        for (int i = 0; i < filterNames.length; i++) {
            nameFilter.put(filterNames[i], filters[i]);
        }

        iWiz = new ImageWiz(nameFilter);

        // Create different GUI parts
        MenuBar menu = getMenu();
        ToolBar toolBar = getToolBar(filterNames);
        imageView = new ImageView();
        imageView.setPreserveRatio(true);
        StackPane sp = new StackPane(imageView);
        VBox root = new VBox();

        // Connect GUI parts
        root.getChildren().addAll(menu);
        root.getChildren().addAll(toolBar);
        root.getChildren().addAll(sp);

        // Add GUI to Scene
        Scene scene = new Scene(root, width, height);
        scene.setFill(Color.OLDLACE);

        primaryStage.setTitle("Image Wizzard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar getMenu() {

        // --- Menu File
        Menu menuFile = new Menu("File");
        MenuItem[] menuFileItems = {
                new MenuItemExt("Open", this::open, KeyCode.O, KeyCombination.CONTROL_DOWN),
                new MenuItemExt("Save", this::save),
                new MenuItemExt("Quit", this::exit)
        };
        menuFile.getItems().addAll(menuFileItems);

        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
        MenuItem[] menuEditItems = {
                new MenuItemExt("Undo", this::undo, KeyCode.Z, KeyCombination.CONTROL_DOWN)
        };
        menuEdit.getItems().addAll(menuEditItems);

        // --- Menu About
        Menu menuAbout = new Menu("About");
        MenuItem[] menuAboutItems = {new MenuItemExt("About", e -> {
        })};
        menuAbout.getItems().addAll(menuAboutItems);

        // -- The bar for all menus
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuEdit, menuAbout);
        return menuBar;
    }


    private ToolBar getToolBar(String[] filterNames) {
        ToolBar toolbar = new ToolBar();
        for (String name : filterNames) {
            Button b = new Button(name);
            b.setOnAction(this::apply);
            toolbar.getItems().add(b);
        }
        return toolbar;
    }

    //  Helper class with more useful constructor
    private static class MenuItemExt extends MenuItem {
        public MenuItemExt(String label, EventHandler<ActionEvent> e) {
            super(label);
            setOnAction(e);
        }

        public MenuItemExt(String label, EventHandler<ActionEvent> e, KeyCode keyCode,
                           KeyCombination.Modifier modifier) {
            this(label, e);
            setAccelerator(new KeyCodeCombination(keyCode, modifier));
        }
    }

    public static void main(String[] args){
        launch();
    }

}
