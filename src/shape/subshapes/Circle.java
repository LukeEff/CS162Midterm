package shape.subshapes;

import shape.Shape;

/**
 * The Circle class.
 * For defining a circle.
 *
 * @author Luke Matthew Fernandez
 * @since 5/14/2020
 */
public class Circle extends Shape {

    private static final String TYPE = "Circle";

    public Circle(double radius) {
        super(radius, TYPE);
    }

    /**
     * Just a toString method for a circle. Returns the properties
     * of the circle as a string (type, area, circumference) in a neatly
     * formatted way. Cuts off all decimals.
     *
     * @return the shape as a string.
     */
    @Override
    public String toString() {
        return "Type: " + getType() + ", Area: " + (int) getArea() + ", Circumference: " + (int) getPerimeter();
    }

    /**
     * Just a toString method for a circle so it says circumference instead. Returns the properties
     * of the circle as a string (type, area, circumference) in a neatly
     * formatted way.
     *
     * @return the shape as a string.
     */
    public String toStringWithDecimals() {
        return "Type: " + getType() + ", Area: " + getArea() + ", Circumference: " + getPerimeter();
    }

}
