package cs1302.ce12;

import cs1302.Utility;

/**
 * Represents a {@code Container} for any object.
 * {@code Container} objects cannot store {@code null} values.
 */
public class Container {
    /** The contents of this {@code Container}. */
    private Object contents;

    /**
     * Constructs a {@code Container} object with the specified
     * {@code Object}. The specified value cannot be {@code null}.
     *
     * @param contents the contetns for the {@code Container}
     * @throws NullPointerException if the contents are null.
     */
    public Container(Object contents) {
        set(contents);
    }

    /**
     * Modifies the contents of this {@code Container} object.
     * The specified value cannot be {@code null}.
     *
     * @param contents the contents for the {@code Container}
     * @throws NullPointerException if the contents are null
     */
    public void set(Object contents) {
        Utility.nullCheck("Container: set", contents);
        this.contents = contents;
    }

    /**
     * Returns the contents of this {@code Container} object.
     * @return the contets
     */
    public Object get() {
        return contents;
    }
}
