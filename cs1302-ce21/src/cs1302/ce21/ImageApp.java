package cs1302.ce21;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * A basic JavaFX 8 program which takes a user specified URL and loads it
 * into an {@code ImageView}.
 *
 */
public class ImageApp extends Application {

    Stage stage;
    Scene scene;

    /** The root container for the application scene graph. */
    TabPane tabPane;

    /**
     * The entry point for our image viewer application.
     *
     * @param stage A reference to the stage object (window) created by the system.
     */
    public void start(Stage stage) {
        this.stage = stage;

        tabPane = new TabPane();

        // Add the ImageLoader objects to the containing Tabs, add the Tabs to the Tabpane
        // and set the Tabpane to be the root of the scene
        for (int i = 0; i < 4; i++) {
            tabPane.getTabs().add(new Tab("New Tab " + (i + 1), new ImageLoader()));
        }
        scene = new Scene(tabPane);

        // Set up the stage and set it to be visible
        // stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("1302 Image Viewer!");
        stage.sizeToScene();
        stage.show();

    } // start

} // ImageApp
