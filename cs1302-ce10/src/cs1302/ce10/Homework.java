package cs1302.ce10;

import java.util.Date;

/**
 * Represents a Homework assignment in the cs1302 mock eLC
 * application.
 *
 * @author Brad Barnes
 * @version 1.0; Feb 9 2019
 */
public class Homework extends Assignment {

    /** Due date of this homework assignment. */
    private Date dueDate;

    /**
     * Constructs a new {@code Homework} object with the specified
     * arguments.
     *
     * @param points the total points allocated to this homework.
     * @param bonus indicates if this is a bonus homework.
     * @param course the course where this homework is assigned.
     * @param dueDate the {@code java.util.Date} this homework is due.
     *
     * @throws IllegalArgumentException if {@code points} is negative
     * or if {@code dueDate} or {@code course} is {@code null}.
     */
    public Homework(int points, boolean bonus, Course course,
                    Date dueDate) {
        nullCheck("Homework", dueDate, course);

        if (points < 0) {
            throw new IllegalArgumentException("Homework Constructor: " +
                                               "Invalid homework point total");
        } // if
        setBonus(bonus);
        setPoints(points);
        setCourse(course);
        this.dueDate = dueDate;
    } // Homework

    /**
     * Updates the due date of this homework assignment.
     *
     * @param due the new due {@code java.util.Date}.
     * @throws NullPointerException if {@code due} is {@code null}.
     */
    public void setDueDate(Date due) {
        this.dueDate = due;
    } // setDueDate

    /**
     * Returns the due date of this homework assignment.
     *
     * @return the {@code java.util.Date} this homework is due.
     */
    public Date getDueDate() {
        return this.dueDate;
    } // getDueDate

} // Homework
