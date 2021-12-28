package cs1302.arcade;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Priority;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.Pos;


/**
 * Application subclass for {@code ArcadeApp}.
 * @version 2019.fa
 */
public class ArcadeApp extends Application {

    VBox root = new VBox();                 // main container
    VBox titleCont = new VBox();
    HBox dialogBox = new HBox();            // dialog box to display info
    HBox scoreBoard = new HBox(20);
    Text blackScore = new Text();
    Text whiteScore = new Text();
    Text dialog = new Text();
    GridPane gameBoard = new GridPane();    // gameboard
    GridPane graphic = new GridPane();
    Button play = new Button("Play!");

    /**
     * {@code Enum} which represents the color of the piece.
     */
    enum PieceColor {
        BLACK,
        WHITE
    }

    PieceColor currColor = PieceColor.BLACK;
    Image black = new Image("file:resources/black.png");
    Image white = new Image("file:resources/white.png");
    PieceColor[][] boardState = new PieceColor[8][8];
    int row;
    int col;
    int blkScore = 0;
    int whtScore = 0;
    Alert alert;

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {
        //Initialize title screen
        titleInit();
        //Set initial dialog and score
        dialog.setText("Welcome to Reversi! First player to 20 wins. Black goes first.");
        dialog.setWrappingWidth(400);
        dialogBox.getChildren().addAll(dialog);
        blackScore.setText("Black: " + blkScore);
        whiteScore.setText("White: " + whtScore);
        scoreBoard.getChildren().addAll(blackScore, whiteScore);
        boardInit();
        //Add scoreboard, gameboard, and dialog box to VBox
        root.getChildren().addAll(scoreBoard, gameBoard, dialogBox);
        //Initialize stackpane for the title menu
        StackPane stack = new StackPane();
        StackPane.setAlignment(play, Pos.BOTTOM_CENTER);
        stack.getChildren().addAll(graphic, play);

        titleCont.getChildren().addAll(stack);
        //Set intial scene
        Scene title = new Scene(titleCont);
        //Change scene to game when button is pressed
        Scene scene = new Scene(root);
        stage.setMaxWidth(1280);
        stage.setMaxHeight(720);
        stage.setTitle("cs1302-arcade!");
        stage.setScene(title);
        play.setOnAction(e -> stage.setScene(scene));
        stage.sizeToScene();
        stage.show();
    } // start

    /**
     * Initializes the title scene.
     */
    public void titleInit() {
        //Create a zoomed in reversi board
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                Rectangle square = new Rectangle(100, 100);
                square.setFill(Color.GREEN);
                square.setStroke(Color.BLACK);
                graphic.add(square, y, x);
            }
        }
        //Put large pieces in the middle
        Rectangle sqr = new Rectangle(100, 100);
        sqr.setFill(Color.GREEN);
        sqr.setStroke(Color.BLACK);
        ImageView blk = new ImageView(black);
        blk.setFitWidth(100);
        blk.setFitHeight(100);
        ImageView blck = new ImageView(black);
        blck.setFitWidth(100);
        blck.setFitHeight(100);
        graphic.add(new StackPane(sqr, blk), 1, 1);
        graphic.add(new StackPane(sqr, blck), 2, 2);
        ImageView wht = new ImageView(white);
        wht.setFitWidth(100);
        wht.setFitHeight(100);
        ImageView whte = new ImageView(white);
        whte.setFitWidth(100);
        whte.setFitHeight(100);
        graphic.add(new StackPane(sqr, wht), 2, 1);
        graphic.add(new StackPane(sqr, whte), 1, 2);
    }

    /**
     * Initializes the game board for Reversi.
     */
    public void boardInit() {
        //Loop through gird pane and init each square of gameboard
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Rectangle square = new Rectangle(50, 50);
                square.setFill(Color.GREEN);
                square.setStroke(Color.BLACK);
                gameBoard.add(new StackPane(square), y, x);

                //Register mouse event handler for each square
                square.setOnMouseClicked(e -> {
                    for (Node node: gameBoard.getChildren()) {
                        //Get the row and column of clicked square
                        if (node.getBoundsInParent().contains(e.getSceneX(), e.getSceneY() - 25)) {
                            row = GridPane.getRowIndex(node).intValue();
                            col = GridPane.getColumnIndex(node).intValue();
                        }
                    }
                    //Check if the move was valid
                    adjacentCheck();
                });
            }
        }
        //Initialize the middle 4 pieces on the gameboard
        updateBoard(3, 3, PieceColor.BLACK);
        updateBoard(4, 4, PieceColor.BLACK);
        updateBoard(4, 3, PieceColor.WHITE);
        updateBoard(3, 4, PieceColor.WHITE);
    }

    /**
     * Adds pieces of the specified color at the specified location.
     * @param x the specified row
     * @param y the specified column
     * @param color the specified color
     */
    public void updateBoard(int x, int y, PieceColor color) {
        Rectangle sqr = new Rectangle(50, 50);
        sqr.setFill(Color.GREEN);
        sqr.setStroke(Color.BLACK);
        ImageView piece;
        //Init image view based on color
        if (color == PieceColor.BLACK) {
            piece = new ImageView(black);
        } else {
            piece = new ImageView(white);
        }
        piece.setFitWidth(50);
        piece.setFitHeight(50);
        piece.setPreserveRatio(true);
        //Stack the piece on top of the square in the grid pane
        gameBoard.add(new StackPane(sqr, piece), y, x);
        boardState[x][y] = color;
    }

    /**
     * Checks if the move is valid or not and flips the pieces accordingly.
     */
    public void adjacentCheck() {
        boolean adjacent = false;
        //The move is valid if at least one of the conditions are met
        if (flipTop()) {
            adjacent = true;
        }
        if (flipBottom()) {
            adjacent = true;
        }
        if (flipLeft()) {
            adjacent = true;
        }
        if (flipRight()) {
            adjacent = true;
        }
        if (flipTopLeft()) {
            adjacent = true;
        }
        if (flipTopRight()) {
            adjacent = true;
        }
        if (flipBottomLeft()) {
            adjacent = true;
        }
        if (flipBottomRight()) {
            adjacent = true;
        }
        //If the move is valid, the turn is over
        if (adjacent) {
            updateBoard(row, col, currColor);
            updateScore();

            if (currColor == PieceColor.BLACK) {
                currColor = PieceColor.WHITE;
                dialog.setText("White's turn.");
            } else {
                currColor = PieceColor.BLACK;
                dialog.setText("Black's turn.");
            }
            checkGameOver();
        } else {
            //If the move is invalid a message is shown at the bottom
            dialog.setText("Invalid move! You must place your piece on an empty square so that one"
                + " or more of the opponet's pieces are between yours!");
        }
    }

    /**
     * Checks if the move is valid and flips the pieces on the top.
     * @return true if the move is valid
     */
    public boolean flipTop() {
        //Check if the move is valid
        if (row - 1 > -1 && currColor == boardState[row - 1][col]) {
            return false;
        }
        if (row - 1 > -1 && boardState[row - 1][col] == null) {
            return false;
        }
        //Check to see if opponent's piece is between current player's
        int i = 2;
        boolean valid = false;
        while (row - i > -1) {
            if (boardState[row - i][col] == null) {
                return false;
            }
            if (currColor == boardState[row - i][col]) {
                valid = true;
                break;
            }
            i++;
        }
        //If move is valid, flip
        i = 1;
        while (valid && currColor != boardState[row - i][col]) {
            if (boardState[row - i][col] != null) {
                updateBoard(row - i, col, currColor);
                i++;
            }
        }
        return valid;
    }

    /**
     * Checks if the move is valid and flips the pieces on the bottom.
     * @return true if the move is valid
     */
    public boolean flipBottom() {
        //Check if the move is valid
        if (row + 1 < 8 && currColor == boardState[row + 1][col]) {
            return false;
        }
        if (row + 1 < 8 && boardState[row + 1][col] == null) {
            return false;
        }
        //Check to see if opponent's piece is between current player's
        int i = 2;
        boolean valid = false;
        while (row + i < 8) {
            if (boardState[row + i][col] == null) {
                return false;
            }
            if (currColor == boardState[row + i][col]) {
                valid = true;
                break;
            }
            i++;
        }
        //If move is valid, flip
        i = 1;
        while (valid && currColor != boardState[row + i][col]) {
            if (boardState[row + i][col] != null) {
                updateBoard(row + i, col, currColor);
                i++;
            }
        }
        return valid;
    }

    /**
     * Checks if the move is valid and flips the pieces on the left.
     * @return true if the move is valid
     */
    public boolean flipLeft() {
        //Check if the move is valid
        if (col - 1 > -1 && currColor == boardState[row][col - 1]) {
            return false;
        }
        if (col - 1 > -1 && boardState[row][col - 1] == null) {
            return false;
        }
        //Check to see if opponent's piece is between current player's
        int i = 2;
        boolean valid = false;
        while (col - i > -1) {
            if (boardState[row][col - i] == null) {
                return false;
            }
            if (currColor == boardState[row][col - i]) {
                valid = true;
                break;
            }
            i++;
        }
        //If move is valid, flip
        i = 1;
        while (valid && currColor != boardState[row][col - i]) {
            if (boardState[row][col - i] != null) {
                updateBoard(row, col - i, currColor);
                i++;
            }
        }
        return valid;
    }

    /**
     * Checks if the move is valid and flips the pieces on the right.
     * @return true if the move is valid
     */
    public boolean flipRight() {
        //Check if the move is valid
        if (col + 1 < 8 && currColor == boardState[row][col + 1]) {
            return false;
        }
        if (col + 1 < 8 && boardState[row][col + 1] == null) {
            return false;
        }
        //Check to see if opponent's piece is between current player's
        int i = 2;
        boolean valid = false;
        while (col + i < 8) {
            if (boardState[row][col + i] == null) {
                return false;
            }
            if (currColor == boardState[row][col + i]) {
                valid = true;
                break;
            }
            i++;
        }
        //If move is valid, flip
        i = 1;
        while (valid && currColor != boardState[row][col + i]) {
            if (boardState[row][col + i] != null) {
                updateBoard(row, col + i, currColor);
                i++;
            }
        }
        return valid;
    }

    /**
     * Checks to see if the move is valid and flips the pieces on the top left diagonal.
     * @return true if the move is valid
     */
    public boolean flipTopLeft() {
        //Check if the move is valid
        if (row - 1 > -1 && col - 1 > -1 && currColor == boardState[row - 1][col - 1]) {
            return false;
        }
        if (row - 1 > -1 && col - 1 > -1 && boardState[row - 1][col - 1] == null) {
            return false;
        }
        //Check to see if opponent's piece is between current player's
        int i = 2;
        boolean valid = false;
        while (row - i > -1 && col - i > -1) {
            if (boardState[row - i][col - i] == null) {
                return false;
            }
            if (currColor == boardState[row - i][col - i]) {
                valid = true;
                break;
            }
            i++;
        }
        //If move is valid, flip
        i = 1;
        while (valid && currColor != boardState[row - i][col - i]) {
            if (boardState[row - i][col - i] != null) {
                updateBoard(row - i, col - i, currColor);
                i++;
            }
        }
        return valid;
    }

    /**
     * Checks to see if the move is valid and flips the pieces on the top right diagonal.
     * @return true if the move is valid
     */
    public boolean flipTopRight() {
        //Check if the move is valid
        if (row - 1 > -1 && col + 1 < 8 && currColor == boardState[row - 1][col + 1]) {
            return false;
        }
        if (row - 1 > -1 && col + 1 < 8 && boardState[row - 1][col + 1] == null) {
            return false;
        }
        //Check to see if opponent's piece is between current player's
        int i = 2;
        boolean valid = false;
        while (row - i > -1 && col + i < 8) {
            if (boardState[row - i][col + i] == null) {
                return false;
            }
            if (currColor == boardState[row - i][col + i]) {
                valid = true;
                break;
            }
            i++;
        }
        //If move is valid, flip
        i = 1;
        while (valid && currColor != boardState[row - i][col + i]) {
            if (boardState[row - i][col + i] != null) {
                updateBoard(row - i, col + i, currColor);
                i++;
            }
        }
        return valid;
    }

    /**
     * Checks to see if the move is valid and flips the pieces on the bottom left diagonal.
     * @return true if the move is valid
     */
    public boolean flipBottomLeft() {
        //Check if the move is valid
        if (row + 1 < 8 && col - 1 > -1 && currColor == boardState[row + 1][col - 1]) {
            return false;
        }
        if (row + 1 < 8 && col - 1 > -1 && boardState[row + 1][col - 1] == null) {
            return false;
        }
        //Check to see if the opponent's piece is between current player's
        int i = 2;
        boolean valid = false;
        while (row + i < 8 && col - i > -1) {
            if (boardState[row + i][col - i] == null) {
                return false;
            }
            if (currColor == boardState[row + i][col - i]) {
                valid = true;
                break;
            }
            i++;
        }
        //If move is valid, flip
        i = 1;
        while (valid && currColor != boardState[row + i][col - i]) {
            if (boardState[row + i][col - i] != null) {
                updateBoard(row + i, col - i, currColor);
                i++;
            }
        }
        return valid;
    }

    /**
     * Checks to see if the move is valid and flips the pieces on the bottom right diagonal.
     * @return true if the move is valid
     */
    public boolean flipBottomRight() {
        //Check if the move is valid
        if (row + 1 < 8 && col + 1 < 8 && currColor == boardState[row + 1][col + 1]) {
            return false;
        }
        if (row + 1 < 8 && col + 1 < 8 && boardState[row + 1][col + 1] == null) {
            return false;
        }
        //Check to see if the opponent's piece is between current player's
        int i = 2;
        boolean valid = false;
        while (row + i < 8 && col + i < 8) {
            if (boardState[row + i][col + i] == null) {
                return false;
            }
            if (currColor == boardState[row + i][col + i]) {
                valid = true;
                break;
            }
            i++;
        }
        //If move is valid, flip
        i = 1;
        while (valid && currColor != boardState[row + i][col + i]) {
            if (boardState[row + i][col + i] != null) {
                updateBoard(row + i, col + i, currColor);
                i++;
            }
        }
        return valid;
    }

    /**
     * Updates the score after a turn has ended.
     */
    public void updateScore() {
        blkScore = 0;
        whtScore = 0;
        //Loop through the array which represents the pieces on the board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                //Check if the piece is white or black and increase score
                if (boardState[row][col] == PieceColor.BLACK) {
                    blkScore++;
                } else {
                    if (boardState[row][col] == PieceColor.WHITE) {
                        whtScore++;
                    }
                }
            }
        }
        //Update the text displayed to the player
        blackScore.setText("Black: " + blkScore);
        whiteScore.setText("White: " + whtScore);
    }

    /**
     * Checks if the game has ended.
     */
    public void checkGameOver() {
        //If either player reaches a score of at least 20, an alert is displayed
        if (blkScore >= 20 || whtScore >= 20) {
            alert = new Alert(AlertType.INFORMATION);
            alert.setResizable(true);
            alert.setHeight(400);
            alert.setWidth(650);
            if (blkScore >= 20) {
                alert.setContentText("Game Over! Black has reached 20 first! The final score is: "
                    + "Black: " + blkScore + " White: " + whtScore + ". A new game has begun!");
            }
            if (whtScore >= 20) {
                alert.setContentText("Game Over! White has reached 20 first! The final score is: "
                    + "Black: " + blkScore + " White: " + whtScore + ". A new game has begun!");
            }
            alert.show();
            //After the alert is displayed the game is reset and a new game starts
            whtScore = 0;
            blkScore = 0;
            currColor = PieceColor.BLACK;
            dialog.setText("Welcome to Reversi! First player to 20 wins. Black goes first.");
            blackScore.setText("Black: " + blkScore);
            whiteScore.setText("White: " + whtScore);
            boardState = new PieceColor[8][8];
            boardInit();
        }
    }

} // ArcadeApp
