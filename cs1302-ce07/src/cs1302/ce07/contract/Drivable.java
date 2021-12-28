package cs1302.ce07.contract;

/**
 * Represents the interface for an object that is drivable.
 * Drivable objects can {@code speedUp} and {@code slowDown}.
 */
public interface Drivable {
    /**
     * Represents the license class of a {@code Drivable} object.
     */
    public enum LicenseClass {
        /**Represents a {@code Drivable} vehicle with license class of Non-Commercial Roadway.*/
        NON_COMMERCIAL_ROADWAY,

        /**Represents a {@code Drivable} vehicle with license class of Commercial Roadway.*/
        COMMERCIAL_ROADWAY,

        /**Represents a {@code Drivable} vehicle with license class of Watercraft.*/
        WATERCRAFT,

        /**Represents a {@code Drivable} vehicle with license class of Aircraft.*/
        AIRCRAFT,

        /**Represents a {@code Drivable} vehicle with license class of Unclassified.*/
        UNCLASSIFIED
    }

    /**
     * Returns the {@code LicenseClass} of the {@code Drivable}.
     * The {@code LicenseClass} of {@code UNCLASSIFIED} will be returned
     * by default.
     *
     * @return the {@code LicenseClass}
     */
    public default LicenseClass getLicenseClass() {
        return Drivable.LicenseClass.UNCLASSIFIED;
    }

    /**
     * Increases the speed of the object by the specified amount.
     * @param amount the specified amount in mph
     * @return true when the operation was successful; false otherwise
     */
    public boolean speedUp(double amount);

    /**
     * Decreases the speed of the object by the specified amount.
     * @param amount the specified amount in mph
     * @return true when the operation was successful; false otherwise
     */
    public boolean slowDown(double amount);

} // Drivable
