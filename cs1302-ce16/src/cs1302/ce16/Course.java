package cs1302.ce16;

/**
 * Represents a course. Each course has an associated course registation number (CRN), prefix, and 
 * listing number, and title.
 */
public class Course implements Comparable<Course>{

    private int crn;
    private String prefix;
    private int number;
    private String title;

    /**
     * Constructs a {@code Course} object.
     *
     * @param crn the specified course registration number
     * @param prefix the specified course prefix
     * @param number the specified course number
     * @param title the specified course title
     * @throws IllegalArgumentException if {@code crn} or {@code number} is negative
     * @throws NullPointerException if {@code prefix} or {@code title} is {@code null}
     * @throws IllegalArgumentException if {@code prefix} or {@code title} is empty
     */
    public Course(int crn, String prefix, int number, String title) {
        setCRN(crn);
        setPrefix(prefix);
        setNumber(number);
        setTitle(title);
    } // Course

    /**
     * Returns the course registration number (CRN).
     *
     * @return the course registration number (CRN)
     */
    public int getCRN() {
        return crn;
    } // getCRN

    /**
     * Sets the course registration number (CRN).
     * 
     * @param crn the specified course registration number (CRN)
     * @throws IllegalArgumentException if {@code crn} is negative
     */
    public void setCRN(int crn) {
        if (crn < 0) {
            throw new IllegalArgumentException("crn cannot be negative");
        } // if
        this.crn = crn;
    } // setCRN

    /**
     * Returns the course number.
     *
     * @return the course number
     */
    public int getNumber() {
        return number;
    } // getNumber

    /**
     * Sets the course number.
     * 
     * @param number the specified course number
     * @throws IllegalArgumentException if {@code number} is negative
     */
    public void setNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("number cannot be negative");
        } // if
        this.number = number;
    } // setNumber

    /**
     * Returns the course prefix.
     *
     * @return the course prefix
     */
    public String getPrefix() {
        return prefix;
    } // getPrefix

    /**
     * Sets the course prefix.
     * 
     * @param prefix the specified course prefix
     * @throws NullPointerException if {@code prefix} is {@code null}
     * @throws IllegalArgumentException if {@code prefix} is empty
     */
    public void setPrefix(String prefix) {
        if (prefix == null) {
            throw new NullPointerException("prefix cannot be null");
        } else if (prefix.isEmpty()) {
            throw new IllegalArgumentException("prefix cannot be empty");
        } // if
        this.prefix = prefix;
    } // setPrefix

    /**
     * Returns the course title.
     *
     * @return the course title
     */
    public String getTitle() {
        return title;
    } // getTitle

    /**
     * Sets the course title.
     * 
     * @param title the specified course title
     * @throws NullPointerException if {@code title} is {@code null}
     * @throws IllegalArgumentException if {@code title} is empty
     */
    public void setTitle(String title) {
        if (title == null) {
            throw new NullPointerException("title cannot be null");
        } else if (title.isEmpty()) {
            throw new IllegalArgumentException("title cannot be empty");
        } // if
        this.title = title;
    } // setTitle

   /**
    * Compares this {@code Course} object to the specified course. This method returns: 
    * {@code 0} if the {@code crn} values are the same, 
    * a positive value is this object has a larger {@code crn},
    * or a negative value if this object has a smaller {@code crn}.
    *
    * @param anotherCourse the other course to compare this course to
    * @return a value indicating which crn is larger
    */
    @Override
    public int compareTo(Course anotherCourse) {
        return this.crn - anotherCourse.crn;
    } // compareTo
    
    @Override
    public String toString() {
        return String.format("Course(crn = %d; prefix = %s; number = %d; title = %s)",
                             crn,
                             prefix,
                             number,
                             title);
    } // toString
        
} // Course

