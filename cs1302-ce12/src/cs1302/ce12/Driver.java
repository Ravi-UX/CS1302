package cs1302.ce12;

/**
 * Driver program for cs1302 class exercise 12 using various types of
 * container objects.
 *
 * @author Brad Barnes and Supa' Mike
 * @version 1.0
 */

public class Driver {

    /**
     * Creates objects for each type of container to check basic functionality.
     * @param args takes command line arguments
     */
    public static void main(String[] args) {

        //Declare objects of all of our container types
        Container sc = new Container("I wish I had a next reference");
        Container dc = new Container(4.5);
        Container ic = new Container(7);
        Container bc = new Container(true);

        //Print the contents of each container
        System.out.println(sc.get());
        System.out.println(dc.get());
        System.out.println(ic.get());
        System.out.println(bc.get());

    } // main

} // Driver
