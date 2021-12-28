package cs1302.ce10;

/**
 * Represents a professor. Each professor has an associated ID, name, and tenure-track status.
 */
public class Professor extends Person {

    private boolean tenureTrack;

    /**
     * Constructs a {@code Professor} object.
     *
     * @param id the specified ID.
     * @param name the specified name
     * @param tenureTrack whether or not this {@code Professor}
     *        is tenure track.
     * @throws IllegalArgumentException if {@code id} is out of bounds
     *         {@code (id < 0 || id > 999_999_999)}.
     * @throws NullPointerException if {@code name} is {@code null}.
     * @throws IllegalArgumentException if {@code name} is empty.
     */
    public Professor(int id,
                     String name,
                     boolean tenureTrack) {
        setName(name);
        setId(id);
        setTenureTrack(tenureTrack);
    } // Professor

    /**
     * Returns the tenure-track status.
     *
     * @return the tenure-track status
     */
    public boolean isTenureTrack() {
        return tenureTrack;
    } // isTenureTrack

    /**
     * Sets the tenure-track status.
     *
     * @param tenureTrack the specified tenure-track status
     */
    public void setTenureTrack(boolean tenureTrack) {
        this.tenureTrack = tenureTrack;
    } // setTenureTrack

} // Professor
