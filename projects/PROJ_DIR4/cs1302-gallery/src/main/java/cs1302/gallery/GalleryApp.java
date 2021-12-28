package cs1302.gallery;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.text.Text;
import javafx.scene.layout.Priority;
import java.net.URL;
import javafx.application.Platform;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.util.Random;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ProgressBar;

/**
 * Represents an iTunes GalleryApp.
 */
public class GalleryApp extends Application {

    HBox tools = new HBox();
    ToolBar toolBar;
    //Play and update buttons
    Button play;
    Button update;
    TextField searchField;
    Text label;
    //The main container for the pictures in the grid
    GridPane pictureGrid = new GridPane();
    int numResults;
    JsonArray results;
    //Image array for images to be displayed
    Image[][] display;
    //Array for remaining images to be swapped between
    Image[] hidden;
    Alert alert;
    Timeline timer = new Timeline();
    KeyFrame keyFr;
    //Default search term
    String defaultTerm = "rap";
    ProgressBar p = new ProgressBar(1);

    /**
     * Start method for the JavaFX Application.
     */
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        //Initialize the toolbar
        toolBarInit();
        //Run default query on new thread
        runNow(() -> {
            defaultQuery();
            Platform.runLater(() -> {
                //Initialize picture grid
                pictureGridInit();
                //Set handlers for update and play buttons
                update.setOnAction(this::getQuery);
                play.setOnAction(this::playHandler);
                //Add componets to root container includuing menu custom component
                root.getChildren().addAll(new MenuComp(), tools, pictureGrid, p);
                Scene scene = new Scene(root);
                stage.setMaxWidth(1280);
                stage.setMaxHeight(720);
                stage.setTitle("GalleryApp!");
                stage.setScene(scene);
                stage.sizeToScene();
                stage.show();
            });
        });
    } // start

    /**
     * Helper method to initalize toolbar.
     */
    private void toolBarInit() {
        //Create play and update buttons
        play = new Button("Pause");
        update = new Button("Update Images");
        //Create text field and label
        searchField = new TextField(defaultTerm);
        label = new Text("Search Query: ");
        //Add elements to toolbar
        toolBar = new ToolBar(play, label, searchField, update);
        HBox.setHgrow(toolBar, Priority.ALWAYS);
        tools.getChildren().add(toolBar);
    }

    /**
     * Handler for the play/pause button.
     * @param e the ActionEvent to be passed in
     */
    private void playHandler(ActionEvent e) {
        //Modify timer and button text depending on state of button when clicked
        if (play.getText().equals("Pause")) {
            timer.pause();
            play.setText("Play");
        } else {
            timer.play();
            play.setText("Pause");
        }
    }

    /**
     * Method to download results from a search query and populate image arrays.
     */
    private void query() {
        try {
            String sUrl = "https://itunes.apple.com/search?term="
                + URLEncoder.encode(searchField.getText(), "UTF-8")  + "&limit=50&media=music";
            URL url = new URL(sUrl); //Create URL from string
            //Download the content from iTunes and parse through Json response for Json Object
            InputStreamReader reader = new InputStreamReader(url.openStream());
            JsonElement je = JsonParser.parseReader(reader);
            JsonObject root = je.getAsJsonObject();
            /*Get json results array and remove duplicates and images which
              have a null value from the Json array*/
            results = rmDuplicates(root.getAsJsonArray("results"));
            numResults = results.size();
            rmNull();
            if (numResults < 21) { //Display alert if there aren't enough pictures
                alert = new Alert(AlertType.WARNING);
                alert.setResizable(true);
                alert.setHeight(400);
                alert.setWidth(650);
                alert.setContentText("Invalid search results!"
                    + " Displaying default image query.");
                alert.show();
                runNow(() -> {
                    defaultQuery();
                    Platform.runLater(() -> pictureGridInit());
                });
            } else {
                //Populate image arrays if there are enough pictures
                display = new Image[4][5];
                int curr = 0;
                JsonElement artworkUrl100;
                String artworkUrl = "";
                Double n = 0.05;
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 5; y++) {
                        /*Convert the Json element to a string and remove quotes
                          at the end before creating image object and adding to array*/
                        artworkUrl100 = results.get(curr)
                            .getAsJsonObject().get("artworkUrl100");
                        artworkUrl = artworkUrl100 + "";
                        display[x][y] =
                            new Image(artworkUrl.substring(1, artworkUrl.length() - 1));
                        n += 0.05;
                        p.setProgress(n);
                        curr++;
                    }
                }
                //Assign remaining elements to second array
                hidden = new Image[numResults - 20];
                for (int i = 0; i < hidden.length; i++) {
                    artworkUrl100 =
                       results.get(curr + i).getAsJsonObject().get("artworkUrl100");
                    artworkUrl = artworkUrl100 + "";
                    hidden[i] = new Image(artworkUrl.substring(1, artworkUrl.length() - 1));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Query when applicaiton is first started.
     */
    public void defaultQuery() {
        try {
            //Download results based on default search query
            String sUrl = "https://itunes.apple.com/search?term="
                + URLEncoder.encode(defaultTerm, "UTF-8")  + "&limit=50&media=music";
            URL url = new URL(sUrl);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            JsonElement je = JsonParser.parseReader(reader);
            JsonObject root = je.getAsJsonObject();
            results = rmDuplicates(root.getAsJsonArray("results"));
            numResults = results.size();
            rmNull();
            display = new Image[4][5];
            int curr = 0;
            JsonElement artworkUrl100;
            String artworkUrl = "";
            //Assign elements from Json array to 2d array
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 5; y++) {
                    artworkUrl100 = results.get(curr)
                        .getAsJsonObject().get("artworkUrl100");
                    artworkUrl = artworkUrl100 + "";
                    display[x][y] =
                    new Image(artworkUrl.substring(1, artworkUrl.length() - 1));
                    curr++;
                }
            }
            //Assign remaining elements to second array
            hidden = new Image[numResults - 20];
            for (int i = 0; i < hidden.length; i++) {
                artworkUrl100 = results.get(curr + i)
                    .getAsJsonObject().get("artworkUrl100");
                artworkUrl = artworkUrl100 + "";
                hidden[i] = new Image(artworkUrl.substring(1, artworkUrl.length() - 1));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Method to swap random images between the visible and hidden Array.
     */
    private void randomImageSwap() {
        runNow(() -> {
            //Swap random images between hidden and visible arrays
            Random r = new Random();
            int x = r.nextInt(3);
            int y = r.nextInt(4);
            Image temp = display[x][y];
            int i = r.nextInt(hidden.length - 1);
            display[x][y] = hidden[i];
            hidden[i] = temp;
            //Insert the random image at a random location in the picture grid
            Platform.runLater(createRunnable(x, y, new ImageView(display[x][y])));
        });
    }

    /**
     * Event handler for the update images button.
     * @param e the ActionEvent to be passed in
     */
    private void getQuery(ActionEvent e) {
        query();
        pictureGridInit();
    }

    /**
     * Creates a Runnable target to bypass local variable
     * error for lambdas. The target adds the ImageView to the GridPane. Taken from project FAQ.
     *
     * @param x the specified row where the ImageView needs to be added
     * @param y the specified colomun where teh ImageView needs to be added
     * @param imgView the specified ImageView to be added
     * @return the target Runnable
     */
    Runnable createRunnable(int x, int y, ImageView imgView) {
        Runnable target = () -> {
            pictureGrid.add(imgView, y, x);
        };
        return target;
    }

    /**
     * Initialize the picture grid.
     */
    private void pictureGridInit() {
        ImageView imgView;
        //Add images from visible 2d array to picture grid
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 5; y++) {
                imgView = new ImageView(display[x][y]);
                imgView.setFitHeight(100);
                imgView.setFitWidth(100);
                pictureGrid.add(imgView, y, x);
            }
        }
        //Do random image swap every 2 seconds
        timer.stop();
        timer.getKeyFrames().clear();
        keyFr = new KeyFrame(Duration.seconds(2), (e) -> randomImageSwap());
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.getKeyFrames().add(keyFr);
        timer.play();
    }

    /**
     * Removes null elements from Json Array.
     */
    private void rmNull() {
        JsonObject result;
        JsonElement artworkUrl100;
        //Remove the object if the artwork element is null
        for (int i = 0; i < numResults; i++) {
            result = results.get(i).getAsJsonObject();
            artworkUrl100 = result.get("artworkUrl100");
            if (artworkUrl100 == null) {
                results.remove(i);
            }
        }
        //Update the variable for number of results
        numResults = results.size();
    }

    /**
     * Removes duplicates from specified Json Array and returns new Array.
     * @param j the sepcified array
     * @return the new array
     */
    private JsonArray rmDuplicates(JsonArray j) {
        //Create temporary Json array
        JsonArray temp = new JsonArray(j.size());
        //Only add elements to temporary array if they are not already in it
        for (int i = 0; i < j.size(); i++) {
            if (!temp.contains(j.get(i))) {
                temp.add(j.get(i));
            }
        }
        //Return temporary array
        return temp;
    }

    /**
     * Creates and starts a new daemon thread. From reading.
     *
     *@param target the object whose run method is invoked when
     * this thread is started
     */
    private static void runNow(Runnable target) {
        //Create and start new thread
        Thread thread = new Thread(target);
        thread.setDaemon(true);
        thread.start();
    }


} // GalleryApp
