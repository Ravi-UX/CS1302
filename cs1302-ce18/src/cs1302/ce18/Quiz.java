package cs1302.ce18;

/**
 * Represents a quiz in the cs1302 mock eLC
 * application.
 *
 * @author Brad Barnes
 * @version 1.1; Mar 4 2019
 */
public class Quiz {
    /** A number used to identify this quiz object. */
    private int number;
    /** Time (in minutes) students have to complete the quiz. */
    private int timeLimit;
    /** Total point value for this quiz. */
    private int points;
    /** Indicates if this is a bonus quiz. */
    private boolean bonus;

    /**
     * Constructs a new {@code Quiz} object with the specified
     * arguments.
     *
     * @param number the quiz identifier.
     * @param points the total points allocated to this quiz.
     * @param bonus indicates if this is a bonus quiz.
     * @param limit the time (in minutes) students have to complete
     * this quiz.
     *
     * @throws IllegalArgumentException if {@code number}, {@code points}
     * or {@code limit} is negative.
     */
    public Quiz(int number, int points, boolean bonus, int limit) {
        checkNegative("Quiz: number cannot be negative", number);
        checkNegative("Quiz: points cannot be negative", points);
        checkNegative("Quiz: time limit cannot be negative", limit);

        this.number = number;
        this.bonus = bonus;
        this.points = points;
        this.timeLimit = limit;
    } // Quiz

    /**
     * Modifies the point total associated with this quiz.
     *
     * @param pointValue the new point value.
     * @throws IllegalArgumentException if {@code pointValue}
     * is negative.
     */
    public void setPoints(int pointValue) {
        checkNegative("Quiz(setPoints): point value cannot be negative", pointValue);

        this.points = pointValue;
    } // setPoints

    /**
     * Updates whether or not this quiz is bonus.
     *
     * @param bonus the bonus indicator.
     */
    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    } // setBonus

    /**
     * Updates the quiz identifier value.
     *
     * @param number the new quiz identifier.
     */
    public void setNumber(int number) {
        checkNegative("Quiz(setNumber): The quiz identifier cannot be negative", number);

        this.number = number;
    } // setNumber

    /**
     * Returns the quiz identifier value.
     *
     * @return the quiz identifier.
     */
    public int getNumber() {
        return this.number;
    } // setNumber

    /**
     * Updates the time limit for this quiz.
     *
     * @param limit the new time limit.
     * @throws IllegalArgumentException if {@code limit} is negative.
     */
    public void setTimeLimit(int limit) {
        checkNegative("Quiz(setPoints): time limit cannot be negative", limit);

        this.timeLimit = limit;
    } // setTimeLimit

    /**
     * Returns whether or not this quiz is bonus.
     *
     * @return {@code true} if this {@code Quiz} is bonus and false
     * otherwise.
     */
    public boolean isBonus() {
        return bonus;
    } // isBonus

    /**
     * Returns the number of points associated with this quiz.
     *
     * @return the points associated with this {@code Quiz} object.
     */
    public int getPoints() {
        return points;
    } // getPoints

    /**
     * Returns the time limit associated with this quiz.
     *
     * @return the time limit associated with this {@code Quiz} object.
     */
    public int getTimeLimit() {
        return timeLimit;
    } // getPoints

    /**
     * Checks the specified {@code value} to ensure it is positive.
     * If {@code value is negative}, the method throws an exception
     * containing the supplied {@code message}.
     *
     * @param message the message used in the exception.
     * @param value the value to check.
     * @throws IllegalArgumentException if {@code value} is negative.
     */
    private static void checkNegative(String message, int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException(message);
        } // if
    } // checkNegative
} // Quiz
