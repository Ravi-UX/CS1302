package cs1302.ce20;

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
    Button load;
    Button zoomIn;
    Button zoomOut;
    Button actualSize;
    HBox bottomHbox;

    double imgH;
    double imgW;

    /**
     * Zoom helper method for zooming buttons.
     * @param d the amount to be zoomed by
     */
    private void zoom(double d) {
        double fitH = imgView.getFitHeight();
        double fitW = imgView.getFitWidth();
        if (d > 0.0) {
            fitH += 25.0;
            fitW += 25.0;
            imgView.setFitHeight(fitH);
            imgView.setFitWidth(fitW);
            if ((fitH + 25.0) * (fitW + 25.0) > 2 * imgH * imgW) {
                zoomIn.setDisable(true);
            }
            zoomOut.setDisable(false);
        } else {
            if (d < 0.0) {
                fitH -= 25.0;
                fitW -= 25.0;
                imgView.setFitHeight(fitH);
                imgView.setFitWidth(fitW);
                if ((fitH - 25.0) * (fitW - 25.0) < 50) {
                    zoomOut.setDisable(true);
                }
                zoomIn.setDisable(false);
            }
        }
    }

    /**
     * Initializes the bottom Hbox.
     */
    private void bottomHboxInit() {
        bottomHbox = new HBox(8);
        bottomHbox.setHgrow(zoomIn, Priority.ALWAYS);
        bottomHbox.setHgrow(zoomOut, Priority.ALWAYS);
        bottomHbox.setHgrow(actualSize, Priority.ALWAYS);
        zoomIn.setMaxWidth(Double.MAX_VALUE);
        zoomOut.setMaxWidth(Double.MAX_VALUE);
        actualSize.setMaxWidth(Double.MAX_VALUE);
        bottomHbox.getChildren().add(zoomIn);
        bottomHbox.getChildren().add(zoomOut);
        bottomHbox.getChildren().add(actualSize);
    }

    @Override
    public void start(Stage stage) {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        hbox = new HBox(8);
        Image img = new Image("http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png");
        imgView = new ImageView(img);
        field = new TextField("https://");
        load = new Button("Load");

        zoomIn = new Button("", new ImageView("file:resources/zoom-in-50.png"));
        zoomOut = new Button("", new ImageView("file:resources/zoom-out-50.png"));
        actualSize = new Button("", new ImageView("file:resources/actual-size-50.png"));
        bottomHboxInit();
        vbox.getChildren().add(hbox);
        vbox.getChildren().add(imgView);
        vbox.getChildren().add(bottomHbox);
        hbox.setHgrow(field, Priority.ALWAYS);
        hbox.getChildren().add(field);
        hbox.getChildren().add(load);

        EventHandler<ActionEvent> loadHandler = (ActionEvent event) -> {
            System.out.println(field.getText());
            try {
                Image image = new Image(field.getText());
                imgView.setImage(image);
                imgView.setFitWidth(image.getWidth());
                imgView.setFitHeight(image.getHeight());
                stage.sizeToScene();
                imgH = imgView.getImage().getHeight();
                imgW = imgView.getImage().getWidth();
            } catch (Exception e) {
                System.err.println("Invalid URL!");
            }
        };
        load.setOnAction(loadHandler);

        zoomIn.setOnAction((e) -> {
            zoom(+25);
            stage.sizeToScene();
        });
        zoomOut.setOnAction((e) -> {
            zoom(-25);
            stage.sizeToScene();
        });
        actualSize.setOnAction((e) -> {
            imgView.setFitWidth(imgW);
            imgView.setFitHeight(imgH);
            zoomOut.setDisable(false);
            zoomIn.setDisable(false);
            stage.sizeToScene();
        });

        stage.setScene(scene);
        stage.setTitle("cs1302 Image App!");
        stage.sizeToScene();
        stage.show();

    } // main

} // ImageApp
