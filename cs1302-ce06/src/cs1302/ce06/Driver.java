package cs1302.ce06;

import cs1302.ce06.impl.Car;
import cs1302.ce06.impl.Motorcycle;
import cs1302.ce06.contract.Drivable;

/**
 * A driver program to test the functionality of
 * {@code cs1302.ce06.impl.Car} and {@code cs1302.ce06.impl.Motorcycle} which implement
 * {@code cs1302.ce06.contract.Drivable}.
 */
public class Driver {

    /**
     * Attempts to speedup and slowdown the {@link cs1302.ce06.contract.Drivable} object
     * by a specified amount. If the {@link cs1302.ce06.contract.Drivable} object is unable
     * to speedup or slowdown by the specified amount, an appropriate message is
     * printed.
     *
     * @param vehicle the {@code Drivable} object to test
     * @param speedupAmount the amount to speedup the car
     * @param slowdownAmount the amount to slowdown the car
     */
    public static void test(Drivable vehicle, double speedupAmount,
                            double slowdownAmount) {
        System.out.println(vehicle);
        if (vehicle.speedUp(speedupAmount)) {
            System.out.println("The vehicle sped up by " + speedupAmount + " mph");
        } else {
            System.out.println("The vehicle cannot go that fast");
        } // if

        if (vehicle.slowDown(slowdownAmount)) {
            System.out.println("The vehicle slowed down by " + slowdownAmount + " mph");
        } else {
            System.out.println("The vehicle is cannot slow down by that amount");
        } // if

        System.out.println(vehicle);
    } // test

    /**
     * {@code main} method to test the functionality of {@code Motorcycle}
     * and {@code Car} classes.
     *
     * @param args the command-line arguments to the program
     */
    public static void main(String[] args) {
        Car fastCar = new Car(185.5);
        Car slowCar = new Car(75.0);
        Motorcycle fastBike = new Motorcycle(200.0);
        Motorcycle slowBike = new Motorcycle(5.0);

        System.out.println("--------------------");

        test(fastCar, 200.5, 20);
        System.out.println("--------------------");

        test(fastCar, 125, 20);
        System.out.println("--------------------");

        test(slowCar, 85, 20);
        System.out.println("--------------------");

        test(slowCar, 65, 65);
        System.out.println("--------------------");

        test(fastBike, 50, 50);
        System.out.println("--------------------");

        test(slowBike, 1, 10);
        System.out.println("--------------------");
    } // main
} // Driver
