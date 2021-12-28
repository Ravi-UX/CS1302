package cs1302.ce14;

import java.util.Arrays;

/**
 * Driver class for {@code cs1302-ce14}.
 */
public class Driver {

    /**
    * Given a reference to an array specified by {@code array}, fill each
    * element by assigning it the value specified by {@code val}.
    *
    * @param <T>    element type
    * @param array  array to fill
    * @param val    value to assign to each element
    */
    public static <T> void fill(T[] array, T val) {
        for (int i = 0; i < array.length; i++) {
            array[i] = val;
        }
    } // fill

    public static void main(String[] args) {

        // SOME AREAS FOR TESTING

        Shape[] shapes = new Shape[] {
            new Circle(2.0),
            new Ellipse(3.2, 2.8),
            new Rectangle(Math.PI, 4.0)
        };

        Circle[] circles = new Circle[] {
            new Circle(4.5),
            new Circle(1.0),
            new Circle(2.3)
        };

        Rectangle[] rectangles = new Rectangle[] {
            new Square(2.0),
            new Rectangle(1.0, 4.0),
            new Square(1.41421356237),
            new Rectangle(2.0, 1.0)
        };

        // YOUR CODE DOWN HERE
        String[] strings = new String[] { "i", "j" };
        Driver.<Object>fill(strings, 2.0);
        System.out.println(Arrays.toString(strings));
    } // main

} // Driver
