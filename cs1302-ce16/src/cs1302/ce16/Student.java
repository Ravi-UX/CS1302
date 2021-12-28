package cs1302.ce16;

/**
 * Represents a student. Each student has an associated ID, name, and GPA.
 */
public class Student {

    private int id;
    private String name;
    private double gpa;

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
                   double gpa) {
        setName(name);
        setId(id);
        setGPA(gpa);
    } // Student

    /**
     * Returns the ID.
     *
     * @return the ID
     */
    public int getId() {
        return id;
    } // getId

    /**
     * Sets the ID.
     *
     * @param id the specified ID.
     * @throws IllegalArgumentException if {@code id} is out of bounds
     *         {@code (id < 0 || id > 999_999_999)}.
     */
    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id cannot be negative");
        } else if (id > 999_999_999) {
            throw new IllegalArgumentException("id cannot exceed nine digits");
        } // if
        this.id = id;
    } // setId

    /**
     * Returns the name.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    } // getName

    /**
     * Sets the name.
     *
     * @param name the specified name
     * @throws NullPointerException if {@code name} is {@code null}.
     * @throws IllegalArgumentException if {@code name} is empty.
     */
    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException("name cannot be null");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty string");
        } // if
        this.name = name;
    } // setName

    /**
     * Returns the GPA.
     *
     * @return the GPA
     */
    public double getGPA() {
        return gpa;
    } // getGPA

    /**
     * Sets the GPA.
     *
     * @param gpa the specified GPA
     * @throws IllegalArgumentException if {@code gpa} is out of bounds
     *         {@code (gpa < 0 || gpa > 4.0)}.
     */
    public void setGPA(double gpa) {
        checkGPA(gpa);
        this.gpa = gpa;
    } // setGPA

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
    private void checkGPA(double gpa) {
        if (gpa < 0) {
            throw new IllegalArgumentException("gpa cannot be negative");
        } else if (gpa > 4.0) {
            throw new IllegalArgumentException("gpa cannot be greater than 4.0");
        } // if
    } // checkGPA

    @Override
    public String toString() {
        return String.format("Person(id = %d; name = %s; gpa = %.2f; standing = %s)",
                             id,
                             name,
                             gpa,
                             computeStanding());
    } // toString


} // Student
