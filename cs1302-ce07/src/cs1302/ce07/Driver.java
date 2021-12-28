package cs1302.ce07;

import cs1302.ce07.contract.Drivable;
import cs1302.ce07.impl.Car;
import cs1302.ce07.impl.Motorcycle;

/**
 * A driver program to test the functionality of
 * {@code cs1302.ce07.contract.Drivable} objects.
 */
public class Driver {

    /**
     * Prints a fancy banner to standard output. This method is for internal use
     * only.
     *
     * @param text the banner text
     * @param width the banner width, in characters
     */
    private static void printBanner(String text, int width) {
        System.out.println(String.format("%0" + width + "d", 0).replace("0", "*"));
        System.out.println(text);
        System.out.println(String.format("%0" + width + "d", 0).replace("0", "*"));
    } // printBanner

    /**
     * Displays the license class of the {@code Drivable} object, and
     * attempts to speedup and slowdown the {@code cs1302.ce07.contract.Drivable} object
     * by a specified amount. If the {@code Drivable} object is unable
     * to speedup or slowdown by the specified amount, an appropriate message is
     * printed.
     *
     * @param d the {@code Drivable} to test
     * @param speedupAmount the amount to speedup
     * @param slowdownAmount the amount to slowdown
     */
    public static void test(Drivable d, double speedupAmount, double slowdownAmount) {
        printBanner("TEST: " + d, 80);

        System.out.println("License Class: " + d.getLicenseClass());
        if (d.speedUp(speedupAmount)) {
            System.out.println("The driveable sped up by " + speedupAmount + " mph");
        } else {
            System.out.println("The driveable cannot go that fast");
        } // if
        System.out.println(d);

        if (d.slowDown(slowdownAmount)) {
            System.out.println("The driveable slowed down by " + slowdownAmount + " mph");
        } else {
            System.out.println("The driveable cannot slow down by that amount");
        } // if
        System.out.println(d);
    } // test

    /**
     * The main entry point of the program.
     * @param args the command-line arguments to the program
     */
    public static void main(String[] args) {
        Drivable[] drivables = new Drivable[] {
            new Car(185.5),
            new Car(75.0),
            new Motorcycle(190.0),
            new Motorcycle(60.0)
        };
        for (int i = 0; i < drivables.length; i++) {
            test(drivables[i], 200.5, 20);
            test(drivables[i], 50, 30);
        }
    } // main

} // Driver
