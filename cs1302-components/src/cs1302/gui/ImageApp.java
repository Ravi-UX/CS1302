package cs1302.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;

/**
 * A basic JavaFX 8 program which takes a user specified URL and loads it
 * into an {@code ImageView}.
 *
 */
public class ImageApp extends Application {

    Stage stage;
    Scene scene;

    /** The root container for the application scene graph. */
    HBox hbox;

    /** The two ImageLoader objects to be contained in the HBox. */
    ImageLoader img1;
    ImageLoader img2;

    /**
     * The entry point for our image viewer application.
     *
     * @param stage A reference to the stage object (window) created by the system.
     */
    public void start(Stage stage) {
        this.stage = stage;

        img1 = new ImageLoader();
        img2 = new ImageLoader();
        hbox = new HBox(10);

        // Add the ImageLoader objects to the containing hbox and set the hbox
        // to be the root of the scene
        hbox.getChildren().addAll(img1, img2);
        scene = new Scene(hbox);

        // Set up the stage and set it to be visible
        // stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("1302 Image Viewer!");
        stage.sizeToScene();
        stage.show();

    } // start

} // ImageApp
