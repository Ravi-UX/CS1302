package cs1302.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;

/**
 * Represents a custom VBox component which loads and displays images.
 *
 */
public class ImageLoader extends VBox {
    /** A default image which loads when the application starts. */
    private static final String DEFAULT_IMG =
        "http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png";

    /** Default height and width for Images. */
    private static final int DEF_HEIGHT = 500;
    private static final int DEF_WIDTH = 500;

    HBox urlLayer;
    TextField urlField;
    Button loadImage;

    ImageView imgView;

    /**
     * Constructor which initializes the ImageLoader VBox and
     * initializes child nodes.
     */
    public ImageLoader() {
        super();
        // Initializing nodes for scene sub graph
        //vbox = new VBox();
        urlLayer = new HBox(10);
        urlField = new TextField("https://");
        loadImage = new Button("Load");

        //Add the button and field to container
        urlLayer.getChildren().addAll(urlField, loadImage);
        HBox.setHgrow(urlField, Priority.ALWAYS);

        //Set default dimensions ofr image
        Image img = new Image(DEFAULT_IMG, DEF_HEIGHT, DEF_WIDTH, false, false);

        //Add image to its container
        imgView = new ImageView(img);

        //Preserve ratio if image is resized
        imgView.setPreserveRatio(true);

        /* Equivalent to
         * EventHandler<ActionEvent> loadImgHandler = this::loadImage or
         * EventHandler<ActionEvent> loadImgHandler = (ActionEvent e) -> some lambda
         * and loadImgHandler is passed into setOnAction
         */
        loadImage.setOnAction(this::loadImage);

        //Add the HBox and ImageView to the ImageLoader object which is essentially a
        // custom VBox
        this.getChildren().addAll(urlLayer, imgView);
    }

    /**
     * Event handler for load button.
     * @param e source event
     */
    private void loadImage(ActionEvent e) {
        try {
            Image newImg =
                new Image(urlField.getText(), DEF_HEIGHT, DEF_WIDTH, false, false);
            imgView.setImage(newImg);
        } catch (IllegalArgumentException exc) {
            System.out.println("The supplied URL is invalid");
        }
    }
}
