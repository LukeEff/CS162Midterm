package shape.subshapes;

/**
 * The Square class.
 * For defining a square.
 *
 * @author Luke Matthew Fernandez
 * @since 5/14/2020
 */
public class Square extends Rectangle {

    private static final String TYPE = "Square";

    /**
     * Constructor for a square.
     *
     * @param length the length of the square
     */
    public Square(double length) {
        super(length, TYPE);
    }

}
