package cs1302.ce22;

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
import javafx.application.Platform;
import javafx.scene.text.Text;

/**
 * A basic JavaFX 11 program which takes a user specified URL and loads it
 * into an {@code ImageView}.
 *
 */
public class ImageApp extends Application {

    Stage stage;
    Scene scene;

    /** The root container for the application scene graph. */
    VBox vbox;

    /** The container for the url textfield and the load image button. */
    HBox urlLayer;
    TextField urlField;
    Button loadImage;

    HBox bottom;
    Text loadText;

    /** The container for the loaded image. */
    ImageView imgView;

    /** A default image which loads when the application starts. */
    private static final String DEFAULT_IMG =
        "http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png";

    /**
     * URL for the deelay.me site. Adding this to the beginning of
     * our image URLs will delay the image download so we can see
     * how multithreading impacts our code and test that our loading
     * text is working properly.
     */
    private static final String DELAY_URL =
        "http://deelay.me/5000/";

    /** Default height and width for Images. */
    private static final int DEF_HEIGHT = 500;
    private static final int DEF_WIDTH = 500;

    /**
     * The entry point for our image viewer application.
     *
     * @param stage A reference to the stage object (window) created by the system.
     */
    public void start(Stage stage) {

        this.stage = stage;

        // Initializing the nodes for the scene graph
        vbox = new VBox();
        urlLayer = new HBox(10);
        urlField = new TextField("https://");
        loadImage = new Button("Load");

        // Adding the textfield and load image button the the containing hbox
        urlLayer.getChildren().addAll(urlField, loadImage);

        // Sets the textfield to grow, as necessary, to fill the hbox
        HBox.setHgrow(urlField, Priority.ALWAYS);

        bottom = new HBox();
        loadText = new Text("");
        bottom.getChildren().add(loadText);

        // Load the default image with the default dimensions
        Image img = new Image(DEFAULT_IMG, DEF_HEIGHT, DEF_WIDTH, false, false);

        // Add the image to its container and preserve the aspect ratio if resized
        imgView = new ImageView(img);
        imgView.setPreserveRatio(true);

        Runnable target = () -> {
            try {
                loadImage.setDisable(true);
                loadText.setText("Loading...");
                String url = DELAY_URL + urlField.getText();
                Image newImg = new Image(url, DEF_HEIGHT, DEF_WIDTH, false, false);
                loadImage.setDisable(false);
                loadText.setText("");
                imgView.setImage(newImg);
                //Platform.runLater(mod);
            } catch (IllegalArgumentException iae) {
                System.out.println("The supplied URL is invalid");
            } // try
        };

        // EventHandler for our button using a fancy method reference.
        loadImage.setOnAction(e -> {
            runNow(target);
        });

        // Add the hbox and imageview to the containing vbox and set the vbox
        // to be the root of the scene
        vbox.getChildren().addAll(urlLayer, imgView, bottom);
        scene = new Scene(vbox);

        // Set up the stage and set it to be visible
        // stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("1302 Image Viewer!");
        stage.sizeToScene();
        stage.show();

    } // start

    /**
     * Students will provide javadoc comments here.
     *
     * @param e source event
     */
    private void loadImage(ActionEvent e) {

        try {
            String url = DELAY_URL + urlField.getText();
            Image newImg = new Image(url, DEF_HEIGHT, DEF_WIDTH, false, false);
            imgView.setImage(newImg);
        } catch (IllegalArgumentException iae) {
            System.out.println("The supplied URL is invalid");
        } // try

    } // loadImage

    /**
     * Creates and starts a new daemon thread.
     * @param target the object whose run method is invoked when
     * this thread is started
     */
    public static void runNow(Runnable target) {
        Thread thread = new Thread(target);
        thread.setDaemon(true);
        thread.start();
    }

} // ImageApp
