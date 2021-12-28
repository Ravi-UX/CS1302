package cs1302.ce07.impl;

import cs1302.ce07.contract.Drivable;

/**
 * Represents a {@code Motorcycle} and implements the
 * {@link cs1302.ce07.contract.Drivable} interface.
 */
public class Motorcycle implements Drivable {
    private double speed = 0;
    private double maxSpeed;

    /**
     * Constructs a {@code Motorcycle} object with the
     * given maximum speed and will default to zero if the
     * given maximum speed is negative.
     *
     * @param maxSpeed the maximum speed of the {@code Motorcycle}
     */
    public Motorcycle (double maxSpeed) {
        if (maxSpeed >= 0) {
            this.maxSpeed = maxSpeed;
        } else {
            this.maxSpeed = 0;
        }
    }

    /**
     * Will decrease the speed of the {@code Motorcycle} by the
     * given amount if the final speed isn't negative.
     *
     * @param amount the amount the speed should be decreased by
     * @return {@code true} if the speed was decreased and {@code false} otherwise
     */
    @Override
    public boolean slowDown(double amount) {
        if (speed - amount >= 0) {
            speed -= amount;
            return true;
        }
        return false;
    }

    /**
     * Will increase the speed of the {@code Motorcycle} by the
     * given amount if the final speed isn't greater than the maximum speed.
     *
     * @param amount the amount the speed should be increased by
     * @return {@code true} if the speed was increased and {@code false} otherwise
     */
    @Override
    public boolean speedUp(double amount) {
        if (speed + amount <= maxSpeed) {
            speed += maxSpeed;
            return true;
        }
        return false;
    }

    /**
     * Returns the license class of this {@code Motorcycle} object.
     *
     * @return license class of {@code Motorcycle}
     */
    @Override
    public Drivable.LicenseClass getLicenseClass() {
        return Drivable.LicenseClass.NON_COMMERCIAL_ROADWAY;
    }

    /**
     * Returns a {@code String} representation of the {@code Motorcycle} in the format
     * Motorcycle(speed: {@code speed}, maxspeed: {@code maxSpeed}).
     * @return String representation of {@code Motorcycle}.
     */
    @Override
    public String toString() {
        return String.format("Motorcycle(speed: %.2f, maxspeed: %.2f)", speed, maxSpeed);
    }
}
