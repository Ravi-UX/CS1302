package cs1302.shapes;

/**
 * This class represents a {@code Square}. A square is a plane figure with
 * four straignt sides and four right angles with all sides having equal length.
 */
public class Square extends Rectangle {

    /**
     * Constructs a {@link Square} object with the specified side length.
     * @param length the side length of the {@code Square}
     */
    public Square(double length) {
        super(length, length);
        setName("Square");
    } //Square


}
