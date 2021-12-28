package cs1302.game;

import cs1302.game.MinesweeperGame;

/**
 * Main driver program for the {@code MinesweeperGame}.
 */
public class MinesweeperDriver {
    public static void main (String[] args) {
        //Makes sure input has two tokens
        if (args.length != 2) {
            System.out.println("Unable to interpret supplied command-line arguments.");
            System.exit(1);
        } else {
            //Interprets command with --seed option
            if (args[0].equals("--seed")) {
                MinesweeperGame g = new MinesweeperGame(args[1]);
                g.play();
            }
            //Interprets command with --gen option
            if (args[0].equals("--gen")) {
                System.out.println("Seedfile generation not supported.");
                System.exit(2);
            } else {
                System.out.println("Unable to interpret supplied command-line arguments.");
                System.exit(1);
            }
        }
    }
}
