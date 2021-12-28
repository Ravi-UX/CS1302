package cs1302.ce15;

import java.util.Arrays;
import cs1302.Utility;
import cs1302.util.ArrayUtility;

/**
 * Driver class for {@code cs1302-ce15}.
 */
public class Driver {

    public static void main(String[] args) {
        String[] strings = new String[] {
            "bb",
            "aa",
            "dd",
            "cc"
        };

        Circle[] circles = new Circle[] {
            new Circle(5.0),
            new Circle(3.3),
            new Circle(4.1),
            new Circle(1.2)
        };

        System.out.println(Arrays.toString(strings));
        ArrayUtility.<String>sort(strings);
        System.out.println(Arrays.toString(strings));

        System.out.println(Arrays.toString(circles));
        ArrayUtility.<Circle>sort(circles);
        //ArrayUtility.<Circle>sort(circles, new AreaComparator());
        System.out.println(Arrays.toString(circles));

    } // main

} // Driver
