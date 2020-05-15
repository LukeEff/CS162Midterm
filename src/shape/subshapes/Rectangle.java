package shape.subshapes;

import shape.Shape;

/**
 * The Rectangle class.
 * For defining a rectangle.
 *
 * @author Luke Matthew Fernandez
 * @since 5/14/2020
 */
public class Rectangle extends Shape {

    private static final String TYPE = "Rectangle";


    /**
     * The constructor for a rectangle object.
     *
     * @param length the length of a side.
     * @param width the width of a side.
     */
    public Rectangle(double length, double width) {
        super(length, width, TYPE);
    }

    /**
     * Constructor that will be called by squares.
     *
     * @param sideLength the side length of the square,
     * @param type the type of square (not really necessary unless there are other subtypes of rectangles).
     */
    protected Rectangle(double sideLength, String type) {
        super(sideLength, sideLength, type);
    }

}
