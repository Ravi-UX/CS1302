package cs1302.shapes;

/**
 * This class represents a {@code Rectangle}. A rectangle is a plane figure with
 * four straignt sides and four right angles. It's adjacent sides can be equal or unequal.
 */
public class Rectangle extends Shape {
    /** Length of the horizontal sides of the {@code Rectangle}. */
    private double length;

    /** Length of teh vertical sides of the {@code Rectangle}. */
    private double height;

    /**
     * Constructs a {@link Rectangle} object with the specified side
     * length and height.
     *
     * @param length the length of the horizontal sides of the {@code Rectangle}.
     * @param height the length of the vertical sides of the {@code Rectangle}.
     */
    public Rectangle(double length, double height) {
        setName("Rectangle");
        this.length = length;
        this.height = height;
    } //Rectangle

    /**
     * Returns the perimeter of the {@code Rectangle} which is the sum of all of the sides.
     * @return the perimeter
     */
    @Override
    public double getPerimeter() {
        return 2 * (length + height);
    } //getPerimeter()

    /**
     * Returns the area of the {@code Rectangle} which is the product of the length and height.
     * @return the area
     */
    @Override
    public double getArea() {
        return length * height;
    } //getArea()

    /**
     * Returns the length of the horizontal side of the {@code Rectangle}.
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * Returns the length of the vertical side of the {@code Rectangle}.
     * @return the height
     */
    public double getHeight() {
        return height;
    }
}
