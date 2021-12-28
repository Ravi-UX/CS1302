package cs1302.ce20;

import javafx.application.Application;

/**
 * Driver for the {@code ImageApp} class.
 */
public class ImageDriver {

    /**
     * Main entry-point into the application.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        try {
            Application.launch(ImageApp.class, args);
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
            System.err.println("Likely due to X11 timeout. Logout and log back in...");
            System.exit(1);
        } // try
    } // main

} // ImageDriver
