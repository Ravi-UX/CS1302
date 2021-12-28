package cs1302.ce10;

/**
 * Represents a {@code Person} at the University.
 */
public abstract class Person {
    private int id;
    private String name;

    /**
    * Returns the id.
    * @return the id.
    */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID.
     * @param id the specified ID.
     * @throws IllegalArgumentException if {@code id} is not out of bounds
     * {@code (id < 0 || id > 999_999_999)}
     */
    public void setId(int id) {
        checkId(id);
        this.id = id;
    }

    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * @param name the specified name
     * @throws NullPointerException if {@code name} is {@code null}.
     * @throws IllegalArgumentException if {@code name} is empty.
     */
    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    /**
     * Checks the specified {@code id} to ensure it's not out of bounds.
     * @param id the specified ID
     * @throws IllegalArgumentExcption if {@code id} is out of bounds
     * {@code (id < 0 || id > 999_999_999)}
     */
    private void checkId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id cannot be negative");
        } else if (id > 999_999_999) {
            throw new IllegalArgumentException("id cannot exceed nine digits");
        }
    }

    /**
     * Checks the specified {@code name} to ensure it is valid.
     * @param name the specified name
     * @throws NullpointerException if {@code nam} is {@code null}.
     * @throws IllegalArgumentException if {@code name} is empty.
     */
    private void checkName(String name) {
        if (name == null) {
            throw new NullPointerException("name cannot be null");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty string");
        }
    }

    /**
     * Saves this {@code Person} to a database.
     */
    public void save() {
        //some code
    }
}
