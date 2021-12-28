package cs1302.ce10;

import java.util.Date;

/**
 * Abstract class that represents an {@code Assignment}.
 */
public abstract class Assignment {
    /** Total points value for this {@code Assignment}.*/
    private int totalPoints;
    /** Indicates if this is a bonus {@code Assignment}.*/
    private boolean bonus;
    /** {@link Course} Where this {@code Assignment} is assigned.*/
    private Course course;

    /**
     * Modifies the point total associated with this assignment.
     * @param pointValue the new point value.
     * @throws IllegalArgumentException if {@code pointValue}
     * is negative.
     */
    public void setPoints(int pointValue) {
        if (pointValue < 0) {
            throw new IllegalArgumentException("Constructor: Invalid point total");
        }
        this.totalPoints = pointValue;
    }

    /**
     * Updates wheter or not this assignment is a bonus assignment.
     * @param bonus the bonus indicator
     */
    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    /**
     * Modifies the {@link Course} that assigned this assignment.
     * @param course the course that assigned this assignment
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Returns wheter or not this assignment is a bonus.
     * @return if this assignment is a bonus assignment.
     */
    public boolean isBonus() {
        return this.bonus;
    }

    /**
     * Returns the number of points associated with this assignment.
     * @return the points associated with this {@code Assignment} object.
     */
    public int getPoints() {
        return this.totalPoints;
    }

    /**
     * Returns the course in which this quiz is assigned.
     * @return the {@link cs1302.ce10.Course} that assigned this assignment.
     */
    public Course getCourse() {
        return this.course;
    }

    /**
     * Throws a {@code NullPointerException} if any values in the varargs parameter, {@code o} are
     * {@code null}. The method performs no actions if all values in {@code o} are non-null.
     *
     * @param method the name of the calling method.
     * @param o varargs parameter containing all objects to verify.
     * @throws NullPointerException if any element of parameter {@code o} is null.
     */
    public void nullCheck(String method, Object ... o) {
        for (Object obj: o) {
            if (o == null) {
                throw new NullPointerException(method + ": Null Argument Provided");
            }
        }
    }

    /**
     * Throws a {@code NullPointerException} if any values in the varargs parameter {@code o}
     * or if the {@code date} parameter is null. The method performs no actions if all values in
     * {@code o} or if {@code date} are non-null.
     *
     * @param method the name of the calling method.
     * @param o varargs parameter containing all objects to verify.
     * @param date the {@code Date} object to verify.
     * @throws NullPointerException if any element of parameter {@code o} or {@code date} are null.
     */
    public void nullCheck(String method, Date date, Object ... o) {
        for (Object obj: o) {
            if (o == null) {
                throw new NullPointerException(method + ": Null argument Provided");
            }
        }
        if (date == null) {
            throw new NullPointerException("Date: Null argumetn Provided");
        }
    }

    /**
     * Saves this {@code Assignment} to a database.
     */
    public void save() {
        //some code
    }
}
