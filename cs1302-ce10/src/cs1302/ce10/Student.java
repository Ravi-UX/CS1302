package cs1302.ce10;

/**
 * Represents a student. Each student has an associated ID, name, and GPA.
 */
public class Student extends Person {

    private int id;
    private String name;
    private float gpa;

    /**
     * Constructs a {@code Student} object.
     *
     * @param id the specified ID.
     * @param name the specified name
     * @param gpa the specified GPA
     * @throws IllegalArgumentException if {@code id} is out of bounds
     *         {@code (id < 0 || id > 999_999_999)}.
     * @throws NullPointerException if {@code name} is {@code null}.
     * @throws IllegalArgumentException if {@code name} is empty.
     */
    public Student(int id,
                   String name,
                   float gpa) {
        setName(name);
        setId(id);
        setGpa(gpa);
    } // Student

    /**
     * Returns the GPA.
     *
     * @return the GPA
     */
    public float getGpa() {
        return gpa;
    } // getGpa

    /**
     * Sets the GPA.
     *
     * @param gpa the specified GPA
     * @throws IllegalArgumentException if {@code gpa} is out of bounds
     *         {@code (gpa < 0 || gpa > 4.0)}.
     */
    public void setGpa(float gpa) {
        checkGpa(gpa);
        this.gpa = gpa;
    } // setGpa

    /**
     * Returns a string representation of the standing of this student. The possible outputs are:
     * {@code "Academic Probation"}, {@code "Good"}, and {@code "Very Good"}.
     *
     * @return string representation of standing
     */
    public String computeStanding() {
        if (gpa < 2.0) {
            return "Academic Probation";
        } else if (gpa < 3.5) {
            return "Good";
        } else {
            return "Very Good";
        } // if
    } // computeStanding


    /**
     * Checks the specified {@code gpa} to ensure it's not out of bounds.
     *
     * @param gpa the specified GPA
     * @throws IllegalArgumentException if {@code gpa} is out of bounds
     *         {@code (gpa < 0 || gpa > 4.0)}.
     */
    private void checkGpa(float gpa) {
        if (gpa < 0) {
            throw new IllegalArgumentException("gpa cannot be negative");
        } else if (gpa > 4.0) {
            throw new IllegalArgumentException("gpa cannot be greater than 4.0");
        } // if
    } // checkGPA

} // Student
