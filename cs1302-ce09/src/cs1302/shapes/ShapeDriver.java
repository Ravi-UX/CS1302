package cs1302.shapes;

/**
 * Main driver class for {@link Shape} objects.
 */
public class ShapeDriver {
    /**
     * Main method to test {@link Shape} objects and child classes.
     * @param args stores command line arguments
     */
    public static void main(String []args) {
        Shape[] shapes = new Shape[] {
            new Ellipse(1.1, 2.5),
            new Ellipse(5.0, 10.0),
            new Circle(4.2),
            new Circle(100.0),
            new Rectangle(7.4, 10.3),
            new Rectangle(10.0, 20.0),
            new Square(49.9),
            new Square(63.1)
        };

        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getName() + ": " + "Perimeter: "
                + shapes[i].getPerimeter() + " Area: " + shapes[i].getArea());
        }
    }
}
