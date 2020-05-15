package shape;

import shape.subshapes.Circle;
import shape.subshapes.Rectangle;
import shape.subshapes.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * -------- BINARY FLIPPING --------
 *
 * It's simple! Flip all the bits and add 1.
 *
 * (8 bits long as per instructions)
 * Example:
 * 15 in binary:  00001111
 * -15 in binary: 11110001
 *
 * --------                 --------
 *
 * @author Luke Matthew Fernandez
 * @since 5/14/2020
 */
public class Test {

    //How many of each type of shape should be made for testing?
    private static final int NUM_OF_EACH_SHAPE = 5;


    /**
     * Tests. I added some more features I thought could be useful.
     * Probably could make a static getter for types so I don't have to create one to get the type of it. (Or made the constant public)
     *
     * @param args lol.
     */
    public static void main(String[] args) {
        final List<Shape> shapes = createRandomShapes(); //List of shapes with random dimensions.
        printShapes(sortShapesByPerimeter(shapes)); //Prints shapes sorted by perimeter.
        printShapeOfType(shapes, createRandomRectangle()); //Prints shapes of any given type.
        printSortedShapesStream(shapes); //Prints a sorted list of shapes via stream by area.
        printShapes(shapes); //Prints a list of shapes.
        printShapeOfType(shapes, createRandomRectangle().getType()); //Prints shapes of any given type with a string.
        printShapes(filterOutShapeOfType(shapes, createRandomRectangle().getType())); //Prints out a list of shapes with some type filtered out.
    }

    /**
     * Creates a list of random shapes that can be used for testing.
     *
     * @return a list of shapes with random values.
     */
    public static List<Shape> createRandomShapes() {
        List<Shape> shapes = new ArrayList<>();
        for(int i = 0; i < NUM_OF_EACH_SHAPE; i++) {
            shapes.add(createRandomCircle());
            shapes.add(createRandomRectangle());
            shapes.add(createRandomSquare());
        }
        return shapes;
    }

    /**
     * Initialises a new square object and returns a reference to it.
     *
     * @return a reference to the square object.
     */
    private static Square createRandomSquare() {
        return new Square(getRandomLength());
    }

    /**
     * Initialises a new rectangle object and returns a reference to it.
     *
     * @return a reference to the rectangle object.
     */
    private static Rectangle createRandomRectangle() {
        final double[] dimensions = getRandomLengthWidth();
        return new Rectangle(dimensions[0], dimensions[1]);
    }

    /**
     * Initialises a new circle object and returns a reference to it.
     *
     * @return a reference to the circle object.
     */
    private static Circle createRandomCircle() {
        return new Circle(getRandomLength());
    }

    /**
     * Gets a random number and multiplies it by 100.
     *
     * @return a random number that represents the length of anything.
     */
    private static double getRandomLength() {
        return Math.random() * 100;
    }

    /**
     * Gets two random values for length and width.
     *
     * @return an array of size 2 containing two doubles that represent length and width.
     */
    private static double[] getRandomLengthWidth() {
        return new double[] {Math.random() * 100, Math.random() * 100};
    }

    /**
     * Prints all of the shapes in a given list.
     *
     * @param shapes the list of shapes to be printed.
     */
    private static void printShapes(List<Shape> shapes) {
        for(Shape shape : shapes) {
            out.println(shape.toString());
        }
    }

    /**
     * Sorts the shape list according to the compareTo method that was overridden
     * in the Shape class.
     *
     * @param shapes the list of shapes to be sorted.
     * @return the sorted list of shapes.
     */
    private static List<Shape> sortShapeList(List<Shape> shapes) {
        return shapes.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Prints a sorted list of shapes.
     *
     * @param shapes the unsorted list of shapes.
     */
    private static void printSortedShapesStream(List<Shape> shapes) {
        printShapes(sortShapeList(shapes));
    }

    /**
     * Prints a list of shapes of a specified type.
     *
     * @param shapes the unfiltered shapes.
     * @param type the type of shape to be filtered for.
     */
    private static void printShapeOfType(List<Shape> shapes, Shape type) {
        printShapeOfType(shapes, type.getType());
    }

    /**
     * Prints a list of shapes of a specified type via String.
     *
     * This is a bit of a bonus. All you need to do is pass the name of the
     * shape here so no declaration of a new shape Object reference is necessary.
     *
     * @param shapes the unfiltered shapes.
     * @param type the type of shape to be filtered for.
     */
    private static void printShapeOfType(List<Shape> shapes, String type) {
        printShapes(filterShapeOfType(shapes, type));
    }

    /**
     * Filters out any shapes that are not of a specified type.
     *
     * @param shapes the shapes to be filtered.
     * @param type the type of the shape.
     * @return the filtered shapes.
     */
    private static List<Shape> filterShapeOfType(List<Shape> shapes, String type) {
        return shapes.stream().filter(shape -> shape.getType().equals(type)).collect(Collectors.toList());
    }

    /**
     * Returns a sorted list of shapes by their perimeter.
     *
     * @param shapes the unsorted list of shapes.
     * @return the sorted list of shapes.
     */
    private static List<Shape> sortShapesByPerimeter(List<Shape> shapes) {
        return shapes.stream().sorted((shapeOne, shapeTwo) -> Double.compare(shapeOne.getPerimeter(), shapeTwo.getPerimeter())).collect(Collectors.toList());
        //If you REALLY wanted to get fancy: return shapes.stream().sorted(Comparator.comparingDouble(Shape::getPerimeter)).collect(Collectors.toList());
    }

    /**
     * Filters OUT any shapes of a type.
     *
     * @param shapes the unfiltered list of shapes.
     * @param type the type to be filtered out.
     * @return the filtered list of shapes without the type passed.
     */
    private static List<Shape> filterOutShapeOfType(List<Shape> shapes, String type) {
        return shapes.stream().filter(shape -> !shape.getType().equals(type)).collect(Collectors.toList());
    }


}
