package cs1302.ce19;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.Priority;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * Represents a basic image viewer app.
 */
public class ImageApp extends Application {

    HBox hbox;
    ImageView imgView;
    TextField field;
    Button button;

    @Override
    public void start(Stage stage) {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        hbox = new HBox(8);
        Image img = new Image("http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png");
        imgView = new ImageView(img);
        field = new TextField("https://");
        button = new Button("Load");

        vbox.getChildren().add(hbox);
        vbox.getChildren().add(imgView);
        hbox.setHgrow(field, Priority.ALWAYS);
        hbox.getChildren().add(field);
        hbox.getChildren().add(button);

        EventHandler<ActionEvent> loadHandler = (ActionEvent event) -> {
            System.out.println(field.getText());
            try {
                Image image = new Image(field.getText());
                imgView.setImage(image);
            } catch (Exception e) {
                System.err.println("Invalid URL!");
            }
        };
        button.setOnAction(loadHandler);

        stage.setScene(scene);
        stage.setTitle("cs1302 Image App!");
        stage.sizeToScene();
        stage.show();

    } // main

} // ImageApp
