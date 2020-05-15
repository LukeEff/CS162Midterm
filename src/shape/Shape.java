package shape;

import static java.lang.System.out;

/**
 * The Shape class.
 * For defining a shape.
 *
 * @author Luke Matthew Fernandez
 * @since 5/14/2020
 */
public abstract class Shape implements Comparable, Drawable {

    private final double area;
    private final double perimeter;
    private final String type;

    /**
     * Constructor for rectangular shapes.
     *
     * @param length the side length of the shape.
     * @param width the side width of the shape.
     * @param type the type of rectangle.
     */
    public Shape(double length, double width, String type) {
        this.area = length * width;
        this.perimeter = calculatePerimeter(length, width);
        this.type = type;
    }

    /**
     * Constructor for a shape that is a circle.
     *
     * @param radius the radius of the circle.
     * @param type the type of circle.
     */
    public Shape(double radius, String type) {
        this.area = (radius * radius) * Math.PI;
        this.perimeter = calculatePerimeter(radius * Math.PI, 0);
        this.type = type;
    }

    /**
     * Compares two shapes's area and returns 1 if this shape is larger
     * than the parameter shape, 0 if they are the same area, and -1 if
     * the area of this shape is smaller than the parameter shape.
     *
     * @param obj another shape object
     * @return -1 if this shape is smaller, 0 if the same, 1 if this shape is larger than obj.
     */
    @Override
    public int compareTo(Object obj) {
        final Shape otherShape = (Shape) obj;
        final double otherArea = otherShape.getArea();

        //Check the legacyCompare method at the bottom of this class for the other way to do it.
        return Double.compare(getArea(), otherArea);
    }

    @Override
    public void draw() {
        out.println("Drawing...");
    }

    /**
     * Gets the area of this shape.
     *
     * @return the area of the shape.
     */
    public double getArea() {
        return this.area;
    }

    /**
     * Gets the perimeter of this shape.
     *
     * @return the perimeter of the shape.
     */
    public double getPerimeter() {
        return this.perimeter;
    }

    /**
     * Gets the type of the shape.
     *
     * @return the type of the shape.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Calculates the perimeter of an object. Used to avoid duplicated
     * code in the constructor.
     *
     * @param length the length (or radius * pi for circle) of the shape.
     * @param width the width of the shape.
     * @return the perimeter of the shape.
     */
    private double calculatePerimeter(double length, double width) {
        return 2 * length + width;
    }

    /**
     * Just a toString method for the shape. Returns the properties
     * of the shape as a string (type, area, perimeter) in a neatly
     * formatted way. Cuts off all decimals
     *
     * @return the shape as a string.
     */
    @Override
    public String toString() {
        return "Type: " + getType() + ", Area: " + (int) getArea() + ", Perimeter: " + (int) getPerimeter();
    }

    /**
     * Just a toString method for the shape. Returns the properties
     * of the shape as a string (type, area, perimeter) in a neatly
     * formatted way.
     *
     * @return the shape as a string.
     */
    public String toStringWithDecimals() {
        return "Type: " + getType() + ", Area: " + getArea() + ", Perimeter: " + getPerimeter();
    }


    /**
     * Compares this shape instance with another for a greater length.
     *
     * @param obj a reference to another shape object.
     * @return 1 when this has a bigger area, -1 when this has a smaller
     * area, and 0 when they are the same.
     * @deprecated Double.compare is superior.
     */
    @Deprecated
    private int legacyCompare(Object obj) {
        final Shape otherShape = (Shape) obj;
        final double otherArea = otherShape.getArea();

        if(getArea() > otherArea) {
            return 1;
        } else if (getArea() < otherArea) {
            return -1;
        } else {
            return 0;
        }
    }


}
