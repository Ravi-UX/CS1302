package cs1302.game;

import java.util.*;
import java.io.*;

/**
 * Represents a {@code MinesweeperGame}.
 */
public class MinesweeperGame {
    int rows;
    int cols;
    int numMines;
    int numRounds = 0;
    int numMarked = 0;
    int numNoMines;
    int x;
    int y;
    String cmd = "";
    Scanner sc = new Scanner(System.in);
    boolean [][] mineLocations;
    boolean [] minesMarked;
    String [][] output;
    String [] cmds = {"nofog", "reveal", "r", "mark", "m", "guess", "g",
                      "noFog", "help", "h", "quit", "q"};

    /**
     * Constructs a {@code MinesweeperGame} object with the
     * specified seed file.
     * @param seed a file which contains the data
     * to create the {@code MineSweeperGame}
     */
    public MinesweeperGame (String seed) {
        try {
            File initFile = new File(seed);
            Scanner initSc = new Scanner(initFile);
            if (initSc.hasNextInt()) { //read in rows
                rows = initSc.nextInt();
            } else {
                System.err.println(fileFormatErr(seed));
                System.exit(3);
            }
            if (initSc.hasNextInt()) { //read in columns
                cols = initSc.nextInt();
            } else {
                System.err.println(fileFormatErr(seed));
                System.exit(3);
            }
            if (rows < 5 || cols < 5) {
                System.err.println(fileValueErr());
                System.exit(1);
            }
            if (initSc.hasNextInt()) { //read in number of mines
                numMines = initSc.nextInt();
            } else {
                System.err.println(fileFormatErr(seed));
                System.exit(3);
            }
            if (numMines > rows * cols) { //check if there are more mines than squares
                System.err.println(fileValueErr2());
                System.exit(1);
            }
            mineLocations = new boolean[rows][cols]; //initialize a boolean array of mines
            output = new String[rows][cols]; //initialize array that is printed to player
            numNoMines = rows * cols - numMines; //initialize var which holds num regular squares
            int r = 0;
            int c = 0;
            for (int i = 0; i < numMines; i++) { //loop to set mine locations in boolean arr to true
                if (initSc.hasNextInt()) {
                    r = initSc.nextInt();
                } else {
                    System.err.println(fileFormatErr(seed));
                    System.exit(3);
                }
                if (initSc.hasNextInt()) {
                    c = initSc.nextInt();
                } else {
                    System.err.println(fileFormatErr(seed));
                    System.exit(3);
                }
                if (r < rows && c < cols) {
                    mineLocations[r][c] = true;
                } else {
                    System.err.println(fileValueErr());
                    System.exit(1);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(fileNotFoundErr(seed));
            System.exit(1);
        }
    }

    /**
     * Returns a file not found error for a specified seed file.
     * @param seed specified seed file
     * @return a {@code String} containing the error.
     */
    public String fileNotFoundErr(String seed) {
        return "Seed file not Found Error: cannot create game with " + seed
            + ", because it cannot be found or cannot be read due to permission.";
    }

    /**
     * Returns a file format error for a specified seed file.
     * @param seed specified seed file
     * @return a {@code String} containing the error.
     */
    public String fileFormatErr(String seed) {
        return "Seed file Format Error: Cannot create game with " + seed
            + ", because it is not formatted correctly.";
    }

    /**
     * Returns a file value error for a seed file.
     * @return a {@code String} containing the error.
     */
    public String fileValueErr() {
        return "Seed file Value Error: Cannot create a mine at that location!";
    }

    /**
     * Returns a file value error when number of mines exceed number of squares.
     * @return a {@code String} containing the error.
     */
    public String fileValueErr2() {
        return "Seedfile Value Error: cannot create a mine field with that "
            + "many rows and/or columns!";
    }

    /**
     * Prints the welcome message for the {@code MinesweeperGame}.
     */
    public void printWelcome() {
        System.out.println("        _\n"
            +   "  /\\/\\ (_)_ __   ___  _____      _____  ___ _ __   ___ _ __\n"
            +  " /    \\| | \'_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ \'_ \\ / _ \\ \'__|\n"
            + "/ /\\/\\ \\ | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |\n"
            + "\\/    \\/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|\n"
            + "                 A L P H A   E D I T I O N |_| v2020.fa");
    }

    /**
     * Prints the mine field and the completed rounds for the {@code MinesweeperGame}.
     */
    public void printMineField() {
        System.out.println();
        System.out.println(" Rounds Completed: " + numRounds);
        System.out.println();
        //Loop through 2d array and print mine field to the user
        for (int r = 0; r < output.length; r++) {
            if (output.length > 10) {
                System.out.printf("%3s |", r);
            } else {
                System.out.printf("%2s |", r);
            }
            for (int c = 0; c < output[0].length; c++) {
                if (output[0].length > 10) {
                    if (output[r][c] != null) {
                        System.out.printf("%4s|", output[r][c]);
                    } else {
                        System.out.printf("%4s|", "");
                    }
                } else {
                    if (output[r][c] != null) {
                        System.out.printf("%3s|", output[r][c]);
                    } else {
                        System.out.printf("%3s|", "");
                    }
                }
            }
            System.out.println();
        }
        //Prints numbers which represent the columns
        if (output.length > 10) {
            System.out.print("    ");
        } else {
            System.out.print("   ");
        }
        if (output[0].length <= 10) {
            for (int i = 0; i < output[0].length; i++) {
                System.out.printf("%3s ", i);
            }
        } else {
            for (int i = 0; i < output[0].length; i++) {
                System.out.printf("%4s ", i);
            }
        }
        System.out.println("\n");
    }

    /**
     * Prints the game prompt to the player and interprets inputted commands.
     */
    public void promptUser() {
        System.out.print("minesweeper-alpha: ");
        cmd = (sc.next()).toLowerCase();
        //Check what command the user typed in
        if (inArr(cmd)) {
            if (cmd.equals("r") || cmd.equals("reveal")) {
                reveal();
                printMineField();
            }
            if (cmd.equals("m") || cmd.equals("mark")) {
                mark();
                printMineField();
            }
            if (cmd.equals("g") || cmd.equals("guess")) {
                guess();
                printMineField();
            }
            if (cmd.equals("nofog")) {
                noFog();
            }
            if (cmd.equals("h") || cmd.equals("help")) {
                help();
                printMineField();
            }
            if (cmd.equals("q") || cmd.equals("quit")) {
                System.out.println();
                System.out.println("Quitting the game...\nBye!");
                System.out.println();
                System.exit(0);
            }
        } else {
            System.out.println("Input Error: Command not recognized!");
            printMineField();
        }
    }

    /**
     * Contains the main loop for the {@code MinesweeperGame}.
     */
    public void play() {
        printWelcome();
        printMineField();
        //Main game loop
        while (true) {
            promptUser();
            sc.reset();
            if (isWon()) {
                printWin();
                System.exit(0);
            }
        }
    }

    /**
     * Handles the reveal command when it is inputted by the player.
     * Reveals the square and marks the specified square with the number
     * of mines in adjacent squares.
     * If a square with a mine is revealed, the player loses the {@code MinesweeperGame}.
     */
    public void reveal() {
        try {
            //Read in square coordinates
            x = sc.nextInt();
            y = sc.nextInt();
            try {
                /*Check if player revealed mine and if not put the number
                  of adjacent mines in the 2d array*/
                if (mineLocations[x][y] == false) {
                    output[x][y] = Integer.toString(getNumAdjMines(x, y));
                    //Reduce the number of squares, with no mines, left to mark
                    numNoMines--;
                    numRounds++;
                } else {
                    printLoss();
                    System.exit(0);
                }
            } catch (ArrayIndexOutOfBoundsException i) {
                System.out.println("Input Error: Index out of bounds!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Error: Command not recongnzied!");
        }
    }

    /**
     * Handles the mark command when it is inputted by the player.
     * Marks the specified square with an F and if the square contains a
     * mine, it increases {@code numMarked}, which tracks the number of mines marked,
     * by one.
     */
    public void mark() {
        try {
            //Read in square coordinates
            x = sc.nextInt();
            y = sc.nextInt();
            try {
                //Mark a square as containing a mine in the 2d array
                output[x][y] = "F";
                //Check if the location marked has a mine
                if (mineLocations[x][y] == true) {
                    //Increase the number of mines successfully marked by one
                    numMarked++;
                }
                numRounds++;
            } catch (ArrayIndexOutOfBoundsException i) {
                System.out.println("Input Error: Index out of bounds!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Error: Command not recongnzied!");
        }
    }

    /**
     * Handles the guess command when it is inputted by the player.
     * Marks the specified square with a ?.
     */
    public void guess() {
        try {
            //Read in square coordinates
            x = sc.nextInt();
            y = sc.nextInt();
            try {
                //Mark a square as a guess in the 2d array
                output[x][y] = "?";
                numRounds++;
            } catch (ArrayIndexOutOfBoundsException i) {
                System.out.println("Input Error: Index out of bounds!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Error: Command not recongnzied!");
        }
    }

    /**
     * Handles the nofog cheatcode when it is inputted by the player.
     * Prints the mine field and shows all mine locations for one round.
     */
    public void noFog() {
        numRounds++;
        System.out.println();
        System.out.println(" Rounds Completed: " + numRounds);
        System.out.println();
        for (int r = 0; r < output.length; r++) { //Loop through the 2d array and print minefield
            if (output.length > 10) {
                System.out.printf("%3s |", r);
            } else {
                System.out.printf("%2s |", r);
            }
            for (int c = 0; c < output[0].length; c++) {
                if (output[0].length > 10) {
                    if (output[r][c] != null) { //Prints the mines in the minefield
                        if (mineLocations[r][c] == true) {
                            System.out.print(" <" + output[r][c] + ">|");
                        } else {
                            System.out.printf("%4s|", output[r][c]);
                        }
                    } else {
                        if (mineLocations[r][c] == true) {
                            System.out.print(" < >|");
                        } else {
                            System.out.printf("%4s|", "");
                        }
                    }
                } else {
                    if (output[r][c] != null) { //Prints minefield with different format
                        if (mineLocations[r][c] == true) {
                            System.out.print("<" + output[r][c] + ">|");
                        } else {
                            System.out.printf("%3s|", output[r][c]);
                        }
                    } else {
                        if (mineLocations[r][c] == true) {
                            System.out.printf("< >|");
                        } else {
                            System.out.printf("%3s|", "");
                        }
                    }
                }
            }
            System.out.println();
        }
        if (output.length > 10) { //print the column numbers
            System.out.print("    ");
        } else {
            System.out.print("   ");
        }
        if (output[0].length <= 10) {
            for (int i = 0; i < output[0].length; i++) {
                System.out.printf("%3s ", i);
            }
        } else {
            for (int i = 0; i < output[0].length; i++) {
                System.out.printf("%4s ", i);
            }
        }
        System.out.println("\n");
    }

    /**
     * Handles the help command when it is inputted by the user.
     * Prints the commands available to use.
     */
    public void help() {
        numRounds++;
        System.out.println("Commands Available...");
        System.out.println(" - Reveal: r/reveal row col");
        System.out.println(" -   Mark: m/mark   row col");
        System.out.println(" -  Guess: g/guess  row col");
        System.out.println(" -   Help: h/help   row col");
        System.out.println(" -   Quit: q/quit   row col");
    }

    /**
     * Returns the number mines adjacent to a specified square on the mine field.
     * @param r the x coordinate of the square
     * @param c the y coordinate of the square
     * @return the number of mines adjacent to a given square
     */
    private int getNumAdjMines(int r, int c) {
        int adjMines = 0;
        //Left mine
        if (c - 1 > -1 && mineLocations[r][c - 1] == true) {
            adjMines++;
        }
        //Top left mine
        if (c - 1 > -1 && r - 1 > -1 && mineLocations[r - 1][c - 1] == true) {
            adjMines++;
        }
        //Bottom left mine
        if (c - 1 > -1 && r + 1 < rows && mineLocations[r + 1][c - 1] == true) {
            adjMines++;
        }
        //Right mine
        if (c + 1 < cols && mineLocations[r][c + 1] == true) {
            adjMines++;
        }
        //Top right mine
        if (r - 1 > -1 && c + 1 < cols && mineLocations[r - 1][c + 1] == true) {
            adjMines++;
        }
        //Bottom right mine
        if (r + 1 < rows && c + 1 < cols && mineLocations[r + 1][c + 1] == true ) {
            adjMines++;
        }
        //Bottom mine
        if (r + 1 < rows && mineLocations[r + 1][c] == true) {
            adjMines++;
        }
        //Top mine
        if (r - 1 > -1 && mineLocations[r - 1][c] == true) {
            adjMines++;
        }
        return adjMines;
    }

    /**
     * Returns wheter a command inputted by the player is in the {@code cmds} array.
     * @param cmd the command inputted by the player
     * @return {@code true} if the command is in the {@code cmds} array or {@code false} otherwise.
     */
    private boolean inArr(String cmd) {
        for (int i = 0; i < cmds.length; i++) {
            if (cmds[i].equals(cmd)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints a message if the player wins the {@code MinesweeperGame}.
     */
    public void printWin() {
        System.out.println();
        System.out.println("░░░░░░░░░▄░░░░░░░░░░░░░░▄░░░░ \"So Doge\"\n"
            + "░░░░░░░░▌▒█░░░░░░░░░░░▄▀▒▌░░░\n"
            + "░░░░░░░░▌▒▒█░░░░░░░░▄▀▒▒▒▐░░░ \"Such Score\"\n"
            + "░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐░░░\n"
            + "░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐░░░ \"Much Minesweeping\"\n"
            + "░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌░░░\n"
            + "░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒▌░░ \"Wow\"\n"
            + "░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐░░\n"
            + "░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄▌░\n"
            + "░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌░\n"
            + "▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒▐░\n"
            + "▐▒▒▐▀▐▀▒░▄▄▒▄▒▒▒▒▒▒░▒░▒░▒▒▒▒▌\n"
            + "▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒▒▒░▒░▒░▒▒▐░\n"
            + "░▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒░▒░▒░▒░▒▒▒▌░\n"
            + "░▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▄▒▒▐░░\n"
            + "░░▀▄▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▄▒▒▒▒▌░░\n"
            + "░░░░▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀░░░ CONGRATULATIONS!\n"
            + "░░░░░░▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀░░░░░ YOU HAVE WON!\n"
            + "░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▀▀░░░░░░░░ SCORE: " + (100.0 * rows * cols / numRounds));
        System.out.println();
    }

    /**
     * Prints a message if the player loses the {@code MinesweeperGame}.
     */
    public void printLoss() {
        System.out.println();
        System.out.println("Oh no... You revealed a mine!\n");
        System.out.println("  __ _  __ _ _ __ ___   ___    _____   _____ _ __\n"
            + " / _` |/ _` | \'_ ` _ \\ / _ \\  / _ \\ \\ / / _ \\ \'__|\n"
            + "| (_| | (_| | | | | | |  __/ | (_) \\ V /  __/ |\n"
            + " \\__, |\\__,_|_| |_| |_|\\___|  \\___/ \\_/ \\___|_|\n"
            + " |___/");
        System.out.println();
    }

    /**
     * Returns whether the player won the {@code MinesweeperGame} or not.
     * @return {@code true} if the player won and {@code false} otherwise
     */
    public boolean isWon() {
        if (numMarked == numMines && numNoMines == 0) {
            return true;
        }
        return false;
    }
}
